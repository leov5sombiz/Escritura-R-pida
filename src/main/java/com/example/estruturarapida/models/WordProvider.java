package com.example.estruturarapida.models;

import java.util.List;

public class WordProvider {

    private static final List<String> WORDS = List.of(
            "java","world","master","stranger","cancer","peanut","demoniac",
            "Animals","concerts","ostentation","abomination","columns","ambivalent",
            "tentative","atrocious","extremely","tartarus","Abbreviation","patience",
            "sensational","exceptional","bloodbath","Consanguineous", "Australopithecus"
    );

    static int index = 0; // starts in the first word

    /**
     * Returns the next word in order. Loops back when the end is reached.
     * @return next word from WORDS
     */

    public static String getNext() {
        String word = WORDS.get(index);
        index++;
        if (index >= WORDS.size()) {
            index = 0; // start again when reaches end
        }
        return word;
    }

    public static void reset() {
        index = 0;
    }

}