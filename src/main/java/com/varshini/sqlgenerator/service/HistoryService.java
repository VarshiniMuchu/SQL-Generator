package com.varshini.sqlgenerator.service;

import com.varshini.sqlgenerator.model.QueryHistory;
import com.varshini.sqlgenerator.model.User;
import com.varshini.sqlgenerator.repository.QueryHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.varshini.sqlgenerator.repository.UserRepository;
import java.time.LocalDateTime;

@Service
public class HistoryService {

    @Autowired
    private QueryHistoryRepository queryHistoryRepository;
    @Autowired
    private UserRepository userRepository;

    public void saveHistory(String email,
                            String prompt,
                            String generatedSql) {

        User user =
                userRepository.findByEmail(email);

        QueryHistory history =
                new QueryHistory();

        history.setUserInput(prompt);
        history.setGeneratedSql(generatedSql);
        history.setCreatedAt(LocalDateTime.now());
        history.setUser(user);
        System.out.println(email);
        queryHistoryRepository.save(history);
    }
}