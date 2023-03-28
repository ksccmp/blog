package com.spring.datetime.entity;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@MappedSuperclass
@SuperBuilder
@NoArgsConstructor
public class Datetime {
	
	private String createAt;
	private String updateAt;
	
	@PrePersist // 데이터 생성이 이루어질때 사전 작업
	public void prePersist() {
		this.createAt = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
		this.updateAt = this.createAt;
	}
	
	@PreUpdate // 데이터 수정이 이루어질때 사전 작업
	public void preUpdate() {
		this.updateAt = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
	}
}
