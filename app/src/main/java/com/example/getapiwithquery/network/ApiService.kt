package com.example.getapiwithquery.network

import com.example.getapiwithquery.data.UseridItem
import com.example.getapiwithquery.data.Users
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
//    @GET("search/users")
//    fun searchUser(@Query("q") username: String) : Call<Users>

    @GET("comments")
    fun searchUserId(@Query("id") userid: Int) : Call<List<UseridItem>>
}