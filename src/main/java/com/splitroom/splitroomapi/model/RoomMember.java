package com.splitroom.splitroomapi.model;

import javax.persistence.*;

@Entity
@Table(name = "ROOM_MEMBERS")
public class RoomMember {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ROOM_ID", unique = true, nullable = false)
    private Long roomId;

    @Column(name = "NAME")
    private String name;

    public long getRoomId() {
        return roomId;
    }

    public void setRoomId(Long roomId) {
        this.roomId = roomId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return String.format("RoomMember [roomId=%s, name=%s]", roomId, name);
    }

}
