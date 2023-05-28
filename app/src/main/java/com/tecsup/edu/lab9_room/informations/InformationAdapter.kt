package com.tecsup.edu.lab9_room.informations

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.widget.AdapterView.OnItemClickListener
import android.view.ViewGroup

class InformationAdapter():
    RecyclerView.Adapter<InformationViewHolder>() {

        private var informationLista = emptyList<Information>()

        fun setInformation(informations: List<Information>){
            this.informationLista = informations
            this.notifyDataSetChanged()
        }

        override fun getItemCount(): Int{
            return informationLista.size
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): InformationViewHolder {
        var inflater = LayoutInflater.from(parent.context)
        return InformationViewHolder(inflater, parent)
    }

    override fun onBindViewHolder(holder: InformationViewHolder, position: Int) {
        val information : Information = informationLista[position]
        holder.bind(information)
    }

    interface ItemClickListener{

        fun onItemClickListener(informationItem: Information)

    }





    }
