package gooner.di.subcomponent

//import gooner.di.module.UserRepoModule
import dagger.Subcomponent
import gooner.di.module.RepositoryModule
import gooner.di.scope.ActivityScope
import gooner.viewmodel.UserViewModel

@ActivityScope
@Subcomponent(modules = [RepositoryModule::class])
interface RepositorySubComponent {

    @Subcomponent.Builder
    interface Builder {
        fun build(): RepositorySubComponent
    }

    fun inject(userViewModel: UserViewModel)
}