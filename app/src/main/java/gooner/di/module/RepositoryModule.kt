package gooner.di.module

import dagger.Module
import dagger.Provides
import gooner.di.scope.ActivityScope
import gooner.repository.UserRepo

@Module
class RepositoryModule {

    @Provides
    @ActivityScope
    fun provideUserRepo() = UserRepo()
}