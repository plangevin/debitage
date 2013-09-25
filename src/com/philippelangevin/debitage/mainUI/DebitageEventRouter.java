package com.philippelangevin.debitage.mainUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.philippelangevin.sdk.uiUtil.interfaces.ControllerIF;
import com.philippelangevin.sdk.uiUtil.interfaces.EventRouterIF;

public class DebitageEventRouter implements EventRouterIF {
	
	private DebitageController controller = null ;
	private DebitageGui gui = null ;
	
	public DebitageEventRouter(DebitageController controller)	{
		setController(controller) ;
	}

	public ActionListener getNewJobButtonActionListener() {
		return new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				onNewJob() ;
			}
		} ;
	}
	
	protected void onNewJob()	{
		controller.onNewJob() ;
	}

	@Override
	public void setController(ControllerIF controller) {
		this.controller = (DebitageController) controller ;		
	}

	@Override
	public ControllerIF getController() {
		return this.controller ;
	}

	@Override
	public DebitageGui getGUI() {
		if (gui == null){
			gui = new DebitageGui(this) ;
		}
		
		return gui;
	}

	@Override
	public void showGUI(boolean show) {
		getGUI().setVisible(show) ;
	}

	@Override
	public void dispose() {
		getGUI().dispose() ;
	}
}
