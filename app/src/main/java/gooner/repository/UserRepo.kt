package gooner.repository

import android.util.Log
import androidx.lifecycle.MutableLiveData
import gooner.api.UserApi
import gooner.di.component.DaggerUserApiComponent
import gooner.model.User
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class UserRepo {

    @Inject
    lateinit var mUserApi: UserApi

    init {
        DaggerUserApiComponent.builder().build().inject(this)
    }


    fun getUserByName(name: String): MutableLiveData<User> {
        val data = MutableLiveData<User>()
        mUserApi.getUserByName(name).enqueue(object : Callback<User> {
            override fun onFailure(call: Call<User>, t: Throwable) {
                t.printStackTrace()
                data.value = null
                Log.d("MainActivty", "Error")
            }

            override fun onResponse(call: Call<User>, response: Response<User>) {
                data.value = response.body()
                data.value.showLog("MainActivity")


            }
        })
        return data
    }

    fun <T> T.showLog(logName: String) {
        Log.d(logName, this.toString())
    }
}