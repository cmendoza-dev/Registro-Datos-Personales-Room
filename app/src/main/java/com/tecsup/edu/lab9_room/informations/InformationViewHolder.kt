package com.tecsup.edu.lab9_room.informations

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.tecsup.edu.lab9_room.R

class InformationViewHolder (inflater: LayoutInflater, parent: ViewGroup) :
    RecyclerView.ViewHolder(inflater.inflate(R.layout.item_information, parent, false))
{
    private var textNames : TextView? = null
    private var textPhoneNumber : TextView? = null
    private var textEmail : TextView? = null
    private var textAddress : TextView? = null

    init {
        textNames = itemView.findViewById(R.id.textNames)
        textPhoneNumber = itemView.findViewById(R.id.textPhoneNumber)
        textEmail = itemView.findViewById(R.id.textEmail)
        textAddress = itemView.findViewById(R.id.textAddress)

    }

    fun bind(information: Information){
        textNames?.text = information.first_last_name
        textPhoneNumber?.text = information.phone_number
        textEmail?.text = information.email
        textAddress?.text = information.address
    }


}