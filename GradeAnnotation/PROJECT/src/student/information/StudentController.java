package student.information;

import java.io.File;
import java.io.IOException;
import com.fasterxml.jackson.databind.ObjectMapper;

/* this consider like a database for the student information which create file for each student 
,update and retrieve the student information*/
public class StudentController {
	private static final ObjectMapper mapper = new ObjectMapper();
	public File getStudentFile(String StudentNumber, String Operation) {
		String fileName = StudentNumber + Operation;
    	final String BASE_DIR = System.getProperty("user.home") + "/Grades";
    	//to create file for each student 
        File file = new File(BASE_DIR +  "/" + fileName + ".json");
        if (!file.getParentFile().exists()) {
            file.getParentFile().mkdirs();
        }
        return file;
    }
	
	
	public void updateStudent(Student student) {
		try {
			// convert the user object to JSON format
            mapper.writeValue(getStudentFile(student.getStudentNumber(), student.getOperation()), student);
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
}
