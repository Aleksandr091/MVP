package ru.chistov.mvp.core.navigation

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import com.github.terrakok.cicerone.androidx.FragmentScreen
import ru.chistov.mvp.details.DetailsFragment
import ru.chistov.mvp.user.UserFragment


object UsersScreen : FragmentScreen {
    override fun createFragment(factory: FragmentFactory): Fragment {
        return UserFragment.getInstance()
    }
}

data class DetailsScreen(private val id: Long) : FragmentScreen {
    override fun createFragment(factory: FragmentFactory): Fragment {
        return DetailsFragment.getInstance(id)
    }
}