package com.example.estruturarapida.views;

import com.example.estruturarapida.models.WordProvider;

/**
 * Core game logic: levels, words, and validation.
 **/

public class GameView {

    private int level;
    private String currentWord;

    /**
     * Starts a new level
     */
    public void startLevel() {
        currentWord = WordProvider.getNext();
        level++;
    }

    /**
     *Checks if the text is same as the word showed up
     */
    public boolean validateInput(String input) {
        return input != null && input.equals(currentWord);
    }


    /**
     * Calculates time player will have in the level
     */
    public int getTimeForLevel() {
        int reductionSteps = (level - 1) / 5; // every 5 levels reduce 2sec
        int baseTime = 20;
        return Math.max(baseTime - reductionSteps * 2, 2);
    }

    /**
     * Getters returns private values
     */
    public String getCurrentWord() { return currentWord; }
    public int getLevel() { return level; }

    /**
     * Restart the game
     */
    public void reset() {
        level = 0;
        WordProvider.reset();
    }
}