package org.bubenheimer.metro

import dev.zacsweers.metro.DependencyGraph
import dev.zacsweers.metro.Includes
import dev.zacsweers.metro.Provides

@DependencyGraph
interface Graph1 {
    val value1: Int

    @Provides
    fun value1(): Int = 1
}

@DependencyGraph
interface Graph2 {
    @DependencyGraph.Factory
    fun interface Factory {
        fun create(@Includes graph1: Graph1): Graph2
    }

    // value2 causes DuplicateBinding in Graph3, removing it causes MissingBinding in Graph3
    val value2: Int
}

@DependencyGraph
interface Graph3 {
    @DependencyGraph.Factory
    fun interface Factory {
        fun create(@Includes graph2: Graph2): Graph3
    }

    val value3: Int
}
