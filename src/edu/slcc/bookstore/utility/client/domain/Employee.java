package edu.slcc.bookstore.utility.client.domain;

import java.io.Serializable;

import com.extjs.gxt.ui.client.data.BaseModelData;
import com.extjs.gxt.ui.client.data.BeanModelMarker;
import com.extjs.gxt.ui.client.data.BeanModelTag;
import com.extjs.gxt.ui.client.data.ModelData;
import com.extjs.gxt.ui.client.data.BeanModelMarker.BEAN;

import edu.slcc.bookstore.utility.client.data.Modelable;

public class Employee implements Serializable, BeanModelTag, Modelable{

	private static final long serialVersionUID = -7413481463818422595L;
	private String sNumber, name;
	
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
	
	@Override
	public ModelData getModel() {
		return new EmployeeModelData(sNumber, name); 
	}
	
	private class EmployeeModelData extends BaseModelData{
		public EmployeeModelData(String sNumber, String name) {
			set("sNumber", sNumber);
			set("name", name);
		}
	}
	
	
	/*
	 * Used to tag this JavaBean for use as a BeanModel. See 
	 * http://www.extjs.com/helpcenter/index.jsp?topic=/com.extjs.gxt.help/html/tutorials/beanmodel.html
	 *
	@BEAN(Employee.class)
	public interface EmployeeBeanModel extends BeanModelMarker{
		
	}*/
}
