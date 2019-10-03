package com.taskmanager.model;

/**
 * 
 * @author Ambuj
 *
 */
public class TaskDTO {

	/** Property for Task Name **/
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
	 * Get Task Name
	 * @return String
	 */
	public String getTaskName() {
		return taskName;
	}

	/**
	 * Set Task Name
	 * @param task
	 */
	public void setTaskName(String task) {
		this.taskName = task;
	}

	/**
	 * Get Priority
	 * @return long
	 */
	public long getPriority() {
		return priority;
	}

	/**
	 * Set Priority
	 * @param priority
	 */
	public void setPriority(long priority) {
		this.priority = priority;
	}

	/**
	 * Get Parent Task
	 * @return String
	 */
	public String getParentTask() {
		return parentTask;
	}

	/**
	 * SeT Parent Task
	 * @param parentTask
	 */
	public void setParentTask(String parentTask) {
		this.parentTask = parentTask;
	}

	/**
	 * Get Start Date
	 * @return String
	 */
	public String getStartDate() {
		return startDate;
	}

	/**
	 * Set Start Date
	 * @param startDate
	 */
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	/**
	 * Get End Date
	 * @return String
	 */
	public String getEndDate() {
		return endDate;
	}

	/**
	 * Set End Date
	 * @param endDate
	 */
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((endDate == null) ? 0 : endDate.hashCode());
		result = prime * result + ((parentTask == null) ? 0 : parentTask.hashCode());
		result = prime * result + (int) (priority ^ (priority >>> 32));
		result = prime * result + ((startDate == null) ? 0 : startDate.hashCode());
		result = prime * result + ((taskName == null) ? 0 : taskName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TaskDTO other = (TaskDTO) obj;
		
		if (taskName == null) {
			if (other.taskName != null)
				return false;
		} else if (!taskName.equals(other.taskName))
			return false;
		return true;
	}

   
	
}
