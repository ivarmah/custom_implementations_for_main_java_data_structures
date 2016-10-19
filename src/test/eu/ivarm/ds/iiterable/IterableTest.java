package test.eu.ivarm.ds.iiterable;

import main.eu.ivarm.ds.iiterable.Student;
import main.eu.ivarm.ds.iiterable.University;
import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;

import static org.hamcrest.core.IsInstanceOf.instanceOf;
import static org.junit.Assert.*;

public class IterableTest {
    private Student[] students;
    private University univ;
    private Iterator<Student> stundentIterator;

    @Before
    public void initialize() {
        final int studentsCount = 10_000;
        students = new Student[studentsCount];
        for (int i = 0; i < studentsCount; i++) {
            students[i] = new Student();
        }
        univ = new University(students);
        stundentIterator = univ.iterator();
    }

    @Test
    public void throwsException() {
        try {
        int y = 0;
        for (Student stud: univ) {
            if (students[y+1] != stud) {
                throw new RuntimeException(String.format("Iterator return incorrect element with index: %d", y));
            }
            y++;
        }}
        catch(RuntimeException e){
            assertThat(e, instanceOf(RuntimeException.class));
        }
    }

    @Test
    public void withoutException() {
        int y = 0;
        for (Student stud: univ) {
            if (students[y+1] != stud) {
                throw new RuntimeException(String.format("Iterator return incorrect element with index: %d", y));
            }
            y++;
        }
    }
}
