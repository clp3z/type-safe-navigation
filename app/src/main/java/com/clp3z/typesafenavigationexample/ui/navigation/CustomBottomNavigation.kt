package com.clp3z.typesafenavigationexample.ui.navigation

import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun CustomBottomNavigation(
    items: List<NavigationItem>,
    selectedItem: NavigationItem,
    onItemSelected: (NavigationItem) -> Unit
) {
    BottomNavigation {
        items.forEach { item ->
            val title = stringResource(id = item.title)
            BottomNavigationItem(
                label = { Text(text = title) },
                icon = {
                    Icon(
                        imageVector = item.icon,
                        contentDescription = title
                    )
                },
                selected = item == selectedItem,
                onClick = { onItemSelected(item) }
            )
        }
    }
}

@Preview
@Composable
fun CustomBottomNavigationPreview() {
    CustomBottomNavigation(
        items = listOf(
            NavigationItem.HOME,
            NavigationItem.BASKET,
            NavigationItem.SETTINGS
        ),
        selectedItem = NavigationItem.SETTINGS,
        onItemSelected = {}
    )
}
