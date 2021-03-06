@file:Suppress("NOTHING_TO_INLINE") // Inline anyway to allow tag reflection to work

package com.github.ajalt.timberkt

import timber.log.Timber

//
// Static methods on the Timber object
//

object Timber {
    /** Log a verbose message that will be evaluated lazily when the message is printed */
    @JvmStatic
    inline fun verbose(noinline message: () -> String) = Timber.v("%s", LazyString(message))

    /** Log a verbose exception and a message that will be evaluated lazily when the message is printed */
    @JvmStatic
    inline fun verbose(t: Throwable, noinline message: () -> String) = Timber.v(t, "%s", LazyString(message))

    /** Log a debug message that will be evaluated lazily when the message is printed */
    @JvmStatic
    inline fun debug(noinline message: () -> String) = Timber.d("%s", LazyString(message))

    /** Log a debug exception and a message that will be evaluated lazily when the message is printed */
    @JvmStatic
    inline fun debug(t: Throwable, noinline message: () -> String) = Timber.d(t, "%s", LazyString(message))

    /** Log an info message that will be evaluated lazily when the message is printed */
    @JvmStatic
    inline fun info(noinline message: () -> String) = Timber.i("%s", LazyString(message))

    /** Log an info exception and a message that will be evaluated lazily when the message is printed */
    @JvmStatic
    inline fun info(t: Throwable, noinline message: () -> String) = Timber.i(t, "%s", LazyString(message))

    /** Log a warning message that will be evaluated lazily when the message is printed */
    @JvmStatic
    inline fun warning(noinline message: () -> String) = Timber.w("%s", LazyString(message))

    /** Log a warning exception and a message that will be evaluated lazily when the message is printed */
    @JvmStatic
    inline fun warning(t: Throwable, noinline message: () -> String) = Timber.w(t, "%s", LazyString(message))

    /** Log an error message that will be evaluated lazily when the message is printed */
    @JvmStatic
    inline fun error(noinline message: () -> String) = Timber.e("%s", LazyString(message))

    /** Log an error exception and a message that will be evaluated lazily when the message is printed */
    @JvmStatic
    inline fun error(t: Throwable, noinline message: () -> String) = Timber.e(t, "%s", LazyString(message))

    /** Log an assert message that will be evaluated lazily when the message is printed */
    @JvmStatic
    inline fun wtf(noinline message: () -> String) = Timber.wtf("%s", LazyString(message))

    /** Log an assert exception and a message that will be evaluated lazily when the message is printed */
    @JvmStatic
    inline fun wtf(t: Throwable, noinline message: () -> String) = Timber.wtf(t, "%s", LazyString(message))

    // These functions forward just to the real timber. They aren't necessary, but they allow method
    // chaining like the normal Timber interface.

    /** A view into Timber's planted trees as a tree itself. */
    @JvmStatic
    fun asTree(): Timber.Tree = Timber.asTree()

    /** Add a new logging tree. */
    @JvmStatic
    fun plant(tree: Timber.Tree) = Timber.plant(tree)

    /** Set a one-time tag for use on the next logging call. */
    @JvmStatic
    fun tag(tag: String): Timber.Tree = Timber.tag(tag)

    /** A view into Timber's planted trees as a tree itself. */
    @JvmStatic
    fun uproot(tree: Timber.Tree) = Timber.uproot(tree)

    /** Set a one-time tag for use on the next logging call. */
    @JvmStatic
    fun uprootAll() = Timber.uprootAll()
}

//
// Extensions on trees
//

/** Log a verbose message that will be evaluated lazily when the message is printed */
inline fun Timber.Tree.verbose(noinline message: () -> String) = v("%s", LazyString(message))

/** Log a verbose exception and a message that will be evaluated lazily when the message is printed */
inline fun Timber.Tree.verbose(t: Throwable, noinline message: () -> String) = v(t, "%s", LazyString(message))

/** Log a debug message that will be evaluated lazily when the message is printed */
inline fun Timber.Tree.debug(noinline message: () -> String) = d("%s", LazyString(message))

/** Log a debug exception and a message that will be evaluated lazily when the message is printed */
inline fun Timber.Tree.debug(t: Throwable, noinline message: () -> String) = d(t, "%s", LazyString(message))

/** Log an info message that will be evaluated lazily when the message is printed */
inline fun Timber.Tree.info(noinline message: () -> String) = i("%s", LazyString(message))

/** Log an info exception and a message that will be evaluated lazily when the message is printed */
inline fun Timber.Tree.info(t: Throwable, noinline message: () -> String) = i(t, "%s", LazyString(message))

/** Log a warning message that will be evaluated lazily when the message is printed */
inline fun Timber.Tree.warning(noinline message: () -> String) = w("%s", LazyString(message))

/** Log a warning exception and a message that will be evaluated lazily when the message is printed */
inline fun Timber.Tree.warning(t: Throwable, noinline message: () -> String) = w(t, "%s", LazyString(message))

/** Log an error message that will be evaluated lazily when the message is printed */
inline fun Timber.Tree.error(noinline message: () -> String) = e("%s", LazyString(message))

/** Log an error exception and a message that will be evaluated lazily when the message is printed */
inline fun Timber.Tree.error(t: Throwable, noinline message: () -> String) = e(t, "%s", LazyString(message))

/** Log an assert message that will be evaluated lazily when the message is printed */
inline fun Timber.Tree.wtf(noinline message: () -> String) = wtf("%s", LazyString(message))

/** Log an assert exception and a message that will be evaluated lazily when the message is printed */
inline fun Timber.Tree.wtf(t: Throwable, noinline message: () -> String) = wtf(t, "%s", LazyString(message))

//
// Plain functions
//

/** Log a verbose message that will be evaluated lazily when the message is printed */
inline fun verbose(noinline message: () -> String) = Timber.v("%s", LazyString(message))

/** Log a verbose exception and a message that will be evaluated lazily when the message is printed */
inline fun verbose(t: Throwable, noinline message: () -> String) = Timber.v(t, "%s", LazyString(message))

/** Log a debug message that will be evaluated lazily when the message is printed */
inline fun debug(noinline message: () -> String) = Timber.d("%s", LazyString(message))

/** Log a debug exception and a message that will be evaluated lazily when the message is printed */
inline fun debug(t: Throwable, noinline message: () -> String) = Timber.d(t, "%s", LazyString(message))

/** Log an info message that will be evaluated lazily when the message is printed */
inline fun info(noinline message: () -> String) = Timber.i("%s", LazyString(message))

/** Log an info exception and a message that will be evaluated lazily when the message is printed */
inline fun info(t: Throwable, noinline message: () -> String) = Timber.i(t, "%s", LazyString(message))

/** Log a warning message that will be evaluated lazily when the message is printed */
inline fun warning(noinline message: () -> String) = Timber.w("%s", LazyString(message))

/** Log a warning exception and a message that will be evaluated lazily when the message is printed */
inline fun warning(t: Throwable, noinline message: () -> String) = Timber.w(t, "%s", LazyString(message))

/** Log an error message that will be evaluated lazily when the message is printed */
inline fun error(noinline message: () -> String) = Timber.e("%s", LazyString(message))

/** Log an error exception and a message that will be evaluated lazily when the message is printed */
inline fun error(t: Throwable, noinline message: () -> String) = Timber.e(t, "%s", LazyString(message))

/** Log an assert message that will be evaluated lazily when the message is printed */
inline fun wtf(noinline message: () -> String) = Timber.wtf("%s", LazyString(message))

/** Log an assert exception and a message that will be evaluated lazily when the message is printed */
inline fun wtf(t: Throwable, noinline message: () -> String) = Timber.wtf(t, "%s", LazyString(message))

/** @suppress */
class LazyString(val initializer: () -> String) {
    val string: String by lazy(initializer)
    override fun toString() = string
}
