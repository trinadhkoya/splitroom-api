package com.splitroom.splitroomapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.splitroom.splitroomapi.model.Room;

/* Copyright (C)  All Rights Reserved
 * Written by trinadhkoya 
 */

@Repository
public interface RoomRepository extends JpaRepository<Room, Long> {

}
