package org.bubenheimer.metro

import dev.zacsweers.metro.DependencyGraph
import dev.zacsweers.metro.Includes

@DependencyGraph
interface Graph {
    @DependencyGraph.Factory
    fun interface Factory {
        fun create(@Includes vararg containers: Any): Graph
    }
}
