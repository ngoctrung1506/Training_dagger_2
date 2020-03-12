package gooner.di.component

import dagger.Component
import gooner.demo.training_dagger.MainActivity
import gooner.di.module.RetrofitModule
import gooner.model.Computer
import javax.inject.Singleton

@Singleton
@Component(modules = [/*ComputerModule::class, */RetrofitModule::class])
interface ComputerComponent {

    fun inject(mainActivity: MainActivity)

    fun computer(): Computer
}