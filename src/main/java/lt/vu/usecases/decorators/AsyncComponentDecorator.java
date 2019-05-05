package lt.vu.usecases.decorators;

import lt.vu.usecases.async.AsyncComponent;
import lt.vu.usecases.async.AsyncInterface;

import javax.decorator.Decorator;
import javax.decorator.Delegate;
import javax.enterprise.inject.Any;
import javax.inject.Inject;
import java.util.concurrent.Future;


@Decorator // kad bus decoratorius
public class AsyncComponentDecorator implements AsyncInterface {

    @Inject // kad beana injectini
    @Delegate // deleguoji visam darbui sian komponente
    @Any // gali bet koki bean injectinti
    private AsyncComponent asyncComponent;

    public Future<String> asyncMethod() {
        System.out.println("Decorator before asyncMethod");
        return asyncComponent.asyncMethod();
    }
}