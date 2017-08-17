/**
 * 
 */
package com.clps.sms.sys.dao.impl;

import static org.junit.Assert.*;


import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.clps.sms.sys.dao.AccountDao;
import com.clps.sms.sys.factory.SysFactory;
import com.clps.sms.sys.model.Account;
import com.clps.sms.util.date.StringtoDate;
import com.clps.sms.util.db.DBConnection;

/**
 * @author erwin.wang
 *
 * 2017年8月15日下午3:00:20
 * 
 * since v1.0
 */
public class AccountDaoImplTest {

	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test method for {@link com.clps.sms.sys.dao.impl.AccountDaoImpl#AccountDaoImpl()}.
	 */
	@Test
	public void testAccountDaoImpl() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link com.clps.sms.sys.dao.impl.AccountDaoImpl#queryAllAccounts()}.
	 * @throws Exception 
	 */
	@Test
	public void testQueryAllAccounts() throws Exception {
		List<Account> list=SysFactory.getAccountInstance().queryAllAccounts();
		for(Account a:list){
			System.out.println("OOOOO"+a);
		}
		System.out.println(list.get(0));
	}

	/**
	 * Test method for {@link com.clps.sms.sys.dao.impl.AccountDaoImpl#queryAllAccountByCondition(com.clps.sms.sys.model.Account)}.
	 * @throws SQLException 
	 */
	@Test
	public void testQueryAllAccountByCondition() throws SQLException {
		Account acc=new Account();
		acc.setAcc_status(0);
		AccountDao accountDao=new AccountDaoImpl();
//		List<Account> list=accountDao.queryAllAccountByCondition(acc);
//		for(Account ac:list){
//			System.out.println(ac.getAcc_created_date());
//		}
//		System.out.println(list);
//		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link com.clps.sms.sys.dao.impl.AccountDaoImpl#queryAccountByMobile(java.lang.String)}.
	 * @throws SQLException 
	 */
	@Test
	public void testQueryAccountByMobile() throws SQLException {
		AccountDao accountDao=new AccountDaoImpl();
		boolean bool=accountDao.queryAccountByMobile("15230535659");
		System.out.println(bool);
//		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link com.clps.sms.sys.dao.impl.AccountDaoImpl#queryAccountByName(java.lang.String)}.
	 * @throws SQLException 
	 */
	@Test
	public void testQueryAccountByName() throws SQLException {
		AccountDao accountDao=new AccountDaoImpl();
		boolean bool=accountDao.queryAccountByName("啦啦");
		System.out.println(bool);
//		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link com.clps.sms.sys.dao.impl.AccountDaoImpl#updateAccountById(com.clps.sms.sys.model.Account, java.lang.Integer)}.
	 * @throws SQLException 
	 */
	@Test
	public void testUpdateAccountById() throws SQLException {
		
		Account acc=new Account();
		acc.setAcc_id(16);
		acc.setAcc_name("糊糊");
		acc.setAcc_password("234567");
		acc.setAcc_email("123456789@qq.com");
		acc.setAcc_mobile("15230535656");
		acc.setAcc_dec("huhuihihiuhiuhi");
		acc.setAcc_status(0);
		String date=StringtoDate.datetoString(new Date());
		acc.setAcc_updated_datatime(date);
		acc.setAcc_updated_name(1);
		acc.setAcc_role_id(2);
		
		AccountDao accountDao=new AccountDaoImpl();
		boolean bool=accountDao.updateAccountById(acc);
		System.out.println(bool);
//		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link com.clps.sms.sys.dao.impl.AccountDaoImpl#deleteAccountById(java.lang.Integer)}.
	 * @throws SQLException 
	 */
	@Test
	public void testDeleteAccountById() throws SQLException {
		Account acc=new Account();
		acc.setAcc_id(16);
		AccountDao accountDao=new AccountDaoImpl();
		boolean bool= accountDao.deleteAccountById(acc.getAcc_id());
		System.out.println(bool);
	}
	
	@Test
	public void insertAccount() throws SQLException{
		Account acc=new Account();
		
		acc.setAcc_name("啦啦");
		acc.setAcc_email("12345677");
		acc.setAcc_mobile("1111111111");
		acc.setAcc_dec("啦啦啦啦啦啦啦");
		acc.setAcc_status(1);
		String date=StringtoDate.datetoString(new Date());
		acc.setAcc_created_datatime(date);
		acc.setAcc_created_name(1);
		acc.setAcc_role_id(1);
		
		AccountDao accountDao=new AccountDaoImpl();
		
		boolean flag=accountDao.insertAccount(acc);
		
		System.out.println(flag);
		
		
//		DBConnection dbc=new DBConnection();
//		System.out.println(dbc.getConnection());
		
	}
}
