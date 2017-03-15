package kz.fa.firebasewriter.writers;

import com.google.firebase.database.*;
import kz.fa.firebasewriter.model.FireBillItem;
import kz.fa.firebasewriter.model.FireGood;

import static kz.fa.firebasewriter.utils.UrlConstants.BILLS_COMMITTED;
import static kz.fa.firebasewriter.utils.UrlConstants.GOODS;

/**
 * Created by abay on 2/13/17.
 */
public class GoodsUpdateFBWriter {
    private DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference();
    public void mergeGoods(FireGood good1, FireGood good2, String categoryUrl){
        rootRef.child(GOODS).child(categoryUrl).child(good1.getId()).setValue(good1);
        //rootRef.child(GOODS).child(categoryUrl).child(good2.getId()).setValue(good2);
        rootRef.child(BILLS_COMMITTED).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot dsp : dataSnapshot.getChildren()){
                    System.out.println(dsp.getRef());
                    dsp.getRef().addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            for (DataSnapshot dsp : dataSnapshot.getChildren()){
                                System.out.println(dsp.getRef().child("items"));
                                dsp.getRef().child("items").addListenerForSingleValueEvent(new ValueEventListener() {
                                    @Override
                                    public void onDataChange(DataSnapshot dataSnapshot) {
                                        for(DataSnapshot dsp : dataSnapshot.getChildren()){
                                            System.out.println(dsp.getRef().child("goodId"));
                                            System.out.println(good1.getId());
                                            FireBillItem item = dsp.getValue(FireBillItem.class);
                                            if(item.getGoodId().equals(good1.getId())){
                                                dsp.getRef().child("goodId").setValue(good2.getId());
                                            }
                                        }
                                    }

                                    @Override
                                    public void onCancelled(DatabaseError databaseError) {

                                    }
                                });
                            }
                        }

                        @Override
                        public void onCancelled(DatabaseError databaseError) {

                        }
                    });
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

    }
    public void splitGoods(FireGood newGood, String categoryUrl){
        rootRef.child(GOODS).child(categoryUrl).child(newGood.getId()).setValue(newGood);

    }
}
