# MapMd SDK for Android  [![](https://jitpack.io/v/Mapmd/MapMd.svg)](https://jitpack.io/#Mapmd/MapMd)

<a href="https://play.google.com/store/apps/details?id=md.point.map">
<img src="https://play.google.com/intl/en_us/badges/images/generic/en-play-badge.png" alt="Get it on Play store" height="90"></a>

</br>
Copyright (c) 2019 Simpals </br>

Current Release: **0.1.3 (2019)**

More information about the API can be found on the Map Portal's [API page](https://map.md/api/documentation/).

You have two ways to set up your app to use the MapMd SDK:
- Setting project 
- Setting up your project with the MapMd SDK

**Setting project**

1. Open [Link](https://map.md/ru/api/) </br>
2. Click Button "Get Code" </br>
3. Put your Package Name 
4. Click button "Save"

**Android Studio Setup**
1. Go to Android Studio | New Project.<br />
2. Select API 17: Android 4.1 or higher and create your new project.<br />
3. After you create a new project, open build.gradle and do the following:<br />

>**Gradle dependency**
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


**Platform or API Level (API level 17 = Platform 4.1)**
```xml
<platform>17</platform>
```

