package com.example.alc40phase1challenge_android;

import androidx.appcompat.app.AppCompatActivity;

import android.net.http.SslError;
import android.os.Bundle;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class AboutALC extends AppCompatActivity {

  WebView webView;
  private String mURL = "https://andela.com/alc";
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_about_alc);

    webView = findViewById(R.id.webView);
    webView.getSettings().setJavaScriptEnabled(true);
    webView.canGoBack();
    webView.setWebViewClient( new MyWebViewClient());
    webView.loadUrl(mURL);
  }
  class MyWebViewClient extends WebViewClient{

    @Override
    public void onPageFinished (WebView view, String url){
      mURL =url;
      super.onPageFinished(view, url);
    }

  @Override
  public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error) {
      handler.proceed();
    }
  }
}
