package com.example.listadelacompra;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import java.util.ArrayList;

public class ArticuloAdapter extends ArrayAdapter<Articulo> {
    public ArticuloAdapter(Context context, ArrayList<Articulo> articulos){
        super(context,0,articulos);
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        // Get the data item for this position
        final Articulo articulo = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item, parent, false);
        }
        // Lookup view for data population
        TextView item = (TextView) convertView.findViewById(R.id.item);
        CheckBox checkBox = convertView.findViewById(R.id.checkbox);
        // Populate the data into the template view using the data object
        item.setText(articulo.nombre);
        checkBox.setChecked(articulo.check);
        checkBox.setTag(String.valueOf(position));
        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                articulo.check = isChecked;
            }
        });
        // Return the completed view to render on screen
        return convertView;
    }
}
