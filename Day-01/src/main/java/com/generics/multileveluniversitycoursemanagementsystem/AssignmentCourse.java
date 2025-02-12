package com.generics.multileveluniversitycoursemanagementsystem;

public class AssignmentCourse extends CourseType {
    public AssignmentCourse(String courseName) {
        super(courseName);
    }

    @Override
    public void evaluate() {
        System.out.println(getCourseName() + " is evaluated based on assignments.");
    }
}