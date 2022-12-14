package ork.liesa.post_comments

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import ork.liesa.post_comments.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import kotlin.math.log


class MainActivity : AppCompatActivity() {
    lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        getPost()

    }


    fun getPost(){
        var retrofit = ApiClient.buildApiClient(ApiInterface::class.java)
        var request = retrofit.getPosts()

        request.enqueue(object : Callback<List<Posts>>{
            override fun onResponse(call: Call<List<Posts>>, response: Response<List<Posts>>) {
                if (response.isSuccessful){
                    var post = response.body()
                    Toast.makeText(baseContext,"fetched ${post!!.size} posts",Toast.LENGTH_LONG).show()
                    var adapter = PostRvAdapter(post)
                    Log.d("Tag",post.toString())
                    binding.rvPost.adapter  = adapter
                    binding.rvPost.layoutManager=LinearLayoutManager(baseContext)


                }
            }

            override fun onFailure(call: Call<List<Posts>>, t: Throwable) {
                Toast.makeText(baseContext, t.message, Toast.LENGTH_LONG).show()
            }
        })

    }

    fun displayPosts(postList: List<Posts>){
        binding.rvPost.layoutManager = LinearLayoutManager(this)
        val postRvAdapter = PostRvAdapter(postList)
        binding.rvPost.adapter = postRvAdapter
    }
}
