package ru.chistov.mvp.userRepos

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter
import ru.chistov.mvp.*
import ru.chistov.mvp.core.databaze.RoomGithubUsersCache
import ru.chistov.mvp.core.network.NetworkProvider
import ru.chistov.mvp.databinding.FragmentUsersRepoListBinding
import ru.chistov.mvp.model.GithubUserRepo
import ru.chistov.mvp.repository.impl.GithubRepositoryImpl


class UserReposFragment: MvpAppCompatFragment(), UserReposView, RepoOnBackPressedListener,OnItemRepoClickListener{

    private lateinit var viewBinding: FragmentUsersRepoListBinding

    private val adapter = UserReposAdapter(this)
    private val userDao = GeekBrainsApp.instance.database.userDao()
    private val connect = GeekBrainsApp.instance.getConnectSingle()
    private val presenter: UserReposPresenter by moxyPresenter {
        UserReposPresenter(
            GithubRepositoryImpl(
                NetworkProvider.usersApi,
                userDao,
                connect,
                RoomGithubUsersCache(userDao)
            ),
            GeekBrainsApp.instance.router
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return FragmentUsersRepoListBinding.inflate(inflater, container, false).also {
            viewBinding = it
        }.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.getString(ID_REPO)?.let { login->
            presenter.loadRepo(login)
        }

        viewBinding.rvGithubUsersRepo.setOnClickListener {
        }
        with(viewBinding) {
            rvGithubUsersRepo.layoutManager = LinearLayoutManager(requireContext())
            rvGithubUsersRepo.adapter = adapter
        }
    }
    override fun initList(list: List<GithubUserRepo>) {
        adapter.repos = list
    }

    override fun showLoading() {
        with(viewBinding) {
            progressBar.makeVisible()
            rvGithubUsersRepo.makeGone()
        }
    }

    override fun hideLoading() {
        with(viewBinding) {
            progressBar.makeGone()
            rvGithubUsersRepo.makeVisible()
        }
    }

    override fun onBackPressed(login: String)= presenter.onBackPressed(login)

    companion object {
        @JvmStatic
        fun getInstance(login: String): UserReposFragment {
            return UserReposFragment().apply {
                arguments = Bundle().apply {
                    putString(ID_REPO, login)
                }
            }
        }
    }

    override fun onItemClick(bundle: Bundle) {
        presenter.onItemClicked(bundle)
    }

}