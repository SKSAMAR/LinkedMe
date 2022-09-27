package com.samar.linkedmewithmaterial3.presentation.landing

import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.samar.linkedmewithmaterial3.presentation.ui.theme.LinkedMewithMaterial3Theme
import com.samar.linkedmewithmaterial3.util.common.BaseComponentAct
import dagger.hilt.android.AndroidEntryPoint


class LandingActivity : BaseComponentAct() {

    private val viewModel by viewModels<LandingViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContent { LinkedMewithMaterial3Theme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    BaseScaffold {
                        LandingScreen(viewModel)
                    }
                }
            }
        }
    }
}