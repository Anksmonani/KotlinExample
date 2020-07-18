package com.anksmonani.kotlin.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.anksmonani.kotlin.R
import com.anksmonani.kotlin.models.UserData
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.row_data.view.*

class CustomAdapter(private val context: Context,private val mDataList: MutableList<UserData>):

    RecyclerView.Adapter<CustomAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.row_data, parent, false)
        return MyViewHolder(view)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.mTvName.text = mDataList[position].GuestName +" "+position+1
        Glide.with(context).load(mDataList[position].GuestImage).into(holder.mUserImage)
    }

    override fun getItemCount(): Int {
        return mDataList.size
    }

    class MyViewHolder(mView: View) : RecyclerView.ViewHolder(mView) {
        val mUserImage = mView.iv_user_image!!
        val mTvName = mView.tv_name!!
    }
}