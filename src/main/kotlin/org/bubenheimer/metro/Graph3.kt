package org.bubenheimer.metro

import dev.zacsweers.metro.AppScope
import dev.zacsweers.metro.ContributesTo
import dev.zacsweers.metro.DependencyGraph
import dev.zacsweers.metro.IntoSet
import dev.zacsweers.metro.Named
import dev.zacsweers.metro.Provides
import dev.zacsweers.metro.createGraph

@DependencyGraph(AppScope::class)
interface Graph3 {
    val set1: Set<Int>

    @Named("s2")
    val set2: Set<Int>
}

@ContributesTo(AppScope::class)
interface I1 {
    @Provides
    @IntoSet
    fun provideValue1(): Int = 1
}

@ContributesTo(AppScope::class)
interface I2a {
    @Provides
    @IntoSet
    val provideValue2a: Int
        get() = 2
}

@ContributesTo(AppScope::class)
interface I2b {
    @Provides
    @IntoSet
    val provideValue2b: Int
        get() = 20
}

@ContributesTo(AppScope::class)
interface I3 {
    @get:Provides
    @get:IntoSet
    val provideValue3: Int
        get() = 3
}

@ContributesTo(AppScope::class)
interface I4 {
    @Provides
    @Named("s2")
    @IntoSet
    fun provideValue4(): Int = 4
}

@ContributesTo(AppScope::class)
interface I5 {
    @Provides
    @Named("s2") // bug: does not end up in set2, but goes into set1
    @IntoSet
    val provideValue5: Int
        get() = 5
}

@ContributesTo(AppScope::class)
interface I6 {
    @get:Provides
    @get:Named("s2")
    @get:IntoSet
    val provideValue6: Int
        get() = 6
}

fun main() {
    val graph = createGraph<Graph3>()
    println(graph.set1)
    println(graph.set2)
}