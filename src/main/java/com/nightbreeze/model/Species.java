package com.nightbreeze.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Species {

    private String name;
    private Map<String, Integer> abilityScoreIncrease;
    private String size;
    private int speed;
    private Proficiency proficiency;
    private List<Trait> traits;
    private List<Language> languages;
    private List<Subrace> subraces;

    // Getters and Setters for all fields...
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<String, Integer> getAbilityScoreIncrease() {
        return abilityScoreIncrease;
    }

    public void setAbilityScoreIncrease(Map<String, Integer> abilityScoreIncrease) {
        this.abilityScoreIncrease = abilityScoreIncrease;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public Proficiency getProficiency() {
        return proficiency;
    }

    public void setProficiency(Proficiency proficiency) {
        this.proficiency = proficiency;
    }

    public List<Trait> getTraits() {
        return traits;
    }

    public void setTraits(List<Trait> traits) {
        this.traits = traits;
    }

    public List<Language> getLanguages() {
        return languages;
    }

    public void setLanguages(List<Language> languages) {
        this.languages = languages;
    }

    public List<Subrace> getSubraces() {
        return subraces;
    }

    public void setSubraces(List<Subrace> subraces) {
        this.subraces = subraces;
    }

    @Override
    public String toString() {
        // Useful for debugging and potentially ComboBox display
        return name;
    }
}
