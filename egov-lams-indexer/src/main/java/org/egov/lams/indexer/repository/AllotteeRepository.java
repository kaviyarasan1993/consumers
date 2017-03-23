package org.egov.lams.indexer.repository;

import org.egov.lams.indexer.config.PropertiesManager;
import org.egov.lams.indexer.contract.AllotteeResponse;
import org.egov.lams.indexer.model.Allottee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

public class AllotteeRepository {

	public static final Logger LOGGER = LoggerFactory.getLogger(AllotteeRepository.class);

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private PropertiesManager propertiesManager;

	public Allottee getAllottee(Long allotteeId) {

		String url = propertiesManager.getAllotteeApiHostUrl()
					+ propertiesManager.getAllotteeApiSearchPath() + "?"
					+ "id=" + allotteeId;

		AllotteeResponse allotteeResponse = null;
		try {
			allotteeResponse = restTemplate.getForObject(url, AllotteeResponse.class);
		} catch (Exception e) {
			LOGGER.info(e.getMessage(), e);
			throw e;// FIXME throw custom exception
		}
		return allotteeResponse.getAllottees().get(0);
	}
}
