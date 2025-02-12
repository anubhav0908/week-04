package com.generics.multileveluniversitycoursemanagementsystem;

public class ResearchCourse extends CourseType {
    public ResearchCourse(String courseName) {
        super(courseName);
    }

    @Override
    public void evaluate() {
        System.out.println(getCourseName() + " is evaluated based on research work.");
    }
}