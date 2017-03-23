package org.egov.lams.indexer.repository;

import org.egov.lams.indexer.config.PropertiesManager;
import org.egov.lams.indexer.contract.AssetResponse;
import org.egov.lams.indexer.model.Asset;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

public class AssetRepository {

	public static final Logger LOGGER = LoggerFactory.getLogger(AssetRepository.class);

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private PropertiesManager propertiesManager;

	public Asset getAsset(Long assetId) {

		String url = propertiesManager.getAssetApiHostUrl()
					+propertiesManager.getAllotteeApiSearchPath()
					+ "?" + "id=" + assetId;
		
		AssetResponse assetResponse = null;
		try {
			assetResponse = restTemplate.getForObject(url, AssetResponse.class);
		} catch (Exception e) {
			LOGGER.info(e.getMessage(), e);
			throw e;// FIXME exception custom
		}
		return assetResponse.getAssets().get(0);
	}

}
