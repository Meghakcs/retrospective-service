package com.core.retrospective.model;

public class FeedbackDTO {

	private String body;
	private String feedbackType;
	private Retrospective retrospectiveId;
	private String name;
	

	public Feedback toFeedback() {
		Feedback feedback = new Feedback();
		feedback.setBody(body);
		feedback.setFeedbackType(feedbackType);
		
		return feedback;
    }

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public String getFeedbackType() {
		return feedbackType;
	}

	public void setFeedbackType(String feedbackType) {
		this.feedbackType = feedbackType;
	}

	public Retrospective getRetrospectiveId() {
		return retrospectiveId;
	}

	public void setRetrospectiveId(Retrospective retrospectiveId) {
		this.retrospectiveId = retrospectiveId;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
