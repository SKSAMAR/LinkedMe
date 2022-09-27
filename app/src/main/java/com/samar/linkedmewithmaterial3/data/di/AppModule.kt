package com.samar.linkedmewithmaterial3.data.di

import android.content.Context
import com.samar.linkedmewithmaterial3.LinkedMeApplication
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideApplication(@ApplicationContext context: Context?): LinkedMeApplication {
        return context as LinkedMeApplication
    }

}