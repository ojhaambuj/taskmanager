package com.taskmanager.controller;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.taskmanager.exception.ServiceException;
import com.taskmanager.model.TaskDTO;
import com.taskmanager.service.TaskService;

/**
 * 
 * @author sekarsk
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TaskControllerTest {
	
	@InjectMocks
	private TaskController taskController;
	
	@Mock
	private TaskService taskService;
	
	@Test
	public void addTaskTC01() throws ServiceException {
		TaskDTO task = new TaskDTO();
		Mockito.when(taskService.addTask(task)).thenReturn("Success");
		String expected = "Success";
		String actual = taskController.addTask(task);
		assertEquals(expected, actual);
	}
	
	@Test
	public void addTaskTC02() throws ServiceException {
		TaskDTO task = new TaskDTO();
		Mockito.doThrow(ServiceException.class).when(taskService).addTask(task);
		String expected = "Technical Exception occurred. Please check the log.";
		String actual = taskController.addTask(task);
		assertEquals(expected, actual);
	}
	
	@Test
	public void updateTaskTC01() throws ServiceException {
		TaskDTO task = new TaskDTO();
		Mockito.when(taskService.updateTask(task)).thenReturn("Success");
		String expected = "Success";
		String actual = taskController.updateTask(task);
		assertEquals(expected, actual);
	}
	
	@Test
	public void updateTaskTC02() throws ServiceException {
		TaskDTO task = new TaskDTO();
		Mockito.doThrow(ServiceException.class).when(taskService).updateTask(task);
		String expected = "Technical Exception occurred. Please check the log.";
		String actual = taskController.updateTask(task);
		assertEquals(expected, actual);
	}
	
	@Test
	public void viewTaskTC01() throws ServiceException {
		TaskDTO task = new TaskDTO();
		task.setTaskName("Task 1");
		task.setPriority(10);
		task.setParentTask("Parent Task 1");
		task.setStartDate("2019-07-28");
		task.setEndDate("2019-07-30");
		List<TaskDTO> expectedTaskList = new ArrayList<>();
		expectedTaskList.add(task);
		Mockito.when(taskService.viewTask()).thenReturn(expectedTaskList);
		List<TaskDTO> actualTaskList = taskController.viewTask();
		assertEquals(expectedTaskList, actualTaskList);
	}
	
	@Test
	public void viewTaskTC02() throws ServiceException {
		List<TaskDTO> expectedTaskList = new ArrayList<>();
		Mockito.doThrow(ServiceException.class).when(taskService).viewTask();
		List<TaskDTO> actualTaskList = taskController.viewTask();
		assertEquals(expectedTaskList, actualTaskList);
	}
	
	@Test
	public void getTaskTC01() throws ServiceException {
		String taskName = "Task 1";
		TaskDTO expectedTask = new TaskDTO();
		expectedTask.setTaskName(taskName);
		expectedTask.setPriority(10);
		expectedTask.setParentTask("Parent Task 1");
		expectedTask.setStartDate("2019-07-28");
		expectedTask.setEndDate("2019-07-30");
		Mockito.when(taskService.getTask(taskName)).thenReturn(expectedTask);
		TaskDTO actualTask = taskController.getTask(taskName);
		assertEquals(expectedTask, actualTask);
	}
	
	@Test
	public void getTaskTC02() throws ServiceException {
		String taskName = "Task 1";
		TaskDTO expectedTask = null;
		Mockito.doThrow(ServiceException.class).when(taskService).getTask(taskName);
		TaskDTO actualTask = taskController.getTask(taskName);
		assertEquals(expectedTask, actualTask);
	}
	
	@Test
	public void endTaskTC01() throws ServiceException {
		String taskName = "Task 1";
		TaskDTO task = new TaskDTO();
		task.setTaskName("Task 2");
		task.setPriority(10);
		task.setParentTask("Parent Task 1");
		task.setStartDate("2019-07-28");
		task.setEndDate("2019-07-30");
		List<TaskDTO> expectedTaskList = new ArrayList<>();
		expectedTaskList.add(task);
		Mockito.when(taskService.endTask(taskName)).thenReturn(expectedTaskList);
		List<TaskDTO> actualTaskList = taskController.endTask(taskName);
		assertEquals(expectedTaskList, actualTaskList);
	}
	
	@Test
	public void endTaskTC02() throws ServiceException {
		String taskName = "Task 1";
		List<TaskDTO> expectedTaskList = new ArrayList<>();
		Mockito.doThrow(ServiceException.class).when(taskService).endTask(taskName);
		List<TaskDTO> actualTaskList = taskController.endTask(taskName);
		assertEquals(expectedTaskList, actualTaskList);
	}

}
