package com.example.shaadicomandroidassesment.ui

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.shaadicomandroidassesment.R
import com.example.shaadicomandroidassesment.adapter.ShaadiAdapter
import com.example.shaadicomandroidassesment.base.RecyclerViewAdapter
import com.example.shaadicomandroidassesment.data.ShaadiId
import com.example.shaadicomandroidassesment.viewmodel.ShaadiViewModel
import org.koin.android.viewmodel.ext.android.viewModel
class ShaadiActivity:AppCompatActivity() ,ShaadiAdapter.ItemClickListener{
    private lateinit var adapter: ShaadiAdapter
    private val viewModel: ShaadiViewModel by viewModel<ShaadiViewModel>()
    private lateinit var recyclerView: RecyclerView
    private lateinit var progressBar: ProgressBar
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView=findViewById(R.id.fragment_search_user_rv)
        progressBar=findViewById(R.id.fragment_search_user_progress)
    }

    override fun onResume() {
        super.onResume()
        viewModel.getShaadiData()
        progressBar.visibility=View.VISIBLE
        viewModel.users.observe(this, Observer {configureRecyclerView()
            progressBar.visibility=View.GONE})

    }

    private fun configureRecyclerView(){
        adapter = ShaadiAdapter(viewModel.users.value!!,this)
        val mLinearLayoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = mLinearLayoutManager
        recyclerView.adapter = adapter

        viewModel.getUserSelectedList();
        viewModel.userSelected.observe(this, Observer {configureRecyclerView()
             adapter?.setIsSelectedList(viewModel.userSelected.value!!)
             progressBar.visibility=View.GONE})
    }

    override fun onItemClick(shaadiId: ShaadiId, position: Int, view: View?) {
      when(view?.id){
          R.id.button_accept->{
              viewModel.postIsUserSelected(shaadiId,true)
          }
          R.id.button_reject->{
              viewModel.postIsUserSelected(shaadiId,false)
          }
      }
    }
}