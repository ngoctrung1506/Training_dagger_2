package gooner

import android.app.Application
import gooner.di.component.*

class App : Application() {

    lateinit var mApiComponent: GitApiComponent
    lateinit var mComputerComponent: ComputerComponent
    lateinit var mUserComponent: UserRepoComponent

    override fun onCreate() {
        super.onCreate()
        mApiComponent = DaggerGitApiComponent.builder().build()
        mComputerComponent = DaggerComputerComponent.builder().build()
        mUserComponent = DaggerUserRepoComponent.builder().build()

    }
}