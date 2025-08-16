package org.bubenheimer.metro

import dev.zacsweers.metro.AppScope
import dev.zacsweers.metro.ContributesTo
import dev.zacsweers.metro.DependencyGraph
import dev.zacsweers.metro.GraphExtension
import dev.zacsweers.metro.Provides

@DependencyGraph(AppScope::class)
interface AppGraph

@GraphExtension
interface ExtGraph {
    @GraphExtension.Factory
    @ContributesTo(AppScope::class)
    fun interface Factory : BaseFactory {
        fun create(@Provides value: Int): ExtGraph

        override fun create(
            name: String,
            value: Int
        ): ExtGraph {
            println(name)
            return create(value)
        }
    }
}

interface BaseFactory {
    fun create(name: String, value: Int): ExtGraph
}
