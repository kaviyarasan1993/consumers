package org.egov.lams.indexer.contract;
import java.util.List;

import org.egov.lams.indexer.model.Allottee;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@EqualsAndHashCode
@Getter
@NoArgsConstructor
@Setter
@ToString
public class AllotteeResponse {
	
	 @JsonProperty("ResposneInfo")
	  private ResponseInfo resposneInfo = null;

	  @JsonProperty("Allottees")
	  private List<Allottee> allottees;
}
