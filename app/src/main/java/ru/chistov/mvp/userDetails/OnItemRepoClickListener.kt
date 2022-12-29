package ru.chistov.mvp.userDetails

import android.os.Bundle
import ru.chistov.mvp.model.GithubUserRepo

interface OnItemRepoClickListener {
    fun onItemClick(bundle: Bundle)
}