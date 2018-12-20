package com.gmail.plmcpesar.k12schoolsearch.models;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.gmail.plmcpesar.k12schoolsearch.R;

import org.w3c.dom.Text;

public class School extends Fragment
{
    private EditText edtx1;
    private TextView searchpass1;
    String param1;

    @Override
    public void onCreate( Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        if (getArguments()!=null)
        {
            param1 = getArguments().getString("params");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.searchtab1, container, false);
        searchpass1 = (TextView) rootView.findViewById(R.id.section_label);
        searchpass1.setText(param1);
        return rootView;
    }


}
