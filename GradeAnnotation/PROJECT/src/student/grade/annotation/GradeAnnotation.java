package student.grade.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.annotation.ElementType;

//@Retention. This annotation marks our annotation to be retained by JVM at runtime.
//This will allow us to use Java reflections

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface GradeAnnotation {
	String operation();
}
