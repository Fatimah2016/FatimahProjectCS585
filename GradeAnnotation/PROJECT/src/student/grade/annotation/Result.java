package student.grade.annotation;

import student.information.Student;

public class Result {
public Result( Student student){
		
	}
	String studentName;
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public String getStudentNumber() {
		return StudentNumber;
	}
	public void setStudentNumber(String studentNumber) {
		StudentNumber = studentNumber;
	}
	public boolean isCorrect() {
		return isCorrect;
	}
	public void setCorrect(boolean isCorrect) {
		this.isCorrect = isCorrect;
	}
	public String getExpectedresult() {
		return expectedresult;
	}
	public void setExpectedresult(String expectedresult) {
		this.expectedresult = expectedresult;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	String StudentNumber;
	boolean isCorrect;
	String expectedresult;
	String result;
	
}

