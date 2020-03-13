package gooner.di.component

import dagger.Component
import dagger.android.AndroidInjectionModule
import gooner.App
import gooner.di.builder.ActivityBuilder
import gooner.di.module.AppModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidInjectionModule::class,
        AppModule::class,
        ActivityBuilder::class]
)
interface AppComponent {

    //    fun userDetailSubcomponent(): UserDetailSubcomponent.Buider
//
//    fun repositorySubcomponent(): RepositorySubComponent.Builder
//
//    fun computer(): Computer
    fun inject(app: App)
}