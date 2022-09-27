package com.samar.linkedmewithmaterial3.presentation.landing

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import androidx.activity.compose.setContent
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.facebook.CallbackManager
import com.facebook.FacebookSdk
import com.facebook.login.LoginManager
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.common.api.ApiException
import com.samar.linkedmewithmaterial3.presentation.ui.theme.LinkedMewithMaterial3Theme
import com.samar.linkedmewithmaterial3.util.ViewUtils.showToast
import com.samar.linkedmewithmaterial3.util.common.BaseComponentAct


class LandingActivity : BaseComponentAct() {

    private val viewModel by viewModels<LandingViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN)
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
        initializer()
    }

    private fun initializer(){
        FacebookSdk.sdkInitialize(this)
        viewModel.gsc = GoogleSignIn.getClient(this@LandingActivity, viewModel.gso)
        viewModel.loginWithGoogle = {
            val intent = viewModel.gsc.signInIntent
            googleLoginResult.launch(intent)
        }
    }

    private val googleLoginResult = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result: ActivityResult ->
        if (result.resultCode == Activity.RESULT_OK) {
            val task = GoogleSignIn.getSignedInAccountFromIntent(result.data)
            try {
                val result = task.result
                val message = "${result.displayName}\n${result.email}"
                showToast(message)

            }catch (e: ApiException){
                e.printStackTrace()
                showToast(e.message)
            }
        }
        else{
            showToast("Failed to Login")
        }
    }
}