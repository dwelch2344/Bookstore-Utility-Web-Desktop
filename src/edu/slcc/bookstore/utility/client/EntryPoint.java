package edu.slcc.bookstore.utility.client;

import java.util.ArrayList;
import java.util.List;

import com.extjs.gxt.desktop.client.Desktop;
import com.extjs.gxt.ui.client.data.BeanModel;
import com.extjs.gxt.ui.client.data.BeanModelFactory;
import com.extjs.gxt.ui.client.data.BeanModelLookup;
import com.extjs.gxt.ui.client.data.ModelData;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.widget.Window;
import com.extjs.gxt.ui.client.widget.grid.ColumnConfig;
import com.extjs.gxt.ui.client.widget.grid.ColumnModel;
import com.extjs.gxt.ui.client.widget.grid.Grid;

import edu.slcc.bookstore.utility.client.data.Modelable;
import edu.slcc.bookstore.utility.client.domain.Employee;

public class EntryPoint implements com.google.gwt.core.client.EntryPoint {

	private Desktop desktop = new Desktop();
	@Override
	public void onModuleLoad() {
		Window win = getWindow2();
		desktop.addWindow(win);
		win.show();
	}
	

	public Window getWindow2(){
		Window win = new Window();
		
		// This lets us use our Beans in our Widgets. 
		// The factory creates BeanModel instances from our Bean Class
		BeanModelFactory factory = BeanModelLookup.get().getFactory(Employee.class);
		
		// Create the store and add our models to it
		final ListStore<BeanModel> store = new ListStore<BeanModel>();
		for(Employee m : getBeanList()){
			BeanModel model = factory.createModel(m);
			store.add(model);
		}
		
		// Create our columns
		List<ColumnConfig> columns = new ArrayList<ColumnConfig>();
		columns.add(new ColumnConfig("sNumber", 100));
		columns.add(new ColumnConfig("name", 100));
		ColumnModel model = new ColumnModel(columns);
		
		// Create the Grid from the data and the columns
		Grid<BeanModel> grid = new Grid<BeanModel>(store, model);
		win.add(grid);
		
		return win;
	}
	
	
	private List<Employee> getBeanList(){
		List<Employee> list = new ArrayList<Employee>();
		list.add(new Employee("S00456789", "David Welch"));
		list.add(new Employee("S00456790", "Susan White"));
		list.add(new Employee("S00456791", "Richard Allred"));
		list.add(new Employee("S00456792", "Matt Haidenthaller"));
		return list;
	}
}
