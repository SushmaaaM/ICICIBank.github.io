package com.example.android.icicibank;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.android.icicibank.R;

public class MainActivity extends AppCompatActivity {
    private WebView ourBrow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ourBrow = findViewById(R.id.webView);
        ourBrow.getSettings().setJavaScriptEnabled(true);
        ourBrow.setWebViewClient(new MyBrowser());
        ourBrow.loadUrl("https://www.icicibank.com/");

        // Handle the app link intent
        handleIntent(getIntent());
        // ATTENTION: This was auto-generated to handle app links.
        Intent appLinkIntent = getIntent();
        String appLinkAction = appLinkIntent.getAction();
        Uri appLinkData = appLinkIntent.getData();
    }

    private void handleIntent(Intent intent) {
        Uri appLinkData = intent.getData();
        if (appLinkData != null) {
            // Extract the URL from the intent data
            String url = appLinkData.toString();
            // Load the URL in the WebView
            ourBrow.loadUrl(url);
        }
    }

    private static class MyBrowser extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }
    }
}
