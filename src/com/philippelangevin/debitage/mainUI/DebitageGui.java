package com.philippelangevin.debitage.mainUI;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import net.miginfocom.swing.MigLayout;

import com.philippelangevin.sdk.translationManagement.MessageBundle;
import com.philippelangevin.sdk.translationManagement.TranslationBundleFactory;
import com.philippelangevin.sdk.uiUtil.DialogRunningModes;
import com.philippelangevin.sdk.uiUtil.interfaces.EventRouterIF;
import com.philippelangevin.sdk.uiUtil.interfaces.GuiIF;

public class DebitageGui extends JFrame implements GuiIF {
	
	private static final MessageBundle messageBundle = TranslationBundleFactory.getTranslationBundle() ;

	private static final long serialVersionUID = 3810149079195633666L;
	
	private DebitageEventRouter eventRouter = null ;

	private String companyName ;
	private String defaultTitle = messageBundle.getString("New") ;
	
	private JPanel mainPanel = null ;
	
	private JButton newJobButton = null ;
	
	private JScrollPane jobListScrollPane = null ;
	private JTable jobListTable = null ;
	
	public DebitageGui(DebitageEventRouter eventRouter)	{
		setEventRouter(eventRouter) ;
		companyName = DebitageController.getInstance().getMainConfig().getCompanyName() ;
		
		this.setTitle(getTitle()) ;
		
//		this.setSize(480, 640) ;
		this.setContentPane(getMainPanel()) ;
		this.pack() ;
		
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE) ;
	}

	@Override
	public String getTitle() {
		return defaultTitle + " - " + companyName ;
	}
	
	private JPanel getMainPanel() {
		if (mainPanel == null){
			mainPanel = new JPanel(new MigLayout()) ;
			
			mainPanel.add(getNewJobButton());
			mainPanel.add(getJobListScrollPane()) ;
		}
		
		return mainPanel ;
	}

	private JButton getNewJobButton()	{
		if (newJobButton == null){
			newJobButton = new JButton(messageBundle.getString("NewJobButton")) ;
			
			newJobButton.addActionListener(eventRouter.getNewJobButtonActionListener()) ;
		}
		
		return newJobButton ;
	}
	private JScrollPane getJobListScrollPane() {
		if (jobListScrollPane == null){
			jobListScrollPane = new JScrollPane(getJobListTable(), JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		}
		
		return jobListScrollPane ;
	}

	private JTable getJobListTable() {
		if (jobListTable == null){
			jobListTable = new JTable() ;
		}
		
		return jobListTable ;
	}

	@Override
	public void setEventRouter(EventRouterIF eventRouter) {
		this.eventRouter = (DebitageEventRouter) eventRouter ;
	}

	@Override
	public boolean setRunningMode(DialogRunningModes runningMode) {
		/*
		 * Makes no sense for the root window
		 */
		return false;
	}
}
