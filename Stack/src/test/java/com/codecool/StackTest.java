package com.codecool;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class StackTest {

    Stack<Integer> intStack;
    Stack<String> stringStack;

    @BeforeEach
    public void setup() {
        intStack = new Stack<>(4);
        stringStack = new Stack<>(3);
    }

    @Test
    public void testFreeSpaces() {
        intStack.push(1);
        intStack.push(2);

        stringStack.push("A");

        assertAll(
                () -> assertEquals(2, intStack.freeSpacesLeft()),
                () -> assertEquals(2, stringStack.freeSpacesLeft())
        );
    }

    @Test
    public void testPeek() {
        intStack.push(1);
        stringStack.push("Village");

        assertAll(
                () -> assertEquals(new Integer(1), intStack.peek()),
                () -> assertEquals("Village", stringStack.peek())
        );
    }

    @Test
    public void testSize() {
        assertAll(
                () -> assertEquals(4, intStack.getSize()),
                () -> assertEquals(3, stringStack.getSize())
        );
    }

    @Test
    public void testPush() throws Exception{
        intStack.push(1);
        intStack.push(2);

        stringStack.push("Brzozo");

        assertAll(
                ()-> assertEquals(1, intStack.getPointer()),
                () -> assertEquals(0, stringStack.getPointer())
        );
    }

    @Test
    public void testPop() throws Exception {
        intStack.push(35);

        stringStack.push("Goat");

        assertAll(
                () -> assertEquals(new Integer(35), intStack.pop()),
                () -> assertEquals("Goat", stringStack.pop())
        );
    }

    @Test
    public void testPopWhileEmpty() throws Exception{
        assertThrows(Exception.class,() -> intStack.pop());
    }

    @Test
    public void testPushWhileFull() {
        stringStack.push("A");
        stringStack.push("B");
        stringStack.push("C");

        assertThrows(StackOverflowError.class, () -> stringStack.push("D"));
    }
}
