package org.egov.lams.contract;

import java.util.List;

import org.egov.lams.contract.ResponseInfo;
import org.egov.lams.model.Agreement;

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
