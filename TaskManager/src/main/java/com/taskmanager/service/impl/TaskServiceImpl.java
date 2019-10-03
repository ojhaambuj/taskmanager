package com.taskmanager.service.impl;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;

import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taskmanager.collection.Task;
import com.taskmanager.dao.TaskDao;
import com.taskmanager.exception.ServiceException;
import com.taskmanager.model.TaskDTO;
import com.taskmanager.service.TaskService;

/**
 * 
 * @author Ambuj
 *
 */
@Service
public class TaskServiceImpl implements TaskService {

	public static final Logger LOGGER = LoggerFactory.getLogger(TaskServiceImpl.class);

	@Autowired
	private TaskDao taskDao;
   
	
	

	private boolean isTaskExist(String taskName) {
		return taskDao.findById(taskName).isPresent();
	}


	/**
	 * Add Task
	 * @param task
	 * @return String
	 * @throws ServiceException
	 */
	@Override
	public String addTask(TaskDTO taskDTO) throws ServiceException {
		if(isTaskExist(taskDTO.getTaskName())) {
			LOGGER.info("Task is already exists");
			return "Task is already exists";

		} else {
			Task task = new Task();
			BeanUtils.copyProperties(taskDTO, task);

			taskDao.save(task);
			return "Success";
		}
	}

	/**
	 * Update Task
	 * @param task
	 * @return String
	 * @throws ServiceException
	 */
	@Override
	public String updateTask(TaskDTO taskDTO) throws ServiceException {
		if (isTaskExist(taskDTO.getTaskName())) {
				
					Task task = new Task();
					BeanUtils.copyProperties(taskDTO, task);
					taskDao.save(task);
									
			return "Success";

		} else {
			LOGGER.info("Task not exists");
			return "Task not exists";
		}
		
	}

	/**
	 * View Task
	 * @return List<Task>
	 * @throws ServiceException
	 */
	@Override
	public List<TaskDTO> viewTask() throws ServiceException {
		List<TaskDTO> taskDTOs = new ArrayList<TaskDTO>();
		List<Task> tasks = taskDao.findAll();
		
		for(Task task: tasks) {
			TaskDTO taskDTO = new TaskDTO();
			BeanUtils.copyProperties(task, taskDTO);
			taskDTOs.add(taskDTO);
		}
		return taskDTOs;
	}

	/**
	 * Get Task
	 * @param taskName
	 * @return Task
	 * @throws ServiceException
	 */
	@Override
	public TaskDTO getTask(String taskName) throws ServiceException {
        Task task = taskDao.findById(taskName).get();
		
		TaskDTO taskDTO = new TaskDTO();
		BeanUtils.copyProperties(task, taskDTO);
		return taskDTO;

	}

	/**
	 * End Task
	 * @param taskName
	 * @return List<Task>
	 * @throws ServiceException
	 */
	@Override
	public List<TaskDTO> endTask(String taskName) throws ServiceException {
		
		taskDao.deleteById(taskName);
		return viewTask();
	}

}
