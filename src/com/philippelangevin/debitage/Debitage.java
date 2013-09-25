package com.philippelangevin.debitage;

import java.sql.SQLException;

import com.philippelangevin.debitage.database.DatabaseDefinition;
import com.philippelangevin.sdk.addressBook.AddressBookDAO;
import com.philippelangevin.sdk.addressBook.contact.ContactController;
import com.philippelangevin.sdk.addressBook.tos.ContactTO;
import com.philippelangevin.sdk.database.dbAccess.ConnectionModeEnum;
import com.philippelangevin.sdk.translationManagement.TranslationBundleFactory;


public class Debitage {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		TranslationBundleFactory.setLocale("FR", "CA") ;

		AddressBookDAO dao = null;
		
		try {
			//dao = new AddressBookDAO(DatabaseDefinition.ADDRESSBOOK_SQLITE, ConnectionModeEnum.READ_WRITE_AUTO_COMMIT);
			dao = new AddressBookDAO(DatabaseDefinition.INVENTAIRE806, "plangevin", "45387z", ConnectionModeEnum.READ_WRITE_AUTO_COMMIT);

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		if (args.length > 0)	{
			if (args[0].equals("-createDB"))	{
				dao.createMainDB() ;
				System.exit(0) ;
			}
		}
		
		ContactTO contact = new ContactTO() ;
//		contact.setId(1) ;
//
//		try {
//			contact = dao.selectTO(contact) ;
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}

		ContactController ctrl = new ContactController(dao) ;
		ctrl.setCurrentContactTO(contact) ;
		ctrl.showMainGUI(true) ;
		
		dao.close() ;

//		SwingUtilities.invokeLater(new Runnable() {
//			public void run() {
//				DebitageController.getInstance().startApplication() ;
//			}
//		}) ;
		
//		try {
//			DAO dao = new DAO("D:\\Perso\\Programmes\\Debitage", DatabaseDefinition.addressBook, ConnectionModeEnum.READ_WRITE_AUTO_COMMIT) ;
//			
//			dao.createMainDB() ;
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}
}
