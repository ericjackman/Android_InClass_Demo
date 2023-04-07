package com.example.csc415.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = false)
data class AlbumResponse(
    @Json(name = "pagination")
    val pagination: Pagination,
    @field:Json(name = "wants")
    val albums: List<Album>,
)

data class Pagination(
    @Json(name = "items")
    val items: Int,
    @Json(name = "page")
    val page: Int,
    @Json(name = "pages")
    val pages: Int,
    @Json(name = "per_page")
    val perPage: Int,
    @Json(name = "urls")
    val urls: Urls
) {
    class Urls
}
