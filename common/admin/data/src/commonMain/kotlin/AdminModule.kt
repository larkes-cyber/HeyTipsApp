import org.koin.dsl.module

val adminModule = module {
    single<AdminRepository> { AdminRepositoryImpl(get()) }
}