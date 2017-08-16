/**
 * 
 */
package com.clps.sms.file.model;

import java.io.Serializable;

/**
 * @author erwin.wang
 *
 * 2017年8月9日下午1:33:44
 * 
 * since v1.0
 */
public class FileName implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2442167529336777695L;

	private String studentName;
	
	private String workCreatedDate;
	
	private Integer countStudent;

	/**
	 * @return the studentName
	 */
	public final String getStudentName() {
		return studentName;
	}

	/**
	 * @param studentName the studentName to set
	 */
	public final void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	/**
	 * @return the workCreatedDate
	 */
	public final String getWorkCreatedDate() {
		return workCreatedDate;
	}

	/**
	 * @param workCreatedDate the workCreatedDate to set
	 */
	public final void setWorkCreatedDate(String workCreatedDate) {
		this.workCreatedDate = workCreatedDate;
	}

	/**
	 * @return the countStudent
	 */
	public final Integer getCountStudent() {
		return countStudent;
	}

	/**
	 * @param countStudent the countStudent to set
	 */
	public final void setCountStudent(Integer countStudent) {
		this.countStudent = countStudent;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "FileName [studentName=" + studentName + ", workCreatedDate=" + workCreatedDate + ", countStudent="
				+ countStudent + "]";
	}
	
	
}
