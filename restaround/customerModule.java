package restaround;
import com.google.inject.AbstractModule;
import com.google.inject.name.Names;

public class customerModule extends AbstractModule{
    protected void configure(){
        bind(Customer.class).to(CustomerImpl.class);
    }
}
