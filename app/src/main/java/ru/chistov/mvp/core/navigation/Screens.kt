package ru.chistov.mvp.core.navigation

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import com.github.terrakok.cicerone.androidx.FragmentScreen
import ru.chistov.mvp.detailsUser.DetailsUserFragment
import ru.chistov.mvp.repoDetails.RepoDetailsFragment
import ru.chistov.mvp.users.UserFragment
import ru.chistov.mvp.userRepos.UserReposFragment


object UsersScreen : FragmentScreen {
    override fun createFragment(factory: FragmentFactory): Fragment {
        return UserFragment.getInstance()
    }
}

data class DetailsScreen(private val login: String) : FragmentScreen {
    override fun createFragment(factory: FragmentFactory): Fragment {
        return DetailsUserFragment.getInstance(login)
    }
}
data class UserDetailsScreen(private val login: String) : FragmentScreen {
    override fun createFragment(factory: FragmentFactory): Fragment {
        return UserReposFragment.getInstance(login)
    }
}
data class RepoDetailsScreen(private val bundle: Bundle ) : FragmentScreen {
    override fun createFragment(factory: FragmentFactory): Fragment {
        return RepoDetailsFragment.getInstance(bundle)
    }
}