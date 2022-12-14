package ru.chistov.mvp.users

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter
import ru.chistov.mvp.GeekBrainsApp
import ru.chistov.mvp.core.OnBackPressedListener
import ru.chistov.mvp.core.databaze.RoomGithubUsersCache
import ru.chistov.mvp.core.databaze.UserDAO
import ru.chistov.mvp.core.network.NetworkProvider
import ru.chistov.mvp.core.network.UsersApi
import ru.chistov.mvp.databinding.FragmentUsersListBinding
import ru.chistov.mvp.makeGone
import ru.chistov.mvp.makeVisible
import ru.chistov.mvp.model.GithubUser
import ru.chistov.mvp.repository.impl.GithubRepositoryImpl
import javax.inject.Inject

class UserFragment : MvpAppCompatFragment(), UserView, OnBackPressedListener, OnItemClickListener {

    companion object {
        fun getInstance(): UserFragment {
            return UserFragment()
        }
    }

    private lateinit var viewBinding: FragmentUsersListBinding

    private val adapter = UserAdapter(this)

    private val presenter: UserPresenter by moxyPresenter {
        UserPresenter().apply {
            GeekBrainsApp.instance.appComponent.inject(this)
        }

    }
    override fun onCreate(savedInstanceState: Bundle?) {
        GeekBrainsApp.instance.appComponent.inject(this)
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return FragmentUsersListBinding.inflate(inflater, container, false).also {
            viewBinding = it
        }.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(viewBinding) {
            rvGithubUsers.layoutManager = LinearLayoutManager(requireContext())
            rvGithubUsers.adapter = adapter
        }
    }

    override fun initList(list: List<GithubUser>) {
        adapter.users = list
    }

    override fun showLoading() {
        with(viewBinding) {
            progressBar.makeVisible()
            rvGithubUsers.makeGone()
        }
    }

    override fun hideLoading() {
        with(viewBinding) {
            progressBar.makeGone()
            rvGithubUsers.makeVisible()
        }
    }

    override fun onBackPressed() = presenter.onBackPressed()
    override fun onItemClick(login: String) {
        presenter.onItemClicked(login)
    }


}