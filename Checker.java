package readability;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Checker {
    ScoreChecker scoreChecker = new ScoreChecker();
    ScoreToYears scoreToYears = new ScoreToYears();

    double sentences;
    double words;
    double characters;
    double syllables;
    double polysyllables;


    public String textChecker(String text) {
        String[] wordsArray = text.replaceAll("[.,!?]", "").split("\\s");

        sentences = text.split("[.!?]").length;
        words = text.split("\\s").length;
        characters = text.replaceAll("\\s+", "").split("").length;

        for (String s : wordsArray) {
            syllables += syllablesCount(s);
            if (syllablesCount(s) >= 3) {
                polysyllables++;
            }
        }

        return String.format("Words: %d\nSentences: %d\nCharacters: %d\nSyllables: %d\nPolysyllables: %d",(int) words, (int) sentences, (int) characters, (int) syllables, (int) polysyllables);
    }

    public int syllablesCount(String word) {
        Pattern p = Pattern.compile("([ayeiou]+)");
        String lowerCase = word.toLowerCase();
        Matcher m = p.matcher(lowerCase);
        int count = 0;
        while (m.find()) {
            count++;
        }
        if (lowerCase.endsWith("e")) {
            count--;
        }
        return count <= 0 ? 1 : count;
    }

    public void score(String scoreSystem) {
        System.out.println();
        double score;
        int years;
        switch (scoreSystem) {
            case "ARI":
                score = scoreChecker.scoreInARI(characters, words, sentences);
                years = scoreToYears.scoreToYears(score);
                System.out.printf("Automated Readability Index: %.2f (about %d year olds)", score, years);
                break;
            case "FK":
                score = scoreChecker.scoreInFK(words, sentences, syllables);
                years = scoreToYears.scoreToYears(score);
                System.out.printf("Flesch–Kincaid readability tests: %.2f (about %d year olds)", score, years);
                break;
            case "SMOG":
                score = scoreChecker.scoreInSMOG(polysyllables, sentences);
                years = scoreToYears.scoreToYears(score);
                System.out.printf("Simple Measure of Gobbledygook: %.2f (about %d year olds)", score, years);
                break;
            case "CL":
                score = scoreChecker.scoreInCL(characters, words, sentences);
                years = scoreToYears.scoreToYears(score);
                System.out.printf("Coleman–Liau index: %.2f (about %d year olds)", score, years);
                break;
            case "all":
                double averageYears = 0;

                score = scoreChecker.scoreInARI(characters, words, sentences);
                years = scoreToYears.scoreToYears(score);
                System.out.printf("Automated Readability Index: %.2f (about %d year olds)\n", score, years);
                averageYears += years;

                score = scoreChecker.scoreInFK(words, sentences, syllables);
                years = scoreToYears.scoreToYears(score);
                System.out.printf("Flesch–Kincaid readability tests: %.2f (about %d year olds)\n", score, years);
                averageYears += years;

                score = scoreChecker.scoreInSMOG(polysyllables, sentences);
                years = scoreToYears.scoreToYears(score);
                System.out.printf("Simple Measure of Gobbledygook: %.2f (about %d year olds)\n", score, years);
                averageYears += years;

                score = scoreChecker.scoreInCL(characters, words, sentences);
                years = scoreToYears.scoreToYears(score);
                System.out.printf("Coleman–Liau index: %.2f (about %d year olds)\n", score, years);
                averageYears += years;

                System.out.println();

                System.out.printf("This text should be understood in average by %.2f year olds.", averageYears / 4);
        }
    }
}
