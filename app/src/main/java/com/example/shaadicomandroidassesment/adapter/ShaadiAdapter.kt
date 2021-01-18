package com.example.shaadicomandroidassesment.adapter

import android.util.Log
import android.view.View
import com.bumptech.glide.Glide
import com.example.shaadicomandroidassesment.R
import com.example.shaadicomandroidassesment.base.RecyclerViewAdapter
import com.example.shaadicomandroidassesment.data.ShaadiData
import com.example.shaadicomandroidassesment.data.ShaadiId
import com.example.shaadicomandroidassesment.data.UserSelected

class ShaadiAdapter : RecyclerViewAdapter<ShaadiData>{

    private lateinit var mClickListeners: ItemClickListener
    private var mList: List<ShaadiData>
    private  var mIsSelectedList: List<UserSelected>?=null

    constructor( mutableList: List<ShaadiData>,mClickListeners: ItemClickListener): super(mutableList) {
        mList=mutableList;
        this.mClickListeners=mClickListeners

    }

    fun setIsSelectedList(mIsSelectedList: List<UserSelected>){
        this.mIsSelectedList=mIsSelectedList
        notifyDataSetChanged()
    }
    override fun onDestroy() {
        Log.d("SASA","SASAS")
    }

    override fun setData(view: ShaadiView, mPosition: Int) {
        Glide.with(view.itemView.getContext())
            .load(mList.get(mPosition).picture.large)
            .into(view.mImageView)
             mIsSelectedList?.let {
                if(mIsSelectedList?.get(mPosition)?.isSelected!!){
                    view.mReject.visibility=View.GONE
                    view.mAccept.visibility=View.GONE
                    view.mIsSelected.text=view.itemView.getContext().getString(R.string.id_seleceted)
                }else{
                    view.mReject.visibility=View.GONE
                    view.mAccept.visibility=View.GONE
                    view.mIsSelected.text=view.itemView.getContext().getString(R.string.id_rejected)
                }
            }
        view.mAccept?.setOnClickListener {
            Log.d("SSA","ACCEPT CLICKED")
            mClickListeners?.onItemClick(mList?.get(mPosition).id,mPosition,it)
        }
        view.mReject?.setOnClickListener {
            Log.d("SSA","ACCEPT CLICKED")
            mClickListeners?.onItemClick(mList?.get(mPosition).id,mPosition,it)
        }
    }

    interface ItemClickListener {
        fun onItemClick(shaadiId: ShaadiId, position: Int, view: View?)
    }
}
