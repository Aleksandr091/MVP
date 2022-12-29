package ru.chistov.mvp.core.navigation

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import com.github.terrakok.cicerone.androidx.FragmentScreen
import ru.chistov.mvp.details.DetailsFragment
import ru.chistov.mvp.repoDetails.RepoDetailsFragment
import ru.chistov.mvp.user.UserFragment
import ru.chistov.mvp.userDetails.UserDetailsFragment


object UsersScreen : FragmentScreen {
    override fun createFragment(factory: FragmentFactory): Fragment {
        return UserFragment.getInstance()
    }
}

data class DetailsScreen(private val login: String) : FragmentScreen {
    override fun createFragment(factory: FragmentFactory): Fragment {
        return DetailsFragment.getInstance(login)
    }
}
data class UserDetailsScreen(private val login: String) : FragmentScreen {
    override fun createFragment(factory: FragmentFactory): Fragment {
        return UserDetailsFragment.getInstance(login)
    }
}
data class RepoDetailsScreen(private val bundle: Bundle ) : FragmentScreen {
    override fun createFragment(factory: FragmentFactory): Fragment {
        return RepoDetailsFragment.getInstance(bundle)
    }
}