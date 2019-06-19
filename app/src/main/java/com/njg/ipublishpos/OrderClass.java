package com.njg.ipublishpos;

import android.annotation.SuppressLint;
import android.app.ActionBar;
import android.app.ActionBar.Tab;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.njg.ipublishpos.adapter.DBAdapter;
import com.njg.ipublishpos.adapter.SampleAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tapdashheuristics on 1/11/17.
 */

public class OrderClass extends AppCompatActivity {
    Button buttonAddPage;
    public FragmentParent fragmentParent;
    TextView textView;
    DBAdapter myDB;
    DBAdapter.DatabaseHelper myDBhelper;
    SQLiteDatabase db;
    String[] productname;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.order_layout);
        getIDs();

        myDB = new DBAdapter(getApplicationContext());
        myDBhelper = new DBAdapter.DatabaseHelper(getApplicationContext());
        db = myDBhelper.getWritableDatabase();

        ListView lv1 = (ListView) findViewById(R.id.listv);
        myDB.open();

        Cursor crs = db.rawQuery("SELECT * FROM "+DBAdapter.CATEGORY_TABLE, null);
        while(crs.moveToNext())
        {
            String cat = crs.getString(crs.getColumnIndex(DBAdapter.KEY_CATEGORY_ITEM));
            // System.out.println(cat);
            //arr.add(cat);
            fragmentParent.addPage(cat);
            System.out.println(cat);
        }
        List<String> your_array_list = new ArrayList<String>();
        your_array_list.add("foo");
        your_array_list.add("bar");

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_1,
                your_array_list );

        lv1.setAdapter(arrayAdapter);


        myDB.close();

    }

    private void getIDs() {

        fragmentParent = (FragmentParent) getSupportFragmentManager().findFragmentById(R.id.fragmentParent);
    }

}
