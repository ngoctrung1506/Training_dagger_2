package gooner.di.component

import dagger.Component
import gooner.api.UserApi
import gooner.di.module.AppModule
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class])
interface GitApiComponent {

    fun inject(userApi: UserApi)
}