package com.splitroom.splitroomapi.repository;

import com.splitroom.splitroomapi.model.Expenditure;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ExpenditureRepository extends JpaRepository<Expenditure, Long> {
}
