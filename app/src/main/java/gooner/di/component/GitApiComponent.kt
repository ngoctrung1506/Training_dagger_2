package gooner.di.component

import dagger.Component
import gooner.api.UserApi
import gooner.di.module.RetrofitModule
import javax.inject.Singleton

@Singleton
@Component(modules = [RetrofitModule::class])
interface GitApiComponent {

    fun inject(userApi: UserApi)
}