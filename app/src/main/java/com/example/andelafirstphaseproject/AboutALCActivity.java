package com.example.andelafirstphaseproject;

import androidx.appcompat.app.AppCompatActivity;

import android.net.http.SslError;
import android.os.Bundle;
import android.view.View;
import android.webkit.SslErrorHandler;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AboutALCActivity extends AppCompatActivity {

    @BindView(R.id.webview_about_alc_activity_id)
    WebView mWebView;
    @BindView(R.id.progress_bar)
    ProgressBar mProgressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_alc);
        ButterKnife.bind(this);

        mProgressBar.setVisibility(View.VISIBLE);

        mWebView.setWebViewClient(new WebViewClient(){
            @Override
            public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error) {
                handler.proceed();
            }
        });

        mWebView.setWebChromeClient(new WebChromeClient(){
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
             if (newProgress == 100){
                 mProgressBar.setVisibility(View.GONE);
             }
            }
        });
        mWebView.getSettings().setJavaScriptEnabled(true);
        mWebView.loadUrl("https://andela.com/alc/");
    }
}
