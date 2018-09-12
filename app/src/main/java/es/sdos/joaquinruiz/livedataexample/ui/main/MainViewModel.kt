package es.sdos.joaquinruiz.livedataexample.ui.main

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.ViewModel
import es.sdos.joaquinruiz.livedataexample.Repository
import es.sdos.joaquinruiz.livedataexample.model.User


class MainViewModel(private val repository: Repository) : ViewModel() {

    fun getUsers(): LiveData<List<User>> {
        return repository.getUsers()
    }

    fun addUser(userUpdated: User) = repository.addUser(userUpdated)

    fun deletaAllUsers() = repository.deleteAllUsers()

//    fun sayHello() = repository.giveHello()

    override fun onCleared() {}

}
