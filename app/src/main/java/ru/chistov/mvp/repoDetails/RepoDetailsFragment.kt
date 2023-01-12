package ru.chistov.mvp.repoDetails

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter
import ru.chistov.mvp.*
import ru.chistov.mvp.databinding.FragmentRepoDetailsBinding
import ru.chistov.mvp.model.GithubUserRepo
import ru.chistov.mvp.userRepos.RepoOnBackPressedListener
import ru.chistov.mvp.users.UserPresenter


class RepoDetailsFragment : MvpAppCompatFragment(), RepoDetailsView, RepoOnBackPressedListener {

    companion object {
        @JvmStatic
        fun getInstance(bundle: Bundle): RepoDetailsFragment {
            return RepoDetailsFragment().apply {
                arguments = Bundle().apply {
                    putBundle(REPO, bundle)
                }
            }
        }
    }

    private var _binding: FragmentRepoDetailsBinding? = null
    private val binding: FragmentRepoDetailsBinding
        get() {
            return _binding!!
        }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    private val presenter: RepoDetailsPresenter by moxyPresenter {
        RepoDetailsPresenter().apply {
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
        _binding = FragmentRepoDetailsBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        showLoading()
        arguments?.getBundle(REPO)?.let {  bundle->
            bundle.getParcelable<GithubUserRepo>(REPO)?.let {
                hideLoading()
                show(it)
            }

        }




    }

    override fun onBackPressed(login:String) = presenter.onBackPressed(login)


    override fun show(repo: GithubUserRepo) {
        binding.apply {
            tvRepo.text = repo.repo
            tvRepoFork.text = "Кол-во форков "+repo.forks.toString()
        }
    }

    override fun showLoading() {
        binding.apply {
            tvRepo.makeGone()
            tvRepoFork.makeGone()
            progressBar.makeVisible()
        }
    }

    override fun hideLoading() {
        binding.apply {
            tvRepo.makeVisible()
            tvRepoFork.makeVisible()
            progressBar.makeGone()
        }
    }


}