package org.egov.lams.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

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
@JsonIgnoreProperties(ignoreUnknown=true)
public class Allottee {

	private Long id;
/*	private String name;
	private String address;
	private Long contactNo;
	private String aadhaarNo;
	private String panNo;
	private String emailId;
*/
}
