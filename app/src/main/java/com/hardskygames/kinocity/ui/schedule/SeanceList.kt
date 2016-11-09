package com.hardskygames.kinocity.ui.schedule

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.hardskygames.kinocity.R
import com.hardskygames.kinocity.entity.Seance
import org.greenrobot.eventbus.EventBus
import java.util.*
import javax.inject.Inject

/**
 * @author Nikolay Mihailov <hardsky@yandex.ru>  on 15.10.16.
 */

class SeanceListAdapter : RecyclerView.Adapter<SeanceListViewHolder>() {

    @Inject
    lateinit var bus: EventBus

    val filmList = ArrayList<Seance>()

    override fun onBindViewHolder(holder: SeanceListViewHolder, position: Int) {
        holder.setData(filmList[position])
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): SeanceListViewHolder {
        val inflater = parent!!.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        return SeanceListViewHolder(bus, inflater.inflate(R.layout.vew_seance_item, null))
    }

    override fun getItemCount(): Int {
        return filmList.size
    }

    fun setData(lst: List<Seance>) {
        filmList.clear()
        filmList.addAll(lst)
    }
}

class SeanceListViewHolder(private val bus: EventBus, itemView: View) : RecyclerView.ViewHolder(itemView) {
    val layout: View
    val txtTime: TextView
    val txtName: TextView
    val txtAddress: TextView
    val context: Context

    init {
        layout = itemView
        txtTime = itemView.findViewById(R.id.txtTime) as TextView
        txtName = itemView.findViewById(R.id.txtName) as TextView
        txtAddress = itemView.findViewById(R.id.txtAddress) as TextView
        context = itemView.context
    }

    fun setData(seance: Seance) {
        txtTime.text = seance.time
        txtName.text = seance.name
        txtAddress.text = seance.address
        layout.setOnClickListener { bus.post(SeanceClickEvent(seance.name, seance.lon, seance.lat)) }
    }
}