package gooner

import android.app.Application
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import gooner.di.component.AppComponent
import gooner.di.component.DaggerAppComponent
import gooner.di.component.DaggerGitApiComponent
import gooner.di.component.GitApiComponent
import javax.inject.Inject

class App : Application(), HasAndroidInjector {

    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Any>

    override fun androidInjector(): AndroidInjector<Any> = dispatchingAndroidInjector

    lateinit var mApiComponent: GitApiComponent
    lateinit var mAppComponent: AppComponent
//    lateinit var mUserSubComponent: RepositorySubComponent

    override fun onCreate() {
        super.onCreate()
        mApiComponent = DaggerGitApiComponent.builder().build()
        mAppComponent = DaggerAppComponent.builder().build()
//        mAppComponent = Dagger.builder().build()
        mAppComponent.inject(this)
//        mUserSubComponent = DaggerRepositorySubComponent.builder().build()

    }
}