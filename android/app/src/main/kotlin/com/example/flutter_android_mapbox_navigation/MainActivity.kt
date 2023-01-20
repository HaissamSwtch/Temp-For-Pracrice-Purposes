package com.example.flutter_android_mapbox_navigation

import android.content.Intent
import androidx.annotation.NonNull
import io.flutter.embedding.android.FlutterActivity
import io.flutter.embedding.engine.FlutterEngine
import io.flutter.plugin.common.MethodChannel

class MainActivity: FlutterActivity() {
    private val CHANNEL = "channelling/turn_by_turn_navigation"
    private val REQUEST_CODE = 1

    override fun configureFlutterEngine(@NonNull flutterEngine: FlutterEngine) {
        super.configureFlutterEngine(flutterEngine)

        MethodChannel(flutterEngine.dartExecutor.binaryMessenger, CHANNEL).setMethodCallHandler {
                call, result ->
                    startActivityForResult(Intent(this, MapboxNavigationActivity::class.java), REQUEST_CODE)

            //      ResourceOptionsManager.getDefault(this, getString(R.string.mapbox_access_token)).update {
            //           tileStoreUsageMode(TileStoreUsageMode.READ_ONLY)
            //      }
        }

        //        GeneratedPluginRegistrant.registerWith(flutterEngine)

    }
}
