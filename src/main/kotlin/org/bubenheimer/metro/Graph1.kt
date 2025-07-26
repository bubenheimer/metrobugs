package org.bubenheimer.metro

import dev.zacsweers.metro.DependencyGraph
import dev.zacsweers.metro.Named
import dev.zacsweers.metro.Provides

@DependencyGraph
interface Graph1 {
    val value1: Int

    @Provides
    fun provideValue1(): Int = 1

    val value2: Long

    @Provides
    val provideValue2: Long
        get() = 2L

    val value3: Short

    @get:Provides
    val provideValue3: Short
        get() = 3

    @Named("v4")
    val value4: Byte

    @Provides
    @Named("v4")
    fun provideValue4(): Byte = 4

    @Named("v5")
    val value5: Double

    @Provides
    @Named("v5")
    val provideValue5: Double
        get() = 5.0

    @Named("v6")
    val value6: Float

    @get:Provides
    @get:Named("v6")
    val provideValue6: Float
        get() = 6f

    @Named("v7")
    val value7: UInt

    @Provides
    @get:Named("v7")
    val provideValue7: UInt
        get() = 7u

    @Named("v8")
    val value8: ULong

    @get:Provides
    @Named("v8")
    val provideValue8: ULong
        get() = 8u

    @get:Named("v9")
    val value9: UByte

    @Provides
    @Named("v9")
    val provideValue9: UByte
        get() = 9u
}