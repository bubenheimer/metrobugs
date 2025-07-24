package org.bubenheimer

import dev.zacsweers.metro.AppScope
import dev.zacsweers.metro.ContributesGraphExtension
import dev.zacsweers.metro.DependencyGraph
import dev.zacsweers.metro.createGraph

@DependencyGraph(isExtendable = true)
interface AppGraph1 {
    //ok
    val appGraph: AppGraph1
}

@DependencyGraph
interface AppGraph2 {
    //No go
//    val factory: Factory

    @DependencyGraph.Factory
    fun interface Factory {
        fun create(): AppGraph2
    }
}

class LoginScope

@DependencyGraph(AppScope::class, isExtendable = true)
interface AppGraph3 {
    // ok
    val loginGraphFactory: LoginGraph3.Factory
}

@ContributesGraphExtension(LoginScope::class)
interface LoginGraph3 {
    // ok, coming from AppGraph3, I think
    val loginGraphFactory: LoginGraph3.Factory

    @ContributesGraphExtension.Factory(AppScope::class)
    fun interface Factory {
        fun create(): LoginGraph3
    }
}

//@DependencyGraph(AppScope::class, isExtendable = true)
//interface AppGraph4 {
//    // No go
//    val loginGraphFactory: LoginGraph4.Factory
//}
//
//@DependencyGraph(LoginScope::class)
//interface LoginGraph4 {
//    // No go
//    val loginGraphFactory: LoginGraph4.Factory
//
//    @DependencyGraph.Factory
//    fun interface Factory {
//        fun create(@Extends appGraph: AppGraph4): LoginGraph4
//    }
//}

fun main() {
    val graph = createGraph<AppGraph1>()
    println(graph.appGraph)

    //No go
//    val graph2 = createGraphFactory<AppGraph2.Factory>().create()
//    println(graph2.factory)

    val graph3 = createGraph<AppGraph3>()
    val loginGraph3 = graph3.loginGraphFactory.create()
    println(loginGraph3.loginGraphFactory)

    //No go
//    val graph4 = createGraph<AppGraph4>()
//    val loginGraph4 = graph4.loginGraphFactory.create(graph4)
//    println(loginGraph4.loginGraphFactory)
}