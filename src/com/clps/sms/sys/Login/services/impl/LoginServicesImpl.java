package com.clps.sms.sys.Login.services.impl;

import java.util.List;

import com.clps.sms.sys.Login.dao.LoginDao;
import com.clps.sms.sys.Login.services.LoginServices;
import com.clps.sms.sys.model.Account;

public class LoginServicesImpl implements LoginServices {

	private LoginDao loginDao;
	
	
	/**
	 *desc:创建LoginDao对象
	 * @param loginDao
	 */

	public LoginServicesImpl(LoginDao loginDao) {
		this.loginDao = loginDao;
	}



	@Override
	public List<Account> loginServices() {
		
		return null;
	}

}
