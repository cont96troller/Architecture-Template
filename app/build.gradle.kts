import java.util.Properties

plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

val localProperties = loadProperties(project.rootProject.file("local.properties"))

android {
    namespace = "com.yoohyun.sample"
    compileSdk = Versions.COMPILE_SDK

    defaultConfig {
        applicationId = "com.yoohyun.sample"
        minSdk = Versions.MIN_SDK
        targetSdk = Versions.TARGET_SDK
        versionCode = Versions.VERSION_CODE
        versionName = Versions.VERSION_NAME

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

        val apiKey = localProperties.getProperty("weather.api.key", "")
        buildConfigField("boolean", "WEATHER_API_KEY", apiKey)
    }

    buildTypes {
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
    kotlinOptions {
        jvmTarget = Versions.JVM_TARGET
    }
    buildFeatures {
        viewBinding = true
    }
}

dependencies {
    implementation(project(":data"))
    implementation(project(":domain"))

    implementation("androidx.core:core-ktx:${Versions.CORE}")
    implementation("androidx.appcompat:appcompat:${Versions.APP_COMPAT}")
    implementation("com.google.android.material:material:${Versions.MATERIAL}")
    implementation("androidx.constraintlayout:constraintlayout:${Versions.CONSTRAINT_LAYOUT}")
    implementation("androidx.navigation:navigation-fragment-ktx:${Versions.NAVIGATION}")
    implementation("androidx.navigation:navigation-ui-ktx:${Versions.NAVIGATION}")

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