/**
 * 
 */
package com.clps.sms.sys.dao;

import java.util.List;

import com.clps.sms.sys.model.Menu;

/**
 * @author erwin.wang
 *
 * 2017年8月15日下午2:19:53
 * 
 * since v1.0
 */
public interface MenuDao {

	/**
	 * desc:
	 * 		query menu table detail	
	 * @return List<Menu>
	 */
	public List<Menu> queryMenuDetail();
}
