package gooner.di.subcomponent

import dagger.Subcomponent
import gooner.demo.training_dagger.MainActivity
import gooner.di.module.UserDetailModule
import gooner.di.scope.ActivityScope

@ActivityScope
@Subcomponent(modules = [UserDetailModule::class])
interface UserDetailSubcomponent {

    @Subcomponent.Builder
    interface Buider {
        fun build(): UserDetailSubcomponent
    }

    fun inject(activity: MainActivity)
}