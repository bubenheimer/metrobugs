package org.bubenheimer.metro

import dev.zacsweers.metro.Inject

@Inject
class Generic<T> private constructor(value: T)
