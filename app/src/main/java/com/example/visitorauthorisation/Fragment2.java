package com.example.visitorauthorisation;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.util.Objects;


public class Fragment2 extends Fragment {

    WebView webView;
    ProgressBar progressBar;
    SwipeRefreshLayout refreshWebView;
    String url ="http://192.168.43.181";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState ){
        View view = inflater.inflate(R.layout.fragment_fragment2,container,false);
        WebView myWebView = view.findViewById(R.id.webview);
        //myWebView.loadUrl("http://192.168.43.181");
        //myWebView.setWebViewClient(MyWebViewClient);

        webView = view.findViewById(R.id.webview);
        progressBar = view.findViewById(R.id.progressBar);
        refreshWebView = view.findViewById(R.id.webViewRefresh);


        initWebView();
        webView.loadUrl(url);

        refreshWebView.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                refreshWebView.setRefreshing(true);
                webView.reload();
                refreshWebView.setRefreshing(false);
            }
        });
        return view;

    }

    private void initWebView(){
        webView.setWebViewClient(new WebViewClient(){
            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
                progressBar.setVisibility(View.VISIBLE);
            }

            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String newURL) {
                //return super.shouldOverrideUrlLoading(view, url);

                webView.loadUrl(newURL);
                url = newURL;
                return true;
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                progressBar.setVisibility(View.GONE);
            }

            @Override
            public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) {
                super.onReceivedError(view, request, error);

                progressBar.setVisibility(View.GONE);

                //Toast.(Fragment2.this,"Error fetching the address!",Toast.LENGTH_SHORT);
            }
        });
        webView.clearCache(true);
        webView.clearHistory();
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setHorizontalScrollBarEnabled(true);

    }




}
