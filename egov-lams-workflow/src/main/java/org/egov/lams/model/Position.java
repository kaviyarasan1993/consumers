package org.egov.lams.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class Position   {
	
  @JsonProperty("id")
  private Long id = null;

  @JsonProperty("name")
  private String name = null;

}

