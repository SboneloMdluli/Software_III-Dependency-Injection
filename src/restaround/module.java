/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaround;

import com.google.inject.AbstractModule;
import com.google.inject.matcher.Matchers;
import com.google.inject.name.Names;

/**
 *
 * @author mylaptop
 */
public class module extends AbstractModule {
    @Override
    protected void configure() {
        //binding to implemenentation
        bind(Menu.class).to(MenuImpl.class);

        bind(Chef.class).to(chefImpl.class);

        bind(processOrder.class).to(processOrderImpl.class);

        //intanceBinding
        bind(int.class)
                .annotatedWith(Names.named("default quantity"))
                .toInstance(1);
        
        bind(int.class)
                .annotatedWith(Names.named("capacity"))
                .toInstance(10);

        // use providers
        bind(customerDatabase.class).toProvider(customerRepositoryProvider.class);

        //AOP binding
        bindInterceptor(Matchers.any(), Matchers.annotatedWith(notification.class),
                new notifierInterceptor());
    }
}
