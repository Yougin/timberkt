package com.github.ajalt.timberkt

import org.assertj.core.api.Assertions.assertThat
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config

data class Msg(val priority: Int, val tag: String?, val message: String?, val t: Throwable?)

@RunWith(RobolectricTestRunner::class)
@Config(manifest = Config.NONE)
class TimberKtTest {
    @Before @After fun setup() {
        Timber.uprootAll();
    }

    @Test
    fun logMessages() {
        val messages = mutableListOf<Msg>()
        Timber.plant(object : timber.log.Timber.DebugTree() {
            override fun log(priority: Int, tag: String?, message: String?, t: Throwable?) {
                messages.add(Msg(priority, tag, message, t))
            }
        })

        verbose { "Verbose" };
        Timber.verbose { "Verbose" };
        Timber.tag("Custom").verbose { "Verbose" };
        debug { "Debug" };
        Timber.debug { "Debug" };
        Timber.tag("Custom").debug { "Debug" };
        info { "Info" };
        Timber.info { "Info" };
        Timber.tag("Custom").info { "Info" };
        warning { "Warn" };
        Timber.warning { "Warn" };
        Timber.tag("Custom").warning { "Warn" };
        error { "Error" };
        Timber.error { "Error" };
        Timber.tag("Custom").error { "Error" };
        wtf { "Assert" };
        Timber.wtf { "Assert" };
        Timber.tag("Custom").wtf { "Assert" };

        assertThat(messages).containsExactly(
                Msg(2, "TimberKtTest", "Verbose", null),
                Msg(2, "TimberKtTest", "Verbose", null),
                Msg(2, "Custom", "Verbose", null),
                Msg(3, "TimberKtTest", "Debug", null),
                Msg(3, "TimberKtTest", "Debug", null),
                Msg(3, "Custom", "Debug", null),
                Msg(4, "TimberKtTest", "Info", null),
                Msg(4, "TimberKtTest", "Info", null),
                Msg(4, "Custom", "Info", null),
                Msg(5, "TimberKtTest", "Warn", null),
                Msg(5, "TimberKtTest", "Warn", null),
                Msg(5, "Custom", "Warn", null),
                Msg(6, "TimberKtTest", "Error", null),
                Msg(6, "TimberKtTest", "Error", null),
                Msg(6, "Custom", "Error", null),
                Msg(7, "TimberKtTest", "Assert", null),
                Msg(7, "TimberKtTest", "Assert", null),
                Msg(7, "Custom", "Assert", null)
        )
    }

    @Test
    fun logExceptions() {
        val messages = mutableListOf<Msg>()
        Timber.plant(object : timber.log.Timber.DebugTree() {
            override fun log(priority: Int, tag: String?, message: String?, t: Throwable?) {
                // Timber appends the error traceback to the message, so don't examine it
                messages.add(Msg(priority, tag, null, t))
            }
        })

        val e = Exception("e")

        verbose(e) { "Verbose" };
        Timber.verbose(e) { "Verbose" };
        Timber.tag("Custom").verbose(e) { "Verbose" };
        debug(e) { "Debug" };
        Timber.debug(e) { "Debug" };
        Timber.tag("Custom").debug(e) { "Debug" };
        info(e) { "Info" };
        Timber.info(e) { "Info" };
        Timber.tag("Custom").info(e) { "Info" };
        warning(e) { "Warn" };
        Timber.warning(e) { "Warn" };
        Timber.tag("Custom").warning(e) { "Warn" };
        error(e) { "Error" };
        Timber.error(e) { "Error" };
        Timber.tag("Custom").error(e) { "Error" };
        wtf(e) { "Assert" };
        Timber.wtf(e) { "Assert" };
        Timber.tag("Custom").wtf(e) { "Assert" };

        assertThat(messages).containsExactly(
                Msg(2, "TimberKtTest", null, e),
                Msg(2, "TimberKtTest", null, e),
                Msg(2, "Custom", null, e),
                Msg(3, "TimberKtTest", null, e),
                Msg(3, "TimberKtTest", null, e),
                Msg(3, "Custom", null, e),
                Msg(4, "TimberKtTest", null, e),
                Msg(4, "TimberKtTest", null, e),
                Msg(4, "Custom", null, e),
                Msg(5, "TimberKtTest", null, e),
                Msg(5, "TimberKtTest", null, e),
                Msg(5, "Custom", null, e),
                Msg(6, "TimberKtTest", null, e),
                Msg(6, "TimberKtTest", null, e),
                Msg(6, "Custom", null, e),
                Msg(7, "TimberKtTest", null, e),
                Msg(7, "TimberKtTest", null, e),
                Msg(7, "Custom", null, e)
        )
    }

    @Test
    fun lazyMessage_noTree() {
        var i = 0

        debug { "${i++}" };
        Timber.debug { "${i++}" };
        Timber.tag("Custom").debug { "${i++}" };

        assertThat(i).isEqualTo(0)
    }

    @Test
    fun lazyMessage_tree() {
        Timber.plant(timber.log.Timber.DebugTree())
        var i = 0

        debug { "${i++}" };
        Timber.debug { "${i++}" };
        Timber.tag("Custom").debug { "${i++}" };

        assertThat(i).isEqualTo(3)
    }
}
