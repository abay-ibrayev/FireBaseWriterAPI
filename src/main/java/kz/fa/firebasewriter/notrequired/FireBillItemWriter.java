package kz.fa.firebasewriter.notrequired;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import kz.fa.firebasewriter.writers.FireWriter;

/**
 * Created by abay on 1/17/17.
 */
public class FireBillItemWriter  implements FireWriter {
    public final String TAG = FireBillWriter.class.getSimpleName();

    private DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference();



}
