package com.example.demo.controllers;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HelloTest {

    @Test
    public void testHelloTest() {
        Hello hello = new Hello();
        String result = hello.helloTest();
        assertEquals("Hello Test", result);
    }
}
