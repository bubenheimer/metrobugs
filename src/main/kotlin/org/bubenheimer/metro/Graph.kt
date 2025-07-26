package org.bubenheimer.metro

import dev.zacsweers.metro.DependencyGraph
import dev.zacsweers.metro.IntoSet
import dev.zacsweers.metro.Named
import dev.zacsweers.metro.Provides
import dev.zacsweers.metro.createGraph

@DependencyGraph
interface Graph {
    val set1: Set<Int>

    @Named("s2")
    val set2: Set<Int>

    @Provides
    @IntoSet
    @Named("s2") // goes into set1 instead of set2
    val provideValue1: Int
        get() = 1

    @Provides
    @IntoSet
    @get:Named("s2") // goes into set2
    val provideValue2: Int
        get() = 2
}

fun main() {
    val graph = createGraph<Graph>()
    println("set1: ${graph.set1}")
    println("set2: ${graph.set2}")
}
