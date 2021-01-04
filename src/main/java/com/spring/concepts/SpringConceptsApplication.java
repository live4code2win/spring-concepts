package com.spring.concepts;

import javax.sound.midi.Soundbank;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.concepts.com.Department;
import com.spring.concepts.com.Employee;

@SpringBootApplication
//@ImportResource({"classpath:spring.xml", "classpath:spring1.xml"})
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
public class SpringConceptsApplication {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		ApplicationContext context1 = new ClassPathXmlApplicationContext("spring1.xml");
		Employee emp_1 = (Employee) context.getBean("employee");
		Employee emp_12 = (Employee) context.getBean("employee");
		Employee emp_2 = (Employee) context1.getBean("employee1");
		Department dept = (Department) context.getBean("dept");
		System.out.println("Employee Object => "+emp_1+" hashcode => "+emp_1.hashCode()+" actual hashcode => "+System.identityHashCode(emp_1));
		System.out.println("Employee1 Object => "+emp_12+" hashcode1 => "+emp_12.hashCode()+" actual hashcode => "+System.identityHashCode(emp_12));
		System.out.println("Employee2 Object => "+emp_2+" hashcode1 => "+emp_2.hashCode()+" actual hashcode => "+System.identityHashCode(emp_2));
		System.out.println("Department Object => "+dept);
		
		ConfigurableApplicationContext cac = SpringApplication.run(SpringConceptsApplication.class, args);
		
		cac.addApplicationListener(new ApplicationListener<ContextClosedEvent>() {
			@Override
			public void onApplicationEvent(ContextClosedEvent event) {
				System.out.println("closing the Spring Boot contex...");
				((AbstractApplicationContext)context).registerShutdownHook();
				((AbstractApplicationContext)context1).registerShutdownHook();
			}
		});
		System.out.println("Spring Boot App is about to shutdown in next 10 sec.");
		
		for (int i = 0; i < 10; i++) {
			try {
				Thread.sleep(1000);
				System.out.println("[ "+(10-i)+"] sec remaining...");
			} catch (Exception e) {
				System.out.println("Somethig went wrong => "+e.getMessage());
			}
		}
		cac.close();
	}

}
