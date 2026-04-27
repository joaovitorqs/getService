package com.jpadev.get_service.service;

import com.jpadev.get_service.DTO.CardRequest;
import com.jpadev.get_service.exception.ResourceNotFoundException;
import com.jpadev.get_service.model.Card;
import com.jpadev.get_service.repository.CardRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;

@Service
public class CardService {

    private final CardRepository cardRepository;

    public List<Card> listAllActive() {
        LocalDateTime now = LocalDateTime.now();

        return cardRepository.findAll().stream()
                .filter(card -> card.getCreatedTime()
                .plusHours(72)
                .isAfter(now))
                .sorted(Comparator.comparing(Card::getCreatedTime))
                .toList();
    }

    public Card findCardById(Long id){
        return cardRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Card not found by ID: " + id));
    }

    public CardService (CardRepository cardRepository){
        this.cardRepository = cardRepository;
    }
    public Card salvarCard (CardRequest request){
        Card card = new Card();

        card.setNameClient(request.getNameClient());
        card.setContact(request.getContact());
        card.setTitle(request.getTitle());
        card.setDescription(request.getDescription());

        card.setCreatedTime(LocalDateTime.now());
        card.setTimeExpired(card.getCreatedTime().plusHours(72));

        return cardRepository.save(card);
    }

    public Card salvarCardTeste (Card card){

        return cardRepository.save(card);
    }

    public void deleteCard (Long id){
        if (!cardRepository.existsById(id)){
            throw new ResourceNotFoundException("Card not found by ID: " + id);
        }
        cardRepository.deleteById(id);
    }
}
