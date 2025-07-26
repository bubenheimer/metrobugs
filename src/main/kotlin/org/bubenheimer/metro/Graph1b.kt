package org.bubenheimer.metro

import dev.zacsweers.metro.ContributesTo
import dev.zacsweers.metro.DependencyGraph
import dev.zacsweers.metro.Named
import dev.zacsweers.metro.Provides

class Scope1b

@DependencyGraph(Scope1b::class)
interface Graph1b {
    @Named("v1")
    val value1: Int

    @Named("v2")
    val value2: Int
}

@ContributesTo(Scope1b::class)
interface V1 {
    companion object {
        @Provides
        @Named("v1")
        val provideValue1: Int = 1
    }
}

@ContributesTo(Scope1b::class)
interface V2 {
    companion object {
        @Provides
        @Named("v2")
        val provideValue2: Int = 2
    }
}
