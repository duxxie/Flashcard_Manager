package org.flashCardManager.app;

import org.flashCardManager.controller.*;

public class AppFactory {

    public MeaningApp createMeaningApp(MeaningController c) {
        return new MeaningApp(c);
    }

    public CardApp createCardApp(CardController c, MeaningApp meaningApp) {
        return new CardApp(c, meaningApp);
    }

    public DeckApp createDeckApp(DeckController c, CardApp cardApp) {
        return new DeckApp(c, cardApp);
    }

    public UserApp createUserApp(UserController c, DeckApp deckApp) {
        return new UserApp(c, deckApp);
    }
}