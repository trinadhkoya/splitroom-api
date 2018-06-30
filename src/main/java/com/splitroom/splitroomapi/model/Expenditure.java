package com.splitroom.splitroomapi.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "EXPENDITURE")
public class Expenditure {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID", unique = true, nullable = false)
    private long id;

    @ManyToOne(targetEntity = RoomMember.class)
    @JoinColumn(name = "ROOM_ID", unique = true, nullable = false)
    private long roomId;

    @Column(name = "ITEM_NAME")
    private String itemName;

    @Column(name = "SPENT_AMOUNT")
    private String spentAmount;

    @Column(name = "DATE")
    private LocalDate amountDate;

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

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getSpentAmount() {
        return spentAmount;
    }

    public void setSpentAmount(String spentAmount) {
        this.spentAmount = spentAmount;
    }

    public LocalDate getAmountDate() {
        return amountDate;
    }

    public void setAmountDate(LocalDate amountDate) {
        this.amountDate = amountDate;
    }

    @Override
    public String toString() {
        return String
                .format("Spent [id=%s, roomId=%s, itemName=%s, spentAmount=%s, amountDate=%s]",
                        id, roomId, itemName, spentAmount, amountDate);
    }

}
