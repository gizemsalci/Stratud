package com.gizemsalcigmail.stratus;

import android.app.ListActivity;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.menu.ListMenuItemView;
import android.text.Layout;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class Questions1Activity extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        database db = new database(getApplicationContext());
        ArrayList<soru> sorular = new ArrayList<soru>();

        sorular =db.getSoruList();
        setListAdapter(new customAdapter(this, sorular));

        //Button btn = new Button(getApplicationContext());






        //soruTv.setText(sorular[0]);
    }
}
