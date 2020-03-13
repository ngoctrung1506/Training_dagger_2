package gooner.di.module

import dagger.Module
import dagger.Provides
import gooner.api.GitHubApi
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
class AppModule {

    @Provides
    @Singleton
    fun provideGitHubApi() = Retrofit.Builder().baseUrl("https://api.github.com")
        .addConverterFactory(MoshiConverterFactory.create()).build()

    @Provides
    @Singleton
    fun provideUserApi(retrofit: Retrofit) = retrofit.create(GitHubApi::class.java)
}