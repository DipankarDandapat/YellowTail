package GenericLab;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;

public class AnnotationTransformer implements IAnnotationTransformer {

	@Override
    public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {
        annotation.setRetryAnalyzer(RetryAnalyzerHelper.class);
    }
	
	
	

	
// This listeners class we need to import in our TestNG xml file
/*<listeners>
    <listener class-name="GenericLab.AnnotationTransformer"/>
</listeners>*/
	
}