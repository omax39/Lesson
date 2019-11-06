package ru.khachalov.one.less2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CorrectBracketSequencePredicateTest {

    @Test
    void nullString() {
        assertEquals(true,
                CorrectBracketSequencePredicate.test(""));
    }

    @Test
    void correctString(){
        assertEquals(true,
                CorrectBracketSequencePredicate.test("(())(())"));
        //assertEquals(true,
        //       CorrectBracketSequencePredicate.test("{(())()}"));
        assertEquals(true,
                CorrectBracketSequencePredicate.test("()"));
        assertEquals(true,
                CorrectBracketSequencePredicate.test("([])"));
        assertEquals(true,
                CorrectBracketSequencePredicate.test("()[]"));
        assertEquals(true,
                CorrectBracketSequencePredicate.test("{()}"));
    }

    @Test
    void incorrectString(){
        assertThrows(IllegalArgumentException.class,
                () -> {
            CorrectBracketSequencePredicate.test(")(");
            CorrectBracketSequencePredicate.test("][");
            CorrectBracketSequencePredicate.test("}{");
            CorrectBracketSequencePredicate.test("(}");
            CorrectBracketSequencePredicate.test("{]");
            CorrectBracketSequencePredicate.test("{{{]]");
            CorrectBracketSequencePredicate.test("{([)}");
                });
    }
}