package gooner.api

import gooner.model.User
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface GitHubApi {

    @GET("users/{user}")
    fun getUser(@Path("user") user: String): Call<User>
}