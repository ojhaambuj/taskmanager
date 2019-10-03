package com.taskmanager.collection;

import java.io.Serializable;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * 
 * @author Ambuj
 *
 */
@Document(collection="tasks")
public class Task implements Serializable {

	/**
	 * Property for Serial Version UID
	 */
	private static final long serialVersionUID = 1L;

	/** Property for Task **/
	@Id
	private String taskName;

	/** Property for Priority **/
	private long priority;

	/** Property for Parent Task **/
	private String parentTask;

	/** Property for Start Date **/
	private String startDate;

	/** Property for End Date **/
	private String endDate;

	
	/**
	 * @return the task
	 */
	public String getTaskName() {
		return taskName;
	}

	/**
	 * @param task the task to set
	 */
	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	/**
	 * @return the priority
	 */
	public long getPriority() {
		return priority;
	}

	/**
	 * @param priority the priority to set
	 */
	public void setPriority(long priority) {
		this.priority = priority;
	}

	/**
	 * @return the parentTask
	 */
	public String getParentTask() {
		return parentTask;
	}

	/**
	 * @param parentTask the parentTask to set
	 */
	public void setParentTask(String parentTask) {
		this.parentTask = parentTask;
	}

	/**
	 * @return the startDate
	 */
	public String getStartDate() {
		return startDate;
	}

	/**
	 * @param startDate the startDate to set
	 */
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	/**
	 * @return the endDate
	 */
	public String getEndDate() {
		return endDate;
	}

	/**
	 * @param endDate the endDate to set
	 */
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}


}
