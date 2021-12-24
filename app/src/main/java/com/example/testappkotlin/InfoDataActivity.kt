package com.example.testappkotlin

import android.os.Bundle
import android.webkit.JavascriptInterface
import android.webkit.WebChromeClient
import android.webkit.WebView
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.testappkotlin.Models.DataObject
import com.example.testappkotlin.Network.RetrofitInstance
import com.example.testappkotlin.ViewModels.DataViewModel
import kotlinx.android.synthetic.main.activity_info_data.*

class InfoDataActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_info_data)
        val wv :WebView = findViewById(R.id.webView)

        wv.webChromeClient = WebChromeClient()
        wv.settings.javaScriptEnabled = true
        wv.loadUrl(RetrofitInstance.BASE_URl)
        wv.addJavascriptInterface(JsObject(), "injectedObject")

    }
    class JsObject {
        @JavascriptInterface
        override fun toString(): String {
            return "Hi from injectedObject"
        }
    }
}