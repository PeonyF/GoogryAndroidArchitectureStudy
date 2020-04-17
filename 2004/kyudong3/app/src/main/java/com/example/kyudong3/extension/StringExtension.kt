package com.example.kyudong3.extension

import androidx.core.text.HtmlCompat

fun String.htmlToString(): String {
    return HtmlCompat.fromHtml(this, HtmlCompat.FROM_HTML_MODE_COMPACT).toString()
}