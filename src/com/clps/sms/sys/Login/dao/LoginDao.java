package com.clps.sms.sys.Login.dao;

import java.util.List;

import com.clps.sms.sys.model.Account;

public interface LoginDao {
	/**
	 * desc：验证用户登录是否登陆成功00000
	 * @return List<Accout>
	 */
	public List<Account> queryAccountbynamepwd(String acc_name,String acc_pwd);
	
}
