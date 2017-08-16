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
	
	private PreparedStatement ps = null;
	private ResultSet rs = null;
	private Account account = null;
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
		this.ps = super.getConnection().prepareStatement(SELECTALLACCOUNTS);
		this.rs = ps.executeQuery();
		setListOfAccount(rs);
		logger.info("listOfAccount size: "+listAccount.size());
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
		this.ps = super.getConnection().prepareStatement(SELECTALLACCOUNTSBYCONDECTION);
		ps.setInt(1, cond);
		this.rs = ps.executeQuery();
		setListOfAccount(rs);
		logger.info("queryAllAccountByCondition listOfAccount size: "+listAccount.size());
		super.getClose();
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
		this.ps=super.getConnection().prepareStatement(SELECTALLACCOUNTSBYMOBILE);
		ps.setString(1,acc_mobile);
		rs=ps.executeQuery();
		flag=showcheckres(rs);
		logger.info("queryAccountByName checkMobile:"+flag);
		super.getClose();
		return flag;
	}

	/*
	 * (non-Javadoc)
	 * desc：验证名字唯一性
	 * @see com.clps.sms.sys.dao.AccountDao#queryAccountByName(java.lang.String)
	 */
	@Override
	public boolean queryAccountByName(String acc_name) throws SQLException{
		this.ps=super.getConnection().prepareStatement(SELECTALLACCOUNTSBYNAME);
		ps.setString(1,acc_name);
		rs=ps.executeQuery();
		flag=showcheckres(rs);
		logger.info("queryAccountByName checkName:"+flag);
		super.getClose();
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
	public boolean updateAccountById(Account acc, Integer acc_id)throws SQLException {
		this.ps=super.getConnection().prepareStatement(updateAccountById);
		
		ps.setString(1, acc.getAcc_name());
//		密码加密
		String pwd=MD5Utils.getPwd(acc.getAcc_password());
		ps.setString(2, pwd);
		ps.setString(3, acc.getAcc_email());
		ps.setString(4, acc.getAcc_mobile());
		ps.setString(5, acc.getAcc_dec());
		ps.setInt(6, acc.getAcc_status());
		ps.setString(7, acc.getAcc_updated_date());
		ps.setInt(8, acc.getAcc_updated_name());
		ps.setInt(9, acc.getAcc_role_id());
		ps.setInt(10, acc_id);
		row=ps.executeUpdate();
		flag=showopreult(row);
		logger.info("updateAccountById is"+flag);
		super.getClose();
		return flag;
	}

	/*
	 * (non-Javadoc)
	 * @desc:通过ID删除用户
	 * @see com.clps.sms.sys.dao.AccountDao#deleteAccountById(java.lang.Integer)
	 */
	@Override
	public boolean deleteAccountById (Integer acc_id) throws SQLException{
		this.ps=super.getConnection().prepareStatement(deleteAccountById);
		ps.setInt(1, acc_id);
		row=ps.executeUpdate();
		flag=showopreult(row);
		logger.info("deleteAccountById  is "+flag);
		super.getClose();
		return flag;
	}
	
	/* (non-Javadoc)
	 *desc：插入数据
	 * @see com.clps.sms.sys.dao.AccountDao#insertAccount(com.clps.sms.sys.model.Account)
	 */
	@Override
	public boolean insertAccount(Account acc) throws SQLException {
		
		this.ps =super.getConnection().prepareStatement(INSERTACCOUNT);
		
		ps.setString(1,acc.getAcc_name());
		ps.setString(2,acc.getAcc_email());
		ps.setString(3,acc.getAcc_mobile());
		ps.setString(4,acc.getAcc_dec());
		ps.setInt(5,acc.getAcc_status());
		ps.setString(6,acc.getAcc_created_date());
		ps.setInt(7,acc.getAcc_created_name());
		ps.setInt(8,acc.getAcc_role_id());
		
		row= ps.executeUpdate();
		flag=showopreult(row);
		logger.info("insertAccount is"+flag);
		super.getClose();
		return flag ;
	}
	
	
	/**
	 * 
	 * setListOfAccount:将查询的语句打印到list集合中
	 *
	 * @author wqeq
	 * @param rs
	 * @return
	 * @throws SQLException
	 * @since JDK 1.8
	 */
	private List<Account> setListOfAccount(ResultSet rs) throws SQLException{
		
		while(rs.next()){
			this.account  = new Account();
			
			account.setAcc_id(rs.getInt("acc_id"));
			account.setAcc_name(rs.getString("acc_name"));
			account.setAcc_mobile(rs.getString("acc_mobile"));
			account.setAcc_email(rs.getString("acc_email"));
			account.setAcc_dec(rs.getString("acc_dec"));
			account.setAcc_created_date(rs.getString("acc_created_datatime"));
			account.setAcc_created_name(rs.getInt("acc_created_name"));
			account.setAcc_updated_date(rs.getString("acc_update_datatime"));
			account.setAcc_updated_name(rs.getInt("acc_update_name"));
			account.setAcc_role_id(rs.getInt("acc_role_id"));
			
			listAccount.add(account);
		}
		return listAccount;
	}
	
	
	/**
	 * 
	 * showflag:判断返回值是true还是false
	 *
	 * @author wqeq
	 * @param row
	 * @return
	 * @since JDK 1.8
	 */
	public  boolean showopreult( int row){
		if(row>0){
			flag = true;
		}else{
			flag =false;
		}
		return flag;
		
	}
	
	/**
	 *
	 *desc:验证手机和用户名是否已存在
	 * @author wqeq
	 * @return
	 * @throws SQLException 
	 * @since JDK 1.8
	 */
	public boolean showcheckres(ResultSet rs) throws SQLException{
		if(rs.first()==false){
			flag=true;
		}else{
			flag=false;
		}
		return flag;
	}

}
