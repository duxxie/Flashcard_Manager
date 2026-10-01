package org.flashCardManager.service;

import org.flashCardManager.factory.RepositoryFactory;
import org.flashCardManager.repository.*;

public class ServiceFactory {

    private final RepositoryFactory repoFactory;

    public ServiceFactory(RepositoryFactory repoFactory) {
        this.repoFactory = repoFactory;
    }

    public UserService createUserService(UserRepository userRepository) {
        return new UserService(userRepository);
    }

    public DeckService createDeckService(DeckRepository deckRepo, CardRepository cardRepo) {
        return new DeckService(deckRepo, cardRepo);
    }

    public CardService createCardService(CardRepository cardRepo, DeckRepository deckRepo) {
        return new CardService(cardRepo, deckRepo);
    }

    public MeaningService createMeaningService(MeaningRepository mRepo, CardRepository cRepo) {
        return new MeaningService(mRepo, cRepo);
    }

    public ExampleService createExampleService(ExampleRepository eRepo, MeaningRepository mRepo) {
        return new ExampleService(eRepo, mRepo);
    }

    public AuthService createAuthService(UserRepository userRepo) {
        return new AuthService(userRepo);
    }
}