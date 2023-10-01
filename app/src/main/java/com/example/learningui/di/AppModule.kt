package com.example.learningui.di

import com.apollographql.apollo3.ApolloClient
import com.example.learningui.data.GraphQlClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideApolloClient() : ApolloClient{
        return ApolloClient.builder().serverUrl("https://spacex-production.up.railway.app/")
            .build()
    }

    @Provides
    @Singleton
    fun provideGraphQlClient (apolloClient: ApolloClient): GraphQlClient{
        return GraphQlClient(apolloClient);
    }
}