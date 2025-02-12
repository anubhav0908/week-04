package universitycoursemanagementtest;

import com.generics.multileveluniversitycoursemanagementsystem.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.util.List;
import java.util.ArrayList;

public class UniversityCourseManagementTest {

    private List<CourseType> courses;

    @Before
    public void setUp() {
        // Setting up courses before each test
        courses = new ArrayList<>();
        courses.add(new ExamCourse("Mathematics"));
        courses.add(new AssignmentCourse("History"));
        courses.add(new ResearchCourse("Physics"));
    }

    @Test
    public void testCourseEvaluation() {
        // Check that each course is evaluated based on its type
        Course<ExamCourse> mathCourse = new Course<>(new ExamCourse("Advanced Calculus"));
        mathCourse.conductEvaluation();

        Course<AssignmentCourse> historyCourse = new Course<>(new AssignmentCourse("World History"));
        historyCourse.conductEvaluation();

        Course<ResearchCourse> physicsCourse = new Course<>(new ResearchCourse("Quantum Mechanics"));
        physicsCourse.conductEvaluation();

        // This test checks if the courses are created successfully, and we manually verify outputs
    }

    @Test
    public void testUniversityManageCourses() {
        // Verify if the University can manage and evaluate a list of courses
        University.manageCourses(courses);

        // No direct assertion for print output. The test verifies that it doesn't throw any exceptions.
    }

    @Test
    public void testCourseCreation() {
        // Verifying the creation of different types of courses
        Course<ExamCourse> examCourse = new Course<>(new ExamCourse("Advanced Algebra"));
        Assert.assertEquals("Advanced Algebra", examCourse.getCourse().getCourseName());

        Course<AssignmentCourse> assignmentCourse = new Course<>(new AssignmentCourse("Philosophy"));
        Assert.assertEquals("Philosophy", assignmentCourse.getCourse().getCourseName());

        Course<ResearchCourse> researchCourse = new Course<>(new ResearchCourse("Artificial Intelligence"));
        Assert.assertEquals("Artificial Intelligence", researchCourse.getCourse().getCourseName());
    }

    @Test
    public void testConductEvaluationForAllCourses() {
        // Verify that evaluation is being conducted for each course type
        Course<ExamCourse> examCourse = new Course<>(new ExamCourse("Calculus"));
        Course<AssignmentCourse> assignmentCourse = new Course<>(new AssignmentCourse("Literature"));
        Course<ResearchCourse> researchCourse = new Course<>(new ResearchCourse("Astrophysics"));

        examCourse.conductEvaluation();
        assignmentCourse.conductEvaluation();
        researchCourse.conductEvaluation();

        // This is a manual verification test; you would check the console to ensure that the right evaluations are printed.
    }
}
