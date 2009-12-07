package edu.slcc.bookstore.utility.client;

import java.util.ArrayList;
import java.util.List;

import com.extjs.gxt.desktop.client.Desktop;
import com.extjs.gxt.ui.client.data.BeanModel;
import com.extjs.gxt.ui.client.data.BeanModelFactory;
import com.extjs.gxt.ui.client.data.BeanModelLookup;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.widget.Window;
import com.extjs.gxt.ui.client.widget.grid.ColumnConfig;
import com.extjs.gxt.ui.client.widget.grid.ColumnModel;
import com.extjs.gxt.ui.client.widget.grid.Grid;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.rpc.ServiceDefTarget;

import edu.slcc.bookstore.utility.client.domain.Employee;
import edu.slcc.bookstore.utility.client.service.EmployeeLookupService;
import edu.slcc.bookstore.utility.client.service.EmployeeLookupServiceAsync;

public class EntryPoint implements com.google.gwt.core.client.EntryPoint {

	private Desktop desktop = new Desktop();
	
	// This lets us use our Beans in our Widgets. 
	// The factory creates BeanModel instances from our Bean Class
	private final BeanModelFactory factory = BeanModelLookup.get().getFactory(Employee.class);
	
	public void onModuleLoad() {
		Window win = getWindow2();
		desktop.addWindow(win);
		win.show();
	}
	

	public Window getWindow2(){
		Window win = new Window();
		
		// Create an instance of our Service
		EmployeeLookupServiceAsync service = (EmployeeLookupServiceAsync) GWT.create(EmployeeLookupService.class);
		// Register the service's URL (corresponds to the web.xml file)
		((ServiceDefTarget) service).setServiceEntryPoint( GWT.getModuleBaseURL() + "EmployeeLookupService");
		
		// Create the store that holds the data for our Grid
		final ListStore<BeanModel> store = new ListStore<BeanModel>();
		
		// Create our callback. If successful, we iterate the employees and add them to the ListStore
		AsyncCallback<List<Employee>> callback = new AsyncCallback<List<Employee>>() {
			
			public void onSuccess(List<Employee> result) {
				for(Employee m : result){
					BeanModel model = factory.createModel(m);
					store.add(model);
				}
			}
			
			public void onFailure(Throwable caught) {
				com.google.gwt.user.client.Window.alert("Failed!\n" + caught.getLocalizedMessage());
			}
		};
		// This actually makes the work happen
		service.getEmployeeList(callback);
		

		// Now we just create our columns
		List<ColumnConfig> columns = new ArrayList<ColumnConfig>();
		columns.add(new ColumnConfig("sNumber", 100));
		columns.add(new ColumnConfig("name", 100));
		ColumnModel model = new ColumnModel(columns);
		
		// Create the Grid from the data and the columns
		Grid<BeanModel> grid = new Grid<BeanModel>(store, model);
		win.add(grid);
		
		return win;
	}
	
	
	
}
