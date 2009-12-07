package edu.slcc.bookstore.utility.client;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.extjs.gxt.desktop.client.Desktop;
import com.extjs.gxt.ui.client.Style.SortDir;
import com.extjs.gxt.ui.client.data.BaseModel;
import com.extjs.gxt.ui.client.data.BaseModelData;
import com.extjs.gxt.ui.client.data.BasePagingLoadConfig;
import com.extjs.gxt.ui.client.data.Loader;
import com.extjs.gxt.ui.client.data.ModelData;
import com.extjs.gxt.ui.client.data.PagingLoadConfig;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.widget.Window;
import com.extjs.gxt.ui.client.widget.grid.ColumnConfig;
import com.extjs.gxt.ui.client.widget.grid.ColumnModel;
import com.extjs.gxt.ui.client.widget.grid.Grid;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.utahwd.gwt.data.Modelable;

import edu.slcc.bookstore.utility.client.domain.Employee;

public class EntryPoint implements com.google.gwt.core.client.EntryPoint {

	private Desktop desktop = new Desktop();
	@Override
	public void onModuleLoad() {
		Window win = getWindow();
		desktop.addWindow(win);
		win.show();
	}

	
	public Window getWindow(){
		Window win = new Window();
		// Create the store and add our models to it
		final ListStore<ModelData> store = new ListStore<ModelData>();
		for(Modelable m : getList()){
			store.add(m.getModel());
		}
		
		// Create our columns
		List<ColumnConfig> columns = new ArrayList<ColumnConfig>();
		ColumnConfig column = new ColumnConfig("sNumber", 100);
		columns.add(column);
		column = new ColumnConfig("name", 100);
		columns.add(column);
		ColumnModel model = new ColumnModel(columns);
		Grid<ModelData> grid = new Grid<ModelData>(store, model);
		win.add(grid);
		
		return win;
	}
	
	
	private List<Modelable> getList(){
		List<Modelable> list = new ArrayList<Modelable>();
		list.add(new Employee("S00456789", "David Welch"));
		list.add(new Employee("S00456790", "Susan White"));
		list.add(new Employee("S00456791", "Richard Allred"));
		list.add(new Employee("S00456792", "Matt Haidenthaller"));
		return list;
	}
}
