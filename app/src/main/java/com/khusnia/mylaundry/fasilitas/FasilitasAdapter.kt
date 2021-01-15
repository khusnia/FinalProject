package com.khusnia.mylaundry.fasilitas

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.khusnia.mylaundry.R

class FasilitasAdapter(private var data: ArrayList<Fasilitas>,
                       private val listener : (Fasilitas) -> Unit)
    : RecyclerView.Adapter<FasilitasAdapter.MyViewHolder>(){

    private lateinit var contextAdapter : Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

        val layoutInflater = LayoutInflater.from(parent.context)
        contextAdapter = parent.context
        val inflaterView : View = layoutInflater.inflate(R.layout.item_row_baner, parent, false)

        return MyViewHolder(inflaterView)

    }

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        holder.bindItem(data[position], listener, contextAdapter)

    }

    class MyViewHolder(view : View) : RecyclerView.ViewHolder(view) {

        private val img: ImageView = view.findViewById(R.id.imageView)

        fun bindItem (data: Fasilitas, listener: (Fasilitas) -> Unit, context: Context){

            Glide.with(context)
                .load(data.gambar)
                .into(img)

            itemView.setOnClickListener {
                listener(data)
            }
        }

    }
}