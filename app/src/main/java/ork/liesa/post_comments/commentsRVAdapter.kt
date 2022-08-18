package ork.liesa.post_comments

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ork.liesa.post_comments.databinding.PostListItemBinding

class commentsRVAdapter (var commentList: List<Posts>):
    RecyclerView.Adapter<commentsRVAdapter.commentsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): commentsViewHolder {
        var binding =commentsListBi.inflate(LayoutInflater.from(parent.context), parent, false)
        return commentsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: commentsViewHolder, position: Int) {
        var currentPost = commentList.get(position)

        var context=holder.itemView.context

        holder.bindingView.cvPost.setOnClickListener {
            val intent=Intent(context,CommentActivity::class.java)
            intent.putExtra("POST_ID",currentPost.id)
            context.startActivity(intent)
        }

        with(holder.bindingView) {
            tvID1.text= currentPost.id.toString()
            tvUserId1.text = currentPost.userId.toString()
            tvTitle1.text= currentPost.title
            tvBody1.text = currentPost.body


        }

    }

    override fun getItemCount(): Int {
        return commentList.size

    }

    class commentsViewHolder(var bindingView: commentsListItemBinding) :
        RecyclerView.ViewHolder(bindingView.root){


    }    }
