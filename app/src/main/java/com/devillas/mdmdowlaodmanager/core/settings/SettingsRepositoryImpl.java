package com.devillas.mdmdowlaodmanager.core.settings;



import android.content.Context;
import android.content.SharedPreferences;
import android.media.RingtoneManager;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;

import com.devillas.mdmdowlaodmanager.R;

import com.devillas.mdmdowlaodmanager.utils.Utils;

import io.reactivex.Flowable;
import com.devillas.mdmdowlaodmanager.core.model.data.entity.SystemFacadeHelper;
import com.devillas.mdmdowlaodmanager.utils.UserAgentUtils;
public class SettingsRepositoryImpl implements SettingsRepository{

private Context appContext;
private SharedPreferences pref;


private static class Default{
    /* Appearance settings */
static int theme(@NonNull Context context){
return Integer.parseInt(context.getString(R.string.pref_theme_light_value));

}
static final boolean progressNotify = true;
static  final  boolean finishNotify = true;
static final boolean pendingNotify = true;
static final String notifySound = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION).toString();
static final boolean playSoundNotify =true;
static final boolean ledIndicatorNotify = true;
static final boolean vibrationNotify = true;
static int ledIndicatorColorNotify(@NonNull Context context){
return ContextCompat.getColor(context,R.color.primary);
}
    /* Behavior settings */
    static final boolean unmeteredConnectionOnly = false;
static final boolean enableRoaming = true;
static final boolean autoStart = false;
static final boolean cpuDoNotSleep = false;
static final boolean onlyCharging = false;
static final boolean batteryControl =false;
static final boolean customBatteryControl =false;
static final int customBatteryControlValue = Utils.getDefaultBatteryLowLevel();
static final int timeOut= HttpConnection.DEFAULT_TIMEOUT;
static final boolean replaceDuplicateDownloads = true;
static final boolean autoConnect = true;

   public static String userAgent(@NonNull Context context)
    {
        String userAgent = SystemFacadeHelper.getSystemFacade(context).getSystemUserAgent();

        return (userAgent == null ? UserAgentUtils.defaultUserAgents[0].userAgent : userAgent);
    }

}




    @Override
    public Flowable<String> observeSettingsChanged() {
        return null;
    }

    @Override
    public int theme() {
        return 0;
    }

    @Override
    public void theme(int val) {

    }

    @Override
    public boolean progressNotify() {
        return false;
    }

    @Override
    public void progressNotify(boolean val) {

    }

    @Override
    public boolean finishNotify() {
        return false;
    }

    @Override
    public void finishNotify(boolean val) {

    }

    @Override
    public boolean pendingNotify() {
        return false;
    }

    @Override
    public void pendingNotify(boolean val) {

    }

    @Override
    public String notifySound() {
        return null;
    }

    @Override
    public void notifySound(String val) {

    }

    @Override
    public boolean playSoundNotify() {
        return false;
    }

    @Override
    public void playSoundNotify(boolean val) {

    }

    @Override
    public boolean ledIndicatorNotify() {
        return false;
    }

    @Override
    public void ledIndicatorNotify(boolean val) {

    }

    @Override
    public boolean vibrationNotify() {
        return false;
    }

    @Override
    public void vibrationNotify(boolean val) {

    }

    @Override
    public int ledIndicatorColorNotify() {
        return 0;
    }

    @Override
    public void ledIndicatorColorNotify(int val) {

    }

    @Override
    public boolean unmeteredConnectionOnly() {
        return false;
    }

    @Override
    public void unmeteredConnectionOnly(boolean val) {

    }

    @Override
    public boolean enabledRoaming() {
        return false;
    }

    @Override
    public void enabledRoaming(boolean val) {

    }

    @Override
    public boolean autostart() {
        return false;
    }

    @Override
    public void autostart(boolean val) {

    }

    @Override
    public boolean cpuDoNotSleep() {
        return false;
    }

    @Override
    public void cpuDoNotSleep(boolean val) {

    }

    @Override
    public boolean onlyCharging() {
        return false;
    }

    @Override
    public void onlyCharging(boolean val) {

    }

    @Override
    public boolean batteryControl() {
        return false;
    }

    @Override
    public void batteryControl(boolean val) {

    }

    @Override
    public boolean customBatteryControl() {
        return false;
    }

    @Override
    public void customBatteryControl(boolean val) {

    }

    @Override
    public int customBatteryControlValue() {
        return 0;
    }

    @Override
    public void customBatteryControlValue(boolean val) {

    }

    @Override
    public int timeOut() {
        return 0;
    }

    @Override
    public void timeOut(int val) {

    }

    @Override
    public boolean replaceDuplicateDownloads() {
        return false;
    }

    @Override
    public void replaceDuplicateDownloads(boolean val) {

    }

    @Override
    public boolean autoConnect() {
        return false;
    }

    @Override
    public void autoConnect(boolean val) {

    }

    @Override
    public String userAgent() {
        return null;
    }

    @Override
    public void userAgent(String val) {

    }

    @Override
    public int maxActiveDownloads() {
        return 0;
    }

    @Override
    public void maxActiveDownloads(int val) {

    }

    @Override
    public int maxDownloadRetries() {
        return 0;
    }

    @Override
    public void maxDownloadRetries(int val) {

    }

    @Override
    public int speedLimit() {
        return 0;
    }

    @Override
    public void speedLimit(int val) {

    }

    @Override
    public String saveDownloadIn() {
        return null;
    }

    @Override
    public void saveDownloadIn(String val) {

    }

    @Override
    public boolean moveAfterDownload() {
        return false;
    }

    @Override
    public void moveAfterDownload(boolean val) {

    }

    @Override
    public String moveAfterDownloadIn() {
        return null;
    }

    @Override
    public void moveAfterDownloadIn(String val) {

    }

    @Override
    public boolean deleteFileIfError() {
        return false;
    }

    @Override
    public void deleteFileIfError(boolean val) {

    }

    @Override
    public boolean preallocateDiskSpace() {
        return false;
    }

    @Override
    public void preallocateDiskSpace(boolean val) {

    }

    @Override
    public boolean browserAllowJavaScripts() {
        return false;
    }

    @Override
    public void browserAllowJavaScripts(boolean val) {

    }

    @Override
    public boolean browserAllowPopupWindows() {
        return false;
    }

    @Override
    public void browserAllowPopupWindows(boolean val) {

    }

    @Override
    public boolean browserLauncherIcon() {
        return false;
    }

    @Override
    public void browserLauncherIcon(boolean val) {

    }

    @Override
    public boolean browserEnableCaching() {
        return false;
    }

    @Override
    public void browserEnableCaching(boolean val) {

    }

    @Override
    public boolean browserEnableCookies() {
        return false;
    }

    @Override
    public void browserEnableCookies(boolean val) {

    }

    @Override
    public boolean browserDisableFromSystem() {
        return false;
    }

    @Override
    public void browserDisabledFromSystem(boolean val) {

    }

    @Override
    public String browserStartPage() {
        return null;
    }

    @Override
    public void browserStartPage(String val) {

    }

    @Override
    public boolean browserBottomAddressBar() {
        return false;
    }

    @Override
    public void browserBottomAddressBar(boolean val) {

    }

    @Override
    public boolean browserDoNotTrack() {
        return false;
    }

    @Override
    public void browserDoNotTrack(boolean val) {

    }

    @Override
    public String browserSearchEngine() {
        return null;
    }

    @Override
    public void browserSearchEngine(String val) {

    }

    @Override
    public boolean browserHideMenuIcon() {
        return false;
    }

    @Override
    public void browserHideMenuIcon(boolean val) {

    }
}
