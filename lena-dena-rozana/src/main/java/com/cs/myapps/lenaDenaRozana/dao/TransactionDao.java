package com.cs.myapps.lenaDenaRozana.dao;

import java.util.ArrayList;
import java.util.List;

import org.ektorp.CouchDbConnector;
import org.ektorp.ViewQuery;

import com.cs.myapps.lenaDenaRozana.beans.Owner;
import com.cs.myapps.lenaDenaRozana.beans.Partner;
import com.cs.myapps.lenaDenaRozana.beans.Transaction;
import com.cs.myapps.lenaDenaRozana.util.Constants;
import com.cs.myapps.lenaDenaRozana.beans.DbDoc;
import com.cs.myapps.lenaDenaRozana.beans.Login;
import com.cs.myapps.lenaDenaRozana.beans.MyDbDoc;



public class TransactionDao {
	
	
	public void save(Transaction transaction, String ownerId)
	{
		CouchDbConnector dbc = CouchDbService.getPartnerDbConnector(ownerId+Constants.getDbSuffix());
		System.out.println("CH** Transaction dbcreated:"+transaction.getId());
		dbc.create(transaction);
	}
	
	public void getFname(String ownerId)
	{
		System.out.println("CH** ownerId:"+ownerId);
		CouchDbConnector dbc = CouchDbService.getPartnerDbConnector(ownerId+Constants.getDbSuffix());
		TransactionRepository rep = new TransactionRepository(Transaction.class, dbc);
		List<Transaction> list = rep.findByName("Nathu");
		System.out.println("List size:"+list.size());
	}
	
	public void getDate(String ownerId)
	{
		System.out.println("CH** ownerId:"+ownerId);
		CouchDbConnector dbc = CouchDbService.getPartnerDbConnector(ownerId+Constants.getDbSuffix());
		TransactionRepository rep = new TransactionRepository(Transaction.class, dbc);
		String date = "[2016, 12, 26]";
		List<Transaction> list = rep.findByDate(date);
		System.out.println("List size:"+list.size());
	}
	
	public List<Transaction> getTrasactionsByDate(String ownerId,int[] date)
	{

		CouchDbConnector dbc = CouchDbService.getPartnerDbConnector(ownerId+Constants.getDbSuffix());
		//date = null;
		System.out.println("CH** date:"+date);
		ViewQuery query = new ViewQuery().designDocId("_design/Transaction").viewName("by_date").includeDocs(true).startKey(date).endKey(date);
	
		return dbc.queryView(query,Transaction.class);
	}
	
	//public Map getPartnerIds


	
}
