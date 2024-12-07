package com.irv205.rickmortygraphql.core.di

import com.irv205.rickmortygraphql.data.repository.RickAndMortyRepositoryImp
import com.irv205.rickmortygraphql.domain.repository.RickAndMortyRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun provideRepository(repositoryImp: RickAndMortyRepositoryImp): RickAndMortyRepository
}