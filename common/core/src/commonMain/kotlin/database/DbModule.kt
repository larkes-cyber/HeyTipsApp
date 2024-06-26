package database

import org.koin.dsl.module
import org.larkes.heytips.TipsDatabase

val dbModule = module {
    single {
        TipsDatabase(DbDriverFactory(get()).provideDbDriver(TipsDatabase.Schema))
    }
}