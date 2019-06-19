package com.njg.ipublishpos;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.database.Cursor;
import android.os.Bundle;

import android.support.v4.widget.SimpleCursorAdapter;
import android.support.v7.app.AlertDialog;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.github.clans.fab.FloatingActionButton;
import com.njg.ipublishpos.adapter.DBAdapter;

/**
 * Created by tapdashheuristics on 1/11/17.
 */

public class ItemsActivity extends Activity {
    Dialog dialog;
    FloatingActionButton btnAddItems;
    ListView lv;
    DBAdapter myDB;
    String categoryname;
        @Override
        public void onCreate(Bundle saveInstanceState){
            super.onCreate(saveInstanceState);
            setContentView(R.layout.fab_items);
            Bundle bundle = getIntent().getExtras();
            categoryname = bundle.getString("categoryname");
            //txt.setText(categoryname);
            btnAddItems = (FloatingActionButton) findViewById(R.id.btnAddItems);
            lv = (ListView) findViewById(R.id.lv);

            lv.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
                @Override
                public boolean onItemLongClick(AdapterView<?> parent, View view, int position, final long id) {
                    dialog = new Dialog(ItemsActivity.this);
                    dialog.setContentView(R.layout.longpressedoptiontwo_layout);
                    dialog.setTitle("Select Action");
                    Button btnEdit,btnRemove;
                    btnEdit = (Button) dialog.findViewById(R.id.btnEditItem);
                    btnRemove = (Button) dialog.findViewById(R.id.btnRemoveItem);

                    btnEdit.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            dialog.dismiss();
                            LayoutInflater li = LayoutInflater.from(ItemsActivity.this);
                            final LinearLayout newNoteBaseLayout = (LinearLayout) li.inflate(R.layout.edit_list_dialog, null);
                            AlertDialog.Builder builder = new AlertDialog.Builder(ItemsActivity.this);
                            final EditText editItemName = (EditText)newNoteBaseLayout.findViewById(R.id.etEditItemName);
                            final EditText editItemPrice = (EditText)newNoteBaseLayout.findViewById(R.id.etEditItemPrice);
                            final Cursor cursor = myDB.getItemRow(id);
                            String name = cursor.getString(DBAdapter.COL_ITEM_ITEM);
                            String price = cursor.getString(DBAdapter.COL_ITEM_PRICE);
                            editItemName.setText(name);
                            editItemPrice.setText(price);
                            builder.setPositiveButton("CONFIRM", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    if(!TextUtils.isEmpty(editItemName.getText().toString())&&!TextUtils.isEmpty(editItemPrice.getText().toString())) {
                                        if (cursor.moveToFirst()) {
                                            String itemname = editItemName.getText().toString();
                                            String itemprice = editItemPrice.getText().toString();
                                            myDB.updateItemRow(id, itemname, itemprice, categoryname);
                                        }
                                        cursor.close();
                                        populatListView();
                                    }
                                    Toast.makeText(ItemsActivity.this, "Category successfully edited!", Toast.LENGTH_LONG).show();
                                }
                            });
                            builder.setNegativeButton("Cancel", null).setTitle("Edit Item/Product");
                            builder.setView(newNoteBaseLayout);
                            builder.show();
                        }
                    });

                    btnRemove.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            dialog.dismiss();
                            AlertDialog.Builder builder = new AlertDialog.Builder(ItemsActivity.this);
                            builder.setTitle("Do you really want to remove this Item/Product?");
                            builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.dismiss();
                                    myDB.deleteItemRow(id);
                                    populatListView();
                                    dialog.dismiss();
                                    Toast.makeText(ItemsActivity.this,"Item/Product successfully deleted!",Toast.LENGTH_LONG).show();
                                }
                            });
                            builder.setNegativeButton("Cancel", null);
                            builder.show();
                        }
                    });
                    dialog.show();
                    return false;
                }
            });

            registerForContextMenu(lv);
            openDB();
            populatListView();
            btnAddItems.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //Toast.makeText(ItemsActivity.this,"Test",Toast.LENGTH_LONG).show();
                    dialog = new Dialog(ItemsActivity.this);
                    dialog.setContentView(R.layout.new_item_dialog);
                    dialog.setTitle("New Item/Product");

                    final EditText itemName,itemPrice;
                    Button btnSave;
                    itemName = (EditText) dialog.findViewById(R.id.etNewItemName);
                    itemPrice = (EditText) dialog.findViewById(R.id.etNewItemPrice);
                    btnSave = (Button) dialog.findViewById(R.id.btnSaveNewItem);

                    btnSave.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            String iName = itemName.getText().toString();
                            String iPrice = itemPrice.getText().toString();
                            if(iName.length()>0&&iPrice.length()>0){
                            //Toast.makeText(ItemsActivity.this,iName+" "+iPrice,Toast.LENGTH_LONG).show();
                                myDB.insertItemRow(categoryname,iPrice,iName);
                                dialog.dismiss();
                                Toast.makeText(ItemsActivity.this,"Item/Product successfully added!",Toast.LENGTH_LONG).show();

                            }else{
                                Toast.makeText(ItemsActivity.this,"Fields Cannot be empty!",Toast.LENGTH_LONG).show();
                            }
                            populatListView();

                        }
                    });

                    dialog.show();

                }
            });
        }

    private void populatListView(){
        Cursor cursor = myDB.getAllItemRows(categoryname);
        String[] fromfieldnames = new String[] {DBAdapter.KEY_ITEM_ID,DBAdapter.KEY_ITEM_ITEM,DBAdapter.KEY_ITEM_PRICE,DBAdapter.KEY_ITEM_CATEGORY};
        int[] toViewIDs = new int[] {R.id.itemid,R.id.txtListItem,R.id.txtListPrice};
        SimpleCursorAdapter myCursorAdapter;
        myCursorAdapter = new SimpleCursorAdapter(getApplicationContext(),R.layout.itemslayout_parent,cursor,fromfieldnames,toViewIDs,0);
        lv.setAdapter(myCursorAdapter);
    }

    public void onClick_clear(){
        myDB.deleteAllItem(categoryname);
        populatListView();
    }


    private void openDB(){
        myDB = new DBAdapter(getApplicationContext());
        myDB.open();
    }

    @Override
    public void onDestroy(){
        super.onDestroy();
        closeDB();
    }
    private void closeDB(){
        myDB.close();
    }


}
