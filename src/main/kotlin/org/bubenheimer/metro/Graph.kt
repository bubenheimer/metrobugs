package org.bubenheimer

import dev.zacsweers.metro.AppScope
import dev.zacsweers.metro.BindingContainer
import dev.zacsweers.metro.Binds
import dev.zacsweers.metro.ContributesTo
import dev.zacsweers.metro.DependencyGraph
import dev.zacsweers.metro.Provides

@DependencyGraph(AppScope::class, isExtendable = true)
interface AppGraph {
    val intValue: Int

    @DependencyGraph.Factory
    fun interface Factory {
        fun create(@Provides aLong: Long): AppGraph
    }
}

@BindingContainer
@ContributesTo(AppScope::class)
class Container1 {
    @Provides
    val value1: Int = 1
}

@BindingContainer
@ContributesTo(AppScope::class)
class Container2 {
    @Provides
    val value2: String = "Hi"
}

@ContributesTo(AppScope::class)
interface Bindings {
    @Binds
    val ArrayList<Int>.value3a: List<Int>
}

@BindingContainer
@ContributesTo(AppScope::class)
class Container3 {
    @Provides
    val value3: ArrayList<Int> = arrayListOf(1)
}
