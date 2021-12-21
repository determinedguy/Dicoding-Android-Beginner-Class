package com.muhammadathallah.dicodingandroidbeginner

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.muhammadathallah.dicodingandroidbeginner.aboutme.AboutMe
import com.muhammadathallah.dicodingandroidbeginner.language.Language
import com.muhammadathallah.dicodingandroidbeginner.language.LanguageAdapter
import com.muhammadathallah.dicodingandroidbeginner.language.LanguageData

class MainActivity : AppCompatActivity() {
    private lateinit var rvLanguage: RecyclerView
    private var list: ArrayList<Language> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val actionbar = supportActionBar
        actionbar!!.title= "Top 10 Bahasa Pemrograman 2021"

        rvLanguage = findViewById(R.id.rv_language)
        rvLanguage.setHasFixedSize(true)

        list.addAll(LanguageData.listData)
        showRecyclerList()
    }

    private fun showRecyclerList() {
        rvLanguage.layoutManager = LinearLayoutManager(this)
        val languageAdapter = LanguageAdapter(list)
        rvLanguage.adapter = languageAdapter
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        setMode(item.itemId)
        return super.onOptionsItemSelected(item)
    }

    private fun setMode(selectedMode: Int) {
        when (selectedMode) {
            R.id.miCompose -> {
                val iAboutMe = Intent(this@MainActivity,
                    AboutMe::class.java)
                startActivity(iAboutMe)
            }
        }
    }
}