package org.flashCardManager.model.entity;

import java.time.LocalDate;
import java.util.Objects;
import java.util.UUID;

public class Meaning {
    private String id;
    private String cardId;
    private String definition;
    // contexts
    // examples
    private LocalDate nextReviewDate;
    private int interval;
    private int repetitions;
    private float easeFactor;
    private PracticeMode practiceMode;
    private LocalDate creationDate;

    public Meaning() {
    }

    private Meaning(Builder builder) {
        setId(UUID.randomUUID().toString().substring(0, 8));
        setCardId(builder.cardId);
        setDefinition(builder.definition);
        setNextReviewDate(builder.nextReviewDate);
        setInterval(builder.interval);
        setRepetitions(builder.repetitions);
        setEaseFactor(builder.easeFactor);
        setPracticeMode(builder.practiceMode);
        setCreationDate(LocalDate.now());
    }

    // Getters
    public String getId() {
        return id;
    }

    public String getCardId() {
        return cardId;
    }

    public String getDefinition() {
        return definition;
    }

    public LocalDate getNextReviewDate() {
        return nextReviewDate;
    }

    public int getInterval() {
        return interval;
    }

    public int getRepetitions() {
        return repetitions;
    }

    public float getEaseFactor() {
        return easeFactor;
    }

    public PracticeMode getPracticeMode() {
        return practiceMode;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    // Setters
    private void setId(String id) {
        this.id = Objects.requireNonNull(id, "Id nao pode ser nulo");
    }

    private void setCardId(String cardId) {
        this.cardId = Objects.requireNonNull(cardId, "CardId nao pode ser nulo");
    }

    private void setDefinition(String definition) {
        Objects.requireNonNull(definition, "Definition nao pode ser nulo");
        if (definition.trim().length() < 10)
            throw new IllegalArgumentException("Definicao deve ter pelo menos 10 caracteres");
        this.definition = definition;
    }

    private void setNextReviewDate(LocalDate nextReviewDate) {
        Objects.requireNonNull(nextReviewDate, "NextReviewDate nao pode ser nulo");
        if (nextReviewDate.isBefore(LocalDate.now()))
            throw new IllegalArgumentException("O nextReviewDate nao pode ser no passado");
        this.nextReviewDate = nextReviewDate;
    }

    private void setInterval(int interval) {
        this.interval = interval;
    }

    private void setRepetitions(int repetitions) {
        this.repetitions = repetitions;
    }

    private void setEaseFactor(float easeFactor) {
        this.easeFactor = easeFactor;
    }

    private void setPracticeMode(PracticeMode practiceMode) {
        this.practiceMode = Objects.requireNonNull(practiceMode, "PracticeMode nao pode ser nulo");
    }

    private void setCreationDate(LocalDate creationDate) {
        this.creationDate = Objects.requireNonNull(creationDate, "Data de criacao é obrigatória");
    }

    // Builder
    public static class Builder {
        private String cardId;
        private String definition;
        private LocalDate nextReviewDate;
        private int interval;
        private int repetitions;
        private float easeFactor;
        private PracticeMode practiceMode;

        public Builder cardId(String cardId) {
            this.cardId = cardId;
            return this;
        }

        public Builder definition(String definition) {
            this.definition = definition;
            return this;
        }

        public Builder nextReviewDate(LocalDate nextReviewDate) {
            this.nextReviewDate = nextReviewDate;
            return this;
        }

        public Builder interval(int interval) {
            this.interval = interval;
            return this;
        }

        public Builder repetitions(int repetitions) {
            this.repetitions = repetitions;
            return this;
        }

        public Builder easeFactor(float easeFactor) {
            this.easeFactor = easeFactor;
            return this;
        }

        public Builder practiceMode(PracticeMode practiceMode) {
            this.practiceMode = practiceMode;
            return this;
        }

        public Meaning build() {
            return new Meaning(this);
        }
    }
}
