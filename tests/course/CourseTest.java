package course;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;



public class CourseTest {


  //TEST CASES 1-4
  //TEST CASES 1-4

//Test case to check that assessment names must be unique
@Test
void testAssessmentNameMustBeUnique() {

    //Create a new course object
    Course course = new Course();

    //Create the first assessment
    boolean firstResult = course.createNewAssessment(
        "assignment one",
        "a valid description",
        10,
        "pdf",
        false,
        "",
        "01/11/2026 09:00",
        "10/11/2026 23:59",
        "11/11/2026 23:59"
    );

    //Precondition: the first assessment was created successfully
    assertTrue(firstResult);
    assertEquals(1, course.getAssessments().size());

    //Record the initial number of assessments
    int initialSize = course.getAssessments().size();

    //Try to create another assessment with the same name
    boolean result = course.createNewAssessment(
        "assignment one",
        "another valid description",
        10,
        "pdf",
        false,
        "",
        "01/12/2026 09:00",
        "10/12/2026 23:59",
        "11/12/2026 23:59"
    );

    //Assert that the duplicate assessment is rejected
    assertFalse(result);
    assertEquals(initialSize, course.getAssessments().size());
}

//Test case to check that the assessment name cannot be blank
@Test
void testAssessmentNameCannotBeBlank() {

    //Create a new course object
    Course course = new Course();

    //Record the initial number of assessments
    int initialSize = course.getAssessments().size();

    //Try to create an assessment with a blank name
    boolean result = course.createNewAssessment(
        "",
        "a valid description",
        10,
        "pdf",
        false,
        "",
        "01/11/2026 09:00",
        "10/11/2026 23:59",
        "11/11/2026 23:59"
    );

    //Assert that the assessment is rejected
    assertFalse(result);
    assertEquals(initialSize, course.getAssessments().size());
}



  //TEST CASES 5-8
  
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