package kz.fa.firebasewriter.notrequired;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import kz.fa.firebasewriter.model.FireReceipt;
import kz.fa.firebasewriter.writers.FireWriter;

import java.util.HashMap;
import java.util.Map;

import static kz.fa.firebasewriter.utils.UrlConstants.*;
/**
 * Created by abay on 1/18/17.
 */
public class FireReceiptWriter implements FireWriter {
    /*

    public final String TAG = FireReceiptWriter.class.getSimpleName();

    private DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference();

    public String createInReceipts(FireReceipt receipt){
        String receiptId = FirebaseDatabase.getInstance().getReference().push().getKey();
        Map<String, Object> map = receipt.toMap();
        Map<String, Object> childUpdates = new HashMap<>();
        childUpdates.put(RECEIPTS_ALL+"/"+receiptId,map);
        childUpdates.put(RECEIPTS_TO_PROCESS+"/"+receiptId,map);
        return  receiptId;
    }
    */
}
