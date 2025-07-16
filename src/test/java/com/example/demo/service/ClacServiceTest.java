package com.example.demo.service;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ClacServiceTest {

    ClacService service = new ClacService();

    @Test
    void testAdd() {
        assertEquals(4, service.add(2, 2));
    }

    @Test
    void testSub() {
        assertEquals(0, service.sub(2, 2));
    }

    @Test
    void testMul() {
        assertEquals(4, service.mul(2, 2));
    }

    @Test
    void testDiv() {
        assertEquals(1, service.div(2, 2));
    }
}
