package gooner.di.component

import dagger.Component
import gooner.demo.training_dagger.MainActivity
import gooner.di.module.AppModule
import gooner.model.Computer
import javax.inject.Singleton

@Singleton
@Component(modules = [/*ComputerModule::class, */AppModule::class])
interface ComputerComponent {

    fun inject(mainActivity: MainActivity)

    fun computer(): Computer
}