package com.njg.ipublishpos;



import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

import java.util.HashMap;
public class manageData {
    SharedPreferences pref;
    SharedPreferences.Editor editor;
    Context _context;
    int PRIVATE_MODE = 0;
    private static final String PREF_NAME = "orderTable";
    private static final String KEY_ORDER_PRODUCT1 = "orderproduct1";
    private static final String KEY_ORDER_PRODUCT2 = "orderproduct2";
    private static final String KEY_ORDER_PRODUCT3 = "orderproduct3";
    private static final String KEY_ORDER_PRODUCT4 = "orderproduct4";
    private static final String KEY_ORDER_PRODUCT5 = "orderproduct5";
    private static final String KEY_ORDER_PRODUCT6 = "orderproduct6";
    private static final String KEY_ORDER_PRODUCT7 = "orderproduct7";
    private static final String KEY_ORDER_PRODUCT8 = "orderproduct8";
    private static final String KEY_ORDER_PRODUCT9 = "orderproduct9";
    private static final String KEY_ORDER_PRODUCT10 = "orderproduct10";
    private static final String KEY_ORDER_PRODUCT11 = "orderproduct11";
    private static final String KEY_ORDER_PRODUCT12 = "orderproduct12";
    private static final String KEY_ORDER_PRODUCT13 = "orderproduct13";
    private static final String KEY_ORDER_PRODUCT14 = "orderproduct14";
    private static final String KEY_ORDER_PRODUCT15 = "orderproduct15";
    private static final String KEY_ORDER_PRODUCT16 = "orderproduct16";
    private static final String KEY_ORDER_PRODUCT17 = "orderproduct17";
    private static final String KEY_ORDER_PRODUCT18 = "orderproduct18";
    private static final String KEY_ORDER_PRODUCT19 = "orderproduct19";
    private static final String KEY_ORDER_PRODUCT20= "orderproduct20";
    private static final String KEY_ORDER_PRICE1 = "price1";
    private static final String KEY_ORDER_PRICE2 = "price2";
    private static final String KEY_ORDER_PRICE3 = "price3";
    private static final String KEY_ORDER_PRICE4 = "price4";
    private static final String KEY_ORDER_PRICE5 = "price5";
    private static final String KEY_ORDER_PRICE6 = "price6";
    private static final String KEY_ORDER_PRICE7 = "price7";
    private static final String KEY_ORDER_PRICE8 = "price8";
    private static final String KEY_ORDER_PRICE9 = "price9";
    private static final String KEY_ORDER_PRICE10 = "price10";
    private static final String KEY_ORDER_PRICE11 = "price11";
    private static final String KEY_ORDER_PRICE12 = "price12";
    private static final String KEY_ORDER_PRICE13 = "price13";
    private static final String KEY_ORDER_PRICE14 = "price14";
    private static final String KEY_ORDER_PRICE15 = "price15";
    private static final String KEY_ORDER_PRICE16 = "price16";
    private static final String KEY_ORDER_PRICE17 = "price17";
    private static final String KEY_ORDER_PRICE18 = "price18";
    private static final String KEY_ORDER_PRICE19 = "price19";
    private static final String KEY_ORDER_PRICE20 = "price20";

    public manageData(Context context){
        this._context = context;
        pref = _context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        editor = pref.edit();
    }


    public void setOrder1(String product, String price){
        editor.putString(KEY_ORDER_PRODUCT1,product);
        editor.putString(KEY_ORDER_PRICE1,price);
        editor.commit();
    }

    public void setOder2(String product, String price){
        editor.putString(KEY_ORDER_PRODUCT2,product);
        editor.putString(KEY_ORDER_PRICE2,price);
        editor.commit();
    }

    public void setOder3(String product, String price){
        editor.putString(KEY_ORDER_PRODUCT3,product);
        editor.putString(KEY_ORDER_PRICE3,price);
        editor.commit();
    }

    public void setOrder4(String product, String price){
        editor.putString(KEY_ORDER_PRODUCT4,product);
        editor.putString(KEY_ORDER_PRICE4,price);
        editor.commit();
    }

    public void setOrder5(String product, String price){
        editor.putString(KEY_ORDER_PRODUCT5,product);
        editor.putString(KEY_ORDER_PRICE5,price);
        editor.commit();
    }

    public void setOrder6(String product, String price){
        editor.putString(KEY_ORDER_PRODUCT6,product);
        editor.putString(KEY_ORDER_PRICE6,price);
        editor.commit();
    }

    public void setOrder7(String product, String price){
        editor.putString(KEY_ORDER_PRODUCT7,product);
        editor.putString(KEY_ORDER_PRICE7,price);
        editor.commit();
    }

    public void setOrder8(String product, String price){
        editor.putString(KEY_ORDER_PRODUCT8,product);
        editor.putString(KEY_ORDER_PRICE8,price);
        editor.commit();
    }

    public void setOrder9(String product, String price){
        editor.putString(KEY_ORDER_PRODUCT9,product);
        editor.putString(KEY_ORDER_PRICE9,price);
        editor.commit();
    }

    public void setOrder10(String product, String price){
        editor.putString(KEY_ORDER_PRODUCT10,product);
        editor.putString(KEY_ORDER_PRICE10,price);
        editor.commit();
    }

    public void setOrder11(String product, String price){
        editor.putString(KEY_ORDER_PRODUCT11,product);
        editor.putString(KEY_ORDER_PRICE11,price);
        editor.commit();
    }

    public void setOrder12(String product, String price){
        editor.putString(KEY_ORDER_PRODUCT12,product);
        editor.putString(KEY_ORDER_PRICE12,price);
        editor.commit();
    }

    public void setOrder13(String product, String price){
        editor.putString(KEY_ORDER_PRODUCT13,product);
        editor.putString(KEY_ORDER_PRICE13,price);
        editor.commit();
    }

    public void setOrder14(String product, String price){
        editor.putString(KEY_ORDER_PRODUCT14,product);
        editor.putString(KEY_ORDER_PRICE14,price);
        editor.commit();
    }

    public void setOrder15(String product, String price){
        editor.putString(KEY_ORDER_PRODUCT15,product);
        editor.putString(KEY_ORDER_PRICE15,price);
        editor.commit();
    }

    public void setOrder16(String product, String price){
        editor.putString(KEY_ORDER_PRODUCT16,product);
        editor.putString(KEY_ORDER_PRICE16,price);
        editor.commit();
    }

    public void setOrder17(String product, String price){
        editor.putString(KEY_ORDER_PRODUCT17,product);
        editor.putString(KEY_ORDER_PRICE17,price);
        editor.commit();
    }

    public void setOrder18(String product, String price){
        editor.putString(KEY_ORDER_PRODUCT18,product);
        editor.putString(KEY_ORDER_PRICE18,price);
        editor.commit();
    }

    public void setOrder19(String product, String price){
        editor.putString(KEY_ORDER_PRODUCT19,product);
        editor.putString(KEY_ORDER_PRICE19,price);
        editor.commit();
    }

    public void setOrder20(String product, String price){
        editor.putString(KEY_ORDER_PRODUCT20,product);
        editor.putString(KEY_ORDER_PRICE20,price);
        editor.commit();
    }



    public void ClearOrder(){
        editor.clear();
        editor.commit();
        editor.commit();
       // Intent i = new Intent(_context, LoginActivity.class);
       // i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
      //  i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
       // _context.startActivity(i);

    }

    public String product1(){
        String order = pref.getString(KEY_ORDER_PRODUCT1,null);
        return order;
    }

    public String product2(){
        String order = pref.getString(KEY_ORDER_PRODUCT2,null);
        return order;
    }

    public String product3(){
        String order = pref.getString(KEY_ORDER_PRODUCT3,null);
        return order;
    }

    public String product4(){
        String order = pref.getString(KEY_ORDER_PRODUCT4,null);
        return order;
    }

    public String product5(){
        String order = pref.getString(KEY_ORDER_PRODUCT5,null);
        return order;
    }

    public String product6(){
        String order = pref.getString(KEY_ORDER_PRODUCT6,null);
        return order;
    }

    public String product7(){
        String order = pref.getString(KEY_ORDER_PRODUCT7,null);
        return order;
    }

    public String product8(){
        String order = pref.getString(KEY_ORDER_PRODUCT8,null);
        return order;
    }

    public String product9(){
        String order = pref.getString(KEY_ORDER_PRODUCT9,null);
        return order;
    }

    public String product10(){
        String order = pref.getString(KEY_ORDER_PRODUCT10,null);
        return order;
    }

    public String product11(){
        String order = pref.getString(KEY_ORDER_PRODUCT11,null);
        return order;
    }

    public String product12(){
        String order = pref.getString(KEY_ORDER_PRODUCT12,null);
        return order;
    }

    public String product13(){
        String order = pref.getString(KEY_ORDER_PRODUCT13,null);
        return order;
    }
    public String product14(){
        String order = pref.getString(KEY_ORDER_PRODUCT14,null);
        return order;
    }
    public String product15(){
        String order = pref.getString(KEY_ORDER_PRODUCT15,null);
        return order;
    }
    public String product16(){
        String order = pref.getString(KEY_ORDER_PRODUCT16,null);
        return order;
    }
    public String product17(){
        String order = pref.getString(KEY_ORDER_PRODUCT17,null);
        return order;
    }
    public String product18(){
        String order = pref.getString(KEY_ORDER_PRODUCT18,null);
        return order;
    }
    public String product19(){
        String order = pref.getString(KEY_ORDER_PRODUCT19,null);
        return order;
    }
    public String product20(){
        String order = pref.getString(KEY_ORDER_PRODUCT20,null);
        return order;
    }




    public String price1(){
        String price = pref.getString(KEY_ORDER_PRICE1,null);
        return price;
    }
    public String price2(){
        String price = pref.getString(KEY_ORDER_PRICE2,null);
        return price;
    }
    public String price3(){
        String price = pref.getString(KEY_ORDER_PRICE3,null);
        return price;
    }
    public String price4(){
        String price = pref.getString(KEY_ORDER_PRICE4,null);
        return price;
    }
    public String price5(){
        String price = pref.getString(KEY_ORDER_PRICE5,null);
        return price;
    }
    public String price6(){
        String price = pref.getString(KEY_ORDER_PRICE6,null);
        return price;
    }
    public String price7(){
        String price = pref.getString(KEY_ORDER_PRICE7,null);
        return price;
    }
    public String price8(){
        String price = pref.getString(KEY_ORDER_PRICE8,null);
        return price;
    }
    public String price9(){
        String price = pref.getString(KEY_ORDER_PRICE9,null);
        return price;
    }
    public String price10(){
        String price = pref.getString(KEY_ORDER_PRICE10,null);
        return price;
    }
    public String price11(){
        String price = pref.getString(KEY_ORDER_PRICE11,null);
        return price;
    }
    public String price12(){
        String price = pref.getString(KEY_ORDER_PRICE12,null);
        return price;
    }
    public String price13(){
        String price = pref.getString(KEY_ORDER_PRICE13,null);
        return price;
    }
    public String price14(){
        String price = pref.getString(KEY_ORDER_PRICE14,null);
        return price;
    }
    public String price15(){
        String price = pref.getString(KEY_ORDER_PRICE15,null);
        return price;
    }
    public String price16(){
        String price = pref.getString(KEY_ORDER_PRICE16,null);
        return price;
    }
    public String price17(){
        String price = pref.getString(KEY_ORDER_PRICE17,null);
        return price;
    }
    public String price18(){
        String price = pref.getString(KEY_ORDER_PRICE18,null);
        return price;
    }
    public String price19(){
        String price = pref.getString(KEY_ORDER_PRICE19,null);
        return price;
    }
    public String price20(){
        String price = pref.getString(KEY_ORDER_PRICE20,null);
        return price;
    }

}