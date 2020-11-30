package com.lepaya.test.ui.trainer.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import androidx.recyclerview.widget.RecyclerView
import com.lepaya.domain.models.Trainer
import com.lepaya.test.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.rv_item_trainer.view.*
import kotlin.collections.ArrayList

class TrainersAdapter(
    private val onTrainerSelected: (trainerListItem: Trainer) -> Unit
) : RecyclerView.Adapter<TrainersAdapter.ViewHolder>(), Filterable {

    var trainersList = arrayListOf<Trainer>()
    var completeTrainerList = arrayListOf<Trainer>() // For Filter

    fun setTrainersList(trainers: List<Trainer>) {
        this.trainersList.clear()
        this.completeTrainerList.clear()
        this.trainersList.addAll(trainers)
        this.completeTrainerList.addAll(trainers)
        this.notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.rv_item_trainer, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = trainersList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(trainersList[position], position)

    }

    inner class ViewHolder(private var view: View) : RecyclerView.ViewHolder(view) {
        fun bind(trainerListItem: Trainer, position: Int) {
            view.tvFullName.text = trainerListItem.fullName
            view.tvEmail.text = trainerListItem.email
            view.tvCreatedAt.text = trainerListItem.createdAt
            Picasso.get().load(trainerListItem.picture).into(view.ivAvatar)
            view.setOnClickListener { onTrainerSelected(trainerListItem) }

        }
    }

    override fun getFilter(): Filter {
        return object : Filter() {
            override fun performFiltering(constraint: CharSequence?): FilterResults {
                val charSearch = constraint.toString()
                if (charSearch.isEmpty()) {
                     trainersList = completeTrainerList
                } else {
                    val resultList = arrayListOf<Trainer>()
                    for (trainer in trainersList) {
                        if (trainer.createdAt.contains(charSearch)) {
                            resultList.add(trainer)
                        }
                    }

                    trainersList = resultList
                }
                val filterResults = FilterResults()
                filterResults.values = trainersList
                return filterResults
            }

            @Suppress("UNCHECKED_CAST")
            override fun publishResults(constraint: CharSequence?, results: FilterResults?) {
                trainersList = results?.values as ArrayList<Trainer>
                notifyDataSetChanged()
            }

        }
    }


}
