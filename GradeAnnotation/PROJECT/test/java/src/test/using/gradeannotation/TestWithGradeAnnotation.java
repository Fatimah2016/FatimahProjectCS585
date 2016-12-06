package test.using.gradeannotation;

import student.grade.annotation.*;

public class TestWithGradeAnnotation {
	
	public static void  main(String[] args) throws Exception {
		// the student should include their name, their student number
		// and their class that include annotation GradeAnnotation
		String studentName= "Fatimah";
		String studentNumber = "4546";
		new GradeAnnotationParser(TestWithGradeAnnotation.class, studentName, studentNumber);

	}
	//annotation work with either Add or Sort function  
		@GradeAnnotation(operation = "Addtion")
		public int add(int x , int y){
			return x+y;
		}
		// the class parser will check the result of sort
		@GradeAnnotation(operation = "Sorting") 
		public int[] sort(int [] array  ){
			function(array);
	           return array;
	    }
		//annotation work with either Add or Sort function 
		@GradeAnnotation(operation = "sub")
			public int sub(int x , int y){
				return x+y;
			}
		
		public int[] function(int [] array  ){
			int n = array.length;
	        int k;
	        for (int m = n; m >= 0; m--) {
	            for (int i = 0; i < n - 1; i++) {
	                k = i + 1;
	                if (array[i] > array[k]) {
	                	int temp;
	                    temp = array[i];
	                    array[i] = array[k];
	                    array[k] = temp;
	                }
	            }
	        }        return array;
	    }
}
