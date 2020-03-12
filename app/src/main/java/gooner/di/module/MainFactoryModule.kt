package gooner.di.module

import dagger.Module
import dagger.Provides
import gooner.App
import gooner.factory.MainFactory
import javax.inject.Singleton

@Module
class MainFactoryModule {

    @Provides
    @Singleton
    fun provideMainFactoryModule(app: App) = MainFactory(app)

}