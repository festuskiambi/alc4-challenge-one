package com.example.alcchallengeone.ui


import android.content.Context
import android.graphics.Bitmap
import android.net.http.SslError
import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.*
import android.widget.Toast

import com.example.alcchallengeone.R
import kotlinx.android.synthetic.main.fragment_alc.*

class AlcFragment : Fragment() {

    private val url= "https://andela.com/alc/"

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_alc, container, false)
    }

    override fun onStart() {
        super.onStart()
        setupWebView()
    }

    private fun setupWebView() {
        // Get the web view settings instance
        val settings = web_view.settings

        // Enable java script in web view
        settings.javaScriptEnabled = true

        // Enable and setup web view cache
        settings.setAppCacheEnabled(true)
        settings.cacheMode = WebSettings.LOAD_DEFAULT
        settings.setAppCachePath(context!!.cacheDir.path)


        // Enable zooming in web view
        settings.setSupportZoom(true)
        settings.builtInZoomControls = true
        settings.displayZoomControls = true


        // Zoom web view text
        settings.textZoom = 125


        // Enable disable images in web view
        settings.blockNetworkImage = false
        // Whether the WebView should load image resources
        settings.loadsImagesAutomatically = true


        // More web view settings
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            settings.safeBrowsingEnabled = true  // api 26
        }
        //settings.pluginState = WebSettings.PluginState.ON
        settings.useWideViewPort = true
        settings.loadWithOverviewMode = true
        settings.javaScriptCanOpenWindowsAutomatically = true
        settings.mediaPlaybackRequiresUserGesture = false


        // More optional settings, you can enable it by yourself
        settings.domStorageEnabled = true
        settings.setSupportMultipleWindows(true)
        settings.loadWithOverviewMode = true
        settings.allowContentAccess = true
        settings.setGeolocationEnabled(true)
        settings.allowUniversalAccessFromFileURLs = true
        settings.allowFileAccess = true

        // WebView settings
        web_view.fitsSystemWindows = true


        /*
            if SDK version is greater of 19 then activate hardware acceleration
            otherwise activate software acceleration
        */
        web_view.setLayerType(View.LAYER_TYPE_HARDWARE, null)


        // Set web view client
        web_view.webViewClient = object: WebViewClient(){
            override fun onPageStarted(view: WebView, url: String, favicon: Bitmap?) {
                // Page loading started
                // Do something
                toast("Page loading.")

            }

            override fun onPageFinished(view: WebView, url: String) {
                // Page loading finished
                // Display the loaded page title in a toast message

            }

            override fun onReceivedSslError(view: WebView?, handler: SslErrorHandler?, error: SslError?) {
                handler!!.proceed()
            }
        }


        // Set web view chrome client
        web_view.webChromeClient = object: WebChromeClient(){
            override fun onProgressChanged(view: WebView, newProgress: Int) {
            }
        }

        web_view.loadUrl(url)
    }
    fun toast(message: String) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }

}

