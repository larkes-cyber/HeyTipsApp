package ktor

import app.cash.sqldelight.driver.jdbc.sqlite.JdbcSqliteDriver
import org.larkes.heytips.TipsDatabase

object TestSqlDelightDriverFactory {
    suspend fun create() = JdbcSqliteDriver(JdbcSqliteDriver.IN_MEMORY)
}