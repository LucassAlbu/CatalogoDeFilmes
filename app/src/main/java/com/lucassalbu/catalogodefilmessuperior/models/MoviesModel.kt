package com.lucassalbu.catalogodefilmessuperior.models

import com.google.gson.annotations.SerializedName



data class MoviesModel(
    val page: Int,
    @SerializedName("results")
    val movies: List<Movie>,
    val total_pages: Int,
    val total_results: Int
)