package com.taskmanager.model;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TaskDTOTest {
	
	@InjectMocks
	private TaskDTO taskDTO;
	
	@Test
	public void init() {
		
		String task = "Task 1";
		long priority = 10;
		String parentTask = "Parent Task 1";
		String startDate = "2019-07-30";
		String endDate = "2019-07-31";
		String createdBy = "SYSTEM";
		Date createdOn = new Date();
		String lastUpdatedBy = "SYSTEM";
		Date lastUpdatedOn = new Date();
		
		taskDTO.setTaskName(task);
		taskDTO.setPriority(priority);
		taskDTO.setParentTask(parentTask);
		taskDTO.setStartDate("2019-07-28");
		taskDTO.setEndDate("2019-07-30");
	
		
		assertEquals(task, taskDTO.getTaskName());
		assertEquals(priority, taskDTO.getPriority());
		assertEquals(parentTask, taskDTO.getParentTask());
		assertEquals(startDate, taskDTO.getStartDate());
		assertEquals(endDate, taskDTO.getEndDate());
		
		
	}
	
}
