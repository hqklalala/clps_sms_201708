/**
 * 
 */
package com.clps.sms.sys.model;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import javax.xml.bind.JAXBException;

import org.xml.sax.SAXException;

/**
 * @author erwin.wang
 *
 * 2017年8月9日下午4:49:30
 * 
 * since v1.0
 */
public class TestAccount {

	/**
	 * @param args
	 * @throws JAXBException 
	 * @throws SAXException 
	 */
	public static void main(String[] args) throws SAXException, JAXBException {
		Account a =new Account();
		List<Account> listAccount =new LinkedList<>();
		for(int i=0;i<5;i++){
			Account temp =new Account();
			temp.setAcc_name("erwin"+i);
			listAccount.add(temp);
		}
		Collections.sort(listAccount,a);
		Iterator<Account> iterator = listAccount.iterator();
		while(iterator.hasNext()){
			System.out.println(iterator.next());
		}
		
	}

}
