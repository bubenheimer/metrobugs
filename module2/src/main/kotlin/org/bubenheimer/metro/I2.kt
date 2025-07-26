package org.bubenheimer.metro

import dev.zacsweers.metro.AppScope
import dev.zacsweers.metro.ContributesTo
import dev.zacsweers.metro.Named
import dev.zacsweers.metro.Provides

@ContributesTo(AppScope::class)
interface I2 {
    @Provides
    @Named("v2")
    val value2: Int
        get() = 2
}
