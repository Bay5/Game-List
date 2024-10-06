package com.parel.submissionbeginner

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat.startActivity
import com.parel.submissionbeginner.Hero
import com.parel.submissionbeginner.R

class DetailActivity : AppCompatActivity() {

    private lateinit var imgPhoto: ImageView
    private lateinit var tvName: TextView
    private lateinit var tvDescription: TextView
    private lateinit var tvGenre: TextView
    private lateinit var tvYear: TextView
    private lateinit var tvDev: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val shareButton: Button = findViewById(R.id.action_share)

        shareButton.setOnClickListener {
            val shareText = "${tvName.text}\n${tvDescription.text}"
            val shareIntent = Intent(Intent.ACTION_SEND).apply {
                type = "text/plain"
                putExtra(Intent.EXTRA_TEXT, shareText)
            }
            startActivity(Intent.createChooser(shareIntent, "Share via"))
        }

        val actionBar = supportActionBar
        actionBar?.setDisplayHomeAsUpEnabled(true)

        imgPhoto = findViewById(R.id.img_detail_photo)
        tvName = findViewById(R.id.tv_detail_name)
        tvDescription = findViewById(R.id.tv_detail_description)
        tvGenre = findViewById(R.id.tv_detail_genre)
        tvYear = findViewById(R.id.tv_detail_year)
        tvDev = findViewById(R.id.tv_detail_dev)

        val hero = intent.getParcelableExtra<Hero>("extra_hero") as Hero

        imgPhoto.setImageResource(hero.photo)
        tvName.text = hero.name
        tvDescription.text = hero.description

        // Assuming the Hero class has fields for genre, year, and developer
        tvGenre.text = "Genre: ${hero.genre}"
        tvYear.text = "Year: ${hero.year}"
        tvDev.text = "Developer: ${hero.developer}"
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
