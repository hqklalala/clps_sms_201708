/**
 * Project Name:clps_sms_201708
 * File Name:AccountServiceImpl.java
 * Package Name:com.clps.sms.sys.service.impl
 * Date:2017年8月16日下午11:49:02
 * Copyright (c) 2017, chenzhou1025@126.com All Rights Reserved.
 *
*/

package com.clps.sms.sys.service.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.clps.sms.sys.dao.AccountDao;
import com.clps.sms.sys.dao.impl.AccountDaoImpl;
import com.clps.sms.sys.model.Account;
import com.clps.sms.sys.service.AccountService;
import com.sun.istack.internal.logging.Logger;

/**
 * ClassName:AccountServiceImpl <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     2017年8月16日 下午11:49:02 <br/>
 * @author   wqeq
 * @version  
 * @since    JDK 1.8
 * @see 	 
 */
public class AccountServiceImpl implements AccountService {
	
	private static Logger logger=Logger.getLogger(AccountServiceImpl.class);
	
	private static AccountDao accountDao=null;
	private static List<Account> listaccount=null;
	private static boolean flag=false;
	
	public AccountServiceImpl(){
		this.accountDao=new AccountDaoImpl();
		this.listaccount=new ArrayList<>();
	}

	@Override
	public List<Account> queryAllAccounts() {
		try {
			listaccount=accountDao.queryAllAccounts();
//			排序tocompare
			
			
			
		} catch (Exception e) {
//			logger.error("mysql db connection failure!");
//			添加日志
		}
		return null;
	}

	@Override
	public List<Account> queryAllAccountByCondition(int cond)   {
		try {
			accountDao.queryAllAccountByCondition(cond);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean queryAccountByMobile(String acc_mobile)   {
		try {
			flag=accountDao.queryAccountByMobile(acc_mobile);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public boolean queryAccountByName(String acc_name)   {
		try {
			flag=accountDao.queryAccountByName(acc_name);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public boolean updateAccountById(Account acc)   {
		try {
			flag=accountDao.updateAccountById(acc);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public boolean deleteAccountById(Integer acc_id)   {
		try {
			flag=accountDao.deleteAccountById(acc_id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public boolean insertAccount(Account acc)   {
		try {
			flag=accountDao.insertAccount(acc);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
	}

}
