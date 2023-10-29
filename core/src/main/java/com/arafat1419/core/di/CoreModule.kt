package com.arafat1419.core.di

import androidx.room.Room
import com.arafat1419.core.BuildConfig
import com.arafat1419.core.data.local.LocalDataSource
import com.arafat1419.core.data.local.db.AppDatabase
import com.arafat1419.core.data.network.DataRepositoryImpl
import com.arafat1419.core.data.network.api.ApiService
import com.arafat1419.core.data.network.datasource.NetworkDataSource
import com.arafat1419.core.domain.repository.DataRepository
import com.arafat1419.core.domain.usecase.DataInteractor
import com.arafat1419.core.domain.usecase.DataUseCase
import com.bumptech.glide.Glide
import com.bumptech.glide.integration.okhttp3.OkHttpUrlLoader
import com.bumptech.glide.load.model.GlideUrl
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.android.ext.koin.androidContext
import org.koin.core.module.Module
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.InputStream
import java.util.concurrent.TimeUnit



object CoreModule {
    private val networkModule = module {
        single {
            OkHttpClient.Builder()
                .addInterceptor(
                    HttpLoggingInterceptor().setLevel(
                        if (BuildConfig.DEBUG) {
                            HttpLoggingInterceptor.Level.BODY
                        } else {
                            HttpLoggingInterceptor.Level.NONE
                        }
                    )
                )
                .connectTimeout(120, TimeUnit.SECONDS)
                .readTimeout(120, TimeUnit.SECONDS)
                .build()
        }

        single {
            val retrofit = Retrofit.Builder()
                .baseUrl(BuildConfig.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(get())
                .build()
            retrofit.create(ApiService::class.java)
        }

        single {
            Glide.get(get())
                .registry
                .prepend(GlideUrl::class.java, InputStream::class.java, OkHttpUrlLoader.Factory(get()))
        }
    }

    private val databaseModule = module {
        factory { get<AppDatabase>().appDao() }
        single {
            Room.databaseBuilder(
                androidContext(),
                AppDatabase::class.java,
                BuildConfig.DB_NAME
            ).fallbackToDestructiveMigration().build()
        }
    }

    private val repositoryModule = module {
        single { NetworkDataSource(get()) }
        single { LocalDataSource(get()) }
        single<DataRepository> {
            DataRepositoryImpl(get(), get())
        }
    }

    private val useCaseModule = module {
        factory<DataUseCase> { DataInteractor(get()) }
    }

    fun getAllModules(): MutableList<Module> = mutableListOf(
        networkModule,
        databaseModule,
        repositoryModule,
        useCaseModule
    )
}