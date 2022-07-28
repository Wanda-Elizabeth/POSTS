package ork.liesa.post_comments

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ork.liesa.post_comments.databinding.PostListItemBinding

class PostRvAdapter(var context:Context, var postList: List<Posts>): RecyclerView.Adapter<RetrofitViewHolder>() {



    override fun onBindViewHolder(holder: RetrofitViewHolder, position: Int) {
        var currentItem = postList.get(position)
        with(holder.bindingView) {
            tvID.text= currentItem.id.toString()
            tvUserId.text = currentItem.userId.toString()
            tvTitle.text= currentItem.title
            tvBody.text = currentItem.body

        }

    }

    override fun getItemCount(): Int {
        return postList.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RetrofitViewHolder {
        var binding =PostListItemBinding .inflate(LayoutInflater.from(context), parent, false)
        return RetrofitViewHolder(binding)
    }
}

class RetrofitViewHolder(var bindingView: PostListItemBinding) :
    RecyclerView.ViewHolder(bindingView.root)

