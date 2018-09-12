package es.sdos.joaquinruiz.livedataexample

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import es.sdos.joaquinruiz.livedataexample.ui.main.MainFragment
import es.sdos.joaquinruiz.livedataexample.ui.main.MainViewModel
import org.koin.android.architecture.ext.viewModel

class MainActivity : AppCompatActivity() {

    val model by viewModel<MainViewModel>()
    private var mBackLocked: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        if (savedInstanceState == null) {
            loadMainFragment()

        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.delete_all_items -> {
                deleteAllContacts()
            }
        }

        ALGO_DON

        return super.onOptionsItemSelected(item)
    }

    fun backLock() {
        mBackLocked = true
    }

    override fun onBackPressed() {
        if (mBackLocked) {
            mBackLocked = false
            loadMainFragment()
        } else {
            super.onBackPressed()
        }
    }

    private fun loadMainFragment() {
        supportFragmentManager.beginTransaction()
                .replace(R.id.container, MainFragment.newInstance())
                .commitNow()
    }

    private fun deleteAllContacts() {
        model.deletaAllUsers()
    }

}
