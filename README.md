# Manga Reader

Manga Reader is an independent native Android manga-reader fork based on the [Mihon](https://github.com/mihonapp/mihon) project. It retains the native Kotlin/Android architecture required for local reading, library management, downloads, reader modes, backup/restore, and extension-store support.

## Extension repositories

Manga Reader does not include content. To add a compatible extension store in the app, open **Browse → Extensions → Extension stores**, then add a repository URL you are permitted to use. The Keiyoushi extension catalog is published at:

```
https://github.com/keiyoushi/extensions/raw/repo/index.pb
```

Only install extensions and access sources in accordance with their terms, applicable law, and your rights to the content.

## Cloud builds

GitHub Actions builds an Android APK without requiring Android Studio or the Android SDK on your computer. In the repository, open **Actions → Build Manga Reader APK → Run workflow** and download the generated APK from the completed workflow artifacts.

## Approved upstream updates

Every six hours, the **Prepare Mihon Update for Approval** workflow checks Mihon's latest stable release. When a newer version is available, it opens a pull request named **Prepare Mihon `<version>` for Manga Reader**. Review the pull request and merge it when you are ready; merging to `main` triggers the Android build and publishes the universal APK as a GitHub release.

If the upstream merge has conflicts, the workflow stops without publishing anything. Resolve the conflicts in the pull request before merging so Manga Reader's fork-specific identity and configuration remain intact.

## Attribution and license

This fork is based on Mihon and retains the upstream Apache License 2.0. It uses a distinct name, application ID, launcher icon, app-link scheme, and disables upstream updater and telemetry integrations.
