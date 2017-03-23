package org.egov.lams.model;

import java.time.LocalDate;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ProcessInstance   {
	
  @JsonProperty("id")
  private String id = null;

  @JsonProperty("businessKey")
  private String businessKey = null;

  @JsonProperty("type")
  private String type = null;

  @JsonProperty("assignee")
  private Position assignee = null;

  @JsonProperty("comments")
  private String comments = null;

  @JsonProperty("createdDate")
  private String createdDate = null;

  @JsonProperty("lastupdatedSince")
  private String lastupdatedSince = null;

  @JsonProperty("owner")
  private Position owner = null;

  @JsonProperty("state")
  private String state = null;

  @JsonProperty("status")
  private String status = null;

  @JsonProperty("senderName")
  private String senderName = null;

  }
