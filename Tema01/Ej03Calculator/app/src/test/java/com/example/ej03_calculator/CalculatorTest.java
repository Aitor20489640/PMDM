package com.example.ej03_calculator;

import static org.junit.Assert.*;

import org.junit.Test;

public class CalculatorTest {
    @Test
    public void testAdd2Opernds() {
        long total = Integer.parseInt(Calculator.calculate("5+3"));
        assertEquals("X + y operations not working correcty", 8, total);
        //The message here is displayed if the test fails
    }

    @Test
    public void testAdd1Operand() {
        long total = Integer.parseInt(Calculator.calculate("4+3+1"));
        assertEquals("+X operations not working correctly", 8, total);
    }
    @Test
    public void testMult2perands() {
        long total = Integer.parseInt(Calculator.calculate("4*2"));
        assertEquals("4*X operations not working correctly", 8, total);
    }
    @Test
    public void test2Mult2perands() {
        long total = Integer.parseInt(Calculator.calculate("2*3"));
        assertEquals("X*Y operations not working correctly", 6, total);
    }
    @Test
    public void testMult1Operand() {
        long total = Integer.parseInt(Calculator.calculate("1*2*8"));
        assertEquals("*X operations not working correctly", 16, total);
    }
    @Test
    public void testMultAdd1Operand() {
        long total = Integer.parseInt(Calculator.calculate("2*2+3"));
        assertEquals("X*Y+Z operations not working correctly", 7, total);
    }
    @Test
    public void testAddMult1Operand() {
        long total = Integer.parseInt(Calculator.calculate("3+2*2"));
        assertEquals("X+Y*Z operations not working correctly", 7, total);
    }
    @Test
    public void testAddMult3Operand() {
        long total = Integer.parseInt(Calculator.calculate("3+2*2+4"));
        assertEquals("X+Y*Z+E operations not working correctly", 11, total);
    }
}
