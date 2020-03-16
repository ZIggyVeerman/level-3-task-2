package com.example.studentportal

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_view.view.*

class LinkAdapter(private val links: List<Link>, private val clickListener: (Link) -> Unit) :
  RecyclerView.Adapter<RecyclerView.ViewHolder>() {

  inner class LinkViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    fun bind(link: Link, clickListener: (Link) -> Unit) {
      itemView.btLink.text = link.name
      itemView.setOnClickListener{ clickListener(link)}
    }
  }

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
    return LinkViewHolder(
      LayoutInflater.from(parent.context).inflate(R.layout.item_view, parent, false)
    )
  }

  override fun getItemCount(): Int {
    return links.size
  }

  override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
    (holder as LinkViewHolder).bind(links[position], clickListener)
  }
}
