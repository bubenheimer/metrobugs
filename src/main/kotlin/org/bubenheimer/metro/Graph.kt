package org.bubenheimer.metro

import dev.zacsweers.metro.AppScope
import dev.zacsweers.metro.ContributesBinding
import dev.zacsweers.metro.ContributesTo
import dev.zacsweers.metro.DependencyGraph
import dev.zacsweers.metro.GraphExtension

@DependencyGraph(AppScope::class)
interface AppGraph

@GraphExtension
interface ExtGraph {
    @GraphExtension.Factory
    @ContributesTo(AppScope::class)
    @ContributesBinding(AppScope::class)
    fun interface Factory : BaseFactory {
        fun create(): ExtGraph
    }
}

interface BaseFactory
