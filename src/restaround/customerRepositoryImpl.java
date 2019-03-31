package restaround;

import com.google.inject.Inject;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class customerRepositoryImpl implements customerRepository {

    static int noOfcustomers;

    @Override
    public int noOfcustomers() {
        return noOfcustomers;
    }

    @Inject
    @Override
    public void SetnoOfcustomers(int noOfcustomers) {
        this.noOfcustomers = noOfcustomers;
    }

    @Inject
    @Override
    public void addCustomer(String name) throws IOException {
        final int capacity = 10;

        FileWriter database = new FileWriter("customerDatabase.txt", true);
        BufferedWriter bw = new BufferedWriter(database);

        if (noOfcustomers() < capacity) {

            bw.write(name);
            bw.newLine();
            bw.close();
            noOfcustomers++;

        } else {

            FileWriter newDtabase = new FileWriter("newDatabase.txt", true);
            BufferedWriter newDB = new BufferedWriter(newDtabase);

            newDB.write(name);
            newDB.newLine();
            newDB.close();

            noOfcustomers++;
        }

    }
}
