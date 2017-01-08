package com.cs.myapps.lenaDenaRozana.dao;

import java.util.List;

import org.ektorp.CouchDbConnector;
import org.ektorp.support.CouchDbRepositorySupport;
import org.ektorp.support.GenerateView;

import com.cs.myapps.lenaDenaRozana.beans.Transaction;

public class TransactionRepository extends CouchDbRepositorySupport<Transaction>{

	protected TransactionRepository(Class<Transaction> type, CouchDbConnector db) {
		super(type, db);
		// TODO Auto-generated constructor stub
	}
	
	@GenerateView
	public List<Transaction> findByName(String name) {
		this.initStandardDesignDocument();
	    return queryView("by_name", name);
	}
	
	@GenerateView
	public List<Transaction> findByDate(String date) {
		this.initStandardDesignDocument();
	    return queryView("by_date", date);
	}

}
