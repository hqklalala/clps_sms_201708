/**
 * 
 */
package com.clps.sms.sys.dao.impl;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;

import java.util.List;

import org.apache.log4j.Logger;

import com.clps.sms.sys.dao.AccountDao;
import com.clps.sms.sys.model.Account;
import com.clps.sms.util.MD5Utils;
import com.clps.sms.util.date.StringtoDate;
import com.clps.sms.util.db.BaseDaoImpl;
import com.clps.sms.util.db.DBConnection;

/**
 * @author erwin.wang
 *
 *         2017年8月8日下午3:32:53
 * 
 *         since v1.0
 */
public class AccountDaoImpl extends DBConnection implements AccountDao {

	private static Logger logger = Logger.getLogger(AccountDaoImpl.class);
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
//	查询所有用户数据
	private static final String SELECTALLACCOUNTS = "SELECT "
														+ strtemp
														+" FROM ACCOUNT WHERE ACC_STATUS=1";
//	插入数据
	private static final String INSERTACCOUNT="INSERT INTO ACCOUNT ("
														+ "ACC_NAME,"
														+ "ACC_EMAIL,"
														+ "ACC_MOBILE,"
														+ "ACC_DEC,"
														+ "ACC_STATUS,"
														+ "ACC_CREATED_DATATIME,"
														+ "ACC_CREATED_NAME,"
														+ "ACC_ROLE_ID"
														+ ")VALUES(?,?,?,?,?,?,?,?);";
	
//	通过状态查询用户数据
	private static final String SELECTALLACCOUNTSBYCONDECTION = "SELECT " 
														+strtemp
														+ "FROM ACCOUNT WHERE ACC_STATUS=?";
//	通过电话查询所有数据
	private static final String SELECTALLACCOUNTSBYMOBILE = "SELECT ACC_MOBILE FROM ACCOUNT WHERE ACC_MOBILE=?";
//	通过名字查询所有数据
	private static final String SELECTALLACCOUNTSBYNAME = "SELECT  ACC_NAME FROM ACCOUNT WHERE ACC_NAME=?";
//	通过Id修改信息
	private static final String updateAccountById="UPDATE ACCOUNT SET "
														+" ACC_NAME=?," 	
														+ "ACC_PASSWORD=?,"
														+ "ACC_EMAIL=?,"
														+ "ACC_MOBILE=?,"
														+ "ACC_DEC=?," 
														+" ACC_STATUS=?,"
														+" ACC_UPDATE_DATATIME=?,"
														+" ACC_UPDATE_NAME=?,"
														+" ACC_ROLE_ID=?"
														+" WHERE ACC_ID=?";
//	通过ID删除
	private static final String deleteAccountById="UPDATE ACCOUNT SET ACC_STATUS=0 WHERE ACC_ID=?";	
	
	
	private List<Account> listAccount =null;
	private boolean flag = false;
	private int row =0;
	/**
	 * 初始化List<Account> listAccount
	 */
	public AccountDaoImpl() {
		this.listAccount = new ArrayList<>();

	}

	/**
	 * desc:查询当前所有有效用户
	 * 		
	 * return List<Account>
	 */
	@Override
	public List<Account> queryAllAccounts() throws SQLException {
		
		listAccount=BaseDaoImpl.query(SELECTALLACCOUNTS, null, Account.class );
		return listAccount;
	}

	
	
	/*
	 * (non-Javadoc)
	 * desc:通过状态查询所有该状态的用户信息
	 * @see
	 * com.clps.sms.sys.dao.AccountDao#queryAllAccountByCondition(com.clps.sms.
	 * sys.model.Account)
	 */
	@Override
	public List<Account> queryAllAccountByCondition(int cond)throws SQLException {

		listAccount=BaseDaoImpl.query(SELECTALLACCOUNTSBYCONDECTION, new Object[]{cond}, Account.class );
		return listAccount;
	}

	/*
	 * (non-Javadoc)
	 * desc：验证手机唯一性
	 * @see
	 * com.clps.sms.sys.dao.AccountDao#queryAccountByMobile(java.lang.String)
	 */
	@Override
	public boolean queryAccountByMobile(String acc_mobile)throws SQLException {

		listAccount=BaseDaoImpl.query(SELECTALLACCOUNTSBYMOBILE, new Object[]{acc_mobile}, Account.class );
		flag=BaseDaoImpl.showcheckres(listAccount);
		return flag;
	}

	/*
	 * (non-Javadoc)
	 * desc：验证名字唯一性
	 * @see com.clps.sms.sys.dao.AccountDao#queryAccountByName(java.lang.String)
	 */
	@Override
	public boolean queryAccountByName(String acc_name) throws SQLException{

		listAccount=BaseDaoImpl.query(SELECTALLACCOUNTSBYNAME, new Object[]{acc_name}, Account.class );
		flag=BaseDaoImpl.showcheckres(listAccount);
		return flag;
	}

	/*
	 * (non-Javadoc)
	 * desc:通过Id修改用户信息
	 * @see
	 * com.clps.sms.sys.dao.AccountDao#updateAccountById(com.clps.sms.sys.model.
	 * Account, java.lang.Integer)
	 */

	@Override
	public boolean updateAccountById(Account acc)throws SQLException {
		Object[] obj={acc.getAcc_name(),MD5Utils.getPwd(acc.getAcc_password()),acc.getAcc_email(),
				acc.getAcc_mobile(),acc.getAcc_dec(),acc.getAcc_status(),acc.getAcc_updated_datatime(),
				acc.getAcc_updated_name(),acc.getAcc_role_id(),acc.getAcc_id()};
		
		flag=BaseDaoImpl.update(updateAccountById, obj);
		
		return flag;
	}

	/*
	 * (non-Javadoc)
	 * @desc:通过ID删除用户
	 * @see com.clps.sms.sys.dao.AccountDao#deleteAccountById(java.lang.Integer)
	 */
	@Override
	public boolean deleteAccountById (Integer acc_id) throws SQLException{
		
		flag=BaseDaoImpl.update(deleteAccountById, new Object[]{acc_id});
		return flag;
	}
	
	/* (non-Javadoc)
	 *desc：插入数据
	 * @see com.clps.sms.sys.dao.AccountDao#insertAccount(com.clps.sms.sys.model.Account)
	 */
	@Override
	public boolean insertAccount(Account acc) throws SQLException {
		
		Object[] obj={acc.getAcc_name(),acc.getAcc_email(),acc.getAcc_mobile(),
				acc.getAcc_dec(),acc.getAcc_status(),acc.getAcc_created_datatime(),
				acc.getAcc_created_name(),acc.getAcc_role_id()};
		flag=BaseDaoImpl.update(INSERTACCOUNT, obj);
		
		return flag ;
	}
	

}
