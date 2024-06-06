package ktor

import org.koin.dsl.module

internal val ktorModule = module {
    single {
        HttpEngineFactory().createEngine()
    }
}