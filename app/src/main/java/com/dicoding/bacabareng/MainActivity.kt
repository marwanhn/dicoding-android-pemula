package com.dicoding.bacabareng

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.dicoding.bacabareng.activity.AboutActivity
import com.dicoding.bacabareng.data.BooksData
import com.dicoding.bacabareng.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val actionbar = supportActionBar
        actionbar!!.title = "BacaBareng"

        val booksAdapter = BooksAdapter(BooksData.getBooksList())

        val layoutManager: RecyclerView.LayoutManager = LinearLayoutManager(this)
        binding.rvBooks.layoutManager = layoutManager

        with(binding){
            rvBooks.adapter = booksAdapter
            rvBooks.setHasFixedSize(true)
        }

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.action_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.menu_account -> {
                val launchAbout = Intent(this@MainActivity, AboutActivity::class.java)
                startActivity(launchAbout)
            }
        }
        return super.onOptionsItemSelected(item)
    }


}