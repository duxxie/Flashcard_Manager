package org.flashCardManager.controller;

import org.flashCardManager.service.*;

public class ControllerFactory {

    public UserController createUserController(UserService userService) {
        return new UserController(userService);
    }

    public DeckController createDeckController(DeckService deckService) {
        return new DeckController(deckService);
    }

    public CardController createCardController(CardService cardService) {
        return new CardController(cardService);
    }

    public MeaningController createMeaningController(MeaningService meaningService) {
        return new MeaningController(meaningService);
    }

    public ExampleController createExampleController(ExampleService exampleService) {
        return new ExampleController(exampleService);
    }

    public AuthController createAuthController(AuthService authService) {
        return new AuthController(authService);
    }
}