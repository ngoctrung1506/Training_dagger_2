package gooner.di.component

import dagger.Component
import gooner.di.module.AppModule
import gooner.di.subcomponent.RepositorySubComponent
import gooner.di.subcomponent.UserDetailSubcomponent
import gooner.model.Computer
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class])
interface AppComponent {

    fun userDetailSubcomponent(): UserDetailSubcomponent.Buider

    fun repositorySubcomponent(): RepositorySubComponent.Builder

    fun computer(): Computer
}