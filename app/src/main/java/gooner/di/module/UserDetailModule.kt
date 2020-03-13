package gooner.di.module

import dagger.Module
import dagger.Provides
import gooner.di.scope.ActivityScope
import gooner.repository.UserRepo

@Module
class UserDetailModule {

    @Provides
    @ActivityScope
    fun provideUserRepo() = UserRepo()
}