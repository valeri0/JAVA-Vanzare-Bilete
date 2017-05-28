package tests;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import dto.EventDTO;
import service.ServiceFactory;

public class EventServiceTest {

	
	
	@Test
	public void test() {
		List<EventDTO> eventDTOs = ServiceFactory.getEventService().getEvents();
		
		if(eventDTOs.size()==0){
			fail("Cannot load from the database");
		}


		for(EventDTO eventDTO : eventDTOs){
			System.out.println(eventDTO.getName());
		}
		
	}

}
