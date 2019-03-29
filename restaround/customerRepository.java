
package restaround;

import java.io.IOException;

public interface customerRepository {
  public void addCustomer(String name) throws IOException;
  public int noOfcustomers();
  public void SetnoOfcustomers(int noOfcustomers);
}
