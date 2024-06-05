package com.clp3z.typesafenavigationexample

import kotlinx.serialization.Serializable

sealed interface Graph {

    @Serializable
    data object Home : Graph

    @Serializable
    data object Basket : Graph

    @Serializable
    data object Settings : Graph
}

interface Destination

sealed class HomeDestination : Destination {

    @Serializable
    data object Home : HomeDestination()

    @Serializable
    data class HomeContent(val name: String) : HomeDestination()
}

sealed class BasketDestination : Destination {

    @Serializable
    data object Basket : BasketDestination()

    @Serializable
    data class BasketContent(val name: String) : BasketDestination()
}

sealed class SettingsDestination : Destination {

    @Serializable
    data object Settings : SettingsDestination()

    @Serializable
    data class SettingsContent(val name: String) : SettingsDestination()
}
