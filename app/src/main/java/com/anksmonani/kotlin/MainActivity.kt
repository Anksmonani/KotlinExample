package com.anksmonani.kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.anksmonani.kotlin.adapter.CustomAdapter
import com.anksmonani.kotlin.api.APIService
import com.anksmonani.kotlin.api.RetrofitBuilder
import com.anksmonani.kotlin.models.UserData
import com.anksmonani.kotlin.models.UserListOutput
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {


    private var mApiService: APIService? = null
    private var mAdapter: CustomAdapter?= null;
    private var mQuestions: MutableList<UserData> = ArrayList()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mApiService = RetrofitBuilder.client.create(APIService::class.java)

        recyclerview!!.layoutManager = LinearLayoutManager(this)

        mAdapter = CustomAdapter(this, mQuestions)
        recyclerview!!.adapter = mAdapter

        fetchDataList()

    }

    private fun fetchDataList() {
        val call = mApiService!!.getUserList();
        call.enqueue(object : Callback<UserListOutput> {

            override fun onResponse(call: Call<UserListOutput>, response: Response<UserListOutput>) {

                val questions = response.body()
                if (questions != null) {
                    mQuestions.addAll(questions.Data)
                    mAdapter!!.notifyDataSetChanged()
                }
            }

            override fun onFailure(call: Call<UserListOutput>, t: Throwable) {
                Log.e(TAG, "Got error : " + t.localizedMessage)
            }
        })
    }

    companion object {
        private val TAG = MainActivity::class.java.simpleName
    }

}