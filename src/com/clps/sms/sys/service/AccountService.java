/**
 * Project Name:clps_sms_201708
 * File Name:AccountService.java
 * Package Name:com.clps.sms.sys.service
 * Date:2017年8月16日下午11:48:24
 * Copyright (c) 2017, chenzhou1025@126.com All Rights Reserved.
 *
*/

package com.clps.sms.sys.service;

import java.sql.SQLException;
import java.util.List;

import com.clps.sms.sys.model.Account;

/**
 * ClassName:AccountService <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     2017年8月16日 下午11:48:24 <br/>
 * @author   wqeq
 * @version  
 * @since    JDK 1.8
 * @see 	 
 */
public interface AccountService {
	/**
	 * desc:
	 * 		
	 * @return List<Account> 
	 */
	public List<Account> queryAllAccounts();
	/**
	 * desc:
	 * 		query model with like
	 * 
	 * @param acc enc. Account 
	 * @return List<Account>
	 */
	public List<Account> queryAllAccountByCondition(int cond);
	
	/**
	 * desc:
	 * 
	 * @param acc_mobile
	 * @return boolean true: acc_mobile unqine false: ....
	 */
	public boolean queryAccountByMobile(String acc_mobile);
	/**
	 * desc:
	 * 		
	 * 
	 * @param acc_name
	 * @return boolean true: false:
	 */
	public boolean queryAccountByName(String acc_name);
	/**
	 * desc:
	 * 		
	 * 
	 * @param acc
	 * @param acc_id
	 * @return
	 */
	public boolean updateAccountById(Account acc);
	/**
	 * desc:
	 * 		
	 * @param acc_id
	 * @return
	 */
	public boolean deleteAccountById(Integer acc_id);
	
	/**
	 * desc:
	 * 		
	 * @param acc
	 * @return
	 * @throws SQLException
	 */
	public boolean insertAccount(Account acc);
}
