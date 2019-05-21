package com.aba.cryptosample.ui.main

import android.content.Context
import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider

import com.aba.cryptosample.R
import com.aba.cryptosample.data.entity.STATE
import com.aba.cryptosample.extension.observeLiveData
import dagger.android.support.AndroidSupportInjection
import kotlinx.android.synthetic.main.main_fragment.*
import javax.inject.Inject

class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private lateinit var viewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.main_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)


    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initUI()
        viewModel.getReport()
    }


    override fun onAttach(context: Context?) {

        AndroidSupportInjection.inject(this)

        super.onAttach(context)

        viewModel = ViewModelProviders.of(this , viewModelFactory).get(MainViewModel::class.java)

        observeViewModel()


    }

    override fun onStop() {
        super.onStop()
        viewModel.clear()
    }

    private fun observeViewModel() {

        observeLiveData(viewModel.getReportItems()){items ->

            if (items.isNullOrEmpty()){
                return@observeLiveData
            }

            val sb = StringBuffer()
            sb.append(items[0].videoTitle)
            sb.append("-")
            sb.append(items[0].product)
            sb.append("-")
            sb.append(items[0].rating)
            sb.append("-")
            sb.append(items[0].manufacturer)
            sb.append("-")
            sb.append(items[0].v)

            tvData.text = sb.toString()

        }


        observeLiveData(viewModel.getState()){ state ->


            when (state) {
                STATE.successful ->{

                    pbMain.visibility = View.GONE
                }

                STATE.loading -> {
                    pbMain.visibility = View.VISIBLE

                }

                else ->{
                    pbMain.visibility = View.GONE

                    Toast.makeText(activity , (state as STATE.error).message , Toast.LENGTH_LONG).show()
                }


            }

        }

    }


    private fun initUI() {

        btnDecrypt.setOnClickListener {
            tvData.text = viewModel.decryptText(tvData.text.toString())


        }


        btnEncrypt.setOnClickListener {
            tvData.text = viewModel.encryptText(tvData.text.toString())

        }




    }



}
