import database.TipsSqlDelightDataSource
import ktor.TipsKtorDataSource
import org.koin.dsl.module

val tipsModule = module {
    factory { TipsSqlDelightDataSource(get()) }
    factory { TipsKtorDataSource(get()) }
    factory<TipsRepository> { TipsRepositoryImpl(get(), get()) }
}