package com.kurban.bankapp.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.bumble.appyx.core.composable.Children
import com.bumble.appyx.core.modality.BuildContext
import com.bumble.appyx.core.node.Node
import com.bumble.appyx.core.node.ParentNode
import com.bumble.appyx.navmodel.backstack.BackStack
import com.kurban.core.presentation.navigation.Route
import com.kurban.feature_home.presentation.HomeNode
import com.kurban.feature_home.presentation.navigation.HomeRoute

class ContainerNode(
    buildContext: BuildContext,
    private val backStack: BackStack<Route> = BackStack(
        initialElement = HomeRoute(),
        savedStateMap = buildContext.savedStateMap
    )
) : ParentNode<Route>(navModel = backStack, buildContext = buildContext) {

    override fun resolve(routing: Route, buildContext: BuildContext): Node = when (routing) {
        is HomeRoute -> HomeNode(buildContext)
//        is Login -> LoginNode(routing.id, routing.param)
        else -> HomeNode(buildContext)
    }

    @Composable
    override fun View(modifier: Modifier) {
        Children(navModel = backStack)
    }
}
