/**
 * 
 */
package com.clps.sms.sys.dao;

import java.sql.SQLException;
import java.util.List;

import com.clps.sms.sys.model.Account;

/**
 * @author erwin.wang
 *
 * 2017年8月8日下午3:30:06
 * 
 * since v1.0
 */
public interface AccountDao {

	/**
	 * desc:
	 * 		
	 * @return List<Account> 
	 */
	public List<Account> queryAllAccounts()throws Exception;
	/**
	 * desc:
	 * 		query model with like
	 * 
	 * @param acc enc. Account 
	 * @return List<Account>
	 */
	public List<Account> queryAllAccountByCondition(int cond)throws SQLException;
	/**
	 * desc:
	 * 
	 * @param acc_mobile
	 * @return boolean true: acc_mobile unqine false: ....
	 */
	public boolean queryAccountByMobile(String acc_mobile)throws SQLException;
	/**
	 * desc:
	 * 		
	 * 
	 * @param acc_name
	 * @return boolean true: false:
	 */
	public boolean queryAccountByName(String acc_name)throws SQLException;
	/**
	 * desc:
	 * 		
	 * 
	 * @param acc
	 * @param acc_id
	 * @return
	 */
	public boolean updateAccountById(Account acc,Integer acc_id)throws SQLException;
	/**
	 * desc:
	 * 		
	 * @param acc_id
	 * @return
	 */
	public boolean deleteAccountById(Integer acc_id)throws SQLException;
	
	/**
	 * desc:
	 * 		
	 * @param acc
	 * @return
	 * @throws SQLException
	 */
	public boolean insertAccount(Account acc)throws SQLException;
}
