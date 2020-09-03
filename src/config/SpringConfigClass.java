package config;

import javax.servlet.Filter;
import javax.servlet.FilterRegistration;
import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
import javax.servlet.ServletRegistration.Dynamic;

import org.apache.tomcat.jni.File;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/*
 * public class SpringConfigClass implements WebApplicationInitializer{ //
 * web.xml 역할임
 * 
 * @Override public void onStartup(ServletContext servletContext) throws
 * ServletException { // Spring MVC 프로젝트 설정을 위해 작성하는 클래스의 객체를 생성한다.
 * AnnotationConfigApplicationContext servletAppContext = new
 * AnnotationConfigApplicationContext();
 * servletAppContext.register(ServletAppContext.class);
 * 
 * // 요청 방생 시 요청을 처리하는 서블릿을 dispatcherServlet으로 설정해준 DispatcherServlet
 * dispatcherServlet= new DispatcherServlet((WebApplicationContext)
 * servletAppContext); ServletRegistration.Dynamic
 * servlet=servletContext.addServlet("dispatcher", dispatcherServlet);
 * 
 * // 부가설정 servlet.setLoadOnStartup(1); servlet.addMapping("/");
 * 
 * // Bean을 정의하는 클래스를 지정 AnnotationConfigApplicationContext rootAppContext= new
 * AnnotationConfigApplicationContext();
 * rootAppContext.register(RootAppContext.class);
 * 
 * // 리스너 설정 ContextLoaderListener listener=new
 * ContextLoaderListener((WebApplicationContext) rootAppContext);
 * servletContext.addListener(listener);
 * 
 * // 파라미터 인코딩 설정 FilterRegistration.Dynamic
 * filter=servletContext.addFilter("encodingFilter",
 * CharacterEncodingFilter.class); filter.setInitParameter("encoding", "UTF-8");
 * filter.addMappingForServletNames(null, false, "dispatcher"); }
 * 
 * }
 */
public class SpringConfigClass extends AbstractAnnotationConfigDispatcherServletInitializer{
	// DispatcherServlet에 매핑할 요청 주소를 셋팅함
	@Override
	protected String[] getServletMappings() {
		// TODO Auto-generated method stub
		return new String[] {"/"};
	}
	
	// Spring MVC 프로젝트 설정을 위한 클래스를 지정한다.
	@Override
	protected Class<?>[] getServletConfigClasses() {
		// TODO Auto-generated method stub
		return new Class[] {ServletAppContext.class};
	}
	
	// 프로젝트에서 사용할 Bean들을 정의하기 위한 클래스를 지정한다.
	@Override
	protected Class<?>[] getRootConfigClasses() {
		// TODO Auto-generated method stub
		return new Class[] {RootAppContext.class};
	}
	
	// 파라미터 인코딩 필터 설정
	@Override
	protected Filter[] getServletFilters() {
		CharacterEncodingFilter encodingFilter= new CharacterEncodingFilter();
		encodingFilter.setEncoding("UTF-8");
		return new Filter[] {encodingFilter};
	}
	
	@Override
	protected void customizeRegistration(Dynamic registration) {
		// TODO Auto-generated method stub
		super.customizeRegistration(registration);
																		//50메가~500메가
		MultipartConfigElement config1=new MultipartConfigElement(null,52428800,524288000,0);
		registration.setMultipartConfig(config1);
	}
}
