/**
 * 
 */
package com.clps.sms.file.service.impl;


import static org.junit.Assert.*;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import com.clps.sms.file.model.FileName;
import com.clps.sms.file.service.IFileService;


/**
 * @author erwin.wang
 *
 * 2017年8月9日下午3:18:12
 * 
 * since v1.0
 */
public class FileServiceTest {

	private IFileService fs =null;
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		System.out.println("init!");
		this.fs =new FileService();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		System.out.println("destroy!");
	}

	/**
	 * Test method for {@link com.clps.sms.file.service.impl.FileService#countStudentName(java.lang.String, java.lang.String, java.lang.String)}.
	 */
	@Test
	public void testCountStudentName() {
		String names ="xxxx_20170809;"
				+ "xxxx1_20170809;"
				+ "xxxx2_20170809;"
				+ "xxxx3_20170809;"
				+ "xxxx4_20170809;"
				+ "xxxx5_20170809;"
				+ "xxxx6_20170810;"
				+ "xxxx_20170809;"
				+ "xxxx1_20170810";
		this.printMap(this.fs.countStudentName(names, "_", ";"));
		assertEquals(5, add(2,3));
		assertNotEquals(6, add(2,3));
		
	}
	

	public int add(int a,int b){
		return a + b;
	}
	
	
	@Test
	public void mm(){
		System.out.println("mm()");
	}
	
	
	private void printMap(Map<String, List<FileName>> maps) {
		for (Entry<String, List<FileName>> entry : maps.entrySet()) {
			System.out.println(entry.getKey());
			this.printList(entry.getValue());
		}
	}

	/**
	 * 
	 * @param fnl
	 */
	private void printList(List<FileName> fnl){
		Iterator<FileName> its=fnl.iterator();
		FileName  fileName =null;
		while(its.hasNext()){
			fileName = its.next();
			System.out.println("\t"+fileName.getStudentName());
			System.out.println("\t"+fileName.getWorkCreatedDate());
		}
	}
}
