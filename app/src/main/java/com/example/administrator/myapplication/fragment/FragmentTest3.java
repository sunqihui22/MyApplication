package com.example.administrator.myapplication.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.administrator.myapplication.R;
import com.example.administrator.myapplication.fragment.basefragment.BaseFragmentTest;

/**
 * Created by Administrator on 2017/4/1.
 */

public class FragmentTest3 extends BaseFragmentTest{
    public static FragmentTest3 newInstance(){
        return new FragmentTest3();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragmenttest3,container,false);
        return view;
    }
}
