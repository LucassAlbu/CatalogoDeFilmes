package com.lucassalbu.catalogodefilmessuperior.di

import com.lucassalbu.catalogodefilmessuperior.repositories.Repository
import com.lucassalbu.catalogodefilmessuperior.repositories.RepositoryCF
import com.lucassalbu.catalogodefilmessuperior.serviceApi.ApiInterface
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideRepository(
        apiInterface: ApiInterface,
    ): Repository {
        return RepositoryCF(apiInterface)
    }

}