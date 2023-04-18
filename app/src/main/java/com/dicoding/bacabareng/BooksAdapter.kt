package com.dicoding.bacabareng

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.dicoding.bacabareng.activity.DetailActivity
import com.dicoding.bacabareng.data.Books
import com.dicoding.bacabareng.databinding.ItemRowBooksBinding

class BooksAdapter(private val booksList: List<Books>) :
    RecyclerView.Adapter<BooksAdapter.ListViewHolder>() {
    //Assign Data
    class ListViewHolder(private val binding: ItemRowBooksBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(books: Books) {
            with(binding) {
                Glide
                    .with(itemView.context)
                    .load(books.image)
                    .into(ivImage)
                tvTitle.text = books.title
                tvAuthor.text = books.author
                tvReleaseDate.text = books.releaseDate
                Glide
                    .with(itemView.context)
                    .load(R.drawable.baseline_star_24)
                    .into(ivRating)
                tvRating.text = books.rate

            }
            itemView.setOnClickListener{
                val moveToDetail = Intent(itemView.context, DetailActivity::class.java)
                moveToDetail.putExtra(DetailActivity.EXTRA_ITEM, books)
                itemView.context.startActivity(moveToDetail)
            }
        }
    }

    // Bind Layout
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val binding =
            ItemRowBooksBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ListViewHolder(binding)
    }

    // Ammount of Data
    override fun getItemCount(): Int {
        return booksList.size
    }

    // Get Data Position
    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        holder.bind(booksList[position])
    }
}