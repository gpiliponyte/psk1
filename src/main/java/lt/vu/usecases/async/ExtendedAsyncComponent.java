package lt.vu.usecases.async;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Specializes;

@ApplicationScoped
@Specializes // Indicates that a bean directly specializes another bean. May be applied to a bean class or producer method.
public class ExtendedAsyncComponent extends AsyncComponent implements AsyncInterface {
}
