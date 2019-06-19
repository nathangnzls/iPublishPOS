package com.njg.ipublishpos.adapter;

import android.content.Context;
import android.database.Cursor;
import android.support.v4.widget.CursorAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.njg.ipublishpos.R;
import com.njg.ipublishpos.manageData;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tapdashheuristics on 1/25/17.
 */
public class CAdapter extends CursorAdapter {

    public CAdapter(Context context, Cursor cursor) {
        super(context, cursor, 0);
    }
    public static ArrayAdapter<String> arrayAdapter1;
    // The newView method is used to inflate a new view and return it,
    // you don't bind any data to the view at this point.
    @Override
    public View newView(Context context, Cursor cursor, final ViewGroup parent) {
        return LayoutInflater.from(context).inflate(R.layout.orderlayout_parent, parent, false);
    }

    // The bindView method is used to bind all data to a given view
    // such as setting the text on a TextView.
    @Override
    public void bindView(final View view, Context context, final Cursor cursor) {
        // Find fields to populate in inflated template
        TextView orderID = (TextView) view.findViewById(R.id.Orderitemid);
        final TextView orderProduct = (TextView) view.findViewById(R.id.txtOrderListItem);
        TextView orderPrice = (TextView) view.findViewById(R.id.txtOrderListPrice);
        TextView addOrder = (TextView) view.findViewById(R.id.txtAddorder);
        TextView removeOrder = (TextView) view.findViewById(R.id.txtRemoveOrder);
        // Extract properties from cursor
        final String _id = cursor.getString(cursor.getColumnIndexOrThrow(DBAdapter.KEY_ITEM_ID));
        final String product = cursor.getString(cursor.getColumnIndexOrThrow(DBAdapter.KEY_ITEM_ITEM));
        final String price = cursor.getString(cursor.getColumnIndexOrThrow(DBAdapter.KEY_ITEM_PRICE));
        // Populate fields with extracted properties
        orderID.setText(_id);
        orderProduct.setText(product);
        orderPrice.setText(price);
        final manageData manageData = new manageData(view.getContext());
        addOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


            }
        });

    }
}