package com.clps.sms.sys.Login.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.management.loading.PrivateClassLoader;

import org.apache.log4j.Logger;

import com.clps.sms.sys.Login.dao.LoginDao;
import com.clps.sms.sys.model.Account;
import com.clps.sms.util.db.BaseDaoImpl;

public class LoginDaoImpl implements LoginDao {
	
	private static Logger logger=Logger.getLogger(LoginDaoImpl.class);
	
	private static List<Account> listaccount=null;
	
	private static boolean flag=false;
	
	public LoginDaoImpl(){
		this.listaccount=new  ArrayList<Account>();
	}
	
	private static String strtemp="ACC_ID,"
							+"ACC_NAME,"
							+ "ACC_EMAIL,"
							+ "ACC_MOBILE," 
							+ "ACC_DEC," 
							+"ACC_STATUS,"
							+ "ACC_CREATED_DATATIME,"
							+"ACC_CREATED_NAME,"
							+"ACC_UPDATE_DATATIME,"
							+"ACC_UPDATE_NAME,"
							+"ACC_ROLE_ID";
	
	//通过用户名和密码查询信息
		private static final String checknameandpwd="SELECT"+strtemp+"FROM ACCOUNT WHERE"
																	+ " ACC_NAME=? "
																	+ "AND ACC_PASSWORD=?"
																	+ " AND ACC_STATUS=1";

	/**
	 * desc:登录用户名密码验证
	 * @param acc_name
	 * @param acc_pwd
	 * @return List<Account>
	 */
	@Override
	public List<Account> queryAccountbynamepwd(String acc_name, String acc_pwd) {
		Object[] paramsValue={acc_name,acc_pwd};
		listaccount=new BaseDaoImpl().query(checknameandpwd, paramsValue,Account.class);
		flag=new BaseDaoImpl().showcheckres(listaccount);
		logger.info(acc_name+"登陆"+flag);
		return listaccount;
	}
	
}
