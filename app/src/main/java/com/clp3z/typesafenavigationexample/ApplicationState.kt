package com.clp3z.typesafenavigationexample

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.rememberCoroutineScope
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.clp3z.typesafenavigationexample.ui.navigation.NavigationItem
import kotlinx.coroutines.CoroutineScope

@Composable
fun rememberApplicationState(
    navHostController: NavHostController = rememberNavController(),
    coroutineScope: CoroutineScope = rememberCoroutineScope()
): ApplicationState {
    return ApplicationState(navHostController, coroutineScope)
}

@Stable
class ApplicationState(
    val navHostController: NavHostController,
    val coroutineScope: CoroutineScope
) {

    val navigationItems = listOf(
        NavigationItem.HOME,
        NavigationItem.BASKET,
        NavigationItem.SETTINGS
    )

    private val _selectedItem = mutableStateOf(NavigationItem.HOME)
    val selectedItem: NavigationItem @Composable get() = _selectedItem.value

    private val currentRoute: String
        @Composable get() = navHostController
            .currentBackStackEntryAsState()
            .value?.destination?.route
            ?: ""

    val shouldShowBottomBar: Boolean
        @Composable get() = currentRoute in navigationItems.map { it.route }

    fun onNavigationItemSelected(item: NavigationItem) {
        _selectedItem.value = item
        when (item) {
            NavigationItem.HOME -> navHostController.navigate(Graph.Home)
            NavigationItem.BASKET -> navHostController.navigate(Graph.Basket)
            NavigationItem.SETTINGS -> navHostController.navigate(Graph.Settings)
        }
    }

    fun <T : Destination> navigateTo(destination: T) {
        navHostController.navigate(destination)
    }

    fun onUpClicked() {
        navHostController.navigateUp()
    }
}
