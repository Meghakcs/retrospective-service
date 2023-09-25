package com.core.retrospective.repository;

import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.core.retrospective.model.Retrospective;

@Repository
public interface RetrospectiveRepository extends JpaRepository<Retrospective, Integer>{


    @Query(value = "SELECT * FROM Retrospective r WHERE " +
            "r.date = :query", nativeQuery = true)
    List<Retrospective> filterByDate(Date query);

	 
}
