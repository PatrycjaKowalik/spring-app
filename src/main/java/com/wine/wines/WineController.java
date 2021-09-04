package com.wine.wines;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class WineController {
    @Autowired private WineService service;
    @Autowired private CommentService cservice;

    @GetMapping("/wines")
    public String showWineList(Model model){
        List<Wine> listWines = service.listAll();
        model.addAttribute("listWines", listWines);

        return "wines";
    }

    @GetMapping("/wines/new")
    public String showNewForm(Model model){
        model.addAttribute("wine", new Wine());
        model.addAttribute("pageTitle", "Add New Wine");
        return "wine_form";
    }

    @PostMapping("/wines/save")
    public String saveWine(Wine wine, RedirectAttributes ra){
        service.save(wine);
        ra.addFlashAttribute("message", "Wine has been saved successfully.");
        return "redirect:/wines";
    }

    @GetMapping("/wines/edit/{id}")
    public String showEditForm(@PathVariable("id") Integer id, Model model, RedirectAttributes ra){
        try{
            Wine wine = service.get(id);
            model.addAttribute("wine", wine);
            model.addAttribute("pageTitle", "Edit wine (ID: " + id + ")");
            return "wine_form";
        } catch (WineNotFoundException e) {
            ra.addFlashAttribute("message", e.getMessage());
            return "redirect:/wines";
        }

    }

    @GetMapping("/wines/delete/{id}")
    public String deleteWine(@PathVariable("id") Integer id, RedirectAttributes ra){
        try{
            service.delete(id);
            ra.addFlashAttribute("message", "Wine has been deleted.");
        } catch (WineNotFoundException e) {
            ra.addFlashAttribute("message", e.getMessage());

        }
        return "redirect:/wines";

    }


}
