package day01;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class ClassNoteBookTest {
    @Test
    void testClassNoteBook() {
        ClassNoteBook classNoteBook = new ClassNoteBook();
        Student student1=  new Student(1212, "Laci");
        classNoteBook.addStudent(student1);
        classNoteBook.addStudent(new Student(1213, "Joci"));
        classNoteBook.addStudent(new Student(1214, "Viki"));

        classNoteBook.addMark(1212, 5);
        classNoteBook.addMark(1213, 5);
        classNoteBook.addMark(1213, 4);
        classNoteBook.addMark(1214, 2);

        System.out.println(classNoteBook.studentListMap);
        System.out.println(classNoteBook.studentListMap.get(student1));

        assertEquals(Arrays.asList(5), classNoteBook.studentListMap.get(student1));

    }

}