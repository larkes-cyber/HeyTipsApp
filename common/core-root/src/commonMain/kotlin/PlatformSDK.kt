import di.Inject
import org.koin.core.context.startKoin
import org.koin.dsl.module

object PlatformSDK {

    fun init(configuration: PlatformConfiguration) {
        val diTree = startKoin {
            modules(module {
                single { configuration }
            })
            modules(coreModule)
            modules(tipsModule)
            modules(adminModule)
            modules(userModule)
        }.koin
        Inject.createDependencies(diTree)
    }

}