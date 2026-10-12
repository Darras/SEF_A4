package course;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;




// C5
public class CourseTest {
  
  @Test
  void TestPointsCannotExceed50(){

    Course course = new Course();

    boolean result = course.createNewAssessment("assignment one",  "a valid description", 51, "pdf", false, "", "01/11/2026 09:00", "10/11/2026 23:59", "11/11/2026 23:59");

    assertFalse(result);
  }
}
