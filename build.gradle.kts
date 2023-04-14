plugins {
    kotlin("js") version "1.8.0"
}

group = "me.itzbu"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
    implementation("org.jetbrains.kotlin-wrappers:kotlin-react:18.2.0-pre.385")
    implementation("org.jetbrains.kotlin-wrappers:kotlin-react-dom:18.2.0-pre.385")
    implementation("org.jetbrains.kotlin-wrappers:kotlin-emotion:11.10.4-pre.385")
    implementation(npm("@jetbrains/kotlin-wrappers", "1.5.2-pre.214-kotlin-1.5.20"))

}

dependencies {
    implementation("io.ktor:ktor-client-core:1.6.4")
    implementation("io.ktor:ktor-server-netty:1.6.4")

}

kotlin {
    js {
        binaries.executable()
        browser {
            browser {
                dependencies {
                    implementation(npm("react", "17.0.2"))
                    implementation(npm("react-dom", "17.0.2"))
                }
                commonWebpackConfig {
                    cssSupport {
                        enabled.set(true)
                    }
                }
            }
        }
    }
}