package com.teach.frame10.frame;

import android.app.Activity;
import android.util.Log;

import androidx.fragment.app.Fragment;

import com.teach.frame10.constants.LoadType;
import com.teach.frame10.design.LoadView;
import com.teach.frame10.frame.ICommonModel;
import com.teach.frame10.frame.ICommonPresenter;
import com.teach.frame10.frame.ICommonView;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import io.reactivex.disposables.Disposable;


public class CommonPresenter<V extends ICommonView, M extends ICommonModel> implements ICommonPresenter {
    private WeakReference<V> mView;
    private WeakReference<M> mModel;
    public List<Disposable> mDisposables;
    private LoadView mLoadView;
    private List<String> mApiList;//用于添加并发网络请求的标识


    public CommonPresenter(V pView, M pModel) {
        mView = new WeakReference<>(pView);
        mModel = new WeakReference<>(pModel);
        if (mDisposables == null) mDisposables = new ArrayList<>();
        mApiList = new LinkedList<>();
    }

  
    @Override
    public void getData(int whichApi, Object... pObjects) {
        if (mModel != null && mModel.get() != null) mModel.get().getData(whichApi, this, pObjects);
        else Log.e(this.getClass().getSimpleName(), "getData: model maybe null");
        controlLoading(whichApi);
    }

    private void controlLoading(int whichApi) {
        if (mView != null && mView.get() != null) {
            Activity activity = mView.get() instanceof Activity? (Activity) mView.get():((Fragment) mView.get()).getActivity();
            //loadview使用了单例，一个页面销毁后改示例仍存在，所以再activity销毁前将该对象置空，方便下个页面再次创对象
            mLoadView = LoadView.getInstance(activity, "");
            if (!mLoadView.isShowing()) mLoadView.show();
            if (!mApiList.contains(whichApi)) mApiList.add(String.valueOf(whichApi));
        }
    }


    @Override
    public void getDataWithLoadType(int whichApi, int loadType, Object... pObjects) {
        if (mModel != null && mModel.get() != null)
            mModel.get().getDataWithLoadType(whichApi, loadType, this, pObjects);
        else Log.e(this.getClass().getSimpleName(), "getData: model maybe null");
        if (loadType == LoadType.NORMAL) controlLoading(whichApi);
    }


    @Override
    public void onSuccess(int whichApi, Object... pObjects) {
        String s = String.valueOf(whichApi);
        if (mApiList.contains(s)) mApiList.remove(s);
        if (mApiList.size() == 0 )  cancelLoadingView();
        if (mView != null && mView.get() != null) mView.get().onSuccess(whichApi, pObjects);
    }

    @Override
    public void onSuccessWithLoadType(int whichApi, int loadType, Object[] pObjects) {
        if (mView != null && mView.get() != null)
            mView.get().onSuccessWithLoadType(whichApi, loadType, pObjects);
        cancelLoadingView();
    }

    public void cancelLoadingView() {
        if (mLoadView != null && mLoadView.isShowing()) {
            mLoadView.dismiss();
        }
    }

    @Override
    public void onFailed(int whichApi, Throwable pThrowable) {
        if (mApiList.contains(whichApi)) mApiList.remove(String.valueOf(whichApi));
        if (mApiList.size() == 0 )  cancelLoadingView();
        if (mView != null && mView.get() != null) {
            mView.get().onFailed(whichApi, pThrowable);
        }
    }

    public void finishConnected() {
        if (mDisposables != null && mDisposables.size() != 0) {
            for (Disposable disposable : mDisposables) {
                if (disposable != null && !disposable.isDisposed()) disposable.dispose();
            }
        }
        mDisposables.clear();
        mDisposables = null;
        if (mView != null) mView.clear();
        if (mModel != null) mModel.clear();
        mView = null;
        mModel = null;
        if (mApiList.size() != 0) mApiList.clear();
    }
}
