  <h1 align="center">HeyTips</h1>
<p align="center">
  <a href="https://opensource.org/licenses/Apache-2.0"><img alt="License" src="https://img.shields.io/badge/License-Apache%202.0-blue.svg"/></a>
  <a href="https://android-arsenal.com/api?level=24"><img alt="API" src="https://img.shields.io/badge/API-24%2B-brightgreen.svg?style=flat"/></a>
</p>
<p align="center">  
  HeyTips is a fullstack cross-platform mobile app that demonstrates modern Compose Multiplatform development with Decompose, Koin, SqlDelight, Ktor based on Multi-Module MVI architecture. Includes admin panel and user sreens based on one technology.
</p>

> [!TIP]
> If you want to see more the Kotlin Multiplatform content, check out the [telegram](https://t.me/snikky_notes) channel.
<img width="1440" alt="image" src="https://github.com/larkes-cyber/HeyTipsApp/assets/79082708/aeae86f0-b91e-484c-a0a6-b6302d586b7f">

## Download
Go to the [Releases](https://github.com/larkes-cyber/HeyTipsApp/releases/tag/publish) to download the latest APK.

## Main features
- Ios/Android/Desktop
- Caching/Pagination
- Image Picker/Internet Images
- Multi-module/MVI
- Unit tests
- MVC ktor server

## Overview
https://github.com/larkes-cyber/HeyTipsApp/assets/79082708/c5a8d48d-8b56-46f8-8229-09546190bbb8

## [Admin overview](https://drive.google.com/file/d/1EE9t2STVpTXjqui5ElY9uj6weLOooZqR/view?usp=sharing)
## [Desktop overview](https://drive.google.com/file/d/1MBCaQKwFDSDqJmL8322-t_sleTriB1GR/view?usp=sharing)

## Tech stack & Open-source libraries
- Minimum SDK level 24
- iOS Deployment Target 15.3
- [Kotlin Multiplatform](https://www.jetbrains.com/kotlin-multiplatform/) based, [Compose Multiplatform](https://www.jetbrains.com/lp/compose-multiplatform/) for Android/Ios/Desktop ui interfaces.
- Kotlin Multiplatform
  -  Expected/actual: Expected and actual declarations allow you to access platform-specific APIs from Kotlin Multiplatform modules. You can provide platform-agnostic APIs in the common code.
  - Gradle kts: Gradle’s Kotlin DSL provides an alternative syntax to the traditional Groovy DSL with an enhanced editing experience in supported IDEs, with superior content assist.
- Architecture
  - Multi-Module Concept: Modularization is a practice of organizing a codebase into loosely coupled and self contained parts. Each part is a module. Each module is independent and serves a clear purpose.
  - Decompose:  library for breaking down your code into tree-structured lifecycle-aware business logic components (aka BLoC), with routing functionality and pluggable UI
  - [Koin](https://insert-koin.io/docs/reference/koin-mp/kmp/): Koin provides us with an all-in kotlin library to use it in our shared module to create injections that can be used by both Android and iOS
  - Repository Pattern: Repository commonly refers to a storage location, often for safety or preservation.
  - [SqlDelight](https://github.com/cashapp/sqldelight):SQLDelight is a powerful tool for implementing data persistence in Kotlin Multiplatform Mobile (KMM) projects
  - [Ktor](https://ktor.io/docs/client-create-multiplatform-application.html):Ktor includes a multiplatform asynchronous HTTP client, which allows you to make requests and handle responses, extend its functionality with plugins, such as authentication, JSON serialization, and so on.
  - [Coil Compose Multiplatform](https://coil-kt.github.io/coil/compose/): Loading images from network.
  



  
