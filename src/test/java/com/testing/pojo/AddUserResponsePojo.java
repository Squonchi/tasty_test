package com.testing.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.testing.utils.DataDeserializer;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class AddUserResponsePojo{
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyy-MM-dd'T'hh:mm:ss.SSS'Z'")
	@JsonDeserialize(using = DataDeserializer.class)
	private LocalDateTime createdAt;
	private String name;
	private int id;
	private String job;
}
