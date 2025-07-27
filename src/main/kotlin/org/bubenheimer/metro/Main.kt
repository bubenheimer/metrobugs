package org.bubenheimer.metro

import dev.zacsweers.metro.DependencyGraph
import dev.zacsweers.metro.Includes
import dev.zacsweers.metro.Inject
import dev.zacsweers.metro.Provides

@DependencyGraph
interface Graph1 {
    @DependencyGraph.Factory
    fun interface Factory {
        fun create(
            @Includes value3Include: Value3Include,
            @Includes value4Include: Value4Include
        ): Graph1
    }

    val value1: Int

    @Provides
    fun provideValue1(): Int = 1

    val bla: Bla

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

@Inject
class Bla(
    myString: String,
    myFloat: Float,
    myDouble: Double
)

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

class Value4Include {
    // Provides a Float binding, but does not add an accessor
    val value4: Float = 3f

    // Provides a String binding, but does not add an accessor
    val value5: String
        get() = "bla"

    // Even provides a binding from a function, but does not add an accessor
    fun value6(): Double = 1.0
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

    //No
//    val value4: Double
}
