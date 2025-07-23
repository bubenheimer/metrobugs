package org.bubenheimer.metro

import dev.zacsweers.metro.Inject

@Inject
class A(val value: Int)

@Inject
class B(val a: A)

@Inject
class C(val a: A)
