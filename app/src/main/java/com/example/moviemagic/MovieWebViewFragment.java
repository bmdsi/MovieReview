package com.example.moviemagic;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

import com.example.moviemagic.core.PageNavigationControlledFragment;
import com.example.moviemagic.data.MovieData;

import butterknife.BindView;

/**
 * A simple fragment to display web views
 * TODO : MVP here
 */

public class MovieWebViewFragment extends PageNavigationControlledFragment {

    private static final String ARGS_URL = "args_url";
    private static final String ARGS_TITLE = "args_title";

    String url;
    String title;

    @BindView(R.id.webview)
    WebView webView;
    @BindView(R.id.progress_bar)
    ProgressBar progressBar;

    public static final MovieWebViewFragment newInstance(MovieData data) {
        Bundle args = new Bundle();
        args.putString(ARGS_URL, data.getLinkUrl());
        args.putString(ARGS_TITLE, data.getDisplayTitle());
        MovieWebViewFragment frag = new MovieWebViewFragment();
        frag.setArguments(args);
        return frag;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_webview;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        url = getArguments().getString(ARGS_URL);
        title = getArguments().getString(ARGS_TITLE);
        setHomeAsUp(true);
        setToolbarTitle(title);
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        webView.setWebViewClient(new WebViewClient());
        webView.setWebChromeClient(new WebChromeClient());
        webView.loadUrl(url);
        //TODO handle back for webviews
    }

    @Override
    public void onResume() {
        super.onResume();
        webView.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
        webView.onPause();
    }

    class MyWebViewClient extends WebViewClient {
        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            progressBar.setVisibility(View.VISIBLE);
            super.onPageStarted(view, url, favicon);
        }

        @Override
        public void onPageFinished(WebView view, String url) {
            progressBar.setVisibility(View.INVISIBLE);
            super.onPageFinished(view, url);
        }
    }
}
