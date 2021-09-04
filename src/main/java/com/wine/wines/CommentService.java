package com.wine.wines;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommentService {

    @Autowired
    private CommentRepository crepo;

    public List<Comment> listAll(){
        return (List<Comment>) crepo.findAll();
    }

    public void saveC(Comment comment) {
        crepo.save(comment);
    }


    public Comment get(Integer id) throws CommentNotFoundException {
        Optional<Comment> result = crepo.findById(id);
        if(result.isPresent()){
            return  result.get();
        }
        throw new CommentNotFoundException("Could not find any comment with ID" + id);
    }


}
