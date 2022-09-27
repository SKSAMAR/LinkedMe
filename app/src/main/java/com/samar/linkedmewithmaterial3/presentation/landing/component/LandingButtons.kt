package com.samar.linkedmewithmaterial3.presentation.landing.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.samar.linkedmewithmaterial3.util.component.sdp
import com.samar.linkedmewithmaterial3.R
import com.samar.linkedmewithmaterial3.util.component.textSdp

@Preview(showBackground = true)
@Composable
fun LandingButtons(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Bottom
    ) {
        Card(
            modifier = Modifier.fillMaxWidth(.9f),
            shape =  RoundedCornerShape(22.sdp),
            colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.primary)
        ) {
            Text(
                modifier = Modifier
                    .padding(vertical = 10.sdp)
                    .align(Alignment.CenterHorizontally),
                text = "Join now"
            )
        }
        
        Spacer(modifier = Modifier.height(10.sdp))
        
        Row(
            modifier = Modifier
                .background(
                    shape = RoundedCornerShape(22.sdp),
                    color = MaterialTheme.colorScheme.surface
                )
                .border(
                    width = 0.8.dp,
                    color = MaterialTheme.colorScheme.inverseSurface,
                    shape = RoundedCornerShape(22.sdp)
                )
                .fillMaxWidth(.9f),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ){

            Image(
                modifier = Modifier
                    .size(24.sdp)
                    .aspectRatio(1f)
                    .padding(5.sdp),
                painter = painterResource(id = R.drawable.google),
                contentDescription = null
            )
            Text(
                modifier = Modifier
                    .padding(vertical = 8.sdp),
                text = "Continue with Google",
                fontSize = 16.textSdp
            )
        }

        Spacer(modifier = Modifier.height(10.sdp))

        Row(
            modifier = Modifier
                .background(
                    shape = RoundedCornerShape(22.sdp),
                    color = MaterialTheme.colorScheme.surface
                )
                .border(
                    width = 0.8.dp,
                    color = MaterialTheme.colorScheme.inverseSurface,
                    shape = RoundedCornerShape(22.sdp)
                )
                .fillMaxWidth(.9f),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ){

            Image(
                modifier = Modifier
                    .size(24.sdp)
                    .aspectRatio(1f)
                    .padding(5.sdp),
                painter = painterResource(id = R.drawable.facebook),
                contentDescription = null
            )
            Text(
                modifier = Modifier
                    .padding(vertical = 8.sdp),
                text = "Continue with Facebook",
                fontSize = 16.textSdp
            )
        }

        Spacer(modifier = Modifier.height(10.sdp))

        Text(
            text = "Sign in",
            color = MaterialTheme.colorScheme.primary,
            fontWeight = FontWeight.SemiBold
        )
    }
}