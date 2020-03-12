package gooner.di.module

import dagger.Module
import dagger.Provides
import gooner.repository.UserRepo
import javax.inject.Singleton

@Module
class UserRepoModule {

    @Provides
    @Singleton
    fun provideUserRepo() = UserRepo()
}