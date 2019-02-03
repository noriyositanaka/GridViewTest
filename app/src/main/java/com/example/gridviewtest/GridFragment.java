package com.example.gridviewtest;

import android.arch.lifecycle.ViewModelProviders;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GridFragment extends Fragment{

    private GridViewModel mViewModel;

    public static GridFragment newInstance() {
        return new GridFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {


        String[] cars = {"succeed","escude","wagonr"};

        Resources resources = getResources();

        int i = 0;
        int j = 0;

        List<Item> list = new ArrayList<>();
        for(i=0;i<cars.length;i++) {
            Map<String,String> map = new HashMap<>();


            System.out.println(cars[i].length());
            int identifier = getResources().getIdentifier(cars[i], "array", getActivity().getPackageName());
            String[] c;
            c = resources.getStringArray(identifier);
            map.put("syamei",cars[i]);
            map.put("maker",c[0]);
            map.put("spec",c[1]);
            map.put("drive",c[2]);
            Item item = new Item(map);
            list.add(item);
        }

        View v= inflater.inflate(R.layout.grid_fragment, container, false);

        GridView gridView = v.findViewById(R.id.gridViewOnFragmen);
        GridAdapter gridAdapter = new GridAdapter(getActivity().getApplication(),R.layout.layout_each_item,list);
        gridView.setAdapter(gridAdapter);


        return v;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(GridViewModel.class);
        // TODO: Use the ViewModel


    }

}
