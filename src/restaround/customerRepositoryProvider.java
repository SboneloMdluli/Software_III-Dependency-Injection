package restaround;

import com.google.inject.Provider;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;

public class customerRepositoryProvider implements Provider<customerDatabase> {

    int noOfcustomers;

    @Override
    public customerDatabase get() {
        // get number of users currently registred
        try {
            FileReader database = new FileReader("customerDatabase.txt");
            LineNumberReader lineNumber = new LineNumberReader(database);

            while (lineNumber.readLine() != null) {
                noOfcustomers++;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        customerDatabase customerRepository = new customerDatabaseImpl();
        customerRepository.SetnoOfcustomers(noOfcustomers);
        return customerRepository;
    }

}
