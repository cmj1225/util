package com.teach.frame10.frame;


public interface ICommonModel<M> {

    void getData(int whichApi,ICommonPresenter pPresenter,M... pMS);

    void getDataWithLoadType(int whichApi,int loadType,ICommonPresenter pPresenter,M... pMS);
}
