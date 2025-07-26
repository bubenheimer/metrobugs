package org.bubenheimer.metro

import dev.zacsweers.metro.DependencyGraph
import dev.zacsweers.metro.Includes
import dev.zacsweers.metro.Named
import dev.zacsweers.metro.Provides

@DependencyGraph
interface Graph1 {
    @DependencyGraph.Factory
    fun interface Factory {
        fun create(@Includes class1: Class1): Graph1
    }

    val acc1: Byte

    @Provides
    fun fun2(
        //No
        //p1: Int,

        //No
        //p2: Double,

        //No
        //p3: Float,

        //No
        //p4: Boolean,

        p5: Long,

        //No
        //p6: Short,

        @Named("pr4")
        p7: Short,

        //No
        //p8: String

        p8: List<Int>,

        //No
        //p9: List<Boolean>,

        @Named("pr10")
        p10: List<Boolean>,

        @Named("pr11")
        p11: List<String>,

        p12: List<Short>,

        @Named("pr13")
        p13: List<Byte>,

        @Named("pr14")
        p14: List<Long>
    ): Byte = 0
}

class Class1(
    param1: Int,
    //No
    private val param2: Double
) {
    //No
    private val prop1: Float = param1.toFloat()

    //No
    private val prop2: Boolean
        get() = param2 == 0.0

    //Yes
    val prop3: Long = 0L

    //Yes
    @Named("pr4")
    val prop4: Short = 1

    //No
    @Provides
    fun fun1(): String = "" + prop1 + prop2 + prop3

    //No
//    @Provides
//    val prop5: List<Int> = listOf()

    //No
//    @get:Provides
//    val prop6: List<Int> = listOf()

    //Yes, but accidental nonsense: @Provides is ignored
    @field:Provides
    val prop7: List<Int> = listOf()

    //No
//    @Provides
//    val prop8: List<Boolean>
//        get() = listOf()

    //No
//    @get:Provides
//    val prop9: List<Boolean>
//        get() = listOf()

    //Yes, but accidental nonsense: @Provides is ignored
    @field:Named("pr10")
    @field:Provides
    val prop10: List<Boolean> = listOf()

    //Yes, but accidental nonsense: @Provides is ignored
    @Named("pr11")
    @field:Provides
    val prop11: List<String> = listOf()

    //Yes
    val prop12: List<Short>
        get() = listOf()

    //Yes
    @Named("pr13")
    val prop13: List<Byte>
        get() = listOf()

    //Yes
    @get:Named("pr14")
    val prop14: List<Long>
        get() = listOf()
}
