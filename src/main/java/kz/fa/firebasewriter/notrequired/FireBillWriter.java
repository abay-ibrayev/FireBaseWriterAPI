package kz.fa.firebasewriter.notrequired;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import kz.fa.firebasewriter.model.FireBill;
import kz.fa.firebasewriter.model.FireBillItem;
import kz.fa.firebasewriter.writers.FireWriter;

import static kz.fa.firebasewriter.utils.UrlConstants.*;

/**
 * Created by abay on 1/17/17.
 */
public class FireBillWriter  implements FireWriter {
    public final String TAG = FireBillWriter.class.getSimpleName();

    private DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference();

    public void createInBillsCommitted(FireBill bill, String storeId){
        bill.setId(FirebaseDatabase.getInstance().getReference().push().getKey());//create key for entity
        rootRef.child(BILLS_COMMITTED).child(storeId).child(bill.getDeviceId()).child(bill.getId()).setValue(bill);
    }
    public void updateInBillsCommited(FireBill bill, String storeId){
        rootRef.child(BILLS_COMMITTED).child(storeId).child(bill.getDeviceId()).child(bill.getId()).setValue(bill);
    }
    public String createInBillItemsCommitted(FireBill bill,FireBillItem billItem, String storeId){
        String billItemId = FirebaseDatabase.getInstance().getReference().push().getKey();
        rootRef.child(BILLS_COMMITTED).child(storeId).child(bill.getDeviceId()).child(bill.getId()).child(ITEMS).child(billItemId).setValue(billItem);
        return billItemId;
    }

}
