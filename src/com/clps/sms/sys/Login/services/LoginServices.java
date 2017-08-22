package com.clps.sms.sys.Login.services;

import java.util.List;

import com.clps.sms.sys.model.Account;

public interface LoginServices {
	/**
	 * desc:登录Services验证
	 * @return List<Account>
	 * 
	 */
	public List<Account> loginServices();
	
}
