package gooner.api

import gooner.di.component.DaggerGitApiComponent
import javax.inject.Inject

class UserApi @Inject constructor() {

    @Inject
    lateinit var mGitHubApi: GitHubApi


    init {
        DaggerGitApiComponent.builder().build().inject(this)
    }

    fun getUserByName(name: String) = mGitHubApi.getUser(name)


}