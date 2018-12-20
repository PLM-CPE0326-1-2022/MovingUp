package com.gmail.plmcpesar.k12schoolsearch.models;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gmail.plmcpesar.k12schoolsearch.R;

public class Strand extends Fragment
{
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.searchtab4, container, false);
        return rootView;
    }
}
