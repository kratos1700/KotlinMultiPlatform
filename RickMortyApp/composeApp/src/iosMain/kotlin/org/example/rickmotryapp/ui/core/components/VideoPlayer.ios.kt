package org.example.rickmotryapp.ui.core.components

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.viewinterop.UIKitView
import platform.Foundation.NSURL
import platform.Foundation.NSURLRequest
import platform.UIKit.UIView
import platform.UIKit.UIViewAutoresizingFlexibleHeight
import platform.UIKit.UIViewAutoresizingFlexibleWidth
import platform.WebKit.WKWebView

@Composable
actual fun VideoPlayer(modifier: Modifier, url: String) {
    val webView = remember { WKWebView() }
    UIKitView(
        modifier = modifier,
        factory = {
            val container = UIView().apply {   // Create a container view to hold the web view
                autoresizingMask =
                    UIViewAutoresizingFlexibleWidth or UIViewAutoresizingFlexibleHeight // Make the container view fill the available space
            }
            webView.apply { // Apply the following to the web view
                autoresizingMask =
                    UIViewAutoresizingFlexibleWidth or UIViewAutoresizingFlexibleHeight // Make the web view fill the available space
                loadRequest(NSURLRequest(NSURL(string = url))) // Load the video from the URL
            }
            container.addSubview(webView) // Add the web view to the container
            container // Return the container
        },
        update = { views ->  // Update the web view
            views.subviews()
                .firstOrNull { it is WKWebView } // find de the view and update with the first one found

        }
    )

}