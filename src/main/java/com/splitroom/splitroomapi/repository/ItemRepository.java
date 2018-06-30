package com.splitroom.splitroomapi.repository;

import com.splitroom.splitroomapi.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends JpaRepository<Item ,Integer> {
}
