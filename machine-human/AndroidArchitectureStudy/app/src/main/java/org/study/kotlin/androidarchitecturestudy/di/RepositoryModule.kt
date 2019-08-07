package org.study.kotlin.androidarchitecturestudy.di

import org.koin.dsl.module
import org.study.kotlin.androidarchitecturestudy.base.BaseRepository
import org.study.kotlin.androidarchitecturestudy.data.TickerRepository

val tickerRepositoryModule = module {
    single<BaseRepository> { TickerRepository(get()) }
}