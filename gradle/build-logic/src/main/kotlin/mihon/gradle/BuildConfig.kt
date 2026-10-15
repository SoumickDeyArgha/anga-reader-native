package mihon.gradle

import org.gradle.api.Project

interface BuildConfig {
    val includeTelemetry: Boolean
    val uploadCrashlyticsMapping: Boolean
    val enableUpdater: Boolean
    val includeDependencyInfo: Boolean
}

private enum class Distribution {
    LOCAL,
    CI,
    GITHUB,
    FOSS,
}

val Project.Config: BuildConfig get() = object : BuildConfig {
    // Independent fork: do not send data to upstream Mihon services.
    override val includeTelemetry: Boolean = false

    // Independent fork: do not use Mihon's upstream update endpoint.
    override val enableUpdater: Boolean = false
    override val includeDependencyInfo: Boolean = project.hasProperty("include-dependency-info")
}

private val distributionNames = Distribution.entries.joinToString { it.name.lowercase() }

private fun Project.flag(name: String): Boolean? = providers.gradleProperty(name).orNull
    ?.let { it.isEmpty() || it.toBoolean() }
