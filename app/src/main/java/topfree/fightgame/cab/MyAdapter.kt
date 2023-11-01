package topfree.fightgame.cab

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlin.concurrent.fixedRateTimer

class MyAdapter (val nameList : ArrayList<DataListSilde>) : RecyclerView.Adapter<MyAdapter.ViewHolder>(){

    lateinit var mlistener : onclickListener

    interface onclickListener {
        fun onItemClick(position: Int)
    }

    fun litener(listener : onclickListener) {
        mlistener=listener
    }

    class ViewHolder(iteamView : View, listener: onclickListener) : RecyclerView.ViewHolder(iteamView) {
        val fromText = iteamView.findViewById<TextView>(R.id.from_name_in_sildeshow)
        val toText = iteamView.findViewById<TextView>(R.id.to_name_in_sildeshow)
        init {
            itemView.setOnClickListener {
                listener.onItemClick(adapterPosition)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context).inflate(R.layout.recycle_view_slideshow,parent,false)
        return ViewHolder(inflater,mlistener)
    }

    override fun getItemCount(): Int {
       return nameList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currantPosition = nameList[position]
        holder.fromText.text = currantPosition.from
        holder.toText.text = currantPosition.to

    }
}