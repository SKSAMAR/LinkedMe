package com.samar.linkedmewithmaterial3.util.component

import android.os.Build
import android.view.View
import android.view.Window
import androidx.annotation.RequiresApi
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.luminance
import androidx.compose.ui.graphics.toArgb
import com.samar.linkedmewithmaterial3.presentation.ui.theme.LinkedMewithMaterial3Theme

@Composable
fun SystemUi(windows: Window) =
    LinkedMewithMaterial3Theme {
        windows.statusBarColor = MaterialTheme.colorScheme.surface.toArgb()
        windows.navigationBarColor = MaterialTheme.colorScheme.surface.toArgb()

        @Suppress("DEPRECATION")
        if (MaterialTheme.colorScheme.surface.luminance() > 0.5f) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                windows.decorView.systemUiVisibility = windows.decorView.systemUiVisibility or
                        View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
            }
        }

        @Suppress("DEPRECATION")
        if (MaterialTheme.colorScheme.surface.luminance() > 0.5f) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                windows.decorView.systemUiVisibility = windows.decorView.systemUiVisibility or
                        View.SYSTEM_UI_FLAG_LIGHT_NAVIGATION_BAR
            }
        }
    }