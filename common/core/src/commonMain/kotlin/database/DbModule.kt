package database

import org.koin.dsl.module

internal val dbModule = module {
    single {
        DbDriverFactory(get())
    }
}