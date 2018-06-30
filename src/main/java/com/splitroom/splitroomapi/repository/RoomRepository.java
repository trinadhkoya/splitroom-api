package com.splitroom.splitroomapi.repository;

import com.splitroom.splitroomapi.model.RoomMember;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

@Repository
public interface RoomRepository extends JpaRepository<RoomMember, Long> {

}
