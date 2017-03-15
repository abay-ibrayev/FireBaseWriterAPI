package kz.fa.firebasewriter.writers;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import kz.fa.firebasewriter.model.FireRegion;

import static kz.fa.firebasewriter.utils.UrlConstants.REGIONS;

/**
 * Created by abay on 2/13/17.
 */
public class RegionFBWriter {
    private DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference();
    public void createRegion(FireRegion region){
        rootRef.child(REGIONS).child(region.getId()).setValue(region);

    }
    public void deleteRegion(String regionID){
        rootRef.child(REGIONS).child(regionID).removeValue();
    }
}
