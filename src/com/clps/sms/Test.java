/**
 * 
 */
package com.clps.sms;

import com.clps.sms.sys.factory.SysFactory;

/**
 * @author erwin.wang
 *
 * 2017年8月15日下午2:29:10
 * 
 * since v1.0
 */
public class Test {

	public static void main(String[] args) throws Exception {
		SysFactory.getAccountInstance().queryAllAccounts();
	}
}
