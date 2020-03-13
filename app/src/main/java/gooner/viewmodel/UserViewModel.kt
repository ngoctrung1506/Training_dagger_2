package gooner.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import gooner.App
import gooner.model.User
import gooner.repository.UserRepo
import javax.inject.Inject

class UserViewModel(app: App) : ViewModel() {

    @Inject
    lateinit var mUserRepo: UserRepo


    init {
//        app.mAppComponent.repositorySubcomponent().build().inject(this)
//        Log.d("Repository", mRetrofit.toString())
    }

    var user = MutableLiveData<User>()

    fun gerUserByName(name: String): MutableLiveData<User> = mUserRepo.getUserByName(name)


    fun <T> MutableLiveData<T>.showLog(logName: String) {
        Log.d(logName, this.value.toString())

    }

}