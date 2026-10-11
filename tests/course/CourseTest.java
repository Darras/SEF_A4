package course;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class CourseTest {
  
  //test case to check if the assessment points cannot exceed 50
  @Test
  void TestPointsCannotExceed50(){

    

    Course course = new Course();

    //record the initial size of the assessments list
    int initialSize = course.getAssessments().size();
    
    //precondition: ensure that the assessments list is not null
    assertNotNull(course.getAssessments());

    
    boolean result = course.createNewAssessment("assignment one",  "a valid description", 51, "pdf", false, "", "01/11/2026 09:00", "10/11/2026 23:59", "11/11/2026 23:59");

    assertFalse(result);
    assertEquals(initialSize, course.getAssessments().size());
  }
  
  //

}
