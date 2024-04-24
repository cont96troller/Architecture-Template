import java.util.Properties

plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
}

val localProperties = loadProperties(project.rootProject.file("local.properties"))

android {
    namespace = "com.yoohyun.data"
    compileSdk = Versions.COMPILE_SDK

    defaultConfig {
        minSdk = Versions.MIN_SDK

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")

        val apiKey = localProperties.getProperty("weather.api.key", "")
        buildConfigField("string", "WEATHER_API_KEY", apiKey)
    }

    buildTypes {
        debug {}
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = Versions.JAVA_VERSION
        targetCompatibility = Versions.JAVA_VERSION
    }

    buildFeatures {
        buildConfig = true
    }

    kotlinOptions {
        jvmTarget = Versions.JVM_TARGET
    }
}

dependencies {
    implementation(project(":domain"))

    implementation("androidx.core:core-ktx:${Versions.CORE}")

    // hilt
    implementation("com.google.dagger:dagger:${Versions.HILT}")
    implementation("com.google.dagger:hilt-android:${Versions.HILT}")

    // coroutines
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.COROUTINES}")

    // okHttp
    implementation(platform("com.squareup.okhttp3:okhttp-bom:${Versions.OKHTTP_BOM}"))
    implementation("com.squareup.okhttp3:okhttp")
    implementation("com.squareup.okhttp3:logging-interceptor")

    // retrofit
    implementation("com.squareup.retrofit2:converter-gson:${Versions.RETROFIT}")
    implementation("com.squareup.retrofit2:retrofit:${Versions.RETROFIT}")

    // gson
    implementation("com.google.code.gson:gson:${Versions.GSON}")

    // test
    testImplementation("junit:junit:${Versions.JUNIT_TEST}")
    androidTestImplementation("androidx.test.ext:junit:${Versions.JUNIT}")
    androidTestImplementation("androidx.test.espresso:espresso-core:${Versions.ESPRESSO}")
}

fun loadProperties(file: File?) = Properties().apply {
    if (file != null && file.exists()) {
        file.inputStream().use { fis ->
            load(fis)
        }
    }
}