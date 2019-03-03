package com;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import com.beans.ComposedBean;
import com.beans.PrototypeBean;
import com.beans.SingletonBean;
import com.beans.SingletonLazyBean;
import com.beans.lombok.LombokBeanA;
import com.repo.DAO;

@Configuration
@EnableAspectJAutoProxy
@ComponentScan({"com.beans","com.conf","com.repo","com.intercept","com.aop"})
public class Application {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx=new AnnotationConfigApplicationContext(Application.class);
		PrototypeBean b1=ctx.getBean(PrototypeBean.class);                 //by primary
		PrototypeBean b2=ctx.getBean("prototypeBean",PrototypeBean.class); //by qualifier
		SingletonBean b3=ctx.getBean(SingletonBean.class);
		SingletonBean b4=ctx.getBean(SingletonBean.class);
		PrototypeBean b5=ctx.getBean("proto6",PrototypeBean.class);        
		ComposedBean b6=ctx.getBean(ComposedBean.class);
		
		System.out.println("Proto 1, x="+b1.x);
		System.out.println("Proto 2, x="+b2.x);
		System.out.println("Single 1, x="+b3.x);
		System.out.println("Single 2, x="+b4.x);
		System.out.println("Proto6, x="+b5.x);
		b6.show();
		b6.show();
		System.out.println("composed.getProto, x="+b6.getProtoX());
		System.out.println("composed.getSingle, x="+b6.getSingleX());
		
		SingletonLazyBean lazy=ctx.getBean(SingletonLazyBean.class);
		
		LombokBeanA lombok=ctx.getBean(LombokBeanA.class);
		
		
//		DAO dao= ctx.getBean(DAO.class);
//		System.out.println("Person count from MySQL: "+dao.count());
		ctx.registerShutdownHook();	
		ctx.close();
	}
	
}
