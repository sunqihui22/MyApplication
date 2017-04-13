package com.example.administrator.myapplication.fragment.basefragment;

import android.app.Activity;

import me.yokeyword.fragmentation.SupportFragment;

public class BaseFragmentTest extends SupportFragment{
    private Activity _mActivity;
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this._mActivity = activity;
    }

}
