package com.example.administrator.myapplication.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;

import com.dd.CircularProgressButton;
import com.example.administrator.myapplication.R;
import com.example.administrator.myapplication.fragment.FragmentTest1;
import com.example.administrator.myapplication.fragment.FragmentTest2;
import com.example.administrator.myapplication.fragment.FragmentTest3;

import java.util.List;

import butterknife.BindView;
import butterknife.BindViews;
import butterknife.ButterKnife;
import butterknife.OnClick;
import me.yokeyword.fragmentation.SupportActivity;

public class MainActivity  extends SupportActivity {
    @BindViews({R.id.btn_go,R.id.fragment1,R.id.fragment2,R.id.fragment3})
    public List<CircularProgressButton> btnTests;
    @BindView(R.id.drawer_layout)
    DrawerLayout drawer;
    @BindView(R.id.toolbar)
    Toolbar toolbar;

    private ActionBarDrawerToggle actionBarToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState == null) {
            loadRootFragment(R.id.content, FragmentTest1.newInstance());
        }
        ButterKnife.bind(this);
        initToolbar();
    }

    public void initToolbar(){
        actionBarToggle = new ActionBarDrawerToggle(this,drawer,toolbar,R.string.navigation_drawer_close,R.string.navigation_drawer_open);
        drawer.setDrawerListener(actionBarToggle);//让抽屉菜单的按钮改变状态
        actionBarToggle.syncState();
        toolbar.setTitle("小龙虾管理系统");
    }

    //region 按钮点击事件
    @OnClick({R.id.btn_go,R.id.fragment1,R.id.fragment2,R.id.fragment3})
    void onClick(CircularProgressButton c){
        switch (c.getId()){
            case R.id.btn_go:
                btnTests.get(0).setIndeterminateProgressMode(true); //设置不精准模式
                btnTests.get(0).setProgress(0);
                btnTests.get(0).setProgress(50);
                btnTests.get(0).setProgress(100);
                startActivity(new Intent(this,BarChartActivity.class));
                break;
            case R.id.fragment1:
                btnTests.get(1).setIndeterminateProgressMode(true);
                btnTests.get(1).setProgress(0);
                btnTests.get(1).setProgress(50);
                btnTests.get(1).setProgress(100);
                start(FragmentTest1.newInstance());
                break;
            case R.id.fragment2:
                btnTests.get(2).setIndeterminateProgressMode(true);
                btnTests.get(2).setProgress(0);
                btnTests.get(2).setProgress(50);
                btnTests.get(2).setProgress(100);
                start(FragmentTest2.newInstance());
                break;
            case R.id.fragment3:
                btnTests.get(3).setIndeterminateProgressMode(true);
                btnTests.get(3).setProgress(0);
                btnTests.get(3).setProgress(50);
                btnTests.get(3).setProgress(100);
                start(FragmentTest3.newInstance());
                break;
            default:break;
        }

    }
    //endregion

}

