/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2016 Rurio Luca
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */


package permission.auron.com.permissionhelper.utils;

import android.Manifest;
import android.os.Build;
import androidx.annotation.RequiresApi;

/**
 * Created by luca on 2/29/16.
 */



public class PermissionUtils {
    @RequiresApi(api = Build.VERSION_CODES.KITKAT_WATCH)
    public static final String Manifest_BODY_SENSORS = Manifest.permission.BODY_SENSORS;
    public static final String Manifest_READ_CALENDAR = Manifest.permission.READ_CALENDAR;
    public static final String Manifest_WRITE_CALENDAR = Manifest.permission.WRITE_CALENDAR;
    public static final String Manifest_READ_CONTACTS = Manifest.permission.READ_CONTACTS;
    public static final String Manifest_WRITE_CONTACTS = Manifest.permission.WRITE_CONTACTS;
    public static final String Manifest_GET_ACCOUNTS = Manifest.permission.GET_ACCOUNTS;
    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    public static final String Manifest_READ_EXTERNAL_STORAGE = Manifest.permission.READ_EXTERNAL_STORAGE;
    @RequiresApi(api = Build.VERSION_CODES.DONUT)
    public static final String Manifest_WRITE_EXTERNAL_STORAGE = Manifest.permission.WRITE_EXTERNAL_STORAGE;
    public static final String Manifest_ACCESS_FINE_LOCATION = Manifest.permission.ACCESS_FINE_LOCATION;
    public static final String Manifest_ACCESS_COARSE_LOCATION = Manifest.permission.ACCESS_COARSE_LOCATION;
    public static final String Manifest_RECORD_AUDIO = Manifest.permission.RECORD_AUDIO;
    public static final String Manifest_READ_PHONE_STATE = Manifest.permission.READ_PHONE_STATE;
    public static final String Manifest_CALL_PHONE = Manifest.permission.CALL_PHONE;
    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    public static final String Manifest_READ_CALL_LOG = Manifest.permission.READ_CALL_LOG;
    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    public static final String Manifest_WRITE_CALL_LOG = Manifest.permission.WRITE_CALL_LOG;
    @RequiresApi(api = Build.VERSION_CODES.ICE_CREAM_SANDWICH)
    public static final String Manifest_ADD_VOICEMAIL = Manifest.permission.ADD_VOICEMAIL;
    @RequiresApi(api = Build.VERSION_CODES.GINGERBREAD)
    public static final String Manifest_USE_SIP = Manifest.permission.USE_SIP;
    public static final String Manifest_PROCESS_OUTGOING_CALLS = Manifest.permission.PROCESS_OUTGOING_CALLS;
    public static final String Manifest_CAMERA = Manifest.permission.CAMERA;
    public static final String Manifest_SEND_SMS = Manifest.permission.SEND_SMS;
    public static final String Manifest_RECEIVE_SMS = Manifest.permission.RECEIVE_SMS;
    public static final String Manifest_READ_SMS = Manifest.permission.READ_SMS;
    public static final String Manifest_RECEIVE_WAP_PUSH = Manifest.permission.RECEIVE_WAP_PUSH;
    public static final String Manifest_RECEIVE_MMS = Manifest.permission.RECEIVE_MMS;
    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    public static final String Manifest_GROUP_CALENDAR = Manifest.permission_group.CALENDAR;
    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    public static final String Manifest_GROUP_CAMERA = Manifest.permission_group.CAMERA;
    @RequiresApi(api = Build.VERSION_CODES.M)
    public static final String Manifest_GROUP_CONTACTS = Manifest.permission_group.CONTACTS;
    public static final String Manifest_GROUP_LOCATION = Manifest.permission_group.LOCATION;
    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    public static final String Manifest_GROUP_MICROPHONE = Manifest.permission_group.MICROPHONE;
    @RequiresApi(api = Build.VERSION_CODES.M)
    public static final String Manifest_GROUP_PHONE = Manifest.permission_group.PHONE;
    @RequiresApi(api = Build.VERSION_CODES.M)
    public static final String Manifest_GROUP_SENSORS = Manifest.permission_group.SENSORS;
    @RequiresApi(api = Build.VERSION_CODES.M)
    public static final String Manifest_GROUP_SMS = Manifest.permission_group.SMS;
    @RequiresApi(api = Build.VERSION_CODES.DONUT)
    public static final String Manifest_GROUP_STORAGE = Manifest.permission_group.STORAGE;
    @RequiresApi(api = Build.VERSION_CODES.P)
    public static final String Manifest_GROUP_CALL_LOG = Manifest.permission_group.CALL_LOG;
}
