package ru.chistov.mvp.userDetails

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter
import ru.chistov.mvp.*
import ru.chistov.mvp.core.OnBackPressedListener
import ru.chistov.mvp.core.network.NetworkProvider
import ru.chistov.mvp.databinding.FragmentUsersRepoListBinding
import ru.chistov.mvp.model.GithubUserRepo
import ru.chistov.mvp.repository.impl.GithubRepositoryImpl
import ru.chistov.mvp.user.OnItemClickListener


class UserDetailsFragment: MvpAppCompatFragment(), UserDetailsView, OnBackPressedListener {

    private lateinit var viewBinding: FragmentUsersRepoListBinding

    private val adapter = UserDetailsAdapter()

    private val presenter: UserDetailsPresenter by moxyPresenter {
        UserDetailsPresenter(
            GithubRepositoryImpl(
                NetworkProvider.usersApi),
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
        arguments?.getString(ID_REPO)?.let {
            presenter.loadRepo(it)
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

    override fun onBackPressed()= presenter.onBackPressed()

    companion object {
        @JvmStatic
        fun getInstance(login: String): UserDetailsFragment {
            return UserDetailsFragment().apply {
                arguments = Bundle().apply {
                    putString(ID_REPO, login)
                }
            }
        }
    }

}