package com.splitroom.splitroomapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.splitroom.splitroomapi.model.Room;

@Repository
public interface RoomRepository extends JpaRepository<Room, Long> {

}
