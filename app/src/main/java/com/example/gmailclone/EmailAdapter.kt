package com.example.gmailclone

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class EmailAdapter(private val emails: List<Email>): RecyclerView.Adapter<EmailAdapter.ViewHolder>() {
    // Provide a direct reference to each of the views within a data item
    // Used to cache the views within the item layout for fast access
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        // We also create a constructor that accepts the entire item row
        // and does the view lookups to find each sub-view
        lateinit var sender: TextView
        lateinit var title: TextView
        lateinit var summary: TextView
        init {
            // Stores the itemView in a public final member variable that can be used
            // to access the context from any ViewHolder instance.
            sender = itemView.findViewById(R.id.senderTv)
            title = itemView.findViewById(R.id.titleTv)
            summary  = itemView.findViewById(R.id.summaryTv)

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        // Inflate the custom layout
        val contactView = inflater.inflate(R.layout.email_item, parent, false)
        // Return a new holder instance
        return ViewHolder(contactView)
    }


    // Populate data into the item through the holder
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        // Get the data model based on position
        val email = emails[position]
        // Set item views based on views and data model
        holder.sender.text = email.sender
        holder.title.text = email.title
        holder.summary.text = email.summary

    }


    override fun getItemCount(): Int {
        return emails.size
    }
}

