package restaround;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class notifierInterceptor implements MethodInterceptor {
   @Override
  public Object invoke(MethodInvocation invocation) throws Throwable {
      
      //need guice
      notifier registrationMsg =  new notifierImpl();
      Customer client =  new CustomerImpl();
      
      Object methodCall = invocation.proceed();
      
      registrationMsg.registrationMessage(client);
    
      return methodCall;
  }
}
