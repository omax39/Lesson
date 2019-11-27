package ru.khachalov.videolection.less1;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RealizationTest {
    private static FizzBuzz testRealization;
    @BeforeAll
    static void createFizzBuzz(){
        testRealization = new Realization();
    }

    @Test
    void testCorrectInput() {
        testRealization.print(0,1);
    }

    @Test
    void testIncorrectInput(){
        assertThrows(IllegalArgumentException.class, () ->{
            testRealization.print(-1,0);
        });
        assertEquals(testRealization.getResulSize(),
                testRealization.sizeResulRigth());
    }

    @Test
    void testNaFizzBuss(){
        assertEquals("FizzBuzz", testRealization.print(15, 15));
        assertEquals("FizzBuzz", testRealization.print(45, 45));
        assertEquals("FizzBuzz", testRealization.print(30, 30));
        assertEquals("FizzBuzz", testRealization.print(60, 60));
        assertEquals("FizzBuzz", testRealization.print(75, 75));
    }

    @Test
    void testNaFizz(){
        assertEquals("Fizz", testRealization.print(3, 3));
        assertEquals("Fizz", testRealization.print(6, 6));
        assertEquals("Fizz", testRealization.print(9, 9));
        assertEquals("Fizz", testRealization.print(12, 12));
        assertEquals("Fizz", testRealization.print(18, 18));
    }

    @Test
    void testNaBuss(){
        assertEquals("Buzz", testRealization.print(5, 5));
        assertEquals("Buzz", testRealization.print(10, 10));
        assertEquals("Buzz", testRealization.print(35, 35));
        assertEquals("Buzz", testRealization.print(20, 20));
        assertEquals("Buzz", testRealization.print(25, 25));
    }

    @Test
    void testNaNomer(){
        assertEquals("1", testRealization.print(1, 1));
        assertEquals("2", testRealization.print(2, 2));
        assertEquals("4", testRealization.print(4, 4));
        assertEquals("7", testRealization.print(7, 7));
        assertEquals("8", testRealization.print(8, 8));
    }
}