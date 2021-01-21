package com.teach.frame10;

import android.view.View;

import com.teach.frame10.constants.ApiConfig;
import com.teach.frame10.constants.LoadType;
import com.teach.frame10.demo.DemoAdapter;
import com.teach.frame10.demo.DemoModel;
import com.teach.frame10.frame.BaseMvpActivity;
import com.teach.frame10.frame.ICommonModel;
import com.yiyatech.utils.newAdd.SharedPrefrenceUtils;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseMvpActivity {


    @Override
    public int setLayout() {
        return R.layout.activity_main;
    }

    @Override
    public void setUpView() {

    }

    @Override
    public void setUpData() {

    }

    @Override
    public ICommonModel setModel() {
        return null;
    }

    @Override
    public void onDataBack(int whichApi, Object... pObjects) {

    }


}
