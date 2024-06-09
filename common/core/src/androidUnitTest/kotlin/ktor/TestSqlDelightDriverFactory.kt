package ktor

import app.cash.sqldelight.driver.jdbc.sqlite.JdbcSqliteDriver
import org.larkes.contacts.TipsDatabase

object TestSqlDelightDriverFactory {
    suspend fun create() = JdbcSqliteDriver(JdbcSqliteDriver.IN_MEMORY)
}