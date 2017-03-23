package org.egov.lams.indexer.repository;

import java.util.Map;

import org.egov.lams.indexer.config.PropertiesManager;
import org.egov.lams.indexer.contract.AgreementDetails;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

@Repository
public class ElasticSearchRepository {

	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private PropertiesManager propertiesManager;
	
	public static final Logger LOGGER = LoggerFactory.getLogger(ElasticSearchRepository.class);
	
	public void saveAgreement(AgreementDetails agreementDetails){
		
		String indexServiceHost = propertiesManager.getIndexServiceHostUrl();
		String indexSericeName = propertiesManager.getIndexServiceIndexName();
		// check for both index name and type name and id before confirming the url 
		String url = indexServiceHost+"/"+indexSericeName; 
		  //  for index id + indexId;
	    restTemplate.postForObject(url, agreementDetails, Map.class);
	}
	
	public void updateAgreement(AgreementDetails agreementDetails) {

		String indexServiceHost = propertiesManager.getIndexServiceHostUrl();
		String indexSericeName = propertiesManager.getIndexServiceIndexName();
		String id = agreementDetails.getAckNumber();
		String url = indexServiceHost + "/" + indexSericeName + "/" + id;
		// TODO add unique id
		restTemplate.postForObject(url, agreementDetails, Map.class);
	}
}
