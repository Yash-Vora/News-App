package com.example.newsapp.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;

import com.example.newsapp.WebViewController;
import com.example.newsapp.databinding.FragmentFoxNewsBinding;

public class FoxNewsFragment extends Fragment {


    FragmentFoxNewsBinding binding;


    // Constructor
    public FoxNewsFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        binding = FragmentFoxNewsBinding.inflate(inflater, container, false);


        // Changing the web settings of the web view
        WebSettings webSettings = binding.webViewFox.getSettings();
        webSettings.setJavaScriptEnabled(true);


        // Improve web view performance
        webSettings.setRenderPriority(WebSettings.RenderPriority.HIGH);
        webSettings.setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);
        webSettings.setAppCacheEnabled(true);
        binding.webViewFox.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
        webSettings.setEnableSmoothTransition(true);


        // Load URL in the app
        binding.webViewFox.setWebViewClient(new WebViewController());


        // Loading URL
        binding.webViewFox.loadUrl("https://foxnews.com");


        // If there is any previous page running in the web view it will just move to the previous page when back button is pressed
        binding.webViewFox.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if ((keyCode == KeyEvent.KEYCODE_BACK) && binding.webViewFox.canGoBack()) {
                    binding.webViewFox.goBack();
                    return true;
                }
                return false;
            }
        });


        return binding.getRoot();

    }

}
