package gooner.di.module

import dagger.Module
import dagger.Provides
import gooner.api.UserApi
import javax.inject.Singleton

@Module
class UserApiModule {

    @Provides
    @Singleton
    fun provideUserApi() = UserApi()
}