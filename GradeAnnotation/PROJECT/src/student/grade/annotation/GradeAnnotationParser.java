package student.grade.annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Random;
import student.information.DatabaseController;

public class GradeAnnotationParser {
	//to sort the array to compare it with the returned output
    public  int[] Sort(int [] array  ){
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
        }
        return array;
    }
	public GradeAnnotationParser(Class<?> testing, String studentName,
    		String studentNumber) throws Exception {
    	
    	Constructor<?> constructor = testing.getConstructor();
    	//get all methods from the class
        Method[] methods = testing.getDeclaredMethods();
        Random r = new Random();
        
        for( Method method : methods){
        	boolean Checkresult = false;
        	//check the function annotated by grade
        	if(method.isAnnotationPresent(GradeAnnotation.class)){
        		GradeAnnotation grade = method.getAnnotation(GradeAnnotation.class);
        		String operation = grade.operation();
        		//to sort the array to compare it with student result
        		if("Sorting".equals(operation)){
        			int [] array = new int[10];
			        int [] temp = new int [10];
			        for (int i = 0; i < array.length; i++) {
			            array[i] = r.nextInt()%20;
			        }
    				temp = array.clone();
    				//invoke the sort function to test it
					method.invoke(constructor.newInstance(), array);
					Sort(temp);
					//compare between correct sort and student sort
					if( Arrays.equals(array, temp))
						Checkresult = true;
					new DatabaseController(studentName, studentNumber, operation, Checkresult, temp, array );
        			
				//to check the add function
        		} else if("Addtion".equals(operation)){
        			int x = 25, y =20;
        			// invoke the add function to test it
        			Object result = method.invoke(constructor.newInstance(), x, y);
        			int addResult = (Integer) result;
        			int j = x + y;
        			if(addResult == j)
        				Checkresult = true;
        			System.out.print(method.getName() + "	" + Checkresult + "		Expected result		"+ j + "		the result 		" + addResult +"\n");
        			new DatabaseController(studentName, studentNumber, operation, addResult, j, Checkresult );
        			
        		}else if("sub".equals(operation)){
        			int x = 25, y =100;
        			// invoke the sub function to test it
        			Object result = method.invoke(constructor.newInstance(), x, y);
        			int addResult = (Integer) result;
        			int j = x - y;
        			if(addResult == j)
        				Checkresult = true;
        			System.out.print(method.getName() + "	" + Checkresult + "		Expected result		"+ j + "		the result 		" + addResult +"\n");
        			new DatabaseController(studentName, studentNumber, operation, addResult, j, Checkresult );
        	}
        }
    }
    }
	
}
