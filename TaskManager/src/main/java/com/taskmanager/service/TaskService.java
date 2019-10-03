package com.taskmanager.service;

import java.util.List;

import com.taskmanager.exception.ServiceException;
import com.taskmanager.model.TaskDTO;

/**
 * 
 * @author Ambuj
 *
 */
public interface TaskService {
	
	/**
	 * Add Task
	 * @param task
	 * @return String
	 * @throws ServiceException
	 */
	String addTask(TaskDTO task) throws ServiceException;
	
	/**
	 * Update Task
	 * @param task
	 * @return String
	 * @throws ServiceException
	 */
	String updateTask(TaskDTO task) throws ServiceException;
	
	/**
	 * View Task
	 * @return List<Task>
	 * @throws ServiceException
	 */
	List<TaskDTO> viewTask() throws ServiceException;
	
	/**
	 * Get Task
	 * @param taskName
	 * @return Task
	 * @throws ServiceException
	 */
	TaskDTO getTask(String taskName) throws ServiceException;
	
	/**
	 * End Task
	 * @param taskName
	 * @return List<Task>
	 * @throws ServiceException
	 */
	List<TaskDTO> endTask(String taskName) throws ServiceException;
	
}
