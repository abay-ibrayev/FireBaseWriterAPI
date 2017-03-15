package kz.fa.firebasewriter.test;

import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 *
 * @author Bagdat
 */
public class FirebaseConnect {
    public FirebaseConnect() throws FileNotFoundException {
        FirebaseOptions options = new FirebaseOptions.Builder()
                .setServiceAccount(new FileInputStream("/home/abay/FirebaseWriter/fir-writerexample-firebase-adminsdk-h7rzy-97136bc0e6.json"))
                .setDatabaseUrl("https://fir-writerexample.firebaseio.com/")
                .build();
        FirebaseApp firebaseApp = FirebaseApp.initializeApp(options);
        System.out.println(firebaseApp.getName());
    }
}
