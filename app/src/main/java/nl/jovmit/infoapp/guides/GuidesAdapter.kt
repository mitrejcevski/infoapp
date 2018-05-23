package nl.jovmit.infoapp.guides

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import nl.jovmit.infoapp.R
import nl.jovmit.infoapp.extensions.inflate
import nl.jovmit.infoapp.extensions.setImageUrl
import nl.jovmit.infoapp.guides.data.Guide

class GuidesAdapter : RecyclerView.Adapter<GuidesAdapter.GuideViewHolder>() {

    private val guides = mutableListOf<Guide>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GuideViewHolder {
        val view = parent.inflate(R.layout.guide_list_item)
        return GuideViewHolder(view)
    }

    override fun onBindViewHolder(holder: GuideViewHolder, position: Int) {
        holder.bind(guides[position])
    }

    override fun getItemCount(): Int = guides.size

    fun setItems(newItems: List<Guide>) {
        guides.clear()
        guides.addAll(newItems)
        notifyDataSetChanged()
    }

    inner class GuideViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        private val thumbnail = itemView.findViewById<ImageView>(R.id.guideImage)
        private val title = itemView.findViewById<TextView>(R.id.guideTitle)
        private val venue = itemView.findViewById<TextView>(R.id.guideVenue)
        private val endDate = itemView.findViewById<TextView>(R.id.guideEndDate)

        fun bind(guide: Guide) {
            thumbnail.setImageUrl(guide.icon)
            title.text = guide.name
            applyVenueLabel(guide)
            endDate.text = guide.endDate
        }

        private fun applyVenueLabel(guide: Guide) {
            if (guide.venue().isEmpty()) {
                venue.setText(R.string.unknownVenueLabel)
            } else {
                venue.text = guide.venue()
            }
        }
    }
}