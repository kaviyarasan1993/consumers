package org.egov.lams.indexer.adapter;

import java.util.ArrayList;
import java.util.List;

import org.egov.lams.indexer.contract.AgreementDetails;
import org.egov.lams.indexer.model.Agreement;
import org.egov.lams.indexer.model.Asset;
import org.egov.lams.indexer.repository.AllotteeRepository;
import org.egov.lams.indexer.repository.AssetRepository;
import org.egov.lams.indexer.repository.BoundaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AgreementAdaptor {
	
	@Autowired
	private AssetRepository assetRepository;

	@Autowired
	private AllotteeRepository allotteeRepository;
	
	@Autowired
	private BoundaryRepository boundaryRepository;
	/***
	 * method to create agreementdetails object and populate values
	 * 
	 * @param agreement
	 * @return AgreementDetails
	 */
	public AgreementDetails indexOnCreate(Agreement agreement) {

		AgreementDetails agreementDetails = new AgreementDetails();
		agreementDetails.setAgreement(agreement);
		agreementDetails.setAllottee(allotteeRepository.getAllottee(agreement.getAllottee().getId()));
		Asset asset = assetRepository.getAsset(agreement.getAsset().getId());
		agreementDetails.setAsset(asset);
		
		List<Long> boundaryIdList = new ArrayList<>();
		boundaryIdList.add(asset.getLocality());
		boundaryIdList.add(asset.getZone());
		boundaryIdList.add(asset.getElectionward());
		boundaryIdList.add(asset.getWard());
		boundaryIdList.add(asset.getBlock());
		boundaryIdList.add(asset.getStreet());
		
		//getlist of boundaries using the list of id form asset object
		//boundaryRepository.getBoundary(); FIXME make call to city controller

		return agreementDetails;
	}
}
