package com.splitroom.model;

import javax.persistence.*;

@Entity
public class Item
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private double individualAmount;
    @JoinColumn(name = "ROOM_ID")
    private long roomId;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getIndividualAmount() {
        return individualAmount;
    }

    public void setIndividualAmount(long individualAmount) {
        this.individualAmount = individualAmount;
    }

    public long getRoomId() {
        return roomId;
    }

    public void setRoomId(long roomId) {
        this.roomId = roomId;
    }
}
