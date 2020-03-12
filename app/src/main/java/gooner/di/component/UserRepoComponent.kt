package gooner.di.component

import dagger.Component
import gooner.di.module.UserRepoModule
import gooner.viewmodel.UserViewModel
import javax.inject.Singleton

@Singleton
@Component(modules = [UserRepoModule::class])
interface UserRepoComponent {

    fun inject(userViewModel: UserViewModel)
}