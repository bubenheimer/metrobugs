package org.bubenheimer.metro

import dev.zacsweers.metro.Assisted
import dev.zacsweers.metro.AssistedFactory
import dev.zacsweers.metro.Inject

@Inject
class GenericClass<T>(
    @Assisted value: T
) {
    @AssistedFactory
    interface Factory<T> {
        fun create(
            value: T
        ): GenericClass<T>
    }
}
