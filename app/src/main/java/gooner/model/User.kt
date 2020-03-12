package gooner.model

import com.squareup.moshi.Json

data class User(
    @field:Json(name = "name")
    val name: String,
    @field:Json(name = "blog")
    val blog: String
)

