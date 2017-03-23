package org.egov.lams.model;

import java.time.LocalDate;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class Task   {
	
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
  private LocalDate createdDate = null;

  @JsonProperty("lastupdatedSince")
  private LocalDate lastupdatedSince = null;

  @JsonProperty("owner")
  private Position owner = null;

  @JsonProperty("state")
  private String state = null;

  @JsonProperty("status")
  private String status = null;

  @JsonProperty("url")
  private String url = null;

  @JsonProperty("action")
  private String action = null;

  @JsonProperty("senderName")
  private String senderName = null;

  @JsonProperty("extraInfo")
  private String extraInfo = null;

  @JsonProperty("natureOfTask")
  private String natureOfTask = null;

  @JsonProperty("entity")
  private String entity = null;
}

