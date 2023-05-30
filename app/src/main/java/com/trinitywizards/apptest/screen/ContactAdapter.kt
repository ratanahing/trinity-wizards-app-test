package com.trinitywizards.apptest.screen

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.trinitywizards.apptest.R
import com.trinitywizards.apptest.models.Contact

class ContactAdapter (
    private val context: Context,
    private val contacts: List<Contact>,
    private val itemClickListener: ItemClickListener
) : RecyclerView.Adapter<ContactAdapter.ViewHolder>() {

    interface ItemClickListener {
        fun onItemClick(contact: Contact)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_contact, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount() = contacts.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(contacts[position])
    }


    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val name1 = itemView.findViewById<TextView>(R.id.name1)
        private val name2 = itemView.findViewById<TextView>(R.id.name2)

        fun bind(contact: Contact) {
            name1.text = contact.firstName + contact.lastName
            name2.text = contact.firstName + contact.lastName
            itemView.setOnClickListener {
                itemClickListener.onItemClick(contact)
            }
        }
    }

}