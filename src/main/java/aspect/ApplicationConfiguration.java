package aspect;

import org.apache.logging.log4j.Logger;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.LoggerFactory;
import org.springframework.aop.Advisor;
import org.springframework.aop.aspectj.AspectJExpressionPointcut;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import serviceInterface.UserEditService;

@Configuration
@EnableAspectJAutoProxy
@Aspect
public class ApplicationConfiguration {

	private static final Logger LOGGER = (Logger) LoggerFactory.getLogger(UserEditService.class);

	@Pointcut("execution(*com.serviceImpl.UserEditServiceImpl.editUser*")
	public void myMonitor() {
	}

	@Bean
	public MyPerformanceMonitorInterceptor myPerformanceMonitorInterceptor() {
		return new MyPerformanceMonitorInterceptor(true);
	}

	@Bean
	public Advisor myPerformanceMonitorAdvisor() {
		AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut();
		pointcut.setExpression("com.serviceImpl.UserEditServiceImpl.myMonitor()");
		return new DefaultPointcutAdvisor(pointcut, myPerformanceMonitorInterceptor());
	}
}
