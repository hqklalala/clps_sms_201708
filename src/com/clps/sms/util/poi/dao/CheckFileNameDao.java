/**
 * 
 */
package com.clps.sms.util.poi.dao;

import java.util.Map;

/**
 * @author erwin.wang
 *
 * 2017年8月9日上午11:07:24
 * 
 * since v1.0
 */
public interface CheckFileNameDao {

	/**
	 * 
	 * @param fileName		文件名称集合的字符串
	 * @param separator		文件内容分割符号	
	 * @param sfn          	文件名字字符串的分割符号
	 * @return Map<String,String> 返回Map类型，其中可以包含两个字符串对象数据。
	 */
	public Map<String,String> getNames(String fileName,String separator,String sfn);
}
