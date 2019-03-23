/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaround;

/**
 *
 * @author mylaptop
 */
public interface RegisterCustomer {

        public void registrationForm(final String firstName, final String lastName, final String email, final double accNum, double balance);
        public void login(final String firstName, final String lastName);
        public void confirmationMessage();
        public void placeOrder(String item);
}