package kz.fa.firebasewriter.writers;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import kz.fa.firebasewriter.model.FireChange;

/**
 * Created by abay on 3/15/17.
 */
public class FireChangeWriter implements FireWriter {
    private DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference();

    public String updateFireChange(FireChange change){
        String fireChangeId = FirebaseDatabase.getInstance().getReference().push().getKey();
        rootRef.child(change.getStoreId() + "/" + change.getDeviceId()+"/"+fireChangeId).setValue(change);
        return fireChangeId;
    }
}
