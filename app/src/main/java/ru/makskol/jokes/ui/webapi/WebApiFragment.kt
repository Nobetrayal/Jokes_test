package ru.makskol.jokes.ui.webapi

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import ru.makskol.jokes.R
import ru.makskol.jokes.ui.jokes.JokesViewModel


class WebApiFragment : Fragment() {

    private lateinit var webView: WebView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val root = inflater.inflate(R.layout.fragment_web_api, container, false)

        val url = getString(R.string.api_url)
        setActivityTitle(getString(R.string.web_api_fragment_title))
        webView = root.findViewById(R.id.webView)

        webView.settings.javaScriptEnabled = true

        if (savedInstanceState != null)
            webView.restoreState(savedInstanceState)
        else
            webView.loadUrl(url)

        return root

    }

    override fun onSaveInstanceState(outState: Bundle) {
        webView.saveState(outState);
        super.onSaveInstanceState(outState)
    }


}

fun Fragment.setActivityTitle(title: String) {

    (activity as AppCompatActivity?)!!.supportActionBar?.title = title

}

