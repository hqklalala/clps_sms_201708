/**
 * 
 */
package com.clps.sms.sys.model;

import java.io.Serializable;
import java.util.Comparator;

/**
 * desc:
 * 		
 * 
 * @author erwin.wang
 *
 *         2017年8月8日下午3:17:32
 * 
 *         since v1.0
 */
public class Account implements Serializable, Comparator<Account> {

	/*
	 * 账户编号 账户名称 账户密码 账户邮箱 账户电话 账户描述 账户状态
	 */

	/**
	 * 
	 */
	private static final long serialVersionUID = -1104603544322025824L;
	private Integer acc_id;
	private String acc_name; // ACC_NAME
	private String acc_password; // ACC_PASSWORD
	private String acc_email; // ACC_EMAIL
	private String acc_mobile; // ACC_MOBILE
	private String acc_dec; // ACC_DEC
	private Integer acc_status; // ACC_STATUS
	private String acc_created_date;
	private Integer acc_created_name;
	private String acc_updated_date;
	private Integer acc_updated_name;
	private Integer acc_role_id;
	public final Integer getAcc_id() {
		return acc_id;
	}
	public final void setAcc_id(Integer acc_id) {
		this.acc_id = acc_id;
	}
	public final String getAcc_name() {
		return acc_name;
	}
	public final void setAcc_name(String acc_name) {
		this.acc_name = acc_name;
	}
	public final String getAcc_password() {
		return acc_password;
	}
	public final void setAcc_password(String acc_password) {
		this.acc_password = acc_password;
	}
	public final String getAcc_email() {
		return acc_email;
	}
	public final void setAcc_email(String acc_email) {
		this.acc_email = acc_email;
	}
	public final String getAcc_mobile() {
		return acc_mobile;
	}
	public final void setAcc_mobile(String acc_mobile) {
		this.acc_mobile = acc_mobile;
	}
	public final String getAcc_dec() {
		return acc_dec;
	}
	public final void setAcc_dec(String acc_dec) {
		this.acc_dec = acc_dec;
	}
	public final Integer getAcc_status() {
		return acc_status;
	}
	public final void setAcc_status(Integer acc_status) {
		this.acc_status = acc_status;
	}
	public final String getAcc_created_date() {
		return acc_created_date;
	}
	public final void setAcc_created_date(String acc_created_date) {
		this.acc_created_date = acc_created_date;
	}
	public final Integer getAcc_created_name() {
		return acc_created_name;
	}
	public final void setAcc_created_name(Integer acc_created_name) {
		this.acc_created_name = acc_created_name;
	}
	public final String getAcc_updated_date() {
		return acc_updated_date;
	}
	public final void setAcc_updated_date(String acc_updated_date) {
		this.acc_updated_date = acc_updated_date;
	}
	public final Integer getAcc_updated_name() {
		return acc_updated_name;
	}
	public final void setAcc_updated_name(Integer acc_updated_name) {
		this.acc_updated_name = acc_updated_name;
	}
	public final Integer getAcc_role_id() {
		return acc_role_id;
	}
	public final void setAcc_role_id(Integer acc_role_id) {
		this.acc_role_id = acc_role_id;
	}
	public static final long getSerialversionuid() {
		return serialVersionUID;
	}
	
	@Override
	public int compare(Account arg0, Account arg1) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
}
