package restaround;

import com.google.inject.Inject;
import com.google.inject.name.Named;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class customerDatabaseImpl implements customerDatabase {
    
    static int noOfcustomers;
    private int capacity;
    
    @Override
    public int noOfcustomers() {
        return noOfcustomers;
    }

    @Override
    public void SetnoOfcustomers(int noOfcustomers) {
        this.noOfcustomers = noOfcustomers;
    }
    
    @Inject
    public void setCapacity(@Named("default quantity") int capacity){
        this.capacity = capacity;
    }

    @Inject
    @Override
    public void addCustomer(String name) throws IOException {
       
        FileWriter database = new FileWriter("customerDatabase.txt", true);
        BufferedWriter bw = new BufferedWriter(database);

        if (noOfcustomers() < capacity) {

            bw.write(name);
            bw.newLine();
            bw.close();
            noOfcustomers++;

        } else {
            //connect to new database
            FileWriter newDtabase = new FileWriter("newDatabase.txt", true);
            BufferedWriter newDB = new BufferedWriter(newDtabase);

            newDB.write(name);
            newDB.newLine();
            newDB.close();
            noOfcustomers++;
        }

    }
}
