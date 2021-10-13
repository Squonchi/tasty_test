package com.testing.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties
public class UserPojo {
	@JsonProperty(value = "last_name")
	private String lastName;
	private int id;
	private String avatar;
	@JsonProperty(value = "first_name")
	private String firstName;
	private String email;
}
