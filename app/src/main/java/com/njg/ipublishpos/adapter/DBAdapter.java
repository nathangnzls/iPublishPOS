
package com.njg.ipublishpos.adapter;


import android.content.ContentValues;
import android.content.Context;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DBAdapter {

    private static final String TAG = "DBAdapter";

    public static final String KEY_ORDER_ID = "order_id";
    public static final String KEY_ORDER_PRODUCT = "oder_product";
    public static final String KEY_ORDER_PRICE = "order_price";
    public static final String KEY_ORDER_QUANTITY = "order_quantity";
    public static final String KEY_ORDER_TABLENO = "order_tableno";
    public static final String KEY_ORDER_DATE = "order_date";


    public static final String KEY_CATEGORY_ID = "_id";
    public static final String KEY_CATEGORY_ITEM = "category";

    public static final String KEY_ITEM_ID = "_id";
    public static final String KEY_ITEM_ITEM = "item";
    public static final String KEY_ITEM_PRICE = "price";
    public static final String KEY_ITEM_CATEGORY = "category";


    public static final String[] ALL_CATEGORY_KEYS = new String[] {KEY_CATEGORY_ID,KEY_CATEGORY_ITEM};
    public static final String[] ALL_ITEM_KEYS = new String[] {KEY_ITEM_ID,KEY_ITEM_ITEM,KEY_ITEM_PRICE,KEY_ITEM_CATEGORY};
    public static final String[] ALL_ORDER_KEYS = new String[]{KEY_ORDER_ID,KEY_ORDER_PRODUCT,KEY_ORDER_PRICE,KEY_ORDER_QUANTITY,KEY_ORDER_TABLENO,KEY_ORDER_DATE};

    public static final int COL_ITEM_ID = 0;
    public static final int COL_ITEM_ITEM = 1;
    public static final int COL_ITEM_PRICE = 2;
    public static final int COL_ITEM_CATEGORY = 3;

    public static final int COL_CATEGORY_ID = 0;
    public static final int COL_CATEOGYR_ITEM = 1;

    public static final int COL_ORDER_ID=0;
    public static final int COL_ORDER_PRODUCT=1;
    public static final int COL_ORDER_PRICE=2;
    public static final int COL_ORDER_QUANTITY=3;
    public static final int COL_ORDER_TABLE=4;
    public static final int COL_ORDER_DATE=5;


    public static final String DB_NAME = "iPublish.db";
    public static final String CATEGORY_TABLE = "category_table";
    public static final String ITEM_TABLE = "item_table";
    public static final String ORDER_TABLE ="order_table";
    public static final int DATABASE_VERSION = 2;

    private static final String CreateDB = "create table if not exists " + CATEGORY_TABLE + " (" +KEY_CATEGORY_ID+" INTEGER PRIMARY KEY AUTOINCREMENT, "+KEY_CATEGORY_ITEM+" TEXT NOT NULL"+");";
    private static final String CreateTbl = "Create table if not exists " +ITEM_TABLE+" ("+KEY_ITEM_ID+" INTEGER PRIMARY KEY AUTOINCREMENT, "+KEY_ITEM_ITEM+" TEXT NOT NULL, "+KEY_ITEM_PRICE+" TEXT NOT NULL, "+KEY_ITEM_CATEGORY+" TEXT NOT NULL"+");";
    private static final String CreateOrder = "Create table if not exists "+ORDER_TABLE+" ("+KEY_ORDER_ID+" INTEGER PRIMARY KEY AUTOINCREMENT, "+ KEY_ORDER_PRODUCT+" TEXT NOT NULL, "+KEY_ORDER_PRICE+" DOUBLE,"+KEY_ORDER_QUANTITY+" INTEGER,"+KEY_ORDER_TABLENO+" INTEGER,"+KEY_ORDER_DATE+"TEXT NOT NULL"+");";

    private final Context context;
    public DatabaseHelper myDBHelper;
    private SQLiteDatabase db;

    public DBAdapter(Context ctx){
        this.context = ctx;
        myDBHelper = new DatabaseHelper(context);

    }

    public DBAdapter open(){
        db = myDBHelper.getWritableDatabase();
        return this;
    }

    public void close(){
        myDBHelper.close();
    }

    public long insertCategoryRow(String item){
        ContentValues initialValues = new ContentValues();
        initialValues.put(KEY_CATEGORY_ITEM,item);
        return db.insert(CATEGORY_TABLE,null, initialValues);
    }

    public long insertOrderRow(String product, double price, int quantity, int tableNo, String orderDate){
        ContentValues initialValues = new ContentValues();
        initialValues.put(KEY_ORDER_PRODUCT,product);
        initialValues.put(KEY_ORDER_PRICE,price);
        initialValues.put(KEY_ORDER_QUANTITY,quantity);
        initialValues.put(KEY_ORDER_TABLENO,tableNo);
        initialValues.put(KEY_ORDER_DATE,orderDate);

        return db.insert(ORDER_TABLE,null,initialValues);
    }

    public long insertItemRow(String item, String price, String category){
        ContentValues initialValues = new ContentValues();
        initialValues.put(KEY_ITEM_ITEM,category);
        initialValues.put(KEY_ITEM_PRICE,price);
        initialValues.put(KEY_ITEM_CATEGORY,item);

        return db.insert(ITEM_TABLE,null, initialValues);
    }


    public boolean deleteCategoryRow(long rowId){
        String where = KEY_CATEGORY_ID +" = "+rowId;
        return db.delete(CATEGORY_TABLE, where, null)!=0;
    }

    public boolean deleteOrderRow(long rowId){
        String where = KEY_ORDER_ID +" = "+rowId;
        return db.delete(ORDER_TABLE,where,null)!=0;
    }


    public boolean deleteAllCategoryItem(String categoryName){
        String where = KEY_ITEM_CATEGORY +" = "+ "\""+categoryName+"\"";
        return db.delete(ITEM_TABLE, where, null)!=0;
    }

    public boolean deleteItemRow(long rowId){
        String where = KEY_ITEM_ID +" = "+rowId;
        return db.delete(ITEM_TABLE, where, null)!=0;
    }

    public void deleteAllCategory(){
        Cursor c = getAllCategoryRows();
        long rowId = c.getColumnIndexOrThrow(KEY_CATEGORY_ID);
        if(c.moveToFirst()){
            do{
                deleteCategoryRow(c.getLong((int)rowId));
            }while(c.moveToNext());
        }
        c.close();
    }

    public void deleteAllOrder(){
        Cursor c= getAllOrderRows();
        long rowId = c.getColumnIndexOrThrow(KEY_ORDER_ID);
        if(c.moveToFirst()){
            do{
                deleteOrderRow(c.getLong((int)rowId));
            }while(c.moveToNext());
        }
        c.close();
    }

    public void deleteAllItem(String categoryname){
        Cursor c = getAllItemRows(categoryname);
        long rowId = c.getColumnIndexOrThrow(KEY_ITEM_ID);
        if(c.moveToFirst()){
            do{
                deleteItemRow(c.getLong((int)rowId));
            }while(c.moveToNext());
        }
        c.close();
    }

    public Cursor getAllCategoryRows(){
        String where = null;
        Cursor c = db.query(true, CATEGORY_TABLE, ALL_CATEGORY_KEYS, where, null, null, null, null, null);

        if (c!=null){
            c.moveToFirst();
        }
        return c;
    }

    public Cursor getAllOrderRows(){
        String where = null;
        Cursor c = db.query(true, ORDER_TABLE, ALL_ORDER_KEYS, where, null, null, null, null, null);
        if(c!=null){
            c.moveToFirst();
        }
        return c;
    }


    //ArrayList<Object> arr = new ArrayList<Object>();
    public String cat;
    FragmentParent fp;
    public Cursor getAllCategory(){
        Cursor crs = db.rawQuery("SELECT * FROM "+CATEGORY_TABLE, null);
        while(crs.moveToNext())
        {
            cat = crs.getString(crs.getColumnIndex(KEY_CATEGORY_ITEM));
           // System.out.println(cat);
            //arr.add(cat);
            //fp.addPage(cat);
            System.out.println(cat);
        }

        return crs;
    }


    public String id,item,price;
    public Cursor getAllItems(String categoryname){
        Cursor crs = db.rawQuery("SELECT * FROM "+ITEM_TABLE, null);
        while(crs.moveToNext())
        {

             id = crs.getString(crs.getColumnIndex(KEY_ITEM_ID));
             item = crs.getString(crs.getColumnIndex(KEY_ITEM_ITEM));
             price = crs.getString(crs.getColumnIndex(KEY_ITEM_PRICE));




            // System.out.println(cat);
            //arr.add(cat);
            //fp.addPage(cat);
            System.out.println(id+" "+item+" "+price);
        }

        return crs;
    }
    public Cursor getAllItemRows(String categoryname){
        String where = KEY_ITEM_CATEGORY + " = "+ " \""+categoryname+ "\"";
        Cursor c = db.query(true, ITEM_TABLE, ALL_ITEM_KEYS, where, null, null, null, null, null);
        if (c!=null){
            c.moveToFirst();
        }
        return c;
    }

    public Cursor getCategoryRow(long rowId){
        String where = KEY_CATEGORY_ID + "=" +rowId;
        Cursor c = db.query(true, CATEGORY_TABLE, ALL_CATEGORY_KEYS, where, null, null, null,null,null);
        if (c!=null){
            c.moveToFirst();
        }
        return c;
    }

    public Cursor getOrderRow(long rowId){
        String where = KEY_ORDER_ID + "=" + rowId;
        Cursor c= db.query(true, ORDER_TABLE, ALL_ORDER_KEYS, where,null,null,null,null,null);
        if(c!=null){
            c.moveToFirst();
        }
        return c;
    }
    public Cursor getItemRow(long rowId){
        String where = KEY_ITEM_ID + "=" +rowId;
        Cursor c = db.query(true, ITEM_TABLE, ALL_ITEM_KEYS, where, null, null, null,null,null);
        if (c!=null){
            c.moveToFirst();
        }
        return c;
    }



    public boolean updateCategoryRow(Long rowId, String categoryname){
        String where = KEY_CATEGORY_ID + "=" + rowId;
        ContentValues newValues = new ContentValues();
        newValues.put(KEY_CATEGORY_ITEM, categoryname);

        return db.update(CATEGORY_TABLE, newValues, where, null)!=0;
    }

    public boolean updateOrderRow(Long rowID, String productname){
        String where = KEY_ORDER_ID+"="+rowID;
        ContentValues newValues = new ContentValues();
        newValues.put(KEY_ORDER_PRODUCT, productname);

        return db.update(ORDER_TABLE, newValues, where, null)!=0;
    }

    public boolean updateAllCategoryItem(String categoryNameLuma,String categoryNameBago){
        String where = KEY_ITEM_CATEGORY +" = "+ "\""+categoryNameLuma+"\"";
        ContentValues newValues = new ContentValues();
        newValues.put(KEY_ITEM_CATEGORY, categoryNameBago);
        return db.update(ITEM_TABLE, newValues, where, null)!=0;
    }



    public boolean updateItemRow(Long rowId, String item, String price, String category){
        String where = KEY_ITEM_ID + "=" + rowId;
        ContentValues newValues = new ContentValues();
        newValues.put(KEY_ITEM_ITEM, item);
        newValues.put(KEY_ITEM_PRICE, price);
        newValues.put(KEY_ITEM_CATEGORY, category);

        return db.update(ITEM_TABLE, newValues, where, null)!=0;
    }

    public static class DatabaseHelper extends SQLiteOpenHelper{
        public DatabaseHelper(Context context){

            super(context, DB_NAME, null, DATABASE_VERSION);
        }
        @Override
        public void onCreate(SQLiteDatabase _db){

            _db.execSQL(CreateDB);
            _db.execSQL(CreateTbl);
            _db.execSQL(CreateOrder);

        }
        @Override
        public void onUpgrade(SQLiteDatabase _db, int oldVersion, int newVersion){
            Log.w(TAG, " Upgrading application's database from version "+oldVersion+ " to "+newVersion+",which will destroy all old data!");

            _db.execSQL("Drop TABLE IF EXISTS "+ CATEGORY_TABLE);
            _db.execSQL("Drop TABLE IF EXISTS "+ ITEM_TABLE);
            _db.execSQL("Drop TABLE IF EXISTS "+ ORDER_TABLE);

            onCreate(_db);
        }
    }

}
