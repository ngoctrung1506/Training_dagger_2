package gooner.di.builder

import dagger.Module
import dagger.android.ContributesAndroidInjector
import gooner.demo.training_dagger.MainActivity
import gooner.di.module.UserDetailModule
import gooner.di.scope.ActivityScope

@Module
abstract class ActivityBuilder {

    @ActivityScope
    @ContributesAndroidInjector(modules = [UserDetailModule::class])
    abstract fun mainActivity(): MainActivity
}