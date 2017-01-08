package com.cs.myapps.lenaDenaRozana.dao;

import javax.naming.InitialContext;

import org.ektorp.CouchDbConnector;
import org.ektorp.CouchDbInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.cs.myapps.lenaDenaRozana.beans.CouchAppProps;
import com.cs.myapps.lenaDenaRozana.config.CouchAppConfig;
import com.cs.myapps.lenaDenaRozana.logging.LenaDenaLogger;


public class CouchDbService 
{
	
	@Autowired
	private static ApplicationContext appCtx;
	
	
	
	private static CouchDbConnector createConnection(String dbname)
	{
		CouchAppProps dbProps = (CouchAppProps) appCtx.getBean(CouchAppProps.class);
		String db_service_lookup = dbProps.getDb_service_lookup() ;
		try {
			//creates a database with the specified name
			CouchDbInstance _db = (CouchDbInstance) new InitialContext().lookup(db_service_lookup);
			//CouchDbInstance _db = (CouchDbInstance) new InitialContext().lookup("java:comp/env/couchdb/lena-dena-rozana-dbservice");
			System.out.println("CH** About to create DB:"+dbname);
			CouchDbConnector dbc = _db.createConnector(dbname, true);
			
			
			return dbc;
		}
		catch (Exception e) {e.printStackTrace();
		return null;
		}
		//create a simple doc to place into your new database

	}
	
	public static CouchDbConnector getOwnerDbConnector()
	{

		LenaDenaLogger.getLogger().warn("CH** appCtx:"+appCtx);
		AbstractApplicationContext context = new AnnotationConfigApplicationContext(CouchAppConfig.class);
		 appCtx = context;
		 LenaDenaLogger.getLogger().warn("CH** appCtx:"+appCtx);
		 CouchAppProps dbProps = (CouchAppProps) appCtx.getBean(CouchAppProps.class);
		LenaDenaLogger.getLogger().warn("CH** environment1:"+dbProps);
		//testBean();
		String owner_dbname = dbProps.getOwner_db_name();
		
		LenaDenaLogger.getLogger().warn(owner_dbname);
		return  createConnection(owner_dbname);

		//return null;
		
	}
	
	public static CouchDbConnector getPartnerDbConnector(String userid)
	{		
		return createConnection(userid);
	}
}
