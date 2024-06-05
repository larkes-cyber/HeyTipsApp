plugins {
    // this is necessary to avoid the plugins to be loaded multiple times
    // in each subproject's classloader
    id(libs.plugins.kotlin.get().pluginId).apply(false)
    id(libs.plugins.android.get().pluginId).apply(false)
    id(libs.plugins.compose.get().pluginId).apply(false)
    id(libs.plugins.libres.get().pluginId).apply(false)
}