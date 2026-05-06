package com.jpadev.get_service.service;

import com.jpadev.get_service.exception.ResourceNotFoundException;
import com.jpadev.get_service.model.Card;
import com.jpadev.get_service.repository.CardRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.ActiveProfiles;
import static org.mockito.Mockito.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

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
    @DisplayName("List active cards")
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
    @DisplayName("Case find id")
    void findCardByIdCase01() {
        Card card = new Card();

        when(cardRepository.findById(1L)).thenReturn(Optional.of(card));

        Card result = cardService.findCardById(1L);

        assertEquals(card, result);
    }

    @Test
    @DisplayName("Case not find id")
    void findCardByIdCase02() {
        when(cardRepository.findById(1L)).thenReturn(Optional.empty());

        assertThrows(ResourceNotFoundException.class,
                () -> cardService.findCardById(1L));
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