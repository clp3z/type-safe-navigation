package com.clp3z.typesafenavigationexample.ui.navigation

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.ShoppingBasket
import androidx.compose.ui.graphics.vector.ImageVector
import com.clp3z.typesafenavigationexample.BasketDestination
import com.clp3z.typesafenavigationexample.Graph
import com.clp3z.typesafenavigationexample.HomeDestination
import com.clp3z.typesafenavigationexample.R
import com.clp3z.typesafenavigationexample.SettingsDestination

enum class NavigationItem(
    @StringRes val title: Int,
    val icon: ImageVector,
    val route: String
) {
    HOME(
        title = R.string.home,
        icon = Icons.Default.Home,
        route = HomeDestination.Home::class.qualifiedName ?: ""
    ),
    BASKET(
        title = R.string.basket,
        icon = Icons.Default.ShoppingBasket,
        route = BasketDestination.Basket::class.qualifiedName ?: ""
    ),
    SETTINGS(
        title = R.string.settings,
        icon = Icons.Default.Settings,
        route = SettingsDestination.Settings::class.qualifiedName ?: ""
    ),
}
