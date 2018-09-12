package es.sdos.joaquinruiz.livedataexample

import android.arch.lifecycle.LiveData
import es.sdos.joaquinruiz.livedataexample.model.User
import es.sdos.joaquinruiz.livedataexample.model.UserDb

interface Repository {
    fun getUsers(): LiveData<List<User>>
    fun addUser(userUpdated: User)
    fun deleteAllUsers()

}

class MyRepository(val application: MyApplication) : Repository {

    private val appDb: UserDb = UserDb.getDataBase(application)
    private val mUsers: LiveData<List<User>> = appDb.daoUser().getAllUser()

    override fun getUsers(): LiveData<List<User>> = mUsers
    override fun addUser(userUpdated: User) = appDb.daoUser().insertUser(userUpdated)
    override fun deleteAllUsers() = appDb.daoUser().deleteAllUser()

}