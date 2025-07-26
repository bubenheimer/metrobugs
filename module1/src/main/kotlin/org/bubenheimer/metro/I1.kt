package org.bubenheimer.metro

import dev.zacsweers.metro.AppScope
import dev.zacsweers.metro.ContributesTo
import dev.zacsweers.metro.Named
import dev.zacsweers.metro.Provides

@ContributesTo(AppScope::class)
interface I1 {
    @Provides
    @Named("v1")
    val value1: Int
        get() = 1
}
