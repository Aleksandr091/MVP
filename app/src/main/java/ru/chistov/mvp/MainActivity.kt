package ru.chistov.mvp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ru.chistov.mvp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), MainView {


    private var _binding: ActivityMainBinding? = null
    private val binding: ActivityMainBinding
        get() = _binding!!

    private lateinit var presenter: CountersPresenter

    private val model = CountersModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initPresenter()

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

    private fun initPresenter() {
        presenter = CountersPresenter(this, model)
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