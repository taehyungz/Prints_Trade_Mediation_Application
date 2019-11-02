package com.example.bboba

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.material_cardview.view.*

class ReqCardAdapterMap(val requestLists:ArrayList<Prints_Request>): RecyclerView.Adapter<ReqCardAdapterMap.ViewHolder>() {
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val data: Prints_Request = requestLists[position]
        holder.bind(data)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ReqCardAdapterMap.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return ViewHolder(inflater, parent, parent.context)
        //val view = LayoutInflater.from(parent.context).inflate(R.layout.fragment_list, parent, false)
        //return ViewHolder(view)
    }
    override fun getItemCount(): Int {
        return requestLists.size
    }



    class ViewHolder(inflater: LayoutInflater, parent: ViewGroup, val context: Context) :
        RecyclerView.ViewHolder(inflater.inflate(R.layout.materil_cardview_map, parent, false)) {
        fun bind(data: Prints_Request) {

            itemView.total_page.text = data.total_page + " page"
            itemView.location.text = data.location_name
            itemView.cardButton.setOnClickListener {
                val detailIntent = Intent(context, DetailReqActivity::class.java)
                detailIntent.putExtra("request_data", data)
                context.startActivity(detailIntent)
            }
        }
    }
}