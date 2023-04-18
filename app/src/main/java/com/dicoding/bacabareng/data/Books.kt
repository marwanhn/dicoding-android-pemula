package com.dicoding.bacabareng.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize

data class Books(
    var image: Int? = null,
    var title: String? = null,
    var author: String? = null,
    var releaseDate: String? = null,
    var genre: String? = null,
    var rate: String? = null,
    var pages: String? = null,
    var description: String? = null,
    var link: String? = null
) : Parcelable
