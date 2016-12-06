package student.information;
import server.gradeAnnotationresult.*;
import java.util.Arrays;

public class DatabaseController {
	public DatabaseController( String name, String number , String operation, boolean codeCorrection, int[] expectedArrayResult, int [] arrayResult){
		String correction;
		if(!codeCorrection)
			correction ="False";
		else
			correction = "True";
		Student student = new Student();
		student.setStudentName(name);
		student.setStudentNumber(number);
		student.setOperation(operation);
		student.setCodeCorrection(correction);
		student.setExpectedResult(Arrays.toString(expectedArrayResult));
		student.setResult(Arrays.toString(arrayResult));
		StudentController studentcontroller = new StudentController();
		studentcontroller.updateStudent(student);
	}
	
public DatabaseController( String name, String number , String operation, int result, int expectedResult, boolean codeCorrection) throws Exception{
	String correction;
	if(!codeCorrection)
		correction ="False";
	else
		correction = "True";
		Student student = new Student();
		student.setStudentName(name);
		student.setStudentNumber(number);
		student.setOperation(operation);
		student.setExpectedResult(Integer.toString(expectedResult));
		student.setResult(Integer.toString(result));
		student.setCodeCorrection(correction);
		StudentController studentcontroller = new StudentController();
		studentcontroller.updateStudent(student);
		Springserver.Start();
	}

}
