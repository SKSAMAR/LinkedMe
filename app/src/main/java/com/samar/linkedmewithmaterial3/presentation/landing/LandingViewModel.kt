package com.samar.linkedmewithmaterial3.presentation.landing

import android.content.Context
import com.facebook.CallbackManager
import com.facebook.FacebookCallback
import com.facebook.FacebookException
import com.facebook.login.LoginManager
import com.facebook.login.LoginResult
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.samar.linkedmewithmaterial3.util.ViewUtils.findActivity
import com.samar.linkedmewithmaterial3.util.common.BaseViewModel
import java.util.*

class LandingViewModel : BaseViewModel<Objects>() {

    //Facebook
    var callbackManager = CallbackManager.Factory.create()

    //Google
    val gso: GoogleSignInOptions = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).requestEmail().build()
    lateinit var gsc: GoogleSignInClient
    lateinit var loginWithGoogle: ()->Unit

    init {
        LoginManager.getInstance().registerCallback(
            callbackManager,
            object : FacebookCallback<LoginResult> {
                override fun onSuccess(loginResult: LoginResult) {
                    println("onSuccess $loginResult")
                }

                override fun onCancel() {
                    println("onCancel")
                }

                override fun onError(exception: FacebookException) {
                    println("onError $exception")
                }
            }
        )
    }



    fun loginWithGoogleAction(){
        loginWithGoogle()
    }


    fun loginWithFacebookAction(context: Context){
        LoginManager.getInstance()
            .logInWithReadPermissions(context.findActivity(), listOf("public_profile"));
    }

    fun loginAction(){

    }

    fun registerAction(){

    }


    override fun onCleared() {
        super.onCleared()
        LoginManager.getInstance().unregisterCallback(callbackManager)
    }



}