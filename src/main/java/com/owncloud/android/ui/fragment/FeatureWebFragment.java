package com.owncloud.android.ui.fragment;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.owncloud.android.R;

public class FeatureWebFragment extends Fragment {
    private String mWebUrl;

    static public FeatureWebFragment newInstance(String webUrl) {
        FeatureWebFragment f = new FeatureWebFragment();
        Bundle args = new Bundle();
        args.putString("url", webUrl);
        f.setArguments(args);
        return f;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mWebUrl = getArguments() != null ? getArguments().getString("url") : null;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.whats_new_webview_element, container, false);

        WebView webView = v.findViewById(R.id.whatsNewWebView);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setDomStorageEnabled(true);
        webView.getSettings().setAllowFileAccess(false);
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl(mWebUrl);

        return v;
    }
}