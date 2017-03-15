package kz.fa.firebasewriter.notrequired;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import kz.fa.firebasewriter.model.FireCashboxOper;
import kz.fa.firebasewriter.writers.FireWriter;

import static kz.fa.firebasewriter.utils.UrlConstants.*;

/**
 * Created by abay on 1/17/17.
 */
public class FireCashBoxWriter implements FireWriter {
    public final String TAG = FireCashBoxWriter.class.getSimpleName();

    private DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference();

    public String createInCashboxes(FireCashboxOper cashBoxOper, String storeId){
        cashBoxOper.setId(FirebaseDatabase.getInstance().getReference().push().getKey());
        rootRef.child(CASHBOX_COMMITTED).child(storeId).child(cashBoxOper.getId()).setValue(cashBoxOper);
        return cashBoxOper.getId();
    }

    public void deleteInCashBoxes(String externalCashboxId, String storeId){
        rootRef.child(CASHBOX_COMMITTED).child(storeId).child(externalCashboxId).removeValue();
    }


}
