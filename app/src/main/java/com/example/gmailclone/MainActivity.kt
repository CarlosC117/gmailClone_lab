package com.example.gmailclone

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    lateinit var emails: MutableList<Email>
    lateinit var emailsRv: RecyclerView
    lateinit var adapter: EmailAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        emailsRv = findViewById(R.id.emailsRv)
        emails = EmailFetcher.getEmails()
        adapter = EmailAdapter(emails)
        emailsRv.adapter = adapter
        emailsRv.layoutManager = LinearLayoutManager(this)

        findViewById<Button>(R.id.loadMoreBtn).setOnClickListener {
            Log.i(TAG, "It was clicked")
            val newEmails = EmailFetcher.getNext5Emails()
            emails.addAll(newEmails)
            adapter.notifyItemRangeInserted(emails.size - newEmails.size, newEmails.size)
            emailsRv.smoothScrollToPosition(emails.size - newEmails.size)
        }


    }
    companion object {
        val TAG = "MainActivity"
    }
}