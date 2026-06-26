package com.varshini.sqlgenerator.controller;

import com.varshini.sqlgenerator.model.QueryHistory;
import com.varshini.sqlgenerator.model.User;
import com.varshini.sqlgenerator.repository.QueryHistoryRepository;
import com.varshini.sqlgenerator.repository.UserRepository;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/history")
public class HistoryController {

    @Autowired
    private QueryHistoryRepository repository;

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/my")
    public List<QueryHistory> myHistory(
            HttpServletRequest request) {

        String email =
                (String) request.getAttribute("email");

        System.out.println("History Email: " + email);

        User user =
                userRepository.findByEmail(email);

        return repository.findByUser(user);
    }

    @DeleteMapping("/{id}")
    public String deleteHistory(
            @PathVariable Long id,
            HttpServletRequest request) {

        String email =
                (String) request.getAttribute("email");

        User user =
                userRepository.findByEmail(email);

        QueryHistory history =
                repository.findById(id).orElse(null);

        if(history == null) {
            return "History Not Found";
        }

        if(!history.getUser().getId()
                .equals(user.getId())) {

            return "Unauthorized";
        }

        repository.delete(history);

        return "Deleted Successfully";
    }

}