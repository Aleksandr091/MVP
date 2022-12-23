package ru.chistov.mvp.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter
import ru.chistov.mvp.*
import ru.chistov.mvp.core.OnBackPressedListener
import ru.chistov.mvp.core.network.NetworkProvider
import ru.chistov.mvp.databinding.FragmentDetailsBinding
import ru.chistov.mvp.model.GithubUser
import ru.chistov.mvp.repository.impl.GithubRepositoryImpl
import ru.chistov.mvp.user.OnItemClickListener


class DetailsFragment : MvpAppCompatFragment(), DetailsView, OnBackPressedListener,
    OnItemClickListener {

    companion object {
        @JvmStatic
        fun getInstance(login: String): DetailsFragment {
            return DetailsFragment().apply {
                arguments = Bundle().apply {
                    putString(ID, login)
                }
            }
        }
    }

    private var _binding: FragmentDetailsBinding? = null
    private val binding: FragmentDetailsBinding
        get() {
            return _binding!!
        }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    private val presenter: DetailsPresenter by moxyPresenter {
        DetailsPresenter(GithubRepositoryImpl(NetworkProvider.usersApi), GeekBrainsApp.instance.router)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDetailsBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.getString(ID)?.let {login->
            presenter.loadUser(login)
            binding.tvUserLogin.setOnClickListener {
                onItemClick(login)
            }
        }


    }

    override fun onBackPressed() = presenter.onBackPressed()

    override fun show(user: GithubUser) {
        binding.apply {
            tvUserLogin.text = user.login
            ivUserAvatar.loadImage(user.avatarUrl)
        }
    }

    override fun showLoading() {
        binding.apply {
            tvUserLogin.makeGone()
            ivUserAvatar.makeGone()
            progressBar.makeVisible()
        }
    }

    override fun hideLoading() {
        binding.apply {
            tvUserLogin.makeVisible()
            ivUserAvatar.makeVisible()
            progressBar.makeGone()
        }
    }

    override fun onItemClick(login: String) {
        presenter.onItemClicked(login)
    }
}