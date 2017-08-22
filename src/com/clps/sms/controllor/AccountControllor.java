package com.clps.sms.controllor;

import java.util.List;

import com.clps.sms.sys.model.Account;
import com.clps.sms.sys.service.AccountService;
import com.clps.sms.sys.service.impl.AccountServiceImpl;

/**
 * desc:控制账户管理页面流转
 * @author wqeq
 *
 */
public class AccountControllor {
	
	private AccountService accountService;
	/**
	 * 
	 * @return
	 */
	private List<Account> getAccount(){
		this.accountService=new AccountServiceImpl();
		return null;
		
	}
}
