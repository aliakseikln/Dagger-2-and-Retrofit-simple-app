package com.example.dagger2demokotlin

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.dagger2demokotlin.databinding.RecyclerViewListRowBinding
import com.example.dagger2demokotlin.model.RecyclerData

class RecyclerViewAdapter : RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder>() {

    private var listData: List<RecyclerData>? = null

    fun setUpdatedData(listData: List<RecyclerData>) {
        this.listData = listData
    }

    class MyViewHolder(binding: RecyclerViewListRowBinding) :
        RecyclerView.ViewHolder(binding.root) {
        private val imageView: ImageView = binding.imageView
        private val textViewName: TextView = binding.textViewName
        private val textViewDescription: TextView = binding.textViewDescription

        fun bind(data: RecyclerData) {
            textViewName.text = data.name
            textViewDescription.text = data.description

            Glide.with(imageView)
                .load(data.owner?.avatar_url)
                .apply(RequestOptions.centerCropTransform())
                .into(imageView)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(RecyclerViewListRowBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(listData?.get(position)!!)
    }

    override fun getItemCount(): Int {
        return if (listData == null) 0
        else listData?.size!!
    }
}