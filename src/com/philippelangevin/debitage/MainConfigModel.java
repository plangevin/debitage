package com.philippelangevin.debitage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class MainConfigModel {
	private Properties configs = new Properties() ;

	public void load(String file) throws FileNotFoundException, IOException{
		configs.clear() ;
		
		configs.loadFromXML(new FileInputStream(file)) ;
	}
	public void save(String file) throws FileNotFoundException, IOException	{
		configs.storeToXML(new FileOutputStream(file, false), null, "utf8") ;
	}
	
	private final String companyNameKey = "companyName" ;
	private final String language = "applicationLanguage" ;
	private final String country = "country" ;
	
	public void setCompanyName(String companyName) {
		configs.setProperty(this.companyNameKey, companyName) ;
	}
	public String getCompanyName() {
		return configs.getProperty(this.companyNameKey) ;
	}

	public void setLanguage(String language)	{
		configs.setProperty(this.language, language) ;
	}
	public String getLanguage() {
		return configs.getProperty(this.language);
	}

	public void setCountry(String country)	{
		configs.setProperty(this.country, country) ;
	}
	public String getCountry() {
		return configs.getProperty(this.country);
	}
	
	public void resetToDefaultData()	{
		setCompanyName("Ébinisterie Langevin") ;
		setLanguage("FR") ;
		setCountry("CA") ;
	}
}
