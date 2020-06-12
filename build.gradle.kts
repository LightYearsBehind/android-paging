buildscript {
    rootProject.extra.apply {
        set("appcompat_version", "1.1.0")
        set("kotlin_version", "1.3.72")
        set("material_version", "1.1.0")

        set("junit_version", "4.13")

        set("test_ext_version", "1.1.1")
        set("test_espresso_version", "3.2.0")
    }

    repositories {
        google()
        jcenter()
    }

    dependencies {
        classpath("com.android.tools.build:gradle:4.0.0")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:${rootProject.extra["kotlin_version"]}")
    }
}

allprojects {
    repositories {
        google()
        jcenter()
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}