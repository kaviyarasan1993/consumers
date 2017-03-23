package org.egov.lams.indexer.contract;

import java.util.List;

import org.egov.lams.indexer.contract.ResponseInfo;
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
public class AgreementResponse {

	private ResponseInfo resposneInfo;
	private List<Agreement> agreement;
}
