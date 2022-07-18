package com.example.pagin3recyclerview.data


import com.google.gson.annotations.SerializedName

data class Result(
    @SerializedName("tags")
    val tags: List<String?>?,
    @SerializedName("_id")
    val id: String?, // JIk3cbQ8s
    @SerializedName("author")
    val author: String?, // Michael Jordan
    @SerializedName("content")
    val content: String?, // I've missed more than 9000 shots in my career. I've lost almost 300 games. 26 times, I've been trusted to take the game winning shot and missed. I've failed over and over and over again in my life. And that is why I succeed.
    @SerializedName("authorSlug")
    val authorSlug: String?, // michael-jordan
    @SerializedName("length")
    val length: Int?, // 224
    @SerializedName("dateAdded")
    val dateAdded: String?, // 2022-07-06
    @SerializedName("dateModified")
    val dateModified: String? // 2022-07-08
)