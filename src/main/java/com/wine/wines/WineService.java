package com.wine.wines;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WineService {

    @Autowired private WineRepository repo;

    @Autowired
    private CommentRepository crepo;

    public List<Wine> listAll(){
        return (List<Wine>) repo.findAll();
    }

    public void save(Wine wine) {
        repo.save(wine);
    }

    public Wine get(Integer id) throws WineNotFoundException {
        Optional<Wine> result = repo.findById(id);
        if(result.isPresent()){
            return  result.get();
        }
        throw new WineNotFoundException("Could not find any wine with ID" + id);
    }

    public void delete(Integer id) throws WineNotFoundException {
        Long count = repo.countById(id);
        if(count == null || count == 0){
            throw new WineNotFoundException("Could not find any wine with ID " + id);

        }
        repo.deleteById(id);
    }

//    public List<Wine> getWineInfo(Integer wineId) {
//
//        Optional<Wine> wineOptional = repo.findById(wineId);
//        Wine wine = wineOptional.get();

//        List<Wine> list = Arrays.asList(new Wine[] { wine });

  //      return list;
   // }

}
