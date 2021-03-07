plugins {
    java
}

group = "com.gabriel.redis4bukkit"
version = "1.0"

repositories {
    mavenLocal()
    mavenCentral()

    maven("https://oss.sonatype.org/content/repositories/snapshots")
    maven("https://hub.spigotmc.org/nexus/content/repositories/snapshots/")

}

dependencies {
    implementation("redis.clients:jedis:3.3.0")
    compileOnly("org.spigotmc:spigot-api:1.12.2-R0.1-SNAPSHOT")
}