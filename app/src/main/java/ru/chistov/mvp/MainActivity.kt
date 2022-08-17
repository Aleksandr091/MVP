package ru.chistov.mvp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import moxy.MvpAppCompatActivity
import moxy.ktx.moxyPresenter
import moxy.presenter.InjectPresenter
import ru.chistov.mvp.databinding.ActivityMainBinding

class MainActivity : MvpAppCompatActivity(), MainView {


    private var _binding: ActivityMainBinding? = null
    private val binding: ActivityMainBinding
        get() = _binding!!


    private val presenter by moxyPresenter { CountersPresenter(CountersModel()) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setOnClickListenerBtn()
    }

    private fun setOnClickListenerBtn() {
        with(binding) {
            btnOne.setOnClickListener {
                presenter.onCounterClickBtnOne()
            }
            btnTwo.setOnClickListener {
                presenter.onCounterClickBtnTwo()
            }
            btnThee.setOnClickListener {
                presenter.onCounterClickBtnThee()
            }
        }
    }

    override fun setButtonTextOne(counter: String) {
        binding.tvTextOne.text = counter
    }

    override fun setButtonTextTwo(counter: String) {
        binding.tvTextTwo.text = counter
    }

    override fun setButtonTextThee(counter: String) {
        binding.tvTextThee.text = counter
    }
    override fun onDestroy() {
        _binding = null
        super.onDestroy()
    }
}