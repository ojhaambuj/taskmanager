package com.taskmanager.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.taskmanager.exception.ServiceException;
import com.taskmanager.model.TaskDTO;
import com.taskmanager.service.TaskService;

/**
 * 
 * @author Ambuj
 *
 */
@RestController
public class TaskController {
	
	/** Property for Task Service **/
	@Autowired
	private TaskService taskService;
	
	/** Property for Logger **/
	public static final Logger LOGGER = LoggerFactory.getLogger(TaskController.class);
	
	/**
	 * Add Task
	 * @param task
	 * @return String
	 */
	@RequestMapping(value = "/addTask", method=RequestMethod.POST)
	public String addTask(@RequestBody TaskDTO task) {
		LOGGER.info("addTask() started");
		
		try {
			return taskService.addTask(task);
		} catch (ServiceException e) {
			LOGGER.info(e.getMessage(), e);
			return "Technical Exception occurred. Please check the log.";
		}
		
	}
	
	/**
	 * Update Task
	 * @param task
	 * @return String
	 */
	@RequestMapping(value = "/updateTask", method=RequestMethod.POST)
	public String updateTask(@RequestBody TaskDTO task) {
		LOGGER.info("updateTask() started");
		
		try {
			return taskService.updateTask(task);
		} catch (ServiceException e) {
			LOGGER.info(e.getMessage(), e);
			return "Technical Exception occurred. Please check the log.";
		}
		
	}
	
	/**
	 * View Task
	 * @return List<Task>
	 */
	@RequestMapping(value = "/viewTask", method=RequestMethod.GET)
	public List<TaskDTO> viewTask() {
		LOGGER.info("viewTask() started");
		
		try {
			return taskService.viewTask();
		} catch (ServiceException e) {
			LOGGER.info(e.getMessage(), e);
			return new ArrayList<>();
		}
		
	}
	
	/**
	 * Get Task
	 * @param taskName
	 * @return Task
	 */
	@RequestMapping(value = "/getTask", method=RequestMethod.GET)
	public TaskDTO getTask(@RequestParam String taskName) {
		LOGGER.info("getTask() started");
		
		try {
			return taskService.getTask(taskName);
		} catch (ServiceException e) {
			LOGGER.info(e.getMessage(), e);
			return null;
		}
		
	}
	
	/**
	 * End Task
	 * @param taskName
	 * @return List<Task>
	 */
	@RequestMapping(value = "/endTask/{taskName}", method=RequestMethod.GET)
	public List<TaskDTO> endTask(@PathVariable String taskName) {
		LOGGER.info("endTask() started");
		
		try {
			return taskService.endTask(taskName);
		} catch (ServiceException e) {
			LOGGER.info(e.getMessage(), e);
			return new ArrayList<>();
		}
		
	}

}
