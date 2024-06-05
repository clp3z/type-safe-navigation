package com.clp3z.typesafenavigationexample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.ui.Modifier
import com.clp3z.typesafenavigationexample.ui.navigation.CustomBottomNavigation
import com.clp3z.typesafenavigationexample.ui.theme.TypeSafeNavigationExampleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TypeSafeNavigationExampleTheme {
                val applicationState = rememberApplicationState()
                with(applicationState) {
                    Scaffold(
                        bottomBar = {
                            if (applicationState.shouldShowBottomBar) {
                                CustomBottomNavigation(
                                    items = navigationItems,
                                    selectedItem = selectedItem,
                                    onItemSelected = { onNavigationItemSelected(it) }
                                )
                            }
                        }
                    ) {
                        Box(modifier = Modifier.padding(it)) {
                            Navigation(this@with)
                        }
                    }
                }
            }
        }
    }
}
