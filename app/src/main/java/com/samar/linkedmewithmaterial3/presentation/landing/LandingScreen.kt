package com.samar.linkedmewithmaterial3.presentation.landing

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.samar.linkedmewithmaterial3.presentation.common.ScreenConfig
import com.samar.linkedmewithmaterial3.presentation.landing.component.LandingButtons
import com.samar.linkedmewithmaterial3.presentation.landing.component.LogoImage
import com.samar.linkedmewithmaterial3.util.component.sdp

@Composable
fun LandingScreen(
    viewModel: LandingViewModel
){
    ScreenConfig(
        horizontalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalAlignment = Alignment.CenterVertically,
        verticalArrangement = Arrangement.SpaceBetween,
        rowContent = {
            LogoImage(
                modifier = Modifier.weight(1f)
            )
            LandingButtons(modifier = Modifier.weight(1f), viewModel = viewModel)
        },
        columnContent = {
            Spacer(modifier = Modifier.height(80.sdp))
            LogoImage(
                modifier = Modifier.weight(1f)
            )
            LandingButtons(modifier = Modifier.weight(1f).padding(bottom = 50.sdp), viewModel = viewModel)
        }
    )
}