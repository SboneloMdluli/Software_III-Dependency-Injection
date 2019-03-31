package restaround;

import com.google.inject.Provider;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;

public class customerRepositoryProvider implements Provider<customerRepository> {

    int noOfcustomers;

    @Override
    public customerRepository get() {

        try {
            FileReader database = new FileReader("customerDatabase.txt");
            LineNumberReader lineNumber = new LineNumberReader(database);

            while (lineNumber.readLine() != null) {
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
