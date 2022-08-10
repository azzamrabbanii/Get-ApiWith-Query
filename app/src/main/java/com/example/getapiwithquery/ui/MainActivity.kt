package com.example.getapiwithquery.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.getapiwithquery.data.UseridItem
import com.example.getapiwithquery.databinding.ActivityMainBinding
import com.example.getapiwithquery.network.ApiConfig
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding as ActivityMainBinding

    private val queryAdapter = AdapterQuery()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        getSearch()
    }

    private fun getSearch() {
        binding.searchView.setOnQueryTextListener(object  : SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
                query?.let {
                    getDataApi(it.toInt())
                }
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                return false
            }

        })
    }

    private fun setRecyclerView(it: List<UseridItem>) {
        binding.rvUserID.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = queryAdapter
            queryAdapter.setData(it)
        }
    }

    private fun getDataApi(id : Int) {
        ApiConfig.getApiService().searchUserId(id).enqueue(object : Callback<List<UseridItem>> {
            override fun onResponse(
                call: Call<List<UseridItem>>,
                response: Response<List<UseridItem>>
            ) {
                response.body()?.let {
                    setRecyclerView(it)
                }
            }

            override fun onFailure(call: Call<List<UseridItem>>, t: Throwable) {
                Log.e("TAG", "onFailure: $t")
            }

        })
    }
}