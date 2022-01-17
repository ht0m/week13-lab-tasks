package day01;

import java.util.*;

public class ClassNoteBook {

    Map<Student, List<Integer>> studentListMap = new TreeMap<>();

    public void addStudent(Student student) {
        if (!studentListMap.containsKey(student)) {
            studentListMap.put(student, new ArrayList<>());
        } else {
            throw new IllegalArgumentException("Student is already in the notebook");
        }

    }

    public void addMark(int id, int mark) {
        for (Map.Entry<Student, List<Integer>> actual : studentListMap.entrySet()) {
            if (id == actual.getKey().getId()) {
                actual.getValue().add(mark);
            }
        }
    }
}
