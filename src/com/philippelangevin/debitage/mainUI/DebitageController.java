package com.philippelangevin.debitage.mainUI;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import com.philippelangevin.debitage.FileAccessor;
import com.philippelangevin.debitage.MainConfigModel;
import com.philippelangevin.sdk.translationManagement.TranslationBundleFactory;
import com.philippelangevin.sdk.uiUtil.interfaces.ControllerIF;

public class DebitageController extends ControllerIF {
	private FileAccessor fileAccessor = null ;
	private MainConfigModel mainConfig = null ;
	
	private static final DebitageController _instance = new DebitageController();
	
	public static DebitageController getInstance() {
		return _instance;
	}
	
	private DebitageController()	{
		this.fileAccessor = new FileAccessor(new File("").getAbsolutePath()) ;
	}
	
	public void startApplication()	{
		if (!loadMainConfig())	{
			return ;
		}
		
		TranslationBundleFactory.setLocale(mainConfig.getLanguage(), mainConfig.getCountry()) ;
		
		this.showMainGUI(true) ;
	}
	
	@Override
	protected DebitageEventRouter getEventRouter() {
		if (this.eventRouter == null) {
			this.eventRouter = new DebitageEventRouter(this);
		}
		return (DebitageEventRouter) this.eventRouter;
	}
	
	public MainConfigModel getMainConfig()	{
		return mainConfig ;
	}
	
	private boolean loadMainConfig()	{
		mainConfig = new MainConfigModel() ;

		try {
			mainConfig.load(fileAccessor.getMainConfig()) ;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return true ;
	}

	public void onNewJob() {
		// TODO Auto-generated method stub
		
	}

}
