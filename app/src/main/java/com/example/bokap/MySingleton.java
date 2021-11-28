package com.example.bokap;

import android.content.Context;

import com.android.volley.*;
import com.android.volley.toolbox.*;


public class MySingleton {

    private static MySingleton mInstance;
    private RequestQueue mRequestQueue;
    private Context mCtx;

    public MySingleton(Context mCtx) {
        this.mCtx = mCtx;
        mRequestQueue = getmRequestQueue();
    }

    public RequestQueue getmRequestQueue(){
        if(mRequestQueue == null){
            Cache cache = new DiskBasedCache(mCtx.getCacheDir(),1024*1024);
            Network network = new BasicNetwork(new HurlStack());
            mRequestQueue = new RequestQueue(cache,network);
            mRequestQueue = Volley.newRequestQueue(mCtx.getApplicationContext());
        }
        return mRequestQueue;
    }

    public static synchronized MySingleton getmInstance(Context context){

        if (mInstance == null){
            mInstance = new MySingleton(context);
        }
        return mInstance;
    }


    public<T> void addToRequestQueue(Request<T> request){
        mRequestQueue.add(request);

    }
}