# MapMd SDK for Android  [![](https://jitpack.io/v/Mapmd/MapMd.svg)](https://jitpack.io/#Mapmd/MapMd)

<a href="https://play.google.com/store/apps/details?id=md.point.map">
<img src="https://play.google.com/intl/en_us/badges/images/generic/en-play-badge.png" alt="Get it on Play store" height="90"></a>
Copyright (c) 2019 Simpals

This repository holds a series of Java-based projects using the **MapMd SDK for Android**. More information about the API can be found on the Map Portal's [API page](https://map.md/api/documentation/).

This set of individual, use-case based projects is designed to be cloned by developers for their own use.

Current Release: **0.0.21 (2019)**

**Gradle dependency**
```groovy
allprojects {
    repositories {
        maven { url 'https://jitpack.io' }
    }
}

dependencies {
    compile 'com.github.Mapmd:MapMd:<VERSION>'
}
```
Be sure to replace `<VERSION>` with the last release version above.


**Platform or API Level (API level 16 = Platform 4.1)**
```xml
<platform>17</platform>
```

