package com.cs.myapps.lenaDenaRozana.dao;

import org.ektorp.CouchDbConnector;

import com.cs.myapps.lenaDenaRozana.beans.Owner;
import com.cs.myapps.lenaDenaRozana.beans.Partner;

public class InitDBViews {
	
	
	public static boolean initDBs(Owner owner)
	{
		CouchDbConnector ownerdbc = CouchDbService.getOwnerDbConnector();
		ownerdbc.create(owner);
		
		CouchDbConnector partnerdbc = CouchDbService.getPartnerDbConnector(owner.getId());
		PartnerRepository partRep = new PartnerRepository(Partner.class, partnerdbc);
				partRep.getNames();
				
		return true;
	}

}
