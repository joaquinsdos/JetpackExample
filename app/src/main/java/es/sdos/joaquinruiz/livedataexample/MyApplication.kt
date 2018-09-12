package es.sdos.joaquinruiz.livedataexample

import android.app.Application
import es.sdos.joaquinruiz.livedataexample.ui.main.MainViewModel
import org.koin.android.architecture.ext.viewModel
import org.koin.android.ext.android.startKoin
import org.koin.dsl.module.Module
import org.koin.dsl.module.applicationContext


class MyApplication : Application() {

    private val myModule: Module = applicationContext {
        viewModel { MainViewModel(get()) } // get() will resolve Repository instance
        bean { MyRepository(this@MyApplication) as Repository }
    }


    override fun onCreate() {
        super.onCreate()
        // Start Koin
        startKoin(this, listOf(myModule))
    }
}