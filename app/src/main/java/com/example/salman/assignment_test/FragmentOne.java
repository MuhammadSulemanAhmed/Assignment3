package com.example.salman.assignment_test;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentOne extends Fragment {
    RecyclerView recyclerView;
    View view;
    public FragmentOne() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragmentone, container, false);
        ArrayList<Person> arrayList = new ArrayList<Person>();
        for (int i = 0; i < 1000; i++) {
            arrayList.add(new Person(i,i +" id=Suleman" ,"suleman217010@gmail.com" ,"03153420690" ));
        }
        recyclerView = (RecyclerView) view.findViewById(R.id.RecyclerView);
        PersonAdapter customAdapter = new PersonAdapter(getActivity(),arrayList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(customAdapter);
        return view;

    }
}
