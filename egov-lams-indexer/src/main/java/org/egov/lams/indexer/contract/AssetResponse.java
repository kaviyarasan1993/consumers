package org.egov.lams.indexer.contract;

import java.util.List;

import org.egov.lams.indexer.model.Asset;

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
public class AssetResponse {

	  @JsonProperty("ResposneInfo")
	  private ResponseInfo resposneInfo = null;

	  @JsonProperty("Assets")
	  private List<Asset> assets;
}
