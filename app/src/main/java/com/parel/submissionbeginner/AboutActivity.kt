package com.parel.submissionbeginner

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import android.widget.ImageView
import android.widget.TextView

class AboutActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)

        val actionBar = supportActionBar // Use 'supportActionBar' for compatibility
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true)
        }

        val tvName: TextView = findViewById(R.id.tv_about_name)
        val tvEmail: TextView = findViewById(R.id.tv_about_email)
        val imgPhoto: ImageView = findViewById(R.id.img_about_photo)

        tvName.text = getString(R.string.about_name)
        tvEmail.text = getString(R.string.about_email)
        imgPhoto.setImageResource(R.drawable.me)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                finish() // Close the activity and go back
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}
