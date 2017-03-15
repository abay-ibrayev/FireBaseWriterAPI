package kz.fa.firebasewriter.test;

import kz.fa.firebasewriter.writers.*;
import kz.fa.firebasewriter.model.*;

import java.io.FileNotFoundException;

/**
 * Created by abay on 1/17/17.
 */
public class FirebaseWriterTest {

    public static void main(String[] args)throws FileNotFoundException {

        new FirebaseConnect();

        FireStoreWriter writer = new FireStoreWriter();
        FireStore storeExample = new FireStore();
        storeExample.setName("MyStore");
        storeExample.setCompanyName("Bug");
        storeExample.setOwner("Adam Smit");
        //writer.createInStores(storeExample);
        FireNewGoodWriter newGoodWriter = new FireNewGoodWriter();
        FireGood good = new FireGood();
        good.setId("-KbE2sSJRbKcXTkSQ3Bq");
        good.setBarcode("azaza");
        //newGoodWriter.transferToGoods(good, "torgai");
        FireGood good2 = new FireGood();
        good2.setId("azazazaza");
        //GoodsUpdateFBWriter writer1 = new GoodsUpdateFBWriter();
        //writer1.mergeGoods(good,good2,"torgai");
        while (true){
        }
    }
}

