package restaround;
import com.google.inject.AbstractModule;

public class customerModule extends AbstractModule{
    protected void configure(){
        bind(RegisterCustomer.class).to(RegisterCustomerImpl.class);
    }
}
