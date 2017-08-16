/**
 * 
 */
package com.clps.sms.util;

import java.io.File;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author erwin.wang
 *
 * 2017年8月11日上午10:22:04
 * 
 * since v1.0
 */
public class FileIOTest {

	private FileIO fio;
	
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		this.fio = new FileIO();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		System.out.println("destroy!");
	}

	/**
	 * Test method for {@link com.clps.sms.util.FileIO#getFileName(java.io.File, java.lang.String)}.
	 */
	@Test
	public void testGetFileName() {
		//this.fio.getFileName(pathName, extension)
		File pathName = new File("");
		this.fio.getFileName(pathName, "zip");
	}

}
