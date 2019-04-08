package restaround;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class notifierInterceptor implements MethodInterceptor {

    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {

        Customer client = new CustomerImpl();
        notifier registrationMsg = new notifierImpl(client);
        
        Object methodCall = invocation.proceed();

        registrationMsg.registrationMessage();

        return methodCall;
    }
}
