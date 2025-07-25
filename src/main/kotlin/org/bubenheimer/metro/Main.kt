package org.bubenheimer.metro

import dev.zacsweers.metro.DependencyGraph
import dev.zacsweers.metro.Includes
import dev.zacsweers.metro.Provides

@DependencyGraph
interface Graph1 {
    @DependencyGraph.Factory
    fun interface Factory {
        fun create(@Includes value3Include: Value3Include): Graph1
    }

    val value1: Int

    @Provides
    fun provideValue1(): Int = 1

    //No: not recognized as accessor
//    @Provides
//    fun provideValue2(): String = "Hi"

    //No: not recognized as accessor
//    fun provideValue2(): String = "Hi"

    //No: not recognized as accessor
//    val value3: Float
//        get() = 3f

    //No: not allowed in interface
//    val value3: Float = 3f
}

interface Value3Include {
    //No: interface not recognized as one that provides accessors
//    val value3: Float
//        get() = 3f

    //No: not allowed in interface
//    val value3: Float = 3f

    //No: no accessor added
//    @Provides
//    val value3: Float
//        get() = 3f
}

//No (compiler crash)
//object Value3Include {
//    val value3: Float = 3f
//}

//No: object @Includes not allowed
//object Value3Include {
//    @Provides
//    val value3: Float = 3f
//}

//No: no accessor
//class Value3Include {
//    @Provides
//    val value3: Float = 3f
//}

@DependencyGraph
interface Graph2 {
    @DependencyGraph.Factory
    fun interface Factory {
        fun create(@Includes graph1: Graph1): Graph2
    }

    val value1: Int

    //No
//    val value2: String

    //No
//    val value3: Float
}
