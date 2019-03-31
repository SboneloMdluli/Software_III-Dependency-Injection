package restaround;

import com.google.inject.AbstractModule;

public class databaseModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(customerRepository.class).toProvider(customerRepositoryProvider.class);
    }
}
