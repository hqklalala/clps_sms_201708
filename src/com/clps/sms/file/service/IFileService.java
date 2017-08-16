/**
 * 
 */
package com.clps.sms.file.service;

import java.util.List;
import java.util.Map;

import com.clps.sms.file.model.FileName;

/**
 * @author erwin.wang
 *
 * 2017年8月9日下午2:36:53
 * 
 * since v1.0
 */
public interface IFileService {

	/**
	 * 
	 * @param names
	 * @param separator
	 * @param sfn
	 * @return Map<String, List<FileName>> 
	 */
	public Map<String, List<FileName>> countStudentName(String names, String separator, String sfn);
}
