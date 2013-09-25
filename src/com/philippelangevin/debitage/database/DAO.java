package com.philippelangevin.debitage.database;

import java.sql.SQLException;

import com.philippelangevin.sdk.database.connector.DatabaseDefinitionIF;
import com.philippelangevin.sdk.database.dbAccess.AbstractDatabaseDAO;
import com.philippelangevin.sdk.database.dbAccess.ConnectionModeEnum;
import com.philippelangevin.sdk.database.dbAccess.DatabaseConnectionFactory;

public class DAO extends AbstractDatabaseDAO {

	public DAO(DatabaseDefinitionIF databaseDefinition, ConnectionModeEnum connectionMode) throws SQLException {
		super(connectionMode);

		dbAccess = DatabaseConnectionFactory.buildConnection(databaseDefinition);
		
		openConnection() ;
	}

	public void createMainDB()	{
		try {
			dbAccess.setAutoCommit(false) ;
			
			
			dbAccess.commit() ;
			dbAccess.setAutoCommit(true) ;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
