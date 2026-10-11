
package course;
import java.util.List;

class Assessment {
private String name;
private String description;
private int points;
private String submissionType;
private boolean group;
private String groupingName;
private String publishDateTime;
private String dueDateTime;
private String hideDateTime;

public Assessment(String name, String description, int points,
String submissionType, boolean group, String groupingName,
String publishDateTime, String dueDateTime, String
hideDateTime) {
//TODO: initilise all the attributes
this.name = name;

this.description = description;

this.points = points;

this.submissionType = submissionType;

this.group = group;

this.groupingName = groupingName;

this.publishDateTime = publishDateTime;

this.dueDateTime = dueDateTime;

this.hideDateTime = hideDateTime;
}

//getter for point attribute
public int getPoints() {
    return points;
}
}

public class Course {

private List<Assessment> assessments = new java.util.ArrayList<>();

//method to get the list of assessments
public List<Assessment> getAssessments() {
        return assessments;
    }
//method to get total points of all assessments
public int getTotalPoints() {
    int totalPoints = 0;
    for (Assessment assessment : assessments){
        totalPoints += assessment.getPoints();
    }
    return totalPoints;
}

public boolean createNewAssessment(String name, String description, int points,
String submissionType, boolean group, String
groupingName,
String publishDateTime, String dueDateTime,
String hideDateTime) {
boolean valid = true;
//TODO: Validate all the provided parameters.
//if the assessment parameters meet the given conditions,
// the function should create a new Assessment object,
// add it in the assessments list and then return true.
//else
// the function should only return false.

//implementation of condition-5
  if (points > 50){

    valid = false;
  }

//implementation of condition-6
  if (getTotalPoints() + points > 100){

    valid = false;
  }

  

  
return valid;

}
}

