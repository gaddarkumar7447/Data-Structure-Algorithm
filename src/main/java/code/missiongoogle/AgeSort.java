package code.missiongoogle;

import java.util.Comparator;

public class AgeSort implements Comparator<Student> {
   /* @Override
    public int compare(Object o1, Object o2) {
        Student student = (Student) o1;
        Student student1 = (Student) o2;
        return student.age - student1.age;
    }*/

    @Override
    public int compare(Student o1, Student o2) {
        return o1.age - o2.age;
    }
}
