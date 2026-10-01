package org.flashCardManager.factory;

import org.flashCardManager.jsonRepository.*;
import org.flashCardManager.repository.*;

public class RepositoryFactory {

    public enum StorageType { JSON, JPA, IN_MEMORY }

    private final StorageType storageType;

    public RepositoryFactory(StorageType storageType) {
        this.storageType = storageType;
    }

    public UserRepository createUserRepository() {
        return switch (storageType) {
            case JSON -> new UserJsonRepository();
            case JPA -> throw new UnsupportedOperationException("JPA ainda não implementado");
            case IN_MEMORY -> throw new UnsupportedOperationException("In-memory ainda não implementado");
        };
    }

    public DeckRepository createDeckRepository() {
        return switch (storageType) {
            case JSON -> new DeckJsonRepository();
            // ...
            default -> throw new UnsupportedOperationException();
        };
    }

    public CardRepository createCardRepository() {
        return switch (storageType) {
            case JSON -> new CardJsonRepository();
            default -> throw new UnsupportedOperationException();
        };
    }

    public MeaningRepository createMeaningRepository() {
        return switch (storageType) {
            case JSON -> new MeaningJsonRepository();
            default -> throw new UnsupportedOperationException();
        };
    }

    public ExampleRepository createExampleRepository() {
        return switch (storageType) {
            case JSON -> new ExampleJsonRepository();
            default -> throw new UnsupportedOperationException();
        };
    }
}