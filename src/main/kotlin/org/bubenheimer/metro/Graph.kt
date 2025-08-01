package org.bubenheimer.metro

import dev.zacsweers.metro.AppScope
import dev.zacsweers.metro.BindingContainer
import dev.zacsweers.metro.Binds
import dev.zacsweers.metro.ContributesTo
import dev.zacsweers.metro.DependencyGraph
import dev.zacsweers.metro.Provides

@DependencyGraph(AppScope::class)
interface AppGraph {
    val realChars: CharSequence
}

@ContributesTo(AppScope::class)
interface Accessors {
    @Binds
    val String.chars: CharSequence

    @BindingContainer
    @ContributesTo(AppScope::class)
    class Container {
        @Provides
        val string: String = "Hi"
    }
}
