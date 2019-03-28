package restaround;
import com.google.inject.AbstractModule;
import com.google.inject.name.Names;

class menuModule extends AbstractModule{
    @Override
    protected void configure(){
        bind(Menu.class).to(MenuImpl.class);
           bind(int.class)
         .annotatedWith(Names.named("default quantity"))
         .toInstance(1);
    }
}