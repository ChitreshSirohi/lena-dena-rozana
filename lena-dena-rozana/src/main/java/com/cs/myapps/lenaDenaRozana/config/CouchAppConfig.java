package com.cs.myapps.lenaDenaRozana.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import com.cs.myapps.lenaDenaRozana.beans.CouchAppProps;

@Configuration
@PropertySource("classpath:cloudant-db.properties")
public class CouchAppConfig 
{
	@Autowired 
	Environment environment;
	
	@Bean
	CouchAppProps appProperties() {
		CouchAppProps bean = new CouchAppProps();
        bean.setDb_service_name(environment.getProperty("db_service_name"));
        bean.setOwner_db_name(environment.getProperty("owner_db_name"));
        bean.setDb_service_lookup(environment.getProperty("db_service_lookup"));
        return bean;
    }
}
