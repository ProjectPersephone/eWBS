package com.wbs.domain;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.annotation.Version;

@Setter
@Getter
public class AuditEntity {

	@Id
	private String _id;
	@CreatedDate
	private Date createdDate;
	@CreatedBy
	private String createdBy;
	@LastModifiedDate
	private Date lastModifiedDate;
	@LastModifiedBy
	private String lastModifiedBy;
	@Version
	private Long version;
	
}