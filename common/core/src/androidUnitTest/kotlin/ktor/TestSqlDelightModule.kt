package ktor

import app.cash.sqldelight.driver.jdbc.sqlite.JdbcSqliteDriver
import org.koin.dsl.module

internal val testSqlDelightModule = module {
    single {
        JdbcSqliteDriver(JdbcSqliteDriver.IN_MEMORY)
    }
}