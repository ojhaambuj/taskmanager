package com.taskmanager.dao;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.taskmanager.collection.Task;

/**
 * 
 * @author Ambuj
 *
 */
public interface TaskDao extends MongoRepository<Task, String> {
		

}
