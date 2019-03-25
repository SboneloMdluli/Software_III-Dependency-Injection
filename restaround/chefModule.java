package restaround;
import com.google.inject.AbstractModule;

// binding module
class chefModule extends AbstractModule{
    @Override
    protected void configure(){
        bind(Menu.class).to(MenuImpl.class);
    }
}