package ru.chistov.mvp.user

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import ru.chistov.mvp.R
import ru.chistov.mvp.databinding.ItemUserBinding
import ru.chistov.mvp.loadImage
import ru.chistov.mvp.model.GithubUser

class UserAdapter(private val onItemClickListener: OnItemClickListener) :
    RecyclerView.Adapter<UserAdapter.GithubUserViewHolder>() {

    var users: List<GithubUser> = emptyList()
        set(value) {
            field = value
            notifyDataSetChanged()
        }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GithubUserViewHolder {

        val binding = ItemUserBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return GithubUserViewHolder(binding.root)
    }

    override fun onBindViewHolder(holder: GithubUserViewHolder, position: Int) {
        holder.bind(users[position])
    }

    override fun getItemCount(): Int {
        return users.size
    }

    inner class GithubUserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        @SuppressLint("CheckResult")
        fun bind(githubUser: GithubUser) {
            ItemUserBinding.bind(itemView).apply {
                with(githubUser) {
                    tvUserLogin.text = githubUser.login
                    ivUserAvatar.loadImage(githubUser.avatarUrl)
                    root.setOnClickListener {
                        onItemClickListener.onItemClick(this.login)
                    }
                }
            }
        }
    }
}

