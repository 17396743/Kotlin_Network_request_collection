package com.example.myapplication4


import retrofit2.Call
import retrofit2.http.GET

/**
 * 接口声明类
 */
interface UserApiService{
    object url {
        var url : String = "https://gank.io/"
    }

    @GET("api/v2/banners")
    fun getData () : Call<Bean>

}