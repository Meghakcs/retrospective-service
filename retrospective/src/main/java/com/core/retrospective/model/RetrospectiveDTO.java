package com.core.retrospective.model;

import java.util.ArrayList;
import java.util.Date;

public record RetrospectiveDTO(String name, String summary, Date date, ArrayList<String> participants, ArrayList<String> feedback) {

		public Retrospective toRetrospective() {
			Retrospective retrospective = new Retrospective();
			retrospective.setName(name);
			retrospective.setSummary(summary);
			retrospective.setDate(date);
			retrospective.setParticipants(participants);
	        return retrospective;
	    }

		
		
	}
	   
