package org.example.spring.unit.testing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class StudentServiceStubTest {

    @Test
    void testFindTotal() {
        StudentService studentService = new StudentService(new StudentDaoStub());
        int total = studentService.findTotal();
        assertEquals(40, total);
    }

}

class StudentDaoStub extends StudentDao{
    //@Override
    public int[] getMarks() {
        return new int[]{15, 20, 5};
    }

}