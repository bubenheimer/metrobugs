package org.bubenheimer.metro

import dev.zacsweers.metro.DependencyGraph
import dev.zacsweers.metro.IntoSet
import dev.zacsweers.metro.Named
import dev.zacsweers.metro.Provides
import dev.zacsweers.metro.createGraph

@DependencyGraph
interface Graph2 {
    val set1: Set<Int>

    @Provides
    @IntoSet
    fun provideValue1(): Int = 1

    @Provides
    @IntoSet
    val provideValue2: Int
        get() = 2

    @get:Provides
    @get:IntoSet
    val provideValue3: Int
        get() = 3

    @Named("s2")
    val set2: Set<Int>

    @Provides
    @Named("s2")
    @IntoSet
    fun provideValue4(): Int = 4

    @Provides
    @Named("s2") // bug: does not end up in set2, but goes into set1
    @IntoSet
    val provideValue5: Int
        get() = 5

    @get:Provides
    @get:Named("s2")
    @get:IntoSet
    val provideValue6: Int
        get() = 6
}

fun main() {
    val graph = createGraph<Graph2>()
    println(graph.set1)
    println(graph.set2)
}