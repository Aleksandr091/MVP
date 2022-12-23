package ru.chistov.mvp.userDetails

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ru.chistov.mvp.databinding.ItemUserRepoBinding
import ru.chistov.mvp.loadImage
import ru.chistov.mvp.model.GithubUser
import ru.chistov.mvp.model.GithubUserRepo
import ru.chistov.mvp.user.OnItemClickListener

class UserDetailsAdapter() :
    RecyclerView.Adapter<UserDetailsAdapter.UserRepoViewHolder>() {

    var repos: List<GithubUserRepo> = emptyList()
        set(value) {
            field = value
            notifyDataSetChanged()
        }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserRepoViewHolder {

        val binding = ItemUserRepoBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return UserRepoViewHolder(binding.root)
    }

    override fun onBindViewHolder(holder: UserRepoViewHolder, position: Int) {
        holder.bind(repos[position])
    }

    override fun getItemCount(): Int {
        return repos.size
    }

    inner class UserRepoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        @SuppressLint("CheckResult")
        fun bind(githubUserRepo: GithubUserRepo) {
            ItemUserRepoBinding.bind(itemView).apply {
                with(githubUserRepo) {
                    tvUserRepo.text = githubUserRepo.repo

                }
            }
        }
    }
}