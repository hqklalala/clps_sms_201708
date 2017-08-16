/**
 * 
 */
package com.clps.sms.util;

import java.io.File;

import org.apache.log4j.Logger;

/**
 * @author erwin.wang
 *
 * 2017年8月11日上午10:12:30
 * 
 * since v1.0
 */
public class FileIO {
	
	private Logger logger = Logger.getLogger(FileIO.class);
	private File file;
	private String dir;
	private String fileName;
	private String [] fileNames;
	
	/**
	 * 
	 */
	public FileIO() {
		super();
	}

	/**
	 * 
	 */
	public FileIO(String dir,String fileName) {
		this.file = new File(dir,fileName);
	}

	/**
	 * desc：
	 * 		该方法遍历指定文件夹下的文件，
	 *      将与参数相等的扩展名字的文件查询出来并返回出字符串数组。
	 * 
	 * @param pathName  文件夹路径
	 * @param extension 扩展名字
	 * @return String[] 返回
	 */
	public String[] getFileName(File pathName,String extension){
		String tempName = "";
		String [] tempNames;
		if(pathName.isDirectory()){
			fileNames = file.list();
			tempNames = new String[fileNames.length];
			logger.info("fileNames Size: "+fileNames.length);
		}
		for(int i=0;i<fileNames.length;i++){
			if(fileNames[i].endsWith(extension)){
				
			}
		}
		return fileNames;
	}
	
	private void mm(){}
	
}
