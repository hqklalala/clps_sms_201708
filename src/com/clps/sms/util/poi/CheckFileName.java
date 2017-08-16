/**
 * 
 */
package com.clps.sms.util.poi;

import java.util.Map;
import java.util.TreeMap;
import com.clps.sms.util.poi.dao.CheckFileNameDao;

/**
 * @author erwin.wang
 *
 * 2017年8月9日上午11:06:51
 * 
 * since v1.0
 */
public class CheckFileName implements CheckFileNameDao {


	private Map<String,String> maps;
	/**
	 * 
	 */
	public CheckFileName() {
		this.maps =new TreeMap<>();
	}

	/**
	 * 
	 * @param fileName		文件名称集合的字符串
	 * @param separator		文件内容分割符号	
	 * @param sfn          	文件名字字符串的分割符号
	 * @return Map<String,String>
	 */
	public Map<String,String> getNames(String fileName,String separator,String sfn){
		String []strNames =fileName.split(sfn);
		String [] splitedName = null;
		for(String str:strNames){
			splitedName =this.splitFileName(separator, str);
				maps.put(splitedName[0], splitedName[1]);
		}
		return maps;
	}
	
	/**
	 * 
	 * @param separator
	 * @param fileName
	 * @return String []
	 */
	public String [] splitFileName(final String separator, final String fileName){
		String []temp = null;
		if(null!=separator||("").equals(separator)){
			temp=fileName.split(separator);	
		}else{
			//
		}
		return temp;
	}
	
	/**
	 * 
	 * @param srcName 初始化的文件名字
	 * @param inName  输入的文件名字或上传的文件名字
	 * @return boolean true：代表名字相等 false：名字不相等
	 */
	public boolean checkName(String srcName,String inName){
		if(srcName.equals(inName)||srcName==inName){
			return true;
		}else{
			return false;
		}
	}
	
}
