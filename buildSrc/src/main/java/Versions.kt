import org.gradle.api.JavaVersion

object Versions {

    // Sdk and tools
    const val COMPILE_SDK = 34
    const val MIN_SDK = 24
    const val TARGET_SDK = 34

    val JAVA_VERSION = JavaVersion.VERSION_1_8
    const val JVM_TARGET = "1.8"

    // app version
    const val VERSION_CODE = 1
    const val VERSION_NAME = "1.0"

    // kotlin
    const val COROUTINES = "1.6.4"

    // jetpack
    const val CORE = "1.13.0"
    const val APP_COMPAT = "1.6.1"
    const val CONSTRAINT_LAYOUT = "2.1.4"
    const val NAVIGATION = "2.7.7"

    // google
    const val MATERIAL = "1.11.0"
    const val GSON = "2.10.1"

    // hilt
    const val HILT = "2.51.1"

    // 3rd
    const val OKHTTP_BOM = "4.12.0"
    const val RETROFIT = "2.9.0"

    // test
    const val JUNIT_TEST = "4.13.2"
    const val JUNIT = "1.1.5"
    const val ESPRESSO = "3.5.1"
}