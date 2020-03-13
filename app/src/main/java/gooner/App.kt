package gooner

import android.app.Application
import gooner.di.component.*

class App : Application() {

    lateinit var mApiComponent: GitApiComponent
    lateinit var mComputerComponent: ComputerComponent
    lateinit var mAppComponent : AppComponent
//    lateinit var mUserSubComponent: RepositorySubComponent

    override fun onCreate() {
        super.onCreate()
        mApiComponent = DaggerGitApiComponent.builder().build()
        mComputerComponent = DaggerComputerComponent.builder().build()
        mAppComponent = DaggerAppComponent.builder().build()
//        mUserSubComponent = DaggerRepositorySubComponent.builder().build()

    }
}