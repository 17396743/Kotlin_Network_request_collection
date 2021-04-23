package com.example.myapplication4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.widget.Toast
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initData()
    }

    fun initData() {
        //创建Retrofit对象
        var retrofit = Retrofit.Builder().baseUrl(UserApiService.url.url)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create()).build()

        //创建请求接口类
        var userApiService = retrofit.create(UserApiService::class.java)
        userApiService.getData().enqueue(object : retrofit2.Callback<Bean> {
            override fun onFailure(call: Call<Bean>, t: Throwable) {

            }

            override fun onResponse(call: Call<Bean>, response: Response<Bean>) {

                var Bean = response.body()
                Log.d("TAG", "onResponse: "+"" + Bean?.data?.get(0)?.title)
            }

        })
    }
}