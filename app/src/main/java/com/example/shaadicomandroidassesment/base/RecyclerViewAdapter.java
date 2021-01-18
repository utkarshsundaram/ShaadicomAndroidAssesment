package com.example.shaadicomandroidassesment.base;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.shaadicomandroidassesment.R;
import com.example.shaadicomandroidassesment.adapter.ShaadiAdapter;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public abstract class RecyclerViewAdapter<E> extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<E> mList;


    public RecyclerViewAdapter(List<E> objects) {
        mList = objects;

    }

    public class ShaadiView extends RecyclerViewHolder {

        public Button mAccept, mReject;
        public TextView mName,mIsSelected;
        public ImageView mImageView;

        public ShaadiView(View view) {
            super(view);
            mImageView = view.findViewById(R.id.imageView);
            mName = view.findViewById(R.id.textView_name);
            mAccept = view.findViewById(R.id.button_accept);
            mReject = view.findViewById(R.id.button_reject);
            mIsSelected=view.findViewById(R.id.textView_selected);

        }
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_item_shaadi_profile, parent, false);
        return new ShaadiView(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
       ShaadiView shaadiView =(ShaadiView)holder;
       setData(shaadiView,position);

    }


    /*
     * (non-Javadoc)
     *
     * @see androidx.recyclerview.widget.RecyclerView.Adapter#getItemCount()
     */
    @Override
    public int getItemCount() {
        return mList.size();
    }

    public List<E> getItems() {
        return mList;
    }

    public E getItemAtPosition(int position) {
        if (position >= mList.size() || position < 0)
            return null;
        return mList.get(position);
    }



    public abstract static class RecyclerViewHolder extends RecyclerView.ViewHolder {
        public RecyclerViewHolder(View itemView) {
            super(itemView);
        }
    }

    public abstract void onDestroy();


    public abstract void setData(ShaadiView view,int mPosition);
}
