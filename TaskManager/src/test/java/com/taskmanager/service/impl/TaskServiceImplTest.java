package com.taskmanager.service.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.taskmanager.collection.Task;
import com.taskmanager.dao.TaskDao;
import com.taskmanager.exception.ServiceException;
import com.taskmanager.model.TaskDTO;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TaskServiceImplTest {
	
	@InjectMocks
	private TaskServiceImpl taskServiceImpl;
	
	@Mock
	private TaskDao taskDao;
	
	@Test
	public void addTaskTC01() throws ServiceException {
		String expected = "Success";
		String taskName = "Task @123";
		TaskDTO taskDTO = new TaskDTO();
		Task task = new Task();
		Optional<Task> optional = Optional.of(task);
		Mockito.when(taskDao.findById(taskName)).thenReturn(optional);
		String actual = taskServiceImpl.addTask(taskDTO);
		assertEquals(expected, actual);
	}
	
	@Test
	public void updateTaskTC01() throws ServiceException {
		String expected = "Task not exists";
		String taskName = "Task @123";
		TaskDTO taskDTO = new TaskDTO();
		Task task = new Task();
		Optional<Task> optional = Optional.of(task);
		Mockito.when(taskDao.findById(taskName)).thenReturn(optional);
		String actual = taskServiceImpl.updateTask(taskDTO);
		assertEquals(expected, actual);
	}
	
	@Test
	public void viewTaskTC01() throws ServiceException {
		List<TaskDTO> expected = new ArrayList<TaskDTO>();
		TaskDTO taskDTO = new TaskDTO();
		expected.add(taskDTO);
		List<Task> tasks = new ArrayList<>();
		Task task = new Task();
		tasks.add(task);
		Mockito.when(taskDao.findAll()).thenReturn(tasks);
		List<TaskDTO> actual = taskServiceImpl.viewTask();
		assertNotNull(actual);
	}
	
	@Test
	public void getTask() throws ServiceException {
		String taskName = "Task 1";
		Task task = new Task();
		Optional<Task> optional = Optional.of(task);
		Mockito.when(taskDao.findById(taskName)).thenReturn(optional);
		TaskDTO actual = taskServiceImpl.getTask(taskName);
		assertNotNull(actual);
	}
	
	@Test
	public void endTask() throws ServiceException {
		String taskName = "Task @XYZ";
		taskServiceImpl.endTask(taskName);
	}
}
