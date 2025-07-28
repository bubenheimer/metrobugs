package org.bubenheimer.metro

import dev.zacsweers.metro.ElementsIntoSet
import dev.zacsweers.metro.Inject
import dev.zacsweers.metro.Named
import dev.zacsweers.metro.Provides

interface Graph1 {
    @Provides
    @ElementsIntoSet
    fun values0(): Set<Int> = setOf(0)

    @Provides
    @ElementsIntoSet
    val values1: Set<Int>
        get() = setOf(1, 2)

    @get:Provides
    @get:ElementsIntoSet
    val values2: Set<Int>
        get() = setOf(3, 4)

    companion object {
        @field:Provides
        @field:ElementsIntoSet
        val values2: Set<Int> = setOf(5)
    }
}

@Inject
@ElementsIntoSet
class CustomSet(@Named("Custom") values: Set<Int>) : HashSet<Int>(values)
