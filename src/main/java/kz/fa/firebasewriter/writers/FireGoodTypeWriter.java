package kz.fa.firebasewriter.writers;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import kz.fa.firebasewriter.model.FireGoodType;
import org.apache.log4j.Logger;

import static kz.fa.firebasewriter.utils.UrlConstants.*;
/**
 * Created by abay on 1/18/17.
 */
public class FireGoodTypeWriter implements FireWriter {
    Logger logger = Logger.getLogger(FireGoodTypeWriter.class);

    private DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference();

    public String createInGoodTypes(FireGoodType goodType){
        String goodTypeId = FirebaseDatabase.getInstance().getReference().push().getKey();
        goodType.setId(goodTypeId);
        logger.info(getClass() + " "+ "Creating... " + rootRef.child(GOOD_TYPES).child(goodType.getId()));
        rootRef.child(GOOD_TYPES).child(goodType.getId()).setValue(goodType);
        return goodType.getId();
    }
    public void updateInGoodTypes(FireGoodType goodType){
        logger.info(getClass() + " "+ "Updating... "+ "\n" + rootRef.child(GOOD_TYPES).child(goodType.getId()));
        rootRef.child(GOOD_TYPES).child(goodType.getId()).setValue(goodType);
    }
    public void deleteInGoodTypes(String externalGoodTypeId){
        logger.info(getClass()+" Deleting... "+ rootRef.child(GOOD_TYPES).child(externalGoodTypeId));
        rootRef.child(GOOD_TYPES).child(externalGoodTypeId).removeValue();
    }
}
