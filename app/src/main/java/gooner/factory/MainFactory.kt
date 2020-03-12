package gooner.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import gooner.App
import gooner.viewmodel.UserViewModel
import javax.inject.Inject

class MainFactory @Inject constructor(val app: App) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(UserViewModel::class.java)) {
            return UserViewModel(app) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }


}