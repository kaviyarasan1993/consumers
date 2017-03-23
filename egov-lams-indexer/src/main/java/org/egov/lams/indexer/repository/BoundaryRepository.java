package org.egov.lams.indexer.repository;

import org.egov.lams.indexer.config.PropertiesManager;
import org.egov.lams.indexer.contract.CityResponse;
import org.egov.lams.indexer.model.City;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

@Repository
public class BoundaryRepository {

	public static final Logger LOGGER = LoggerFactory.getLogger(BoundaryRepository.class);

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private PropertiesManager propertiesManager;

	public City getBoundary(Long boundaryId) {
		// TODO make api call to boundary repository

		String url = propertiesManager.getBoundaryApiHostUrl() 
					+propertiesManager.getBoundaryApiSearchPath()
					+ "?" + "code=" + boundaryId;
		CityResponse cityResponse = null;
		try {
			cityResponse = restTemplate.getForObject(url, CityResponse.class);
		} catch (Exception e) {
			LOGGER.info(e.getMessage(), e);
			throw e;// FIXME throw custom exception
		}
		return cityResponse.getCity();
	}

}
