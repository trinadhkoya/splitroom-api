package com.splitroom.splitroomapi.model;

import java.io.Serializable;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/* Copyright (C)  All Rights Reserved
 * Written by trinadhkoya 
 */

@Entity
@Table(name = "room")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = { "createdAt", "modifiedAt" },allowGetters = true)
public class Room implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "room_id")
	private Long roomId;

	@Column(name = "room_name")
	private String roomName;

	
	@Column(name = "is_room_active")
	private String isRoomActive;

	@Column(nullable = false, updatable = false,name="created_date")
	@Temporal(TemporalType.TIMESTAMP)
	@CreatedDate
	private Date createdAt;

	@Column(nullable = false,name="modified_date")
	@Temporal(TemporalType.TIMESTAMP)
	@LastModifiedDate
	private Date modifiedAt;

	public Long getRoomId() {
		return roomId;
	}

	public void setRoomId(Long roomId) {
		this.roomId = roomId;
	}

	public String getRoomName() {
		return roomName;
	}

	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}

	public String getIsRoomActive() {
		return isRoomActive;
	}

	public void setIsRoomActive(String isRoomActive) {
		this.isRoomActive = isRoomActive;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getModifiedAt() {
		return modifiedAt;
	}

	public void setModifiedAt(Date modifiedAt) {
		this.modifiedAt = modifiedAt;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	

}
