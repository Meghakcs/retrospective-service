package com.core.retrospective.service;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.core.retrospective.model.Retrospective;
import com.core.retrospective.repository.RetrospectiveRepository;

@Service
public class RetrospectiveService {

    private final RetrospectiveRepository retrospectiveRepository;

    public RetrospectiveService(RetrospectiveRepository retrospectiveRepository) {
        this.retrospectiveRepository = retrospectiveRepository;
    }

    public Retrospective create(Retrospective retrospective) {
        return retrospectiveRepository.save(retrospective);
    }

	public Page<Retrospective> getAllRetrospects(int currentPage, int pageSize) {
        Pageable pageable = PageRequest.of(currentPage, pageSize);
		return retrospectiveRepository.findAll(pageable);
	}

	 public List<Retrospective> filterByDate(Date date) {
		return retrospectiveRepository.filterByDate(date);
	 }

}
