package com.core.retrospective.controller;

import java.sql.Date;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.core.retrospective.model.Feedback;
import com.core.retrospective.model.FeedbackDTO;
import com.core.retrospective.model.Retrospective;
import com.core.retrospective.model.RetrospectiveDTO;
import com.core.retrospective.service.FeedbackService;
import com.core.retrospective.service.RetrospectiveService;
import com.core.retrospective.util.AppConstants;

/** Rest API for Retrospective
 *  @author Megha
 *  @since 1.0 
 */
@RequestMapping("/retrospective")
@RestController
public class RetrospectiveController {
	
	@Autowired
	RetrospectiveService retrospectiveService;
	
	@Autowired
	FeedbackService feedbackService;
	
	private static final Logger logger = LoggerFactory.getLogger(RetrospectiveController.class);
	
	/**
	 * Rest API to create new Retrospective - Feedback Items can be empty
	 * Date and Participants are required to create Retrospective
	 * @param retrospectiveDTO
	 * @return Retrospective
	 */
	@PostMapping("/createRetrospective")
	public ResponseEntity<Retrospective> createRetrospective(@RequestBody RetrospectiveDTO retrospectiveDTO) {
		Retrospective retrospectiveCreated = null;
		try {
		  retrospectiveCreated = retrospectiveService.create(retrospectiveDTO.toRetrospective());
		  logger.info("create Retrospective Response" +retrospectiveCreated);
		} catch (Exception e) {
		logger.error("Error while creating Retrospective" +e.getMessage());
		 return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	    return new ResponseEntity<>(retrospectiveCreated, HttpStatus.CREATED);
	}
	
	
   	/**
	 * Rest Api to get all the Retrospect with pagination
	 * @param currentPage defines offset
	 * @param pageSize defines number of records per page
	 * @return Retrospective
	 */
    @GetMapping("/getRetrospects")
    public Page<Retrospective> getAllRetrospects(
            @RequestParam(value = "currentPage", defaultValue = AppConstants.DEFAULT_PAGE_NUMBER, required = false) int currentPage,
            @RequestParam(value = "pageSize", defaultValue = AppConstants.DEFAULT_PAGE_SIZE, required = false) int pageSize
    ){
        return retrospectiveService.getAllRetrospects(currentPage, pageSize);
    }
    
    
    /**
     * Search Api to filter Retrospective By Date
     * @param date
     * @return Retrospective
     */
    @GetMapping("/filterByDate")
    public ResponseEntity<List<Retrospective>> getRetrospectiveByDate(@RequestParam Date date){
    	return ResponseEntity.ok(retrospectiveService.filterByDate(date));
    }
    

    /**
     * Rest Api to update feedback items body and type.
     * @param id
     * @param feedbackDTO
     * @return
     */
   
   @PatchMapping("/updateFeedbackDetails/{id}")
   public ResponseEntity<Feedback> updateFeedbackDetails(@PathVariable int id, @RequestBody FeedbackDTO feedbackDTO) {
		Feedback feedbackUpdated = null;
		try {
		  feedbackUpdated = feedbackService.updateFeedbackDetails(id, feedbackDTO);
		  logger.info("Update Feedback Response" +feedbackUpdated);
		} catch (Exception e) {
		logger.error("Error while updating Feedback Details" +e.getMessage());
		}
	    return new ResponseEntity<>(feedbackUpdated, HttpStatus.CREATED);
   }
   
   /**
    * Rest Api to add new feedback to existing Retrospective
    * @param id
    * @param feedbackDTO
    * @return
    */
   @PatchMapping("/updateFeedback/{id}")
   public ResponseEntity<Feedback> updateFeedback(@PathVariable int id, @RequestBody FeedbackDTO feedbackDTO) {
		Feedback feedbackUpdated = null;
		try {
		  feedbackUpdated = feedbackService.updateFeedback(id, feedbackDTO);
		  logger.info("Update Feedback Response" +feedbackUpdated);
		} catch (Exception e) {
		logger.error("Error while updating Feedback Details" +e.getMessage());
		}
	    return new ResponseEntity<>(feedbackUpdated, HttpStatus.CREATED);
   }


}
