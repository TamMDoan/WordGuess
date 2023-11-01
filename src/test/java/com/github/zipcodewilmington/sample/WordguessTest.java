package com.github.zipcodewilmington.sample;

import com.github.zipcodewilmington.Wordguess;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class WordguessTest {

    @Test
    public void testWordguessConstructor(){
        Wordguess wordguess = new Wordguess();

        Assert.assertNotNull(wordguess.getListOfWordsToGuess());
    }

    @Test
    public void testGetListOfWordsToGuess(){
        Wordguess wordguess = new Wordguess();
        String[] expected = new String[]{"jazz", "bread", "zipcode", "dolio"};
        Assert.assertEquals(expected, wordguess.getListOfWordsToGuess());
    }

    @Test
    public void testGetWordToGuess(){
        Wordguess wordguess = new Wordguess();
        wordguess.setUpGame();
        String expected = Arrays.toString(wordguess.getWordToGuess());

        Assert.assertEquals(expected, Arrays.toString(wordguess.getWordToGuess()));
    }

    @Test
    public void testGetPlayersGuesses(){
        Wordguess wordguess = new Wordguess();
        char[] expected = wordguess.getPlayersGuesses();

        Assert.assertEquals(expected, wordguess.getPlayersGuesses());
    }

    @Test
    public void testCheckIfGuessIsValid(){
        Wordguess wordguess = new Wordguess();
        wordguess.setWordToGuess("hello".toCharArray());
        wordguess.setPlayersGuesses("_____".toCharArray());
        String letterGuessed = "l";

        wordguess.checkIfGuessIsValid(letterGuessed);
        String expected = "[_, _, l, l, _]";

        Assert.assertEquals(expected, Arrays.toString(wordguess.getPlayersGuesses()));

    }

    @Test
    public void testCheckIfGuessIsNotValid(){
        Wordguess wordguess = new Wordguess();
        wordguess.setWordToGuess("hello".toCharArray());
        wordguess.setPlayersGuesses("_____".toCharArray());
        String letterGuessed = "p";

        wordguess.checkIfGuessIsValid(letterGuessed);
        String expected = "[_, _, _, _, _]";

        Assert.assertEquals(expected, Arrays.toString(wordguess.getPlayersGuesses()));
    }









}
