package in.ineuron.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TransactionManagement {
	
	@Pointcut("execution(public * in.ineuron.dao.EmployeeDao.*())")
	public void p1() {
		//System.out.println("Hey I'm inside p1()..");
	}
	
//	@Around("p1()")
//	public int aroundAdvice(ProceedingJoinPoint jp) {
//		System.out.println("Before Transaction");
//		try {
//			Object obj=jp.proceed();
//			System.out.println("Data is::"+obj);
//			return (int)obj;
//		} catch (Throwable e) {
//			e.printStackTrace();
//		}
//		System.out.println("After Transaction");
//		return 0;
//	}
	
	@Before("p1()")
	public void beginTransaction() {
		System.out.println("Transaction Started...");
	}
//	
	@AfterReturning(value="p1()",returning="obj")
	public void commitTransaction(Object obj) {
		System.out.println("Transaction Committed...");
		System.out.println("Data is::"+obj);
	}
//	
//	@AfterThrowing(value="p1()",throwing="obj")
//	public void rollBack(Throwable obj) {
//		System.out.println("Transaction Rollback..."+obj.getMessage());
//	}
	@After("p1()")
	public void emailSetupCredentials() {
		System.out.println("Email setup is done...");
	}
	

}
