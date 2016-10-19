package main.eu.ivarm.ds.iiterable;


import java.util.Iterator;
import java.util.Arrays;

public class University implements Iterable<Student>{

    private final Student[] students;

    public University(final Student[] students) {
        this.students = students;
    }

    @Override
    public Iterator<Student> iterator(){
        return Arrays.asList(students).iterator();
    }
}

