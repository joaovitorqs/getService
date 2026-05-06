package com.jpadev.get_service.service;

import com.jpadev.get_service.model.Card;
import com.jpadev.get_service.repository.CardRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import static org.mockito.Mockito.*;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ActiveProfiles("test")
class CardServiceTest {

    private CardService cardService;

    @Mock
    private CardRepository cardRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        cardService = new CardService(cardRepository);
    }

    @Test
    void listAllActive() {
        LocalDateTime now = LocalDateTime.now();

        Card active = new Card();
        active.setCreatedTime(now.minusHours(10));

        Card expired = new Card();
        expired.setCreatedTime(now.minusHours(73));

        when(cardRepository.findAll()).thenReturn(List.of(expired, active));

        List<Card> result = cardService.listAllActive();

        assertEquals(1, result.size());
        assertEquals(active, result.get(0));
    }

    @Test
    void findCardById() {
    }

    @Test
    void salvarCard() {
    }

    @Test
    void salvarCardTeste() {
    }

    @Test
    void deleteCard() {
    }
}