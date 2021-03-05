package com.qa.listeners;



import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;

import utility.RetryLogic;

public class AnotationTransformer implements IAnnotationTransformer{

	@Override
	public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {
		//annotation.setDataProvider("Multiple login");
		annotation.setRetryAnalyzer(RetryLogic.class);
		
		
	}

	
	
}
