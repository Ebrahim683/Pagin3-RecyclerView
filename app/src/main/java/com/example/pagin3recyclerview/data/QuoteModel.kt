package com.example.pagin3recyclerview.data


import com.google.gson.annotations.SerializedName

data class QuoteModel(
    @SerializedName("count")
    val count: Int?, // 20
    @SerializedName("totalCount")
    val totalCount: Int?, // 2043
    @SerializedName("page")
    val page: Int?, // 1
    @SerializedName("totalPages")
    val totalPages: Int?, // 103
    @SerializedName("lastItemIndex")
    val lastItemIndex: Int?, // 20
    @SerializedName("results")
    val results: List<Result>
)