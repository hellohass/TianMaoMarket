package com.tianmao.market.pages;

import java.util.UUID;

import org.apache.log4j.Logger;

import com.tianmao.market.bean.Customer;
import com.tianmao.market.bean.Material;
import com.tianmao.market.dao.CustomerDAO;
import com.tianmao.market.dao.MaterialDAO;

public class PurchaseFirstDay {

	private static Logger logger = Logger.getLogger(PurchaseFirstDay.class);
	
	public static void main(String[] args) {
		
		//**********************三只松鼠店面************************
		 Material guazi = getMaterial("瓜子",23);
		 MaterialDAO doMaterial = new MaterialDAO();
		 doMaterial.insertNewMaterial(guazi);
		 
		 //****************增加一个顾客***********
		 Customer firstMan = getPerson("路人甲",132);
		 CustomerDAO cusDao = new CustomerDAO();
		 cusDao.insertNewCustomer(firstMan);
	}	
 
	private static Customer getPerson(String name, int costAccount) {
		Customer AA = new Customer();
		AA.setId(getUUID());
		AA.setName(name);
		AA.setNumber("a001");
		AA.setCostAccount(costAccount);
		return AA;
	}

	private static Material getMaterial(String name, int price) {
		Material buyMaterial = new Material();
		String firstId = getUUID();
		buyMaterial.setId(firstId);
		buyMaterial.setName(name);
		buyMaterial.setNumber("001");
		buyMaterial.setPrice(price);
		return buyMaterial;
	}
	
	public static String getUUID(){
		UUID getID = UUID.randomUUID();
		return getID.toString(); 
	}
	
}
