package com.company;

import java.util.List;

public class JavaStudentGroup {
    private List<Student> group;

    public void setGroup(List<Student> group) {
        this.group = group;
    }

    public JavaStudentGroup() {

    }

    public void group(List<Student> students, double x){
        int size = (int) Math.ceil(students.size() / x);
        System.out.println("Groups:");
        for (int start = 0; start < students.size(); start += size) {
            int end = Math.min(start + size, students.size());
            System.out.println(size);
            List<Student> sublist = students.subList(start, end);
            System.out.println(sublist);
        }
    }

    @Override
    public String toString() {
        return "JavaStudentGroup{" +
                "group=" + group +
                '}';
    }
}
