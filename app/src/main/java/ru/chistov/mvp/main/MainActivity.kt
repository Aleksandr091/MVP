package ru.chistov.mvp.main

import android.os.Bundle
import com.github.terrakok.cicerone.NavigatorHolder
import com.github.terrakok.cicerone.androidx.AppNavigator
import moxy.MvpAppCompatActivity
import moxy.ktx.moxyPresenter
import ru.chistov.mvp.GeekBrainsApp
import ru.chistov.mvp.R
import ru.chistov.mvp.core.OnBackPressedListener
import ru.chistov.mvp.databinding.ActivityMainBinding
import javax.inject.Inject

class MainActivity : MvpAppCompatActivity(), MainView {


    private var _binding: ActivityMainBinding? = null
    private val binding: ActivityMainBinding
        get() = _binding!!
    private val navigator = AppNavigator(this, R.id.containerMain)
    @Inject
    lateinit var navigatorHolder: NavigatorHolder
    private val presenter by moxyPresenter { MainPresenter().apply {
        GeekBrainsApp.instance.appComponent.inject(this)
    }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        GeekBrainsApp.instance.appComponent.inject(this)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }

    override fun onResumeFragments() {
        super.onResumeFragments()
        navigatorHolder.setNavigator(navigator)
    }

    override fun onPause() {
        navigatorHolder.removeNavigator()
        super.onPause()
    }


    override fun onBackPressed() {
        supportFragmentManager.fragments.forEach {
            if (it is OnBackPressedListener && it.onBackPressed()) {
                return
            }
        }
        presenter.onBackPressed()
    }


    override fun onDestroy() {
        _binding = null
        super.onDestroy()
    }

}