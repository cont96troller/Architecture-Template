plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.yoohyun.data"
    compileSdk = Versions.COMPILE_SDK

    defaultConfig {
        minSdk = Versions.MIN_SDK

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
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
}

dependencies {

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