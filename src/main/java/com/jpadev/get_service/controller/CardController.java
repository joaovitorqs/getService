package com.jpadev.get_service.controller;

import com.jpadev.get_service.DTO.CardRequest;
import com.jpadev.get_service.model.Card;
import com.jpadev.get_service.service.CardService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cards")
@CrossOrigin
public class CardController {

    private final CardService cardService;

    public CardController (CardService cardService){
        this.cardService = cardService;
    }

    @GetMapping
    public List<Card> listAllCards () {
        return cardService.listAllActive();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findCardById(@PathVariable Long id){
        Card card = cardService.findCardById(id);
        return ResponseEntity.ok(card);
    }

    @PostMapping
    public ResponseEntity<Card> createCard(@Valid @RequestBody CardRequest cardRequest){
        Card saved = cardService.salvarCard(cardRequest);
        return ResponseEntity.status(201).body(saved);
    }

    @PostMapping("/teste")
    public Card createCardTeste(@RequestBody Card createCardTeste){
        return cardService.salvarCardTeste(createCardTeste);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCard(@PathVariable Long id){
        cardService.deleteCard(id);
        return ResponseEntity.noContent().build();
    }

}
