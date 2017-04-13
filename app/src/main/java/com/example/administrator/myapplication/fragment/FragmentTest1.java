package com.example.administrator.myapplication.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.administrator.myapplication.R;

import me.yokeyword.fragmentation.SupportFragment;

/**
 * Created by Administrator on 2017/4/1.
 */

public class FragmentTest1 extends SupportFragment {
    private TextInputLayout inputLayout;
    public static FragmentTest1 newInstance(){
        return new FragmentTest1();
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragmenttest1, container, false);
        inputLayout = (TextInputLayout) view.findViewById(R.id.input);
        return view;
    }
}
