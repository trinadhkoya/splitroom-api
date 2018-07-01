package com.splitroom.model;


import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Room {


    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private long id;
    private String name;

    @OneToMany(targetEntity =Member.class)
    private Set<Member> members = new HashSet<>();


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Member> getMembers() {
        return members;
    }

    public void setMembers(Set<Member> members) {
        this.members = members;
    }



}
