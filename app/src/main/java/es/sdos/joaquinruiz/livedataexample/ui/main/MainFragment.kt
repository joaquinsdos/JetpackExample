package es.sdos.joaquinruiz.livedataexample.ui.main

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import es.sdos.joaquinruiz.livedataexample.MainActivity
import es.sdos.joaquinruiz.livedataexample.R
import es.sdos.joaquinruiz.livedataexample.adapter.UserAdapter
import es.sdos.joaquinruiz.livedataexample.model.User
import kotlinx.android.synthetic.main.main_fragment.*
import org.koin.android.architecture.ext.viewModel

class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

//    private lateinit var viewModel: MainViewModel
    private val userAdapter = UserAdapter(emptyList())
    val model by viewModel<MainViewModel>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.main_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        initViewModel()
        initAdapter()
        initOnClick()
    }

    private fun initViewModel() {
//        viewModel = ViewModelProviders.of(activity!!).get(MainViewModel::class.java)
        model.getUsers().observe(this, Observer<List<User>> {
            checkResult(it ?: emptyList())
        })
    }

    private fun checkResult(users: List<User>) {
        main__label__welcome.text = if (users.isNotEmpty()) {
            String.format(resources.getString(R.string.last_user), users.last().username)

        } else {
            getString(R.string.welcome)
        }

        userAdapter.updateUsers(users)
    }


    private fun initAdapter() {
        main__list__user_list.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)
        main__list__user_list.adapter = userAdapter
    }

    private fun initOnClick() {
        main__btn__connect.setOnClickListener {
            val user = User(username = main__input__username.text.toString())
            model.addUser(user)
            with(activity!! as MainActivity) {
                val view: View? = this.currentFocus
                if (view != null) {
                    view.clearFocus()
                    val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
                    imm.hideSoftInputFromWindow(view.windowToken, 0)
                }
                backLock()
                supportFragmentManager.beginTransaction()
                        .replace(R.id.container, LoggedFragment.newInstance())
                        .commitNow()
            }
        }
    }

}
