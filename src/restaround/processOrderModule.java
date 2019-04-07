package restaround;

import com.google.inject.AbstractModule;
import com.google.inject.name.Names;

public class processOrderModule extends AbstractModule {

    @Override
    protected void configure() {
        //normal binding
        
        
        bind(Menu.class).to(MenuImpl.class);
        
        bind(Customer.class).to(CustomerImpl.class);
        
        bind(chef.class).to(chefImpl.class);
        
        bind(processOrder.class).to(processOrderImpl.class);
        
        //constant primitive wrapper
        bind(int.class)
                .annotatedWith(Names.named("default quantity"))
                .toInstance(1);
        // use providers
        bind(customerRepository.class).toProvider(customerRepositoryProvider.class);
        
        //AOP binding
        
         // bindInterceptor(Matchers.any(), Matchers.annotatedWith(notification.class), 
   //     new notifierInterceptor());
    }
}
