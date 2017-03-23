package org.egov.lams.indexer.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import lombok.Getter;

@Configuration
@Getter
public class PropertiesManager {
	
	 @Autowired
	 private Environment environment;
	 
	 @Value("${egov.services.asset_service.hostname}")
	 private String assetApiHostUrl;
	 
	 @Value("${egov.services.asset_service.searchpath}")
	 private String assetApiSearchPath;
	
	 @Value("${egov.services.allottee_service.hostname}")
	 private String allotteeApiHostUrl;
	 
	 @Value("${egov.services.allottee_service.searchpath}")
	 private String allotteeApiSearchPath;
	 
	 @Value("${egov.services.boundary_service.hostname}")
	 private String boundaryApiHostUrl;
	 
	 @Value("${egov.services.boundary_service.searchpath}")
	 private String boundaryApiSearchPath;
	 
	 @Value("${egov.services.lams.indexer.host}")
	 private String indexServiceHostUrl;
	 
	 @Value("${egov.services.lams.indexer.name}")
	 private String indexServiceIndexName;
}
