package com.jpadev.get_service.controller;

import com.jpadev.get_service.model.Card;
import com.jpadev.get_service.service.CardService;
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
    public Card createCard(@RequestBody Card card){
        return cardService.salvarCard(card);
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
