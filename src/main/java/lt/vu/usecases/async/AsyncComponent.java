package lt.vu.usecases.async;

import org.apache.deltaspike.core.api.future.Futureable;

import javax.ejb.AsyncResult;
import javax.enterprise.context.ApplicationScoped;
import java.io.Serializable;
import java.util.concurrent.Future;

@ApplicationScoped
public class AsyncComponent implements AsyncInterface, Serializable {

    @Futureable
    public Future<String> asyncMethod() {
        System.out.println("Just working on a large task");
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            System.out.println("Oh no, an exception occurred");
        }
        System.out.println("Large task complete");
        return new AsyncResult<>("BIG result");
    }
}