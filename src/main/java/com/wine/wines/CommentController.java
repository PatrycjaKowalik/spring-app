package com.wine.wines;

import com.wine.user.UserNotFoundException;
import com.wine.user.WebSecurityConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.bind.annotation.RequestParam;
import com.wine.user.CustomUserDetails;
import com.wine.user.User;

import java.util.List;

@Controller
public class CommentController {

    @Autowired private CommentService cservice;
    @Autowired private WineService service;


  /*  @GetMapping("/wines/comment/new")
    public String showNewForm(Model model){
        model.addAttribute("comment", new Comment());
        return "comment_form";
    }*/

    @GetMapping("/wines/comment/{id}")
    public String showCommentForm(@PathVariable("id") Integer id, Model model, RedirectAttributes ra){
        try{
            Wine wine = service.get(id);
            model.addAttribute("wine", wine);
            model.addAttribute("pageTitle", "Comment wine " + wine.getName());
            model.addAttribute("comment", new Comment());
            return "comment_form";
        } catch (WineNotFoundException e) {
            ra.addFlashAttribute("message", e.getMessage());
            return "redirect:/wines";
        }

    }


    @GetMapping("/wines/comments")
    public String showCommentList(Model model){
        List<Comment> listComments = cservice.listAll();
        model.addAttribute("listComment", listComments);
        return "comments";
    }

    @PostMapping("/wines/saveComment/{id}")
    public String saveComment(@PathVariable("id") Integer id, Model model,Comment comment,  RedirectAttributes ra){
        try {
            Wine wine = service.get(id);
            model.addAttribute("wine", wine);
            comment.setWineN(wine.getName());
            cservice.saveC(comment);

            ra.addFlashAttribute("message", "Comment has been saved successfully.");
            return "redirect:/wines";
        }
        catch (WineNotFoundException e) {
            ra.addFlashAttribute("message", e.getMessage());
            return "redirect:/wines";
        }

    }



}
