package com.gtaskmanager.databaseroompractice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.renderscript.ScriptGroup
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.room.Room
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.launch
import java.util.*

class MainActivity : AppCompatActivity() {
    lateinit var database: ContactDatabase
    lateinit var btngetData: Button
    lateinit var show: TextView
    @InternalCoroutinesApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

      database = ContactDatabase.getdatabase(this)

        btngetData = findViewById(R.id.btndata)
        show = findViewById(R.id.dataaaa)

        GlobalScope.launch {
            database.clearAllTables()
            database.contactDao().insertcontact(Contact(0,"Hassan","1234",Date()))

        }
        btngetData.setOnClickListener {
            getdata()
        }

    }


    fun getdata(){
        database.contactDao().getallcontact().observe(this, Observer {
            show.text = it.toString()
        })
    }
}