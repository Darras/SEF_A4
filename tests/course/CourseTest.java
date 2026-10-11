package course;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class CourseTest {
  
  //test case to check if the assessment points cannot exceed 50
  @Test
  void testPointsCannotExceed50(){

    

    Course course = new Course();

    //record the initial size of the assessments list
    int initialSize = course.getAssessments().size();
    
    //precondition: ensure that the assessments list is not null
    assertNotNull(course.getAssessments());

    
    boolean result = course.createNewAssessment("assignment one",  "a valid description", 51, "pdf", false, "", "01/11/2026 09:00", "10/11/2026 23:59", "11/11/2026 23:59");

    assertFalse(result);
    assertEquals(initialSize, course.getAssessments().size());
  }

  //test case to check if the total assessment points for all assessments in a course cannot exceed 100
  @Test
  void testTotalPointsCannotExceed100(){

      //create a new course object
      Course course = new Course();

      Assessment assessment1 = new Assessment("assignment one",  "a valid description", 50, "pdf", false, "", "01/11/2026 09:00", "10/11/2026 23:59", "11/11/2026 23:59");
      Assessment assessment2 = new Assessment("assignment two",  "a valid description", 50, "pdf", false, "", "01/11/2026 09:00", "10/11/2026 23:59", "11/11/2026 23:59");
      
      //add the assessments to the course
      course.getAssessments().add(assessment1);
      course.getAssessments().add(assessment2);

      //Precondition: ensure that the total points of all assessments in the course is 100
      assertEquals(2, course.getAssessments().size());
      assertEquals(100, course.getTotalPoints());

      //record the initial size of the assessments list
      int initialSize = course.getAssessments().size();

      //Act: creating a new assessment that would exceed the total points limit of 100
      boolean result = course.createNewAssessment("assignment three",  "a valid description", 1, "pdf", false, "", "01/11/2026 09:00", "10/11/2026 23:59", "11/11/2026 23:59");

      assertFalse(result);
      assertEquals(initialSize, course.getAssessments().size());
      assertEquals(100, course.getTotalPoints());
  }

  //test to check if submission type is valid
  @Test
  void testSubmissionTypeIsValid(){
    
    //create a new course object
    Course course = new Course();

    //Pre-condition: assessments list exists
    assertNotNull(course.getAssessments());

    //record the initial size of the assessments list
    int initialSize = course.getAssessments().size();

    //creating a new assessment with invalid type
    boolean result = course.createNewAssessment("assignment one", "this is valid", 50, "txt", false, "", "01/11/2026 09:00", "10/11/2026 23:59",  "11/11/2026 23:59");

    //Assert
    assertFalse(result);
    assertEquals(initialSize, course.getAssessments().size());
  }

  //test to see if group name exists for a group
  @Test
  void testGroupNameValid(){

    //create a new course object
    Course course = new Course();

    //Pre-condition: assessments list exists
    assertNotNull(course.getAssessments());

    //record the initial size of the assessments list
    int initialSize = course.getAssessments().size();

    //creating a new assessment with no group name
    boolean result = course.createNewAssessment("assignment one", "this is valid", 50, "pdf", true, "", "01/11/2026 09:00", "10/11/2026 23:59", "11/11/2026 23:59");

    //Asserts
    assertFalse(result);
    assertEquals(initialSize, course.getAssessments().size());
  }
}