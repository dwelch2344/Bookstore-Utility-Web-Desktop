package edu.slcc.bookstore.utility.client.domain;

import com.extjs.gxt.ui.client.data.BaseModelData;
import com.extjs.gxt.ui.client.data.ModelData;
import com.utahwd.gwt.data.Modelable;

public class Employee implements Modelable{

	private String sNumber, name;
	
	public Employee(String sNumber, String name) {
		this.sNumber = sNumber;
		this.name = name;
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
}
