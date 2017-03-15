package kz.fa.firebasewriter.writers;

import com.google.firebase.database.*;
import kz.fa.firebasewriter.model.FireUser;
import kz.fa.firebasewriter.notrequired.FireBillWriter;
import org.apache.log4j.*;
import org.apache.log4j.Logger;
//import org.apache.log4j.Logger;

import java.util.Date;

import static kz.fa.firebasewriter.utils.UrlConstants.*;
/**
 * Created by abay on 1/17/17.
 */
public class FireUserWriter implements FireWriter {
    org.apache.log4j.Logger logger = Logger.getLogger(FireUserWriter.class);

    public final String TAG = FireBillWriter.class.getSimpleName();

    private DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference();

    public void createUserInUsers(FireUser user){
        logger.info(getClass() + " "+ "Creating User... " + rootRef.child(USERS).child(user.getLogin()));
        rootRef.child(USERS).child(user.getLogin()).setValue(user);
    }
    public void updateUserInUsers(FireUser user){
        logger.info(getClass() + " "+ "Updating User... "+ rootRef.child(USERS).child(user.getLogin()));
        rootRef.child(USERS).child(user.getLogin()).setValue(user);
    }
    public void deleteUserInUsers(String userLogin){
        logger.info(getClass()+" Deleting User... "+ rootRef.child(USERS).child(userLogin));
        rootRef.child(USERS).child(userLogin).removeValue();
    }
    public void changeUserRoleInStore(String userLogin,String storeId, String newRole){
        logger.info(getClass()+" ChangingRoleInStore..."+userLogin + " "+ newRole);
        rootRef.child(STORES).child(storeId).child(USERS).child(userLogin).child(ROLE).setValue(newRole);
        rootRef.child(STORES).child(storeId).child(CHILD_CHANGE_DATE).setValue(new Date().getTime());
        rootRef.child(USERS).child(userLogin).child(STORES).child(storeId).child(ROLE_IN_SHOP).setValue(newRole);
    }

    public void deleteUserInStore(String userLogin, String storeId){
        logger.info(getClass()+" Deleting UserInStore... "+ userLogin);
        rootRef.child(STORES).child(storeId).child(USERS).child(userLogin).removeValue();
        rootRef.child(STORES).child(storeId).child(CHILD_CHANGE_DATE).setValue(new Date().getTime());
        rootRef.child(USERS).child(userLogin).child(STORES).child(storeId).removeValue();
    }
    public void changeUserRoleInUsers(String userLogin, String newRole){
        logger.info(getClass()+" ChangingRole..."+rootRef.child(USERS).child(userLogin).child(ROLE));
        rootRef.child(USERS).child(userLogin).child(ROLE).setValue(newRole);
    }

    public void deleteUserInAllStores(String userLogin){
        rootRef.child(STORES).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot dsp : dataSnapshot.getChildren()){
                    logger.info(getClass()+" Deleting User in AllStores..."+dsp.getRef().child(USERS).child(userLogin));
                    dsp.getRef().child(USERS).child(userLogin).removeValue();
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        //child(storeId).child(USERS).child(userLogin).removeValue();
    }
}
