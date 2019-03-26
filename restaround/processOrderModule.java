package restaround;
import com.google.inject.AbstractModule;
import com.google.inject.name.Names;

public class processOrderModule extends AbstractModule{
    @Override
    protected void configure(){
       bind(RegisterCustomer.class).to(RegisterCustomerImpl.class);
        
    }
}
