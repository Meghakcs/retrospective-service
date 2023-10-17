package com.core.retrospective.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.core.retrospective.model.Feedback;
import com.core.retrospective.model.FeedbackDTO;
import com.core.retrospective.model.Retrospective;
import com.core.retrospective.repository.FeedbackRepository;
import com.core.retrospective.repository.RetrospectiveRepository;

@Service
public class FeedbackService {

	@Autowired
	FeedbackRepository feedbackRepository;
	
	@Autowired
	RetrospectiveRepository retrospectiveRepository;

	/**
	 * Update Feedback body and type 
	 * @param id
	 * @param feedbackDTO
	 * @return
	 */
	public Feedback updateFeedbackDetails(int id, FeedbackDTO feedbackDTO) {

		// get the Feedback from DB by id
		// update with new value getting from request

		Feedback feedback = feedbackRepository.findById(id).get(); // DB
		feedback.setBody(feedbackDTO.getBody());
		feedback.setFeedbackType(feedbackDTO.getFeedbackType());
		return feedbackRepository.save(feedback);
	}

	/**
	 * 
	 * @param id retrospective Id
	 * @param feedbackDTO
	 * @return
	 */
	public Feedback updateFeedback(int id, FeedbackDTO feedbackDTO) {

		Optional<Retrospective> retrospective = retrospectiveRepository.findById(id);
		Feedback feedback = new Feedback();
		feedback.setName(feedbackDTO.getName());
		feedback.setBody(feedbackDTO.getBody());
		feedback.setFeedbackType(feedbackDTO.getFeedbackType());
		feedback.setRetrospective(retrospective.get());
		return feedbackRepository.save(feedback);
	}

}
