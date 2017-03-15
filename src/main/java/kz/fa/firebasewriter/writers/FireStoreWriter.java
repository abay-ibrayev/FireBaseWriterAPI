package kz.fa.firebasewriter.writers;

import com.google.firebase.database.*;
import kz.fa.firebasewriter.model.FireGood;
import kz.fa.firebasewriter.model.FireStore;
import org.apache.log4j.*;
import org.apache.log4j.Logger;
import sun.rmi.runtime.Log;

import java.util.Date;

import static kz.fa.firebasewriter.utils.UrlConstants.*;

/**
 * Created by abay on 1/17/17.
 */
public class FireStoreWriter implements FireWriter {
    org.apache.log4j.Logger logger = Logger.getLogger(FireStoreWriter.class);
    public final String TAG = FireStoreWriter.class.getSimpleName();


    private DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference();

    public void deleteInAllTables(String externalStoreId){
        deleteInStores(externalStoreId);
        deleteInBillsCommitted(externalStoreId);
        deleteInBillsCurrent(externalStoreId);
        deleteInCashbox(externalStoreId);
        deleteInDistrsAll(externalStoreId);
        deleteInDistrsStore(externalStoreId);
        deleteInGoodsInStores(externalStoreId);
        deleteInRecepts(externalStoreId);
        deleteInUsers(externalStoreId);
    }
    public String createInStores(FireStore store){
        String storeId = FirebaseDatabase.getInstance().getReference().push().getKey();
        logger.info(getClass() + " "+ "Creating  in Stores... " + rootRef.child(STORES).child(storeId));
        rootRef.child(STORES).child(storeId).setValue(store);
        createInGoodsInStore(storeId);
        return storeId;
    }
    public void createInGoodsInStore(String storeId){
        rootRef.child(GOODS).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot dsp : dataSnapshot.getChildren()){
                    logger.info(getClass()+ " Creating In GoodsInStore... "+ rootRef.child(GOODS_IN_STORE).child(storeId));
                    rootRef.child(GOODS_IN_STORE).child(storeId).setValue(dsp.getValue());
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
    public void updateInStores(FireStore store, String storeId){
        logger.info(getClass() + " "+ "Updating... " + rootRef.child(STORES).child(storeId));
        rootRef.child(STORES).child(storeId).setValue(store);
    }
    public void deleteInStores(String externalStoreId){
        logger.info(getClass()+" Deleting In Stores... "+ rootRef.child(STORES).child(externalStoreId));
        rootRef.child(STORES).child(externalStoreId).removeValue();
    }
    public void deleteInGoodsInStores(String externalStoreId) {
        logger.info(getClass()+" Deleting In GoodsInStore... "+  rootRef.child(GOODS_IN_STORE).child(externalStoreId));
        rootRef.child(GOODS_IN_STORE).child(externalStoreId).removeValue();
    }
    public void deleteInBillsCommitted(String externalStoreId){
        logger.info(getClass()+" Deleting In Bills Committed... "+ rootRef.child(BILLS_COMMITTED).child(externalStoreId));
        rootRef.child(BILLS_COMMITTED).child(externalStoreId).removeValue();
    }
    public void deleteInBillsCurrent(String externalStoreId){
        logger.info(getClass()+" Deleting In Bills Current... "+ rootRef.child(BILLS_CURRENT).child(externalStoreId));
        rootRef.child(BILLS_CURRENT).child(externalStoreId).removeValue();
    }
    public void deleteInCashbox(String externalStoreId){
        logger.info(getClass()+" Deleting in Cashbox... "+ rootRef.child(CASHBOX_COMMITTED).child(externalStoreId)
                +"\n" + rootRef.child(CASHBOX_CURRENT).child(externalStoreId));
        rootRef.child(CASHBOX_COMMITTED).child(externalStoreId).removeValue();
        rootRef.child(CASHBOX_CURRENT).child(externalStoreId).removeValue();
    }
    public void deleteInDistrsAll(String externalStoreId){
        logger.info(getClass()+" Deleting in DistrsAll... "+ rootRef.child(ALL_DISTRS).child(externalStoreId));
        rootRef.child(ALL_DISTRS).child(externalStoreId).removeValue();
    }
    public void deleteInDistrsStore(String externalStoreId){
        logger.info(getClass()+" Deleting in DistrsStore... "+ rootRef.child(STORE_DISTRS).child(externalStoreId));
        rootRef.child(STORE_DISTRS).child(externalStoreId).removeValue();
    }
    public void deleteInUsers(String externalStoreId){

        rootRef.child(USERS).orderByChild("stores").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot dsp : dataSnapshot.getChildren()){
                    logger.info(getClass() + " Deleting in Users..."+ dsp.getRef().child(STORES).child(externalStoreId));
                    dsp.getRef().child(STORES).child(externalStoreId).removeValue();
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });    }
    public void deleteInRecepts(String externalStoreId){
        logger.info(getClass()+" Deleting in Recepts... "+ externalStoreId);
        rootRef.child(RECEIPTS_ALL).child(externalStoreId).removeValue();
        rootRef.child(RECEIPTS_TO_PROCESS).child(externalStoreId).removeValue();
    }
    public void changeStoreName(String newName, String storeId){
        logger.info(getClass()+" Changing name... "+  rootRef.child(STORES).child(storeId).child(NAME));
        rootRef.child(STORES).child(storeId).child(NAME).setValue(newName);
        logger.info(getClass()+" Changing dateOfChange... "+ rootRef.child(STORES).child(storeId).child(CHILD_CHANGE_DATE));
        rootRef.child(STORES).child(storeId).child(CHILD_CHANGE_DATE).setValue(new Date().getTime());

        rootRef.child(STORES).child(storeId).child(USERS).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for(DataSnapshot dsp : dataSnapshot.getChildren()){
                    logger.info(getClass()+" Changing name... "+  dsp.getRef().child(NAME));
                    dsp.getRef().child(NAME).setValue(newName);
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    /*
    public void createInGoodsInStores(FireStore store, String storeId){
        rootRef.child(GOODS_IN_STORE).child(storeId).setValue(store);
    }
    public void updateInGoodsInStores(FireStore store, String storeId){
        createInStores(store,storeId);
    }

    public void createInBillsCommitted(FireStore store, String storeId){
        rootRef.child(BILLS_COMMITTED).child(storeId).setValue(store);
    }
    public void updateInBillsCommitted(FireStore store, String storeId){
        createInBillsCommitted(store,storeId);
    }
    public void createInBillsCurrent(FireStore store, String storeId){
        rootRef.child(BILLS_CURRENT).child(storeId).setValue(store);
    }
    public void updateInBillsCurrent(FireStore store, String storeId){
        createInBillsCurrent(store,storeId);
    }

    public void createInCashboxCommitted(FireStore store, String storeId){

    }
    */
}
