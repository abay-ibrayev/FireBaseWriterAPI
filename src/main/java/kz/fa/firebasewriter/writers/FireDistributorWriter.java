package kz.fa.firebasewriter.writers;

import com.google.firebase.database.*;
import kz.fa.firebasewriter.model.FireDistributor;
import org.apache.log4j.Logger;

import java.util.HashMap;
import java.util.Map;
import static kz.fa.firebasewriter.utils.UrlConstants.*;

/**
 * Created by abay on 1/18/17.
 */
public class FireDistributorWriter  implements FireWriter {
    Logger logger = Logger.getLogger(FireDistributorWriter.class);

    public final String TAG = FireDistributorWriter.class.getSimpleName();

    private DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference();

    public String createInDistrsAll(FireDistributor distributor){
        logger.info(getClass() + " Creating inAll..." + "\n"+ distributor);
        String distributorId = FirebaseDatabase.getInstance().getReference().push().getKey();
        Map<String,Object> map = distributor.toMap();
        Map<String,Object> childUpdates = new HashMap<>();
        childUpdates.put(ALL_DISTRS + "/"+ distributorId,map);
        rootRef.updateChildren(childUpdates);
        return distributorId;
    }

    public String createInDistrsStore(FireDistributor distributor, String storeId){
        logger.info(getClass() + " Creating inStore..." + "\n"+ distributor);
        String distributorId = FirebaseDatabase.getInstance().getReference().push().getKey();
        Map<String,Object> map = distributor.toMap();
        Map<String,Object> childUpdates = new HashMap<>();
        childUpdates.put(STORE_DISTRS+"/"+storeId+"/"+distributorId,map);
        rootRef.updateChildren(childUpdates);
        return distributorId;
    }

    public void deleteInDistrsAll(String externalDistributorId){
        logger.info(getClass()+ "Deleting inAll... "+ rootRef.child(ALL_DISTRS).child(externalDistributorId));
        rootRef.child(ALL_DISTRS).child(externalDistributorId).removeValue();
    }

    public void deleteInDistrsStore(String externalDistributorId,String storeId){
        logger.info(getClass()+ "Deleting inStore... "+ rootRef.child(STORE_DISTRS).child(storeId).child(externalDistributorId));
        rootRef.child(STORE_DISTRS).child(storeId).child(externalDistributorId).removeValue();
    }

    public void deleteInAllDistrsStores(String externalDistributorId){

        rootRef.child(STORE_DISTRS).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot dsp : dataSnapshot.getChildren()){
                    logger.info(getClass()+ "Deleting inAllStores... "+ dsp.getRef().child(externalDistributorId));
                    dsp.getRef().child(externalDistributorId).removeValue();
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
}
