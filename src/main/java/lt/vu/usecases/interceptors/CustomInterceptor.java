package lt.vu.usecases.interceptors;
import javax.interceptor.InterceptorBinding;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@InterceptorBinding //bus interceptorius
@Target({METHOD, TYPE}) // gali det ant metodo arba type class or interveise
@Retention(RUNTIME) //anotacija bus saugoma runtime
public @interface CustomInterceptor {
}
