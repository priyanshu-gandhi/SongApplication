package com.example.jc_interview.di

import com.example.jc_interview.data.MockInterceptor
import com.example.jc_interview.data.SongsInterfece
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton
import okhttp3.OkHttpClient
import okhttp3.Interceptor
import okhttp3.Response

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun provideRetrofitInstance() : Retrofit{

        val client = OkHttpClient.Builder()
            .addInterceptor(MockInterceptor())
            .build()

        return Retrofit.Builder()
            .baseUrl("https://api.example.com/")
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun provideSongInterface(retrofit: Retrofit): SongsInterfece{
        return retrofit.create(SongsInterfece::class.java)
    }
}