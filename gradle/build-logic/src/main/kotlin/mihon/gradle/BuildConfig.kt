package mihon.gradle

import org.gradle.api.Project

interface BuildConfig {
    val includeTelemetry: Boolean
    val enableUpdater: Boolean
    val includeDependencyInfo: Boolean
}

val Project.Config: BuildConfig get() = object : BuildConfig {
    // Independent fork: do not send data to upstream Mihon services.
    override val includeTelemetry: Boolean = false
    // Independent fork: do not use Mihon's upstream update endpoint.
    override val enableUpdater: Boolean = false
    override val includeDependencyInfo: Boolean = project.hasProperty("include-dependency-info")
}
