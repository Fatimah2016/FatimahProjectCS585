package server.gradeAnnotationresult;

import java.util.List;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import com.fasterxml.jackson.databind.ObjectMapper;

import student.information.Student;

@RestController
public class StudentController {

@RequestMapping(value = "/result", method = RequestMethod.GET)
	
	ModelAndView  getStudentGrade() {
		ObjectMapper mapper = new ObjectMapper();
    	final String BASE_DIR = System.getProperty("user.home") + "/Grades";
    	File folder = new File(BASE_DIR);
    	File[] listOfFiles = folder.listFiles();
    	List<Student> student = new ArrayList<Student>();
    	// read all files in grades folder
    	for (File file : listOfFiles) {
    	    if (file.isFile()) {
				try {
					
					student.add(mapper.readValue(file, Student.class));
					
				} catch (IOException e) {

					e.printStackTrace();
				}
				
               
    	    }
    	}
    	
    	//create model view to display the result locally
    	ModelAndView model = new ModelAndView("result");
    	model.addObject("result", student);

    	return model;
 
    }
    /*********** Web UI Test Utility **********/
    /**
     * This method provide a simple web UI for you to test the different 
     * functionalities used in this web service. 
     */
    @RequestMapping(value = "/result", method = RequestMethod.GET)
    ModelAndView getUserHomepage(@PathVariable("Stduent") String userId) {
    	Student student = new Student();
    	
        ModelAndView modelAndView = new ModelAndView("result");
        modelAndView.addObject("result", student.getStudentName());        

        return modelAndView;
    }	
    
}
