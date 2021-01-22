package com.teach.frame10;

import com.teach.frame10.frame.BaseMvpActivity;
import com.teach.frame10.frame.ICommonModel;

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
