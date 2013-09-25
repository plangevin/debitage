package com.philippelangevin.debitage;

import java.io.File;

public class FileAccessor {
	/*
	 * Folders
	 */
	private static final String resources = "resources" ;
	
	/*
	 * Files
	 */
	/*
	 * Files in the resource folder
	 */
	private static final String mainConfigFile = "config.xml" ;
	
	private String applicationRootFolder ;
	
	public FileAccessor(String applicationRootFolder){
		this.applicationRootFolder = applicationRootFolder ;
		
		if (!this.applicationRootFolder.substring( this.applicationRootFolder.length() - 1 ).equals( "/" )){
			this.applicationRootFolder += File.separatorChar ;
		}
	}
	
	public String getApplicationRootFolder()	{
		return applicationRootFolder ;
	}
	public File getApplicationRootFolderFile()	{
		return new File(applicationRootFolder) ;
	}
	
	public String getResourceFolder()	{
		return getApplicationRootFolder() + resources + File.separatorChar ;  
	}
	public File getResourceFolderFile()	{
		return new File(getResourceFolder()) ;
	}
	
	public String getMainConfig()	{
		return getResourceFolder() + mainConfigFile ;  
	}
	public File getMainConfigFile()	{
		return new File(getMainConfig()) ;
	}
}
