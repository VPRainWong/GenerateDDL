package com.vp.plugin.sample.genddl.actions;

import java.sql.SQLClientInfoException;

import com.vp.plugin.ApplicationManager;
import com.vp.plugin.DatabaseManager;
import com.vp.plugin.ViewManager;
import com.vp.plugin.action.VPAction;
import com.vp.plugin.action.VPActionController;
import com.vp.plugin.diagram.IBusinessProcessDiagramUIModel;
import com.vp.plugin.diagram.IDiagramUIModel;
import com.vp.plugin.diagram.IShapeUIModel;
import com.vp.plugin.model.DatabaseType;
import com.vp.plugin.model.IModelElement;
import com.vp.plugin.model.IProject;
import com.vp.plugin.model.factory.IModelElementFactory;

public class GenDDLActionControl implements VPActionController {

	@Override
	public void performAction(VPAction arg0) {
		// retrieve current opening project
		IProject project = ApplicationManager.instance().getProjectManager().getProject();		
		
		// obtain DatabaseManager form ApplicationManager
		DatabaseManager dm = ApplicationManager.instance().getDatabaseManager();
		
		// obtain all entities (DB Table) from project
		IModelElement[] entities = project.toModelElementArray(IModelElementFactory.MODEL_TYPE_DB_TABLE);
		
		// call DatabaseManager to generate DDL
		String ddl = dm.generateCreateSQL(DatabaseType.MySQL_505, entities);
		
		// display DDL in message pane 
		ApplicationManager.instance().getViewManager().showMessage(ddl);
	}

	@Override
	public void update(VPAction arg0) {
		// TODO Auto-generated method stub
		
	}

}
