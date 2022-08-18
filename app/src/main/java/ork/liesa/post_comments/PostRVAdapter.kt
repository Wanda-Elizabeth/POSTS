package ork.liesa.post_comments

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ork.liesa.post_comments.databinding.PostListItemBinding

 class PostRvAdapter(var postList: List<Posts>): RecyclerView.Adapter<PostRvAdapter.RetrofitViewHolder>() {

     override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RetrofitViewHolder {
         var binding =PostListItemBinding .inflate(LayoutInflater.from(parent.context), parent, false)
         return RetrofitViewHolder(binding)
     }

    override fun onBindViewHolder(holder: RetrofitViewHolder, position: Int) {
        var currentPost = postList.get(position)

        var context=holder.itemView.context

        holder.bindingView.cvPost.setOnClickListener {
            val intent=Intent(context,CommentActivity::class.java)
            intent.putExtra("POST_ID",currentPost.id)
            context.startActivity(intent)
        }

        with(holder.bindingView) {
            tvID.text= currentPost.id.toString()
            tvUserId.text = currentPost.userId.toString()
            tvTitle.text= currentPost.title
            tvBody.text = currentPost.body


        }

    }

    override fun getItemCount(): Int {
        return postList.size

    }

class RetrofitViewHolder(var bindingView: PostListItemBinding) :
    RecyclerView.ViewHolder(bindingView.root){


}    }


