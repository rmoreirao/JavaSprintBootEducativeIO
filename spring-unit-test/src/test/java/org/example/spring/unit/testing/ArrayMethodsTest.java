package org.example.spring.unit.testing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class ArrayMethodsTest {

    private ArrayMethods arrayMethods;

    @Test
    public void testfindIndex_numberInArray() {
        //1. create object of the class
        ArrayMethods arrayMethods = new ArrayMethods();
        //2. call method
        int result = arrayMethods.findIndex(new int[]{8,4,5}, 4);
        //3. compare the actual results to the expected
        assertEquals(1, result);
    }

    //this test will fail. The error message will gve an insight into what the test was supposed to do.
    @Test
    @Disabled
    public void testfindIndex_numberNotInArray() {
        ArrayMethods arrayMethods = new ArrayMethods();
        assertEquals(1, arrayMethods.findIndex(new int[]{8,4,5}, 1),"The findIndex method finds the index of a given number");
    }

    @Test
    public void testfindIndex_emptyArray() {
        ArrayMethods arrayMethods = new ArrayMethods();
        assertEquals(-1, arrayMethods.findIndex(new int[]{}, 1));
    }

    @Test
    public void testAssert() {
        boolean condition = true;
        assertEquals(true,true);
        assertTrue(condition);

        String str = null;
        assertEquals(null, str);
        assertNull(str);

    }


    @Test
    public void testfindIndex_indexOutOfBound() {
        ArrayMethods arrayMethods = new ArrayMethods();
        assertThrows(ArrayIndexOutOfBoundsException.class, ()->arrayMethods.printArray(new int[] {1,8,5}, 3));
    }

    @Test
    public void testfindIndex() {
        ArrayMethods arrayMethods = new ArrayMethods();
        assertAll(
                () -> assertEquals(1, arrayMethods.findIndex(new int[]{8,4,5}, 4)),
                () -> assertEquals(-1, arrayMethods.findIndex(new int[]{8,4,5}, 1)),
                () -> assertEquals(-1, arrayMethods.findIndex(new int[]{}, 1))
        );
    }

    @Test
    @Disabled
    public void testSortArray() {
        fail("unimplemented method");
    }

    @BeforeEach
    void init(){
        //Initialize the object here
        System.out.println("Initializing before test");
        arrayMethods = new ArrayMethods();
    }

    @AfterEach
    void afterEachTest(){
        System.out.println("Clean up after test");
    }

    @BeforeAll
    static void beforeAllTests() {
        System.out.println("Run this code before all tests");
    }

    @AfterAll
    static void afterAllTests() {
        System.out.println("Run this code after all tests");
    }

}