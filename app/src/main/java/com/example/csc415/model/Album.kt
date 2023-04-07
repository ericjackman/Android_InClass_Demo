package com.example.csc415.model


import com.squareup.moshi.Json

data class Album(
    @Json(name = "date_added")
    val dateAdded: String,
    @Json(name = "id")
    val id: Int,
    @Json(name = "rating")
    val rating: Int,
    @Json(name = "resource_url")
    val resourceUrl: String,
    @field:Json(name = "basic_information")
    val basicInformation: BasicInformation
) {
    data class BasicInformation(
        @Json(name = "artists")
        val artists: List<Artist>,
        @Json(name = "cover_image")
        val coverImage: String,
        @Json(name = "formats")
        val formats: List<Format>,
        @Json(name = "genres")
        val genres: List<String>,
        @Json(name = "id")
        val id: Int,
        @Json(name = "labels")
        val labels: List<Label>,
        @Json(name = "master_id")
        val masterId: Int,
        @Json(name = "master_url")
        val masterUrl: String,
        @Json(name = "resource_url")
        val resourceUrl: String,
        @Json(name = "styles")
        val styles: List<String>,
        @Json(name = "thumb")
        val thumb: String,
        @Json(name = "title")
        val title: String,
        @Json(name = "year")
        val year: Int
    ) {
        data class Artist(
            @Json(name = "anv")
            val anv: String,
            @Json(name = "id")
            val id: Int,
            @Json(name = "join")
            val join: String,
            @Json(name = "name")
            val name: String,
            @Json(name = "resource_url")
            val resourceUrl: String,
            @Json(name = "role")
            val role: String,
            @Json(name = "tracks")
            val tracks: String
        )

        data class Format(
            @Json(name = "descriptions")
            val descriptions: List<String>,
            @Json(name = "name")
            val name: String,
            @Json(name = "qty")
            val qty: String
        )

        data class Label(
            @Json(name = "catno")
            val catno: String,
            @Json(name = "entity_type")
            val entityType: String,
            @Json(name = "entity_type_name")
            val entityTypeName: String,
            @Json(name = "id")
            val id: Int,
            @Json(name = "name")
            val name: String,
            @Json(name = "resource_url")
            val resourceUrl: String
        )
    }
}
