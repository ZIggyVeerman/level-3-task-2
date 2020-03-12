package com.example.studentportal

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_view.view.*

class LinkAdapter(private val links: List<Link>) :
  RecyclerView.Adapter<LinkAdapter.ViewHolder>() {

  inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    fun bind(link: Link) {
      itemView.btLink.text = link.name
    }
  }

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
    return ViewHolder(
      LayoutInflater.from(parent.context).inflate(R.layout.item_view, parent, false)
    )
  }

  override fun getItemCount(): Int {
    return links.size
  }

  override fun onBindViewHolder(holder: ViewHolder, position: Int) {
    holder.bind(links[position])
  }
}
