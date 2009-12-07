package edu.slcc.bookstore.utility.client.domain;

import java.io.Serializable;

import com.extjs.gxt.ui.client.data.BaseModelData;
import com.extjs.gxt.ui.client.data.BeanModelMarker;
import com.extjs.gxt.ui.client.data.BeanModelTag;
import com.extjs.gxt.ui.client.data.ModelData;
import com.extjs.gxt.ui.client.data.BeanModelMarker.BEAN;

import edu.slcc.bookstore.utility.client.data.Modelable;

public class Employee implements Serializable, BeanModelTag{

	private static final long serialVersionUID = -7413481463818422595L;
	private String sNumber, name;
	
	// DON'T FORGET THIS OTHERWISE GWT COMPLAINS!!!
	public Employee() {
		// TODO Auto-generated constructor stub
	}
	
	public Employee(String sNumber, String name) {
		this.sNumber = sNumber;
		this.name = name;
	}
	
	
	public String getName() {
		return name;
	}
	
	public String getsNumber() {
		return sNumber;
	}
	
	
	
	/*
	 * Used to tag this JavaBean for use as a BeanModel. See 
	 * http://www.extjs.com/helpcenter/index.jsp?topic=/com.extjs.gxt.help/html/tutorials/beanmodel.html
	 *
	@BEAN(Employee.class)
	public interface EmployeeBeanModel extends BeanModelMarker{
		
	}*/
}
