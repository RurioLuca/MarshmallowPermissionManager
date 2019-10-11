# PermissionHelper

[![Platform (Android)](https://img.shields.io/badge/platform-Android-blue.svg?style=flat-square)](http://www.android.com)
[![ Android Arsenal](https://img.shields.io/badge/Android%20Arsenal-MarshmallowPermissionManager-green.svg?style=true)](https://android-arsenal.com/details/1/3234)
[![GitHub license](https://img.shields.io/github/license/mashape/apistatus.svg)](https://github.com/RurioLuca/MarshmallowPermissionManager/blob/master/License)
<!--[![Codewake](https://www.codewake.com/badges/ask_question_flat_square.svg)](https://www.codewake.com/p/marshmallowpermissionmanager)-->
[![FOSSA Status](https://app.fossa.io/api/projects/git%2Bgithub.com%2FRurioLuca%2FPermissionManager.svg?type=shield)](https://app.fossa.io/projects/git%2Bgithub.com%2FRurioLuca%2FPermissionManager?ref=badge_shield)
[ ![Download](https://api.bintray.com/packages/auron/maven/permission-manage/images/download.svg) ](https://bintray.com/auron/maven/permission-manage/_latestVersion) 
[![API](https://img.shields.io/badge/API-9%2B-brightgreen.svg?style=flat)](https://android-arsenal.com/api?level=15)
[![GitHub stars](https://img.shields.io/github/stars/RurioLuca/MarshmallowPermissionManager.svg)](https://github.com/RurioLuca/MarshmallowPermissionManager/stargazers)
[![GitHub forks](https://img.shields.io/github/forks/RurioLuca/MarshmallowPermissionManager.svg)](https://github.com/RurioLuca/MarshmallowPermissionManager/network) 
[![GitHub issues](https://img.shields.io/github/issues/RurioLuca/MarshmallowPermissionManager.svg)](https://github.com/RurioLuca/MarshmallowPermissionManager/issues) 

#### Helper to ask runtime permission on Android

The library takes care themselves to check whether a permit has already been agreed by the user or not.
if the user has given consent call the system dialog for the acceptance

![Logo](https://raw.githubusercontent.com/RurioLuca/MarshmallowPermissionManager/master/img/web_hi_res_400.png)

![Screen](https://raw.githubusercontent.com/RurioLuca/MarshmallowPermissionManager/master/img/screener_20170126.png)

### Demo

A demo app is available on Google Play:

<a href="https://play.google.com/store/apps/details?id=permission.auron.com.marshmallowpermissionhelper">
	<img alt="Get it on Google Play" src="https://play.google.com/intl/en_us/badges/images/generic/it-play-badge.png" height="60" />
</a>

### Requirements

The library requires Android **API Level 15+**.


### Import

in build.gradle

```Gradle
allprojects {
    repositories {
        jcenter()
    }
}

```
```Gradle
dependencies {
 implementation 'com.auron:permission-manage:1.2.0'
}
```

### How to use

#### Activity

Activity extends ActivityManagePermission

```java

public class MainActivity extends ActivityManagePermission {

}
```

sample usage to ask camera permission



```java
  askCompactPermission(PermissionUtils.Manifest_CAMERA, new PermissionResult() {
                    @Override
                    public void permissionGranted() {
                        //permission granted
                        //replace with your action
                    }

                    @Override
                    public void permissionDenied() {
                        //permission denied
                        //replace with your action
                    }
                       @Override
                    public void permissionForeverDenied() {
                     // user has check never ask again
                     // you need to open setting manually
                     //  Intent intent = new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
                     //  Uri uri = Uri.fromParts("package", getPackageName(), null);
                     //   intent.setData(uri);
                     //  startActivityForResult(intent, REQUEST_PERMISSION_SETTING); 
                    }
                });
```

#### Fragment

FragmentHome extends FragmentManagePermission

```java

public class FragmentHome extends FragmentManagePermission {

}
```

sample usage to ask camera permission


```java
  askCompactPermission(PermissionUtils.Manifest_CAMERA, new PermissionResult() {
                    @Override
                    public void permissionGranted() {
                        //permission granted
                        //replace with your action
                    }

                    @Override
                    public void permissionDenied() {
                        //permission denied
                        //replace with your action
                    }
                     @Override
                    public void permissionForeverDenied() {
                     // user has check never ask again
                     // you need to open setting manually
                     //  Intent intent = new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
                     //  Uri uri = Uri.fromParts("package", getPackageName(), null);
                     //   intent.setData(uri);
                     //  startActivityForResult(intent, REQUEST_PERMISSION_SETTING); 
                    }
                });
```

# Advance Usage

#### check whether a permit has been agreed

```java
boolean isGranted = isPermissionGranted(MainActivity.this,PermissionUtils.Manifest_WRITE_EXTERNAL_STORAGE);
```

#### check whether multiple permission has been agreed

```java
boolean isGranted = isPermissionsGranted(MainActivity.this,new String[]{PermissionUtils.Manifest_WRITE_EXTERNAL_STORAGE,PermissionUtils.Manifest_CAMERA});
```

#### PermissionUtils

The permission class utils contains the permissions you need to ask runtime

### Multiple Permissions


```java
  askCompactPermissions(new String[]{PermissionUtils.Manifest_CAMERA, PermissionUtils.Manifest_WRITE_EXTERNAL_STORAGE}, new PermissionResult() {
            @Override
            public void permissionGranted() {
                //permission granted
                //replace with your action
            }

            @Override
            public void permissionDenied() {
                //permission denied
                //replace with your action
            }
             @Override
                    public void permissionForeverDenied() {
                     // user has check 'never ask again'
                     // you need to open setting manually
                     //  Intent intent = new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
                     //  Uri uri = Uri.fromParts("package", getPackageName(), null);
                     //   intent.setData(uri);
                     //  startActivityForResult(intent, REQUEST_PERMISSION_SETTING); 
                    }
        });
```
### Group Permissions


```java
  askCompactPermission(PermissionUtils.Manifest_GROUP_STORAGE, PermissionUtils.Manifest_WRITE_EXTERNAL_STORAGE}, new PermissionResult() {
            @Override
            public void permissionGranted() {
                //permission granted
                //replace with your action
            }

            @Override
            public void permissionDenied() {
                //permission denied
                //replace with your action
            }
             @Override
                    public void permissionForeverDenied() {
                     // user has check 'never ask again'
                     // you need to open setting manually
                     //  Intent intent = new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
                     //  Uri uri = Uri.fromParts("package", getPackageName(), null);
                     //   intent.setData(uri);
                     //  startActivityForResult(intent, REQUEST_PERMISSION_SETTING); 
                    }
        });
```
#### Open Setting Application

need class extend FragmentManagePermission or ActivityManagePermission

```java

 openSettingsApp(MainActivity.this);

```
### Javadoc
[Javadoc](http://rurioluca.github.io/MarshmallowPermissionManager/javadoc/) thanks to [rebus007](https://github.com/rebus007)


### Developed By
Rurio Luca- [rurio.luca@gmail.com](mailto:rurio.luca@gmail.com)

[![Linkedin](https://raw.githubusercontent.com/RurioLuca/MarshmallowPermissionManager/master/img/social/linkedin-icon.png) ](https://it.linkedin.com/in/luca-rurio-5a4462107)

### App using PermissionHelper


  * [Material Qr](https://play.google.com/store/apps/details?id=qrreader.com.studios.it.qrreader)
  * [Volo](https://play.google.com/store/apps/details?id=volo.tsc.it.volo)
  * [Volo Oss](https://play.google.com/store/apps/details?id=volontario.volo.tsc.it.volontario)
  * [Gespat](https://play.google.com/store/apps/details?id=gespat.tsc.it.gespat)
  * [PermissionManager](https://play.google.com/store/apps/details?id=permission.auron.com.marshmallowpermissionhelper)
  * [2017 Best Status - Quotes](https://play.google.com/store/apps/details?id=com.latest.best.whatsapp.status)
  * [My Notebook](https://play.google.com/store/apps/details?id=com.notes.dairy.notebook)
  * [Styled Map With Pager](https://play.google.com/store/apps/details?id=com.thebrownarrow.styledmapwithpager)
  * [Mercatini Usato](https://play.google.com/store/apps/details?id=it.auron.mercatino&hl=it)

send me your apps!
rurio.luca@gmail.com

# License

The MIT License (MIT)

Copyright (c) 2016 Rurio Luca

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.


[![FOSSA Status](https://app.fossa.io/api/projects/git%2Bgithub.com%2FRurioLuca%2FPermissionManager.svg?type=large)](https://app.fossa.io/projects/git%2Bgithub.com%2FRurioLuca%2FPermissionManager?ref=badge_large)
