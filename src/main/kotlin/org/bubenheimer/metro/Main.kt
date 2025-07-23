package org.bubenheimer.metro

import dev.zacsweers.metro.BindingContainer
import dev.zacsweers.metro.ContributesTo
import dev.zacsweers.metro.DependencyGraph
import dev.zacsweers.metro.Extends
import dev.zacsweers.metro.Includes
import dev.zacsweers.metro.Provides
import dev.zacsweers.metro.createGraph
import dev.zacsweers.metro.createGraphFactory

fun main() {
    val graph1 = createGraph<Graph1>()
    println(graph1.b.a.value)

    val graph2 = createGraph<Graph2>()
    println(graph2.b.a.value)

    val graph3 = createGraph<Graph3>()
    println(graph3.b.a.value)

    val graph4 = createGraphFactory<Graph4.Factory>().create(createGraph<ParentGraph4>())
    println(graph4.b.a.value)

    val graph5 = createGraphFactory<Graph5.Factory>().create(createGraph<ParentGraph5>())
    println(graph5.b.a.value)

    val graph6 = createGraphFactory<Graph6.Factory>().create(ParentGraph6())
    println(graph6.b.a.value)

    val graph7 = createGraphFactory<Graph7.Factory>().create(ParentGraph7())
    println(graph7.b.a.value)

    val graph8 = createGraph<Graph8>()
    println(graph8.b.a.value)

    val graph9 = createGraph<Graph9>()
    println(graph9.b.a.value)

    val graph10 = createGraphFactory<Graph10.Factory>().create(createGraph<IncludedGraph10>())
    println(graph10.c.a.value)

    val graph11 = createGraphFactory<Graph11.Factory>().create(createGraph<IncludedGraph11>())
    println(graph11.c.a.value)
}

@DependencyGraph
interface Graph1 {
    val b: B

    @Provides
    fun provideValue(): Int = 1
}

@DependencyGraph
interface Graph2 : ParentGraph2 {
    @Provides
    fun provideValue(): Int = 2
}

interface ParentGraph2 {
    val b: B
}

@DependencyGraph
interface Graph3 : ParentGraph3

interface ParentGraph3 {
    val b: B

    @Provides
    fun provideValue(): Int = 3
}

@DependencyGraph
interface Graph4 {
    val b: B

    @DependencyGraph.Factory
    fun interface Factory {
        fun create(@Extends parentGraph: ParentGraph4): Graph4
    }
}

@DependencyGraph(isExtendable = true)
interface ParentGraph4 {
    @Provides
    fun provideValue(): Int = 4
}

@DependencyGraph
interface Graph5 {
    val b: B

    @DependencyGraph.Factory
    fun interface Factory {
        fun create(@Includes parentGraph: ParentGraph5): Graph5
    }
}

@DependencyGraph
interface ParentGraph5 {
    val value: Int

    @Provides
    fun provideValue(): Int = 5
}

@DependencyGraph
interface Graph6 {
    val b: B

    @DependencyGraph.Factory
    fun interface Factory {
        fun create(@Includes parentGraph: ParentGraph6): Graph6
    }
}

class ParentGraph6 {
    fun provideValue(): Int = 6
}

@DependencyGraph
interface Graph7 {
    val b: B

    @DependencyGraph.Factory
    fun interface Factory {
        fun create(@Includes parentGraph: ParentGraph7): Graph7
    }
}

@BindingContainer
class ParentGraph7 {
    @Provides
    fun provideValue(): Int = 7
}

class Scope8

@DependencyGraph(Scope8::class)
interface Graph8 {
    val b: B
}

@ContributesTo(Scope8::class)
interface ParentGraph8 {
    @Provides
    fun provideValue(): Int = 8
}

class Scope9

@DependencyGraph(Scope9::class)
interface Graph9 {
    val b: B
}

@BindingContainer
@ContributesTo(Scope9::class)
class ParentGraph9 {
    @Provides
    fun provideValue(): Int = 9
}

class Scope10

@DependencyGraph
interface Graph10 {
    val c: C

    @DependencyGraph.Factory
    fun interface Factory {
        fun create(@Includes includedGraph: IncludedGraph10): Graph10
    }
}

@DependencyGraph(Scope10::class)
interface IncludedGraph10 {
    val b: B
}

@BindingContainer
@ContributesTo(Scope10::class)
class ParentGraph10 {
    @Provides
    fun provideValue(): Int = 10
}

@ContributesTo(Scope10::class)
interface InterfaceGraph10 {
    val value: Int
}

class Scope11

@DependencyGraph
interface Graph11 {
    val c: C

    @DependencyGraph.Factory
    fun interface Factory {
        fun create(@Includes includedGraph: IncludedGraph11): Graph11
    }
}

@DependencyGraph(Scope11::class)
interface IncludedGraph11 {
    val b: B
}

@ContributesTo(Scope11::class)
interface ParentGraph11 {
    @Provides
    fun provideValue(): Int = 11
}

@ContributesTo(Scope11::class)
interface InterfaceGraph11 {
    val value: Int
}
