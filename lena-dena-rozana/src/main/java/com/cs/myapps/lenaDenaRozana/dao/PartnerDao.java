package com.cs.myapps.lenaDenaRozana.dao;

import java.util.List;
import org.ektorp.CouchDbConnector;
import org.ektorp.ViewQuery;

import com.cs.myapps.lenaDenaRozana.beans.Partner;



public class PartnerDao {
	
	
	public void save(Partner partner, String ownerId)
	{
		CouchDbConnector dbc = CouchDbService.getPartnerDbConnector(ownerId);
		System.out.println("CH** dbcreated");
		dbc.create(partner);
	}
	

	public List<Partner> getPartners(String ownerId)
	{
		CouchDbConnector dbc = CouchDbService.getPartnerDbConnector(ownerId);
		ViewQuery query = new ViewQuery().designDocId("_design/Partner").viewName("getNames").includeDocs(true);
		return dbc.queryView(query,Partner.class);
	}	
	
	public List<Partner> getPartners1(String ownerId)
	{
		CouchDbConnector dbc = CouchDbService.getPartnerDbConnector(ownerId);
		ViewQuery query = new ViewQuery().designDocId("_design/Partner").viewName("getNames").includeDocs(true);
		return dbc.queryView(query,Partner.class);
	}	
	
	public String getMobileNo(String ownerId,String partnerId)
	{
		CouchDbConnector dbc = CouchDbService.getPartnerDbConnector(ownerId);
		System.out.println("PartnerId:"+partnerId);
		//ViewQuery query = new ViewQuery().designDocId("_design/partners").key(partnerId).includeDocs(true);
		Partner pObj = dbc.find(Partner.class, partnerId);
		//List<Partner> partList = dbc.queryView(query,Partner.class);
		return pObj.getMobileNo();
		
		 
	}
	
	public String getName(String ownerId,String partnerId)
	{
		CouchDbConnector dbc = CouchDbService.getPartnerDbConnector(ownerId);
		System.out.println("PartnerId:"+partnerId);
		//ViewQuery query = new ViewQuery().designDocId("_design/partners").key(partnerId).includeDocs(true);
		Partner pObj = dbc.find(Partner.class, partnerId);
		//List<Partner> partList = dbc.queryView(query,Partner.class);
		return pObj.getFname();
		
		 
	}
}
