package com.clp3z.typesafenavigationexample

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import androidx.navigation.toRoute
import com.clp3z.typesafenavigationexample.ui.navigation.NavigationItem

@Composable
fun Navigation(applicationState: ApplicationState) {
    with(applicationState) {
        NavHost(
            navController = navHostController,
            startDestination = Graph.Home
        ) {
            homeScreen(applicationState)
            basketScreen(applicationState)
            settingsScreen(applicationState)
        }
    }
}

private fun NavGraphBuilder.homeScreen(applicationState: ApplicationState) {
    with(applicationState) {
        navigation<Graph.Home>(startDestination = HomeDestination.Home) {
            composable<HomeDestination.Home> {
                ContentScreen(
                    title = NavigationItem.HOME.route.substringAfterLast("."),
                    backgroundColor = MaterialTheme.colors.primary.copy(alpha = 0.2f),
                    isFirstLevel = true,
                    onButtonClick = { navigateTo(HomeDestination.HomeContent(it)) },
                    onBackClick = { /*TODO*/ }
                )
            }
            composable<HomeDestination.HomeContent> {
                val homeContent = it.toRoute<HomeDestination.HomeContent>()
                ContentScreen(
                    title = homeContent.name,
                    backgroundColor = MaterialTheme.colors.primary.copy(alpha = 0.2f),
                    isFirstLevel = false,
                    onButtonClick = { /*TODO*/ },
                    onBackClick = { onUpClicked() }
                )
            }
        }
    }
}

private fun NavGraphBuilder.basketScreen(applicationState: ApplicationState) {
    with(applicationState) {
        navigation<Graph.Basket>(startDestination = BasketDestination.Basket) {
            composable<BasketDestination.Basket> {
                ContentScreen(
                    title = NavigationItem.BASKET.route.substringAfterLast("."),
                    backgroundColor = MaterialTheme.colors.secondary.copy(alpha = 0.2f),
                    isFirstLevel = true,
                    onButtonClick = { navigateTo(BasketDestination.BasketContent(it)) },
                    onBackClick = { /*TODO*/ }
                )
            }
            composable<BasketDestination.BasketContent> {
                val basketContent = it.toRoute<BasketDestination.BasketContent>()
                ContentScreen(
                    title = basketContent.name,
                    backgroundColor = MaterialTheme.colors.secondary.copy(alpha = 0.2f),
                    isFirstLevel = false,
                    onButtonClick = { /*TODO*/ },
                    onBackClick = { onUpClicked() }
                )
            }
        }
    }
}

private fun NavGraphBuilder.settingsScreen(applicationState: ApplicationState) {
    with(applicationState) {
        navigation<Graph.Settings>(startDestination = SettingsDestination.Settings) {
            composable<SettingsDestination.Settings> {
                ContentScreen(
                    title = NavigationItem.SETTINGS.route.substringAfterLast("."),
                    backgroundColor = MaterialTheme.colors.primaryVariant.copy(alpha = 0.2f),
                    isFirstLevel = true,
                    onButtonClick = { navigateTo(SettingsDestination.SettingsContent(it)) },
                    onBackClick = { /*TODO*/ }
                )
            }
            composable<SettingsDestination.SettingsContent> {
                val settingsContent = it.toRoute<SettingsDestination.SettingsContent>()
                ContentScreen(
                    title = settingsContent.name,
                    backgroundColor = MaterialTheme.colors.primaryVariant.copy(alpha = 0.2f),
                    isFirstLevel = false,
                    onButtonClick = { /*TODO*/ },
                    onBackClick = { onUpClicked() }
                )
            }
        }
    }
}
