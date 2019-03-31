package restaround;

import com.google.inject.AbstractModule;
import com.google.inject.name.Names;

public class processOrderModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(Customer.class).to(CustomerImpl.class);
        bind(int.class)
                .annotatedWith(Names.named("default quantity"))
                .toInstance(1);
    }
}
