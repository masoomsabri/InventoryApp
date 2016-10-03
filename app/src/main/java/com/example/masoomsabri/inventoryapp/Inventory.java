package com.example.masoomsabri.inventoryapp;

import android.app.Application;
import android.content.ContentValues;
import com.example.masoomsabri.inventoryapp.data.DBUtils;
import com.example.masoomsabri.inventoryapp.data.InventoryContract;
/**
 * Created by masoomsabri on 7/4/16.
 */
public class Inventory extends Application {
    @Override public void onCreate() {
        super.onCreate();
        createSupplierRecord();
        createProductRecord();
    }

    @Override public void onTerminate() {
        super.onTerminate();
    }

    private void createSupplierRecord() {
        ContentValues contentValues = new ContentValues();
        contentValues.put(InventoryContract.SupplierEntry.COLUMN_NAME_SUPPLIER_NAME,
                "Reliance Digital");
        contentValues.put(InventoryContract.SupplierEntry.COLUMN_NAME_SUPPLIER_ID, 101);
        contentValues.put(InventoryContract.SupplierEntry.COLUMN_NAME_PHONE, 97654);
        DBUtils.getInstance(this)
                .insertIntoDB(InventoryContract.SupplierEntry.TABLE_NAME, contentValues);
        contentValues = new ContentValues();
        contentValues.put(InventoryContract.SupplierEntry.COLUMN_NAME_SUPPLIER_NAME, "Chroma");
        contentValues.put(InventoryContract.SupplierEntry.COLUMN_NAME_SUPPLIER_ID, 102);
        contentValues.put(InventoryContract.SupplierEntry.COLUMN_NAME_PHONE, 97654);
        DBUtils.getInstance(this)
                .insertIntoDB(InventoryContract.SupplierEntry.TABLE_NAME, contentValues);
    }

    private void createProductRecord() {
        ContentValues contentValues = new ContentValues();
        contentValues.put(InventoryContract.ProductEntry.COLUMN_NAME_PRODUCT_NAME, "iPhone");
        contentValues.put(InventoryContract.ProductEntry.COLUMN_NAME_QUANTITY, 20);
        contentValues.put(InventoryContract.ProductEntry.COLUMN_NAME_PRICE, 50000.10);
        contentValues.put(InventoryContract.ProductEntry.COLUMN_NAME_SUPPLIER_ID, 102);
        contentValues.put(InventoryContract.ProductEntry.COLUMN_NAME_IMAGE_URL, "http://store"
                + ".storeimages.cdn-apple.com/4973/as-images.apple.com/is/image/AppleInc/aos/published/images/i/ph/iphone6/plus/iphone6-plus-box-silver-2014_GEO_US?wid=478&hei=595&fmt=jpeg&qlt=95&op_sharpen=0&resMode=bicub&op_usm=0.5,0.5,0,0&iccEmbed=0&layer=comp&.v=IqGln0");
        DBUtils.getInstance(this)
                .insertIntoDB(InventoryContract.ProductEntry.TABLE_NAME, contentValues);

        contentValues = new ContentValues();
        contentValues.put(InventoryContract.ProductEntry.COLUMN_NAME_PRODUCT_NAME, "iPad");
        contentValues.put(InventoryContract.ProductEntry.COLUMN_NAME_QUANTITY, 10);
        contentValues.put(InventoryContract.ProductEntry.COLUMN_NAME_PRICE, 23467.65);
        contentValues.put(InventoryContract.ProductEntry.COLUMN_NAME_SUPPLIER_ID, 101);
        contentValues.put(InventoryContract.ProductEntry.COLUMN_NAME_IMAGE_URL,
                "http://store.storeimages.cdn-apple.com/4973/as-images.apple.com/is/image/AppleInc/aos/published/images/i/pa/ipad/air/ipad-air-witb-gray-cel-201410_GEO_US?wid=366&hei=519&fmt=jpeg&qlt=95&op_sharpen=0&resMode=bicub&op_usm=0.5,0.5,0,0&iccEmbed=0&layer=comp&.v=Fzsl_0");
        DBUtils.getInstance(this)
                .insertIntoDB(InventoryContract.ProductEntry.TABLE_NAME, contentValues);

        contentValues = new ContentValues();
        contentValues.put(InventoryContract.ProductEntry.COLUMN_NAME_PRODUCT_NAME, "Mac");
        contentValues.put(InventoryContract.ProductEntry.COLUMN_NAME_QUANTITY, 40);
        contentValues.put(InventoryContract.ProductEntry.COLUMN_NAME_PRICE, 98000.00);
        contentValues.put(InventoryContract.ProductEntry.COLUMN_NAME_SUPPLIER_ID, 101);
        contentValues.put(InventoryContract.ProductEntry.COLUMN_NAME_IMAGE_URL,
                "http://store.storeimages.cdn-apple.com/4973/as-images.apple.com/is/image/AppleInc/aos/published/images/M/F8/MF858/MF858?wid=572&hei=572&fmt=jpeg&qlt=95&op_sharpen=0&resMode=bicub&op_usm=0.5,0.5,0,0&iccEmbed=0&layer=comp&.v=ronlz2");
        DBUtils.getInstance(this)
                .insertIntoDB(InventoryContract.ProductEntry.TABLE_NAME, contentValues);
    }
}
