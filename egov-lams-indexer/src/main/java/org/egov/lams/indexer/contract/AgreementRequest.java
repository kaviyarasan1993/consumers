package org.egov.lams.indexer.contract;

import org.egov.lams.indexer.contract.RequestInfo;
import org.egov.lams.indexer.model.Agreement;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class AgreementRequest {

	private RequestInfo requestInfo;
	private Agreement agreement;

}
