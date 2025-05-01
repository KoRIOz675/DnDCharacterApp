package com.nightbreeze.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javafx.beans.property.*;

public class Character {

    // Basic Information
    private final StringProperty characterName = new SimpleStringProperty();
    private final StringProperty className = new SimpleStringProperty();
    private final IntegerProperty classLevel = new SimpleIntegerProperty(1);
    private final StringProperty background = new SimpleStringProperty();
    private final StringProperty playerName = new SimpleStringProperty();
    private final StringProperty race = new SimpleStringProperty();
    private final StringProperty alignment = new SimpleStringProperty();
    private final IntegerProperty experiencePoints = new SimpleIntegerProperty(0);

    private final BooleanProperty inspiration = new SimpleBooleanProperty(false);

    // Hit Points
    private final IntegerProperty maxHP = new SimpleIntegerProperty();
    private final IntegerProperty currentHP = new SimpleIntegerProperty();
    private final IntegerProperty temporaryHP = new SimpleIntegerProperty();

    // Abilities
    private final IntegerProperty strength = new SimpleIntegerProperty();
    private final IntegerProperty dexterity = new SimpleIntegerProperty();
    private final IntegerProperty constitution = new SimpleIntegerProperty();
    private final IntegerProperty intelligence = new SimpleIntegerProperty();
    private final IntegerProperty wisdom = new SimpleIntegerProperty();
    private final IntegerProperty charisma = new SimpleIntegerProperty();

    // Constructor
    public Character() {}

    // JavaFX Properties
    public StringProperty CharacterNameProperty() {
        return characterName;
    }

    public StringProperty classNameProperty() {
        return className;
    }

    public StringProperty raceProperty() {
        return race;
    }

    public IntegerProperty classLevelProperty() {
        return classLevel;
    }

    public StringProperty backgroundProperty() {
        return background;
    }

    public StringProperty alignmentProperty() {
        return alignment;
    }

    public IntegerProperty maxHPProperty() {
        return maxHP;
    }

    public IntegerProperty currentHPProperty() {
        return currentHP;
    }

    public IntegerProperty temporaryHPProperty() {
        return temporaryHP;
    }

    public IntegerProperty strengthProperty() {
        return strength;
    }

    public IntegerProperty dexterityProperty() {
        return dexterity;
    }

    public IntegerProperty constitutionProperty() {
        return constitution;
    }

    public IntegerProperty intelligenceProperty() {
        return intelligence;
    }

    public IntegerProperty wisdomProperty() {
        return wisdom;
    }

    public IntegerProperty charismaProperty() {
        return charisma;
    }

    // Getters & Setters -- Basic Info
    public String getName() {
        return characterName.get();
    }

    public void setName(String name) {
        this.characterName.set(name);
    }

    public String getClassName() {
        return className.get();
    }

    public void setClassName(String className) {
        this.className.set(className);
    }

    public String getRace() {
        return race.get();
    }

    public void setRace(String race) {
        this.race.set(race);
    }

    public int getLevel() {
        return classLevel.get();
    }

    public void setLevel(int level) {
        this.classLevel.set(level);
    }

    public String getBackground() {
        return background.get();
    }

    public void setBackground(String background) {
        this.background.set(background);
    }

    public String getAlignment() {
        return alignment.get();
    }

    public void setAlignment(String alignment) {
        this.alignment.set(alignment);
    }

    // Getters & Setters -- Max Hit Points
    public int getMaxHP() {
        return maxHP.get();
    }

    public void setMaxHP(int maxHP) {
        this.maxHP.set(maxHP);
    }

    // Getters & Setters -- Current Hit Points
    public int getCurrentHP() {
        return currentHP.get();
    }

    public void setCurrentHP(int hp) {
        currentHP.set(Math.min(hp, maxHP.get()));
        if (currentHP.get() < 0) {
            currentHP.set(0);
        }
    }

    // Getters & Setters -- Temporary Hit Points
    public int getTemporaryHP() {
        return temporaryHP.get();
    }

    public void setTemporaryHP(int hp) {
        temporaryHP.set(Math.max(0, hp));
    }

    // Getters & Setters -- Ability
    public int getStrength() {
        return strength.get();
    }

    public void setStrength(int score) {
        this.strength.set(score);
    }

    public int getDexterity() {
        return dexterity.get();
    }

    public void setDexterity(int score) {
        this.dexterity.set(score);
    }

    public int getConstitution() {
        return constitution.get();
    }

    public void setConstitution(int score) {
        this.constitution.set(score);
    }

    public int getIntelligence() {
        return intelligence.get();
    }

    public void setIntelligence(int score) {
        this.intelligence.set(score);
    }

    public int getWisdom() {
        return wisdom.get();
    }

    public void setWisdom(int score) {
        this.wisdom.set(score);
    }

    public int getCharisma() {
        return charisma.get();
    }

    public void setCharisma(int score) {
        this.charisma.set(score);
    }

    // Getters -- Ability Modifier
    @JsonIgnore
    public int getStrengthModifier() {
        return Math.floorDiv(getStrength() - 10, 2);
    }

    @JsonIgnore
    public int getDexterityModifier() {
        return Math.floorDiv(getDexterity() - 10, 2);
    }

    @JsonIgnore
    public int getConstitutionModifier() {
        return Math.floorDiv(getConstitution() - 10, 2);
    }

    @JsonIgnore
    public int getIntelligenceModifier() {
        return Math.floorDiv(getIntelligence() - 10, 2);
    }

    @JsonIgnore
    public int getWisdomModifier() {
        return Math.floorDiv(getWisdom() - 10, 2);
    }

    @JsonIgnore
    public int getCharismaModifier() {
        return Math.floorDiv(getCharisma() - 10, 2);
    }

    // Methods

    // Take Damage
    public void damage(int damageValue) {
        if (damageValue <= 0) return;

        int tempDamage = Math.min(damageValue, getTemporaryHP());
        setTemporaryHP(getCurrentHP() - tempDamage);

        int remainDamage = damageValue - tempDamage;
        if (remainDamage > 0) {
            setCurrentHP(getCurrentHP() - remainDamage);
        }
    }

    // Receive healing
    public void heal(int healValue) {
        if (healValue <= 0) return;
        setCurrentHP(Math.min(getMaxHP(), getCurrentHP() + healValue));
    }

    // Receive temporary hit points
    public void temporaryHP(int temporaryHPValue) {
        if (temporaryHPValue <= 0) return;

        setTemporaryHP(getTemporaryHP() + temporaryHPValue);
    }
}
