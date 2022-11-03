package com.lucassalbu.catalogodefilmessuperior.models

import com.google.gson.annotations.SerializedName

data class TvShowModel(
    val page: Int,
    @SerializedName("results")
    val tvShows: List<TvShow>,
    val total_pages: Int,
    val total_results: Int
)