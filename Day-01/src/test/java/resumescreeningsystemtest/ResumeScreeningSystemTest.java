package resumescreeningsystemtest;

import com.generics.aidrivenresumescreeningsystem.*;
import org.junit.Test;
import static org.junit.Assert.*;

import java.util.*;

public class ResumeScreeningSystemTest {

    @Test
    public void testSoftwareEngineerEligibility() {
        SoftwareEngineer engineer = new SoftwareEngineer("Furqan", 3);
        assertTrue("Engineer should be eligible with 3 years of experience", engineer.isEligible());

        SoftwareEngineer engineerUnderqualified = new SoftwareEngineer("Furqan", 1);
        assertFalse("Engineer should not be eligible with 1 year of experience", engineerUnderqualified.isEligible());
    }

    @Test
    public void testDataScientistEligibility() {
        DataScientist scientist = new DataScientist("Anubhav", 3);
        assertTrue("Scientist should be eligible with 3 years of experience", scientist.isEligible());

        DataScientist scientistUnderqualified = new DataScientist("Anubhav", 2);
        assertFalse("Scientist should not be eligible with 2 years of experience", scientistUnderqualified.isEligible());
    }

    @Test
    public void testProductManagerEligibility() {
        ProductManager manager = new ProductManager("Deepansh", 6);
        assertTrue("Manager should be eligible with 6 years of experience", manager.isEligible());

        ProductManager managerUnderqualified = new ProductManager("Deepansh", 4);
        assertFalse("Manager should not be eligible with 4 years of experience", managerUnderqualified.isEligible());
    }

    @Test
    public void testScreeningPipeline() {
        // Create a list of job roles
        List<JobRole> applicants = new ArrayList<>();
        applicants.add(new SoftwareEngineer("Furqan", 3));
        applicants.add(new DataScientist("Anubhav", 2));
        applicants.add(new ProductManager("Deepansh", 6));

        // Create a custom StringBuilder to capture output during the screening
        final StringBuilder output = new StringBuilder();
        System.setOut(new java.io.PrintStream(new java.io.OutputStream() {
            @Override
            public void write(int b) {
                output.append((char) b);
            }
        }));

        // Process resumes through the Screening Pipeline
        ScreeningPipeline.processResumes(applicants);

        // Validate the output for the screening process
        assertTrue(output.toString().contains("Screening: Furqan"));
        assertTrue(output.toString().contains("Eligibility: Accepted")); // For SoftwareEngineer
        assertTrue(output.toString().contains("Screening: Anubhav"));
        assertTrue(output.toString().contains("Eligibility: Rejected")); // For DataScientist
        assertTrue(output.toString().contains("Screening: Deepansh"));
        assertTrue(output.toString().contains("Eligibility: Accepted")); // For ProductManager
    }
}
