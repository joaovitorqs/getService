package com.jpadev.get_service.service;

import com.jpadev.get_service.model.Card;
import com.jpadev.get_service.repository.CardRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class CardService {

    private final CardRepository cardRepository;

    public List<Card> listAll(){
        return cardRepository.findAll();
    }

    public List<Card> listAllActive(){
        return cardRepository.findAllActiveNotExpired(LocalDateTime.now()); //Lembrar de fazer regra no banco para o filtro.
    }

    public Card findCardById(Long id){
        return cardRepository.findById(id)
                .orElseThrow();//Voltar e tratar exception corretamente !
    }

    public CardService (CardRepository cardRepository){
        this.cardRepository = cardRepository;
    }
    public Card salvarCard (Card card){
        card.setCreatedTime(LocalDateTime.now());
        card.setTimeExpired(LocalDateTime.now().plusDays(3));

        return cardRepository.save(card);
    }

    public void deleteCard (Long id){
        if (!cardRepository.existsById(id)){
            //Voltar e tratar exception corretamente !
        }
        cardRepository.deleteById(id);
    }
}
