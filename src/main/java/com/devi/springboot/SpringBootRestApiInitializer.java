package com.devi.springboot;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class SpringBootRestApiInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
	 
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[] { SpringBootRestApiApp.class };
    }
  
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return null; //new Class[] {SpringBootRestApiApp.class};
    }
  
    @Override
    protected String[] getServletMappings() {
        return new String[] { "/" };
    }
 
}
