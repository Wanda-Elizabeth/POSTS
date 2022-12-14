package ork.liesa.post_comments

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiInterface {
    @GET("/posts")
    fun getPosts():Call<List<Posts>>
    @GET("/posts{id}")
    fun  getPostById(@Path("id")postId:Int):Call<Posts>

}