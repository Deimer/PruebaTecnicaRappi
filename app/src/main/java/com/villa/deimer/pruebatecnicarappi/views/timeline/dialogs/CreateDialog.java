package com.villa.deimer.pruebatecnicarappi.views.timeline.dialogs;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;

import com.jaredrummler.materialspinner.MaterialSpinner;
import com.villa.deimer.pruebatecnicarappi.R;
import com.villa.deimer.pruebatecnicarappi.events.MessageBusCategory;
import com.villa.deimer.pruebatecnicarappi.events.StationBus;

import java.util.List;

public class CreateDialog {

    private Context context;

    public CreateDialog(Context context) {
        this.context = context;
    }

    public void dialogSelectCategory(List<String> categories) {
        final AlertDialog.Builder builder = new AlertDialog.Builder(context);
        LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        assert inflater != null;
        @SuppressLint("InflateParams")
        View view = inflater.inflate(R.layout.dialog_category, null);
        builder.setView(view);
        final AlertDialog alertDialog = builder.create();
        setElements(view, alertDialog, categories);
        alertDialog.show();
    }

    private void setElements(View view, final AlertDialog alertDialog, List<String> categories) {
        final MaterialSpinner spinner = view.findViewById(R.id.spinner_categories);
        Button but_cancel = view.findViewById(R.id.but_cancel);
        Button but_done = view.findViewById(R.id.but_done);

        spinner.setItems(categories);
        but_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertDialog.dismiss();
            }
        });
        but_done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertDialog.dismiss();
                getIndexOptionMessage(spinner);
            }
        });
    }

    private void getIndexOptionMessage(MaterialSpinner spinner) {
        int option = spinner.getSelectedIndex();
        if(option == 0) {
            StationBus.getBus().post(new MessageBusCategory(false, option));
        } else {
            StationBus.getBus().post(new MessageBusCategory(true, option));
        }
    }

}
