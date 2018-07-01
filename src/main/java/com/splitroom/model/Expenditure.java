package com.splitroom.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Expenditure {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String itemName;
    private Double spentAmount;
    private LocalDate addedDate;
    @JoinColumn(name = "ROOM_ID")
    private Long roomId;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public Double getSpentAmount() {
        return spentAmount;
    }

    public void setSpentAmount(Double spentAmount) {
        this.spentAmount = spentAmount;
    }

    public LocalDate getAddedDate() {
        return addedDate;
    }

    public void setAddedDate(LocalDate addedDate) {
        this.addedDate = addedDate;
    }
}
