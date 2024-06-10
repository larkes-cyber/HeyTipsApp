import org.koin.dsl.module

val userModule = module{
    single<UserRepository> {
        UserRepositoryImpl(get())
    }
}