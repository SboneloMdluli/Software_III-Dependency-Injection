package restaround;

import com.google.inject.Inject;
import com.google.inject.Provider;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

class CustomerImpl implements Customer {

    static private String firstName;
    static private String lastName;
    static private String email;
    static private double accNum;
    static private double balance;
    
    private Chef customerMenu; 
    private processOrder order; 
    private customerDatabase customerDatabase;
    
    @Inject
    private Provider<customerDatabase> database; 
 
        public customerDatabase getConnection(){
        return database.get();
    }   
    
    @Inject
    public void setMenu(Chef customerMenu) {
        this.customerMenu = customerMenu;
    } 
    
    @Inject
    public void setOrder(processOrder order) {
        this.order = order;
    } 
    
     @Inject
    public void setDatabase(customerDatabase customerDatabase) {
        this.customerDatabase = customerDatabase;
    } 

    @Override
    @notification // send confirmation message
    public void registrationForm(final String firstName, final String lastName, final String email, final double accNum, double balance) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.accNum = accNum;
        try {
            setBalance(balance);

        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
        }

        // store customer in database
        try {
            
            //get the database the customer is connected to
            System.out.println("Connecting to "+getConnection()); 
            customerDatabase.addCustomer(getName());
        } catch (IOException ex) {
            Logger.getLogger(CustomerImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void setBalance(double balance) {
        if (balance < 0) {
            throw new IllegalArgumentException("negative balance");
        } else {
            this.balance = balance;
        }
    }

    @Override
    public void placeOrder(String item, int quantity) {
       
        if (quantity < 0) {
            throw new IllegalArgumentException("negative quantity");
        } else {
            order.Bill(item, quantity);
            System.out.println("Ordered: " + quantity +" "+ item+"'s");
        }
        
    }

    @Override
    public void updateBalance(double itemPrice) {
        balance = balance - itemPrice;
        setBalance(balance);
    }

    @Override
    public double getAccNumber() {
        return accNum;
    }

    @Override
    public double getBalance() {
        return balance;
    }

    @Override
    public String getEmail() {
        return email;
    }

    @Override
    public void login(final String firstName, final String lastName) {
        
        try {
            //the chefImpl removes the meal as the restraunt ran out of ingredients
            customerMenu.removeMeal("Chidori");
      
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
        }

        // hand printed menu to customer
        customerMenu.getMenu();
    }

    @Override
    public String getName() {
        return (firstName + " " + lastName);
    }

  
}
