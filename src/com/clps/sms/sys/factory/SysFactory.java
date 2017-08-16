/**
 * 
 */
package com.clps.sms.sys.factory;

import com.clps.sms.sys.dao.AccountDao;
import com.clps.sms.sys.dao.MenuDao;
import com.clps.sms.sys.dao.RoleDao;
import com.clps.sms.sys.dao.impl.AccountDaoImpl;
import com.clps.sms.sys.dao.impl.MenuDaoImpl;
import com.clps.sms.sys.dao.impl.RoleDaoImpl;

/**
 * @author erwin.wang
 *
 * 2017年8月15日下午2:25:54
 * 
 * since v1.0
 */
public class SysFactory {

	/**
	 * desc:创建新建
	 * 		
	 * 
	 * @return AccountDao
	 */
	public static AccountDao getAccountInstance(){
		return new AccountDaoImpl();
	}
	/**
	 * 
	 * @return
	 */
	public static RoleDao getRoleInstance(){
		return new RoleDaoImpl();
	}
	/**
	 * 
	 * @return
	 */
	public static MenuDao getMenuInstance(){
		return new MenuDaoImpl();
	}
	/*public static AccountDao getAccountInstance(){
		return new AccountDaoImpl();
	}*/
}
