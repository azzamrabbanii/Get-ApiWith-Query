//package com.example.getapiwithquery.ui
//
//import android.util.Log
//import androidx.lifecycle.LiveData
//import androidx.lifecycle.MutableLiveData
//import androidx.lifecycle.ViewModel
//import com.example.getapiwithquery.data.UseridItem
//import com.example.getapiwithquery.network.ApiConfig
//import retrofit2.Call
//import retrofit2.Callback
//import retrofit2.Response
//
//class UserViewModel: ViewModel() {
////    private val listUser = MutableLiveData<Users>()
//    private val listUserId = MutableLiveData<UseridItem>()
//
//    fun searchUserApi(username: Int) {
//        ApiConfig.getApiService().searchUserId(username).enqueue(object : Callback<UseridItem>{
//            override fun onResponse(call: Call<UseridItem>, response: Response<UseridItem>) {
//                listUserId.value = response.body()
//                }
//
//            override fun onFailure(call: Call<UseridItem>, t: Throwable) {
//                Log.e("TAG","onFailure  $t", )
//            }
//
//        })
//    }
//
//
//    // fungsi buat nampilin datanya
//    fun getSearchUser(): LiveData<UseridItem> = listUserId
//}