package gooner.di.component

import dagger.Component
import gooner.di.module.UserApiModule
import gooner.repository.UserRepo
import javax.inject.Singleton

@Singleton
@Component(modules = [UserApiModule::class])
interface UserApiComponent {

    fun inject(userRepo: UserRepo)
}