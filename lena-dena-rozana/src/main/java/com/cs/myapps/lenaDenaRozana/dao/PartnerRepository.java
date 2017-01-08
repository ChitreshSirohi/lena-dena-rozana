package com.cs.myapps.lenaDenaRozana.dao;

import java.util.List;

import org.ektorp.CouchDbConnector;
import org.ektorp.ViewQuery;
import org.ektorp.ViewResult;
import org.ektorp.support.CouchDbRepositorySupport;
import org.ektorp.support.View;

import com.cs.myapps.lenaDenaRozana.beans.Partner;

public class PartnerRepository extends CouchDbRepositorySupport<Partner>{

	protected PartnerRepository(Class<Partner> type, CouchDbConnector db) {
		super(type, db);
		// TODO Auto-generated constructor stub
	}
	
	@View( name = "getNames", map = "classpath:getNamesFunction.js")
	public void getNames()
	{
		this.initStandardDesignDocument();
		//ViewQuery query = new ViewQuery().designDocId("_design/partners").viewName("getNames").includeDocs(true);
		//ViewResult r = db.queryView(createQuery("getNames.json"));
		//System.out.println(r.getSize());
		//return r.getRows();
		//return db.queryView(createQuery("complicated_view.json"));
	}

}
