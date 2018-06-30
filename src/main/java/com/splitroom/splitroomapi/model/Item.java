package com.splitroom.splitroomapi.model;

import javax.persistence.*;

@Entity
@Table(name = "INDIVIDUAL_AMOUNT")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID", unique = true, nullable = false)
    private long id;

    @ManyToOne(targetEntity = RoomMember.class)
    @JoinColumn(name = "ROOM_ID", unique = true, nullable = false)
    private long roomId;

    @Column(name = "INDIVIDUAL_AMOUNT")
    private long individualAmount;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public long getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public long getIndividualAmount() {
        return individualAmount;
    }

    public void setIndividualAmount(int individualAmount) {
        this.individualAmount = individualAmount;
    }

    @Override
    public String toString() {
        return String.format("Item [id=%s, roomId=%s, individualAmount=%s]",
                id, roomId, individualAmount);
    }

}
