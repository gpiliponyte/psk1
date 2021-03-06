package lt.vu.usecases.interceptors;

import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import java.io.Serializable;

@CustomInterceptor
@Interceptor // both pof these means kad cia implementacija
public class CustomInterceptorImplementation implements Serializable {
    @AroundInvoke
    public Object intercept(InvocationContext ctx) throws Exception {
        System.out.println("Interceptor called");
        Object result = ctx.proceed();
        return result;
    }
}
