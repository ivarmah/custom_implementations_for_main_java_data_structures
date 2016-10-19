package main.eu.ivarm.ds.iterator;

import main.eu.ivarm.ds.iiterable.Student;

import java.util.Iterator;
import java.util.Arrays;
import java.util.NoSuchElementException;

public class Group implements Iterable<Student> {

    private Student[] students;

    public Group(final Student[] students) {
        this.students = students;
    }

    public Iterator<Student> iterator() {
        return new StudentsIterator(students);
    }

    private static class StudentsIterator implements Iterator<Student> {
        private Student[] students;
        private int index = 0;

        public StudentsIterator(final Student[] students) {
            this.students = students;
        }

        public boolean hasNext() {
            return students.length > index;
        }

        public Student next() {
            try {
                if (hasNext()) {
                    return students[index++];
                } else {
                    throw new NoSuchElementException();
                }
            } catch (NoSuchElementException e) {
                throw e;
            }
        }
    }

}