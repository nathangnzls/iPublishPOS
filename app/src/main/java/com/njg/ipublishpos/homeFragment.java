package com.njg.ipublishpos;


import android.content.Intent;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.Toast;

import com.github.clans.fab.FloatingActionButton;
import com.njg.ipublishpos.adapter.DBAdapter;
import com.njg.ipublishpos.adapter.SampleAdapter;

/**
 * Created by tapdashheuristics on 1/9/17.
 */

public class homeFragment extends Fragment {

    FloatingActionButton btnOrder;
    Button test;
    DBAdapter myDB;
    public FragmentParent fragmentParents;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fab_home, null);

        btnOrder = (FloatingActionButton) view.findViewById(R.id.btnAddOrder);
        test = (Button) view.findViewById(R.id.btnTest);
        myDB = new DBAdapter(getActivity());
        myDB.open();
        test.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                myDB.open();
                myDB.getAllItems("Foods");
                String a = myDB.item;
                String b= myDB.id;
                String c = myDB.price;
              //  Cursor ab = myDB.getAllItemRows("Foods");
               // int x = ab.getCount();
                //if(a.equals("")){
                //    Toast.makeText(getActivity(),ab.getCount()+"",Toast.LENGTH_SHORT).show();
                //}else{
               //     Toast.makeText(getActivity(),a+" "+b+" "+c ,Toast.LENGTH_SHORT).show();
               // }
                //Cursor crs = myDB.rawQuery("SELECT * FROM "+DBAdapter.CATEGORY_TABLE, null);
               // String val = crs.getString(crs.getColumnIndex(DBAdapter.KEY_CATEGORY_ITEM))+"";;
                //Toast.makeText(getActivity(),"",Toast.LENGTH_SHORT).show();
                myDB.close();
            }
        });

        getid();

        GridView gridview = (GridView) view.findViewById(R.id.gridview);
        gridview.setAdapter(new SampleAdapter(getActivity()));

        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                Toast.makeText(getActivity(), "" + position,Toast.LENGTH_SHORT).show();
            }
        });

        btnOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(getActivity(),"TEST",Toast.LENGTH_LONG).show();
                Intent i = new Intent(getActivity(),OrderClass.class);

                //fragmentParents.addPage();
                startActivity(i);
            }
        });

        return view;
    }

    public void getid(){
        fragmentParents = (FragmentParent) getFragmentManager().findFragmentById(R.id.fragmentParent);
    }




}
