package com.philippelangevin.debitage.database;

import com.philippelangevin.sdk.database.connector.DBType;
import com.philippelangevin.sdk.database.connector.DatabaseDefinitionIF;

public enum DatabaseDefinition implements DatabaseDefinitionIF {
	//Windows colmatec321 : D:\\Perso\\Programmes\\Debitage
	//Linux inspiron1720 : /home/philippe/Programmes/Debitage
	
	DEBITAGE_SQLITE("D:\\Philippe\\Programmes\\eclipse\\debitage", "debitage.db", DBType.SQLite), 
	ADDRESSBOOK_SQLITE("D:\\Philippe\\Programmes\\eclipse\\debitage", "addressBook.db", DBType.SQLite),

	DEBITAGE_MYSQL("localhost", "debitage", DBType.MySQL),
	ADDRESSBOOK_MYSQL("localhost", "addressBook", DBType.MySQL),
	INVENTAIRE806("localhost", "Inventaire806", DBType.MySQL)
	;

	private String location ;
	private String dbName ;
	private DBType dbType ;
	
	private DatabaseDefinition(String location, String dbName, DBType dbType){
		this.location = location ;
		this.dbName = dbName ;
		this.dbType = dbType ;
	}

	@Override
	public String getLocation() {
		return location;
	}	
	@Override
	public String getName() {
		return this.dbName ;
	}

	@Override
	public DBType getDBType() {
		return this.dbType ;
	}

}
