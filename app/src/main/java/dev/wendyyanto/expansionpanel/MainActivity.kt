package dev.wendyyanto.expansionpanel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import androidx.recyclerview.widget.LinearLayoutManager
import dev.wendyyanto.expansionpanel.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val view = ActivityMainBinding.inflate(LayoutInflater.from(this))
        val adapter = DataAdapter(listOf("First", "Second", "Third", "Four", "Five", "First", "Second", "Third", "Four", "Five"))
        view.rvList.layoutManager = LinearLayoutManager(this)
        view.rvList.adapter = adapter
        setContentView(view.root)
    }
}