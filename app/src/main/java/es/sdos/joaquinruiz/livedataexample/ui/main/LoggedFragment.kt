package es.sdos.joaquinruiz.livedataexample.ui.main

import android.arch.lifecycle.Observer
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import es.sdos.joaquinruiz.livedataexample.R
import es.sdos.joaquinruiz.livedataexample.model.User
import kotlinx.android.synthetic.main.fragment_logged.*
import org.koin.android.architecture.ext.viewModel

class LoggedFragment : Fragment() {

    companion object {
        fun newInstance() = LoggedFragment()
    }

    //    private lateinit var viewModel: MainViewModel
    val model by viewModel<MainViewModel>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_logged, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        initViewModel()
    }

    private fun initViewModel() {
//        viewModel = ViewModelProviders.of(activity!!).get(MainViewModel::class.java)
        val nameObserver = Observer<List<User>> {
            if (it != null && it.isNotEmpty()) {
                logged__label__username.text = String.format(resources.getString(R.string.lorem), it.last().username)
            }

        }
        model.getUsers().observe(this, nameObserver)
    }


}
