package kz.fa.firebasewriter.writers;

import com.google.firebase.database.*;
import kz.fa.firebasewriter.model.FireGood;
import kz.fa.firebasewriter.model.FirePrice;
import org.apache.log4j.*;
import org.apache.log4j.Logger;

import static kz.fa.firebasewriter.utils.UrlConstants.*;

/**
 * Created by abay on 1/17/17.
 */
public class FireGoodWriter implements FireWriter{

    org.apache.log4j.Logger logger = Logger.getLogger(FireGoodWriter.class);

    public final String TAG = FireGoodWriter.class.getSimpleName();

    private DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference();

    public void createInAllTables(FireGood good, String categoryUrl, String storeId){
        createInGoods(good,categoryUrl);
        createInGoodsInStore(good, storeId);

    }
    public void deleteInAllTables (String externalGoodId, String storeId){
        deleteInGoods(externalGoodId);
        deleteInGoodsInStore(externalGoodId, storeId);
    }
    public void updateInAllTables(FireGood good,String categoryUrl,String storeId){
        updateInGoods(good, categoryUrl);
        updateInGoodsInStore(good, storeId);
    }
    public void createInGoods(FireGood good, String categoryUrl){
        good.setId(FirebaseDatabase.getInstance().getReference().push().getKey());
        logger.info(getClass() + " "+ "Creating... "  + "\n"+ rootRef.child(GOODS).child(categoryUrl).child(good.getId()).toString());
        rootRef.child(GOODS).child(categoryUrl).child(good.getId()).setValue(good);
    }
    public void updateInGoods(FireGood good, String categoryUrl){
        logger.info(getClass() + " "+ "Updating... "  + "\n"+ rootRef.child(GOODS).child(categoryUrl).child(good.getId()).toString());
        rootRef.child(GOODS).child(categoryUrl).child(good.getId()).setValue(good);
    }


    public void deleteInGoods(String externalGoodId){
        rootRef.child(GOODS).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot dsp : dataSnapshot.getChildren()){
                    logger.info(getClass()+ " Deleting... "+ dsp.getRef().child(externalGoodId).toString());
                    dsp.getRef().child(externalGoodId).removeValue();
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
    public void createInGoodsInStore(FireGood good, String storeId){
        logger.info(getClass()+ " Creating In GoodsInStore..."+ rootRef.child(GOODS_IN_STORE).child(storeId).child(good.getId()).toString());
        rootRef.child(GOODS_IN_STORE).child(storeId).child(good.getId()).setValue(good);
    }
    public void updateInGoodsInStore(FireGood good, String storeId){
        logger.info(getClass()+ " Updating In GoodsInStore..."+ rootRef.child(GOODS_IN_STORE).child(storeId).child(good.getId()).toString());
        rootRef.child(GOODS_IN_STORE).child(storeId).child(good.getId()).setValue(good);
    }
    public void deleteInGoodsInStore(String externalGoodId, String storeId){
        logger.info(getClass()+ " Deleting In GoodsInStore..."+ rootRef.child(GOODS_IN_STORE).child(storeId).child(externalGoodId).toString());
        rootRef.child(GOODS_IN_STORE).child(storeId).child(externalGoodId).removeValue();
    }
    public void updatePrice(String goodId, FirePrice price, String storeId){
        logger.info(getClass()+ "Updating Price..."+  rootRef.child(GOODS_IN_STORE).child(storeId).child(goodId).child(PRICES).child(price.getType().toLowerCase())
                .child(String.valueOf(price.getDateBegin())).toString());
        rootRef.child(GOODS_IN_STORE).child(storeId).child(goodId).child(PRICES).child(price.getType().toLowerCase())
                .child(String.valueOf(price.getDateBegin())).setValue(price);
    }



}
