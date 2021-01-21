package com.teach.frame10.frame;

import com.teach.datalibrary.JavaBean;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;


public interface IService {
    @GET("project/list/{page}/json")
    Observable<JavaBean> getBean(@Path("page") Object page, @Query("cid") Object cid);
}
