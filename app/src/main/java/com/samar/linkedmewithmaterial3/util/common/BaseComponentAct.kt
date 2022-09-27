package com.samar.linkedmewithmaterial3.util.common

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.samar.linkedmewithmaterial3.util.component.ConnectionLiveData
import com.samar.linkedmewithmaterial3.util.component.sdp
import com.samar.linkedmewithmaterial3.util.component.textSdp
import me.onebone.toolbar.CollapsingToolbarScaffold
import me.onebone.toolbar.CollapsingToolbarScope
import me.onebone.toolbar.ScrollStrategy
import me.onebone.toolbar.rememberCollapsingToolbarScaffoldState

open class BaseComponentAct : ComponentActivity() {

    lateinit var connectionLiveData: ConnectionLiveData

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        connectionLiveData = ConnectionLiveData(this@BaseComponentAct)
    }


    @OptIn(ExperimentalMaterial3Api::class)
    @SuppressLint("UnusedMaterialScaffoldPaddingParameter",
        "UnusedMaterial3ScaffoldPaddingParameter"
    )
    @Composable
    open fun BaseScaffold(
        topBar: @Composable () -> Unit = {},
        bottomBar: @Composable ()->Unit = {},
        content: @Composable () -> Unit
    ) {
        val isNetworkAvailable = connectionLiveData.observeAsState(true)

        Scaffold(
            topBar = topBar,
            bottomBar = bottomBar,
        ) {
            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                AnimatedVisibility(
                    visible = !isNetworkAvailable.value,
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight(.05f)
                ) {
                    Card(
                        modifier = Modifier
                            .fillMaxSize(),
                        colors = CardDefaults.cardColors(
                            containerColor = MaterialTheme.colorScheme.errorContainer,
                        ),
                        shape = RoundedCornerShape(0.dp),
                        elevation = CardDefaults.cardElevation(3.sdp),
                    ) {
                        Row(
                            modifier = Modifier
                                .fillMaxSize(),
                            horizontalArrangement = Arrangement.Center,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = "No Internet Available",
                                color = MaterialTheme.colorScheme.error,
                                fontSize = 12.textSdp
                            )
                        }
                    }
                }
                content()
            }
        }


    }



    @Composable
    fun BaseCollapsingToolbarScaffold(
        toolbar: @Composable CollapsingToolbarScope.() -> Unit,
        content: @Composable () -> Unit,
    ) {
        val isNetworkAvailable = connectionLiveData.observeAsState(true)
        val toolbarState = rememberCollapsingToolbarScaffoldState()
        CollapsingToolbarScaffold(
            modifier = Modifier,
            state = toolbarState,
            scrollStrategy = ScrollStrategy.EnterAlways,
            toolbar = toolbar) {
            Column(
                modifier = Modifier.fillMaxSize()
            ) {
                AnimatedVisibility(
                    visible = !isNetworkAvailable.value,
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight(.05f)
                ) {
                    Card(
                        modifier = Modifier
                            .fillMaxSize(),
                        colors = CardDefaults.cardColors(
                            containerColor = MaterialTheme.colorScheme.errorContainer,
                        ),
                        shape = RoundedCornerShape(0.dp),
                        elevation = CardDefaults.cardElevation(3.sdp),
                    ) {
                        Row(
                            modifier = Modifier
                                .fillMaxSize(),
                            horizontalArrangement = Arrangement.Center,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = "No Internet Available",
                                color = Color.Red,
                                fontSize = 12.sp
                            )
                        }
                    }
                }
                content()
            }

        }

    }


}