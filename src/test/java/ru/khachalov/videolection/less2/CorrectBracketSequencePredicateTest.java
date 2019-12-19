package ru.khachalov.videolection.less2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CorrectBracketSequencePredicateTest {

    @Test
    void nullString() {
        assertEquals(true,
                CorrectBracketSequencePredicate.check(""));
    }

    @Test
    void correctString(){
        assertEquals(true,
                CorrectBracketSequencePredicate.check("(())(())"));
        assertEquals(true,
                CorrectBracketSequencePredicate.check("{(())()}"));
        assertEquals(true,
                CorrectBracketSequencePredicate.check("(())()"));
        assertEquals(true,
                CorrectBracketSequencePredicate.check("{(())()[{}]}"));
        assertEquals(true,
                CorrectBracketSequencePredicate.check("{(())()}[{}]()"));
        assertEquals(true,
                CorrectBracketSequencePredicate.check("{(()){{}}()}"));
        assertEquals(true,
                CorrectBracketSequencePredicate.check("{(({}))()}"));
        assertEquals(true,
                CorrectBracketSequencePredicate.check("()"));
        assertEquals(true,
                CorrectBracketSequencePredicate.check("([])"));
        assertEquals(true,
                CorrectBracketSequencePredicate.check("()[]"));
        assertEquals(true,
                CorrectBracketSequencePredicate.check("{()}"));
    }

    @Test
    void incorrectString(){
        assertThrows(IllegalArgumentException.class,
                () -> {
            CorrectBracketSequencePredicate.check(")(");
            CorrectBracketSequencePredicate.check("][");
            CorrectBracketSequencePredicate.check("}{");
            CorrectBracketSequencePredicate.check("(}");
            CorrectBracketSequencePredicate.check("{]");
            CorrectBracketSequencePredicate.check("{{{]]");
            CorrectBracketSequencePredicate.check("{([)}");
                });
    }
}