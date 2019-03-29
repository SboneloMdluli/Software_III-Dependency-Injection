package restaround;

import com.google.inject.Provider;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;

public class customerRepositoryProvider implements Provider<customerRepository> {

    int noOfcustomers;

    @Override
    public customerRepository get() {

        try {

            // File database = new File("customerDatabase.txt");
            FileReader database = new FileReader("customerDatabase.txt");
            LineNumberReader lnr = new LineNumberReader(database);

            while (lnr.readLine() != null) {
                noOfcustomers++;  
            }
            
        } catch (IOException e) {
            e.printStackTrace();
        }

        customerRepository customerRepository = new customerRepositoryImpl();
        customerRepository.SetnoOfcustomers(noOfcustomers);
        return customerRepository;
    }

}
