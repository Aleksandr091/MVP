package ru.chistov.mvp.dI

import dagger.Component
import ru.chistov.mvp.dI.modules.ApiModule
import ru.chistov.mvp.dI.modules.DataBaseModule
import ru.chistov.mvp.dI.modules.NavigationModule
import ru.chistov.mvp.dI.modules.AppModule
import ru.chistov.mvp.dI.modules.RepositoryModule
import ru.chistov.mvp.detailsUser.DetailsPresenter
import ru.chistov.mvp.detailsUser.DetailsUserFragment
import ru.chistov.mvp.main.MainActivity
import ru.chistov.mvp.main.MainPresenter
import ru.chistov.mvp.repoDetails.RepoDetailsFragment
import ru.chistov.mvp.repoDetails.RepoDetailsPresenter
import ru.chistov.mvp.userRepos.UserReposFragment
import ru.chistov.mvp.userRepos.UserReposPresenter
import ru.chistov.mvp.users.UserFragment
import ru.chistov.mvp.users.UserPresenter
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        ApiModule::class,
        AppModule::class,
        DataBaseModule::class,
        NavigationModule::class,
        RepositoryModule::class

    ]
)

interface AppComponent {
    fun inject(userFragment: UserFragment)
    fun inject(userPresenter: UserPresenter)

    fun inject(mainPresenter: MainPresenter)
    fun inject(mainActivity: MainActivity)

    fun inject(userReposPresenter: UserReposPresenter)
    fun inject(detailsUserFragment: DetailsUserFragment)

    fun inject(detailsPresenter: DetailsPresenter)
    fun inject(userReposFragment: UserReposFragment)

    fun inject(repoDetailsPresenter: RepoDetailsPresenter)
    fun inject(repoDetailsFragment: RepoDetailsFragment)


}