package com.dicoding.bacabareng.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.bumptech.glide.Glide
import com.dicoding.bacabareng.R.*
import com.dicoding.bacabareng.R.drawable.*
import com.dicoding.bacabareng.data.Books
import com.dicoding.bacabareng.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val actionbar = supportActionBar
        actionbar!!.title = "Detail Books"
        actionbar.setDisplayHomeAsUpEnabled(true)

        val books = intent.getParcelableExtra<Books>(EXTRA_ITEM)
//        val btnSave: Button = findViewById(id.btn_save)
//        val actionShare: Button = findViewById(id.action_share)

        var save = false
        if (books != null){
            with(binding){
                tvTitle.text = books.title
                Glide
                    .with(this@DetailActivity)
                    .load(books.image)
                    .into(ivImage)
                tvAuthor.text= books.author
                tvReleaseDate.text = books.releaseDate
                tvRate.text = tvRate.text
                tvGenre.text = tvGenre.text
                tvPage.text = tvPage.text
                Glide
                    .with(this@DetailActivity)
                    .load(baseline_star_24)
                    .into(ivRating)
                tvRating.text = books.rate
                tvGenres.text = books.genre
                tvPages.text = books.pages
                tvDesc.text = tvDesc.text
                tvDescription.text = books.description
                btnSave.setCompoundDrawablesWithIntrinsicBounds(
                    baseline_bookmark_border_24,0,0,0
                )
            }
        }
        binding.btnSave.setOnClickListener {
            if (!save) {
                binding.btnSave.setCompoundDrawablesWithIntrinsicBounds(
                    baseline_bookmark_24,0,0,0
                )
                Toast.makeText(this, "${books!!.title} berhasil disimpan", Toast.LENGTH_SHORT).show()
                save = true
            }

            else {
                binding.btnSave.setCompoundDrawablesWithIntrinsicBounds(
                    baseline_bookmark_border_24,0,0,0
                )
                Toast.makeText(this, "${books!!.title} berhasil dihapus", Toast.LENGTH_SHORT).show()
                save = false
            }
        }

        binding.actionShare.setOnClickListener {
            val shareIntent = Intent()
            shareIntent.action = Intent.ACTION_SEND
            shareIntent.putExtra(Intent.EXTRA_TEXT, "Hai, ayo kita baca buku ${books!!.title}, hanya di ${books.link}")
            shareIntent.type = "text/plain"
            startActivity(Intent.createChooser(shareIntent, "Bagikan \"${books!!.title}\" melalui: "))
        }

    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    companion object{
        const val EXTRA_ITEM = "extra_item"
    }
}