package database

import org.koin.dsl.module

val dbModule = module {
    single {
        DbDriverFactory(get())
    }
}