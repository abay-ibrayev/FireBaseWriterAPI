package kz.fa.firebasewriter.writers;

import com.google.firebase.database.*;
import kz.fa.firebasewriter.model.FireGood;

import static kz.fa.firebasewriter.utils.UrlConstants.*;
import org.apache.log4j.Logger;

/**
 * Created by abay on 1/23/17.
 */
public class FireNewGoodWriter implements  FireWriter {

    Logger logger = Logger.getLogger(FireNewGoodWriter.class);

    private DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference();

    public void createInNewGoods(FireGood good){
        logger.info(getClass() + " "+ "Creating... " + "\n"+ rootRef.child(NEW_GOODS).child(good.getId()));
        good.setId(FirebaseDatabase.getInstance().getReference().push().getKey());
        rootRef.child(NEW_GOODS).child(good.getId()).setValue(good);
    }
    public void updateInNewGoods(FireGood good){
        logger.info(getClass() + " "+ "Updating... "+ "\n" + rootRef.child(NEW_GOODS).child(good.getId()));
        rootRef.child(NEW_GOODS).child(good.getId()).setValue(good);
    }

    public void deleteInNewGoods(String externalGoodId){
        logger.info(getClass()+" Deleting... "+ rootRef.child(NEW_GOODS).child(externalGoodId));
        rootRef.child(NEW_GOODS).child(externalGoodId).removeValue();
    }
    public void transferToGoods(FireGood good, String categoryUrl){
        logger.info(getClass()+" Transfer to Goods... "+ rootRef.child(NEW_GOODS).child(categoryUrl).child(good.getId()) );
        rootRef.child(GOODS).child(good.getId()).setValue(good);
        rootRef.child(NEW_GOODS).child(categoryUrl).child(good.getId()).removeValue();
    }
}
