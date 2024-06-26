package database

import PlatformConfiguration
import app.cash.sqldelight.async.coroutines.synchronous
import app.cash.sqldelight.db.QueryResult
import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.db.SqlSchema
import app.cash.sqldelight.driver.native.NativeSqliteDriver

actual class DbDriverFactory actual constructor(platformConfiguration: PlatformConfiguration) {
    actual  fun provideDbDriver(schema: SqlSchema<QueryResult.AsyncValue<Unit>>): SqlDriver = NativeSqliteDriver(schema.synchronous(), "heytips.db")
}