package com.jpadev.get_service.repository;

import com.jpadev.get_service.model.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface CardRepository extends JpaRepository<Card, Long> {
    List<Card> findAllActiveNotExpired(LocalDateTime now);
}
