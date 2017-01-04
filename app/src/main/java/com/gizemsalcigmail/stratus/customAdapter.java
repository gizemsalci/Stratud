package com.gizemsalcigmail.stratus;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.content.Context;
import android.widget.ArrayAdapter;
import android.widget.RadioButton;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by GizemSalci on 4.1.2017.
 */

public class customAdapter extends ArrayAdapter<soru> {

    private final Context context;
    private final ArrayList<soru> values;

    public customAdapter(Context context, ArrayList<soru> values) {
        super(context, R.layout.activity_questions1, values);
        this.context = context;
        this.values = values;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View rowView = inflater.inflate(R.layout.activity_questions1, parent, false);

        TextView txtsoru = (TextView) rowView.findViewById((R.id.soru));
        RadioButton rba = (RadioButton) rowView.findViewById(R.id.rb_a);
        RadioButton rbb = (RadioButton) rowView.findViewById(R.id.rb_b);
        RadioButton rbc = (RadioButton) rowView.findViewById(R.id.rb_c);

        txtsoru.setText(values.get(position).soru);
        rba.setText(values.get(position).a);
        rbb.setText(values.get(position).b);
        rbc.setText(values.get(position).c);

        return rowView;
    }
}
