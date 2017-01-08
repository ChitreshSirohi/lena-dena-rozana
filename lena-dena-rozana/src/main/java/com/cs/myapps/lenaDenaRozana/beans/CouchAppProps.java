package com.cs.myapps.lenaDenaRozana.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;

import com.cs.myapps.lenaDenaRozana.logging.LenaDenaLogger;

@Configuration
public class CouchAppProps {
	
	private String db_service_name;
	private String owner_db_name;
	private String db_service_lookup;
	@Autowired
	  private ApplicationContext appContext;
	
	public String getDb_service_name() {
		return db_service_name;
	}

	public void setDb_service_name(String db_service_name) {
		this.db_service_name = db_service_name;
	}
	public String getOwner_db_name() {
		return owner_db_name;
	}
	public void setOwner_db_name(String owner_db_name) {
		this.owner_db_name = owner_db_name;
	}
	public String getDb_service_lookup() {
		return db_service_lookup;
	}
	public void setDb_service_lookup(String db_service_lookup) {
		LenaDenaLogger.getLogger().warn("CH** appContext:"+appContext);
		this.db_service_lookup = db_service_lookup;
	}

}
