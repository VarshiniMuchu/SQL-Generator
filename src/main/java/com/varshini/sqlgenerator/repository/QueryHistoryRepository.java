package com.varshini.sqlgenerator.repository;

import com.varshini.sqlgenerator.model.QueryHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import com.varshini.sqlgenerator.model.User;

public interface QueryHistoryRepository
        extends JpaRepository<QueryHistory, Long> {

    List<QueryHistory> findByUser(User user);
}
