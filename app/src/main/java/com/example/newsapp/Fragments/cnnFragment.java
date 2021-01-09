package com.example.newsapp.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;

import com.example.newsapp.WebViewController;
import com.example.newsapp.databinding.FragmentCnnBinding;

public class cnnFragment extends Fragment {


    FragmentCnnBinding binding;


    // Constructor
    public cnnFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        binding = FragmentCnnBinding.inflate(inflater, container, false);


        // Changing the web settings of the web view
        WebSettings webSettings = binding.webViewCNN.getSettings();
        webSettings.setJavaScriptEnabled(true);


        // Improve web view performance
        webSettings.setRenderPriority(WebSettings.RenderPriority.HIGH);
        webSettings.setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);
        webSettings.setAppCacheEnabled(true);
        binding.webViewCNN.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
        webSettings.setEnableSmoothTransition(true);


        // Load URL in the app
        binding.webViewCNN.setWebViewClient(new WebViewController());


        // Loading URL
        binding.webViewCNN.loadUrl("https://edition.cnn.com");


        // If there is any previous page running in the web view it will just move to the previous page when back button is pressed
        binding.webViewCNN.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if ((keyCode == KeyEvent.KEYCODE_BACK) && binding.webViewCNN.canGoBack()) {
                    binding.webViewCNN.goBack();
                    return true;
                }
                return false;
            }
        });


        return binding.getRoot();

    }

}
