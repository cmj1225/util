package com.teach.frame10.frame;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadMoreListener;
import com.teach.frame10.R;
import com.teach.frame10.constants.ApiConfig;
import com.teach.frame10.constants.LoadType;


public class BaseActivity extends AppCompatActivity {
    public String TAG = "睚眦";
    public RecyclerView recyclerView;
    public SmartRefreshLayout mRefreshLayout;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        showLog(this.getClass().getName());
    }

    public void showLog(@NonNull Object object) {
        Log.e(TAG, object.toString());
    }

    public void showToast(@NonNull Object object) {
        Toast.makeText(this, object.toString(), Toast.LENGTH_SHORT).show();
    }

    public void initRecycler() {
        recyclerView = findViewById(com.teach.frame10.R.id.recyclerView);
        mRefreshLayout = findViewById(R.id.refreshLayout);
        mRefreshLayout.setOnRefreshLoadMoreListener(new OnRefreshLoadMoreListener() {
            @Override
            public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
                onListLoadMore();
            }

            @Override
            public void onRefresh(@NonNull RefreshLayout refreshLayout) {
                onListRefresh();
            }
        });
        LinearLayoutManager manager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(manager);
    }

    public void onListRefresh() {
    }

    public void onListLoadMore() {
    }
}
