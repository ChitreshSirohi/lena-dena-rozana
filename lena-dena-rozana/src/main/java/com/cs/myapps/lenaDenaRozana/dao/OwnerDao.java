package com.cs.myapps.lenaDenaRozana.dao;

import org.ektorp.CouchDbConnector;
import com.cs.myapps.lenaDenaRozana.beans.Owner;
import com.cs.myapps.lenaDenaRozana.beans.DbDoc;
import com.cs.myapps.lenaDenaRozana.beans.Login;
import com.cs.myapps.lenaDenaRozana.beans.MyDbDoc;



public class OwnerDao {
	
	
	public void save(Owner owner)
	{
		//CouchDbConnector dbc = CouchDbService.getOwnerDbConnector();
		//System.out.println("CH** dbcreated");
		//dbc.create(owner);
		InitDBViews.initDBs(owner);
	}
	
	public String verifyOwner(String id,String password)
	{
		CouchDbConnector dbc = CouchDbService.getOwnerDbConnector();
		System.out.println("CH** owberid:"+id);
		System.out.println("CH** password:"+password);
		Owner owner = dbc.get(Owner.class, id);
		if(password.equals(owner.getPassword()))
				{
			System.out.println("CH** opassword:"+owner.getPassword());
			return id;
				}
		return null;
	}
	
	public void saveRet(Login login)
	{
		CouchDbConnector dbc = CouchDbService.getOwnerDbConnector();
		dbc.create(login);
		Login login1 = dbc.get(Login.class, login.getId());
		
	}

	public void dbDocTest()
	{
		CouchDbConnector dbc = CouchDbService.getOwnerDbConnector();
		MyDbDoc dc = new MyDbDoc();
		dc.setId("007");
		dc.setColor("blue");
		dbc.create(dc);
		dbc.get(MyDbDoc.class, dc.getId());
		
	}
	
}
