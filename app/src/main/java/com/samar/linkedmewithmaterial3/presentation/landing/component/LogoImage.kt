package com.samar.linkedmewithmaterial3.presentation.landing.component

import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.material.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import com.samar.linkedmewithmaterial3.R

@Composable
fun LogoImage(
    modifier: Modifier = Modifier
){
    Icon(
        modifier = modifier.aspectRatio(0.5625f),
        painter = painterResource(id = R.drawable.logo),
        contentDescription = null,
        tint = MaterialTheme.colorScheme.primary
    )
}