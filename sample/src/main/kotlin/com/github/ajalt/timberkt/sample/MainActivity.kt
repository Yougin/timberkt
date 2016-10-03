package com.github.ajalt.timberkt.sample

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.github.ajalt.timberkt.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        var i = 0

        Timber.debug { "log ${i++}" }
        Timber.info { "log ${i++}" }
        Timber.warning { "log ${i++}" }
        Timber.error { "log ${i++}" }
        Timber.wtf { "log ${i++}" }

        Timber.tag("Custom tag").debug { "log ${i++}" }
        Timber.tag("Custom tag").info { "log ${i++}" }
        Timber.tag("Custom tag").warning { "log ${i++}" }
        Timber.tag("Custom tag").error { "log ${i++}" }
        Timber.tag("Custom tag").wtf { "log ${i++}" }

        debug { "log ${i++}" }
        info { "log ${i++}" }
        warning { "log ${i++}" }
        error { "log ${i++}" }
        wtf { "log ${i++}" }
    }
}
