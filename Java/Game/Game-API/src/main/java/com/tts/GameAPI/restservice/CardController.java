package com.tts.GameAPI.restservice;

import com.tts.GameAPI.Card;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@CrossOrigin(origins = "http://localhost:3000/")
@RestController
public class CardController {

    // 📝 Counter for id
    private final AtomicLong counter = new AtomicLong();

    // @PostMapping("/Game")
    // public

    // 📝 TODO: method to generate specific card
    // e.g. Ace of Spades:
    // id: counter
    // Suit: Spades
    // BlackjackValue: "ACE" (see BlackjackValue class under cardClasses)
    // ImageData: src = "AS.svg", alt = "Ace of spades" (go to `React/react-meta-component/public/Images" in the class repo for the image file names

    // 📝 TODO: method to generate full 52 deck of cards "in order"
    // i.e. go to `React/react-meta-component/public/Data/non-API/deck.json` to see an example of a json with all 52 cards
    // 📝 Also note that this deck will be only be used **interally** in the java backend API; i.e. it will be used for game logic calculations, but the react front-end will only be given single cards at a time for each GET request

    // 📝 TODO: method to generate deck of n * 52 cards in a random order where $n\in\mathbb{N}$

}