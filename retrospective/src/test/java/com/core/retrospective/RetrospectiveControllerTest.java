package com.core.retrospective;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.core.retrospective.controller.RetrospectiveController;
import com.core.retrospective.model.Retrospective;
import com.core.retrospective.service.RetrospectiveService;

@RunWith(MockitoJUnitRunner.class)
public class RetrospectiveControllerTest {
	
	@Mock
	RetrospectiveService retrospectiveService;

	@InjectMocks
	RetrospectiveController retrospectiveController;

	@Test
	public void testcreateRetrospective() {
		
		Retrospective retrospective = new Retrospective();
		retrospective.setName("Retrospective 1");
		retrospective.setSummary("Post release retrospective");
		ArrayList<String> participants = new ArrayList<String> ();
		participants.add("Megha");
		participants.add("Victor");
		retrospective.setParticipants(participants);
		
		when(retrospectiveService.create(any())).thenReturn(retrospective);
		assertEquals(retrospective, retrospectiveController.createRetrospective(any()));
	}


}
