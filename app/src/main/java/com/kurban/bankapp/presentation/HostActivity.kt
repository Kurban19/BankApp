package com.kurban.bankapp.presentation

import android.os.Bundle
import com.kurban.core_compose.theme.BankAppTheme
import androidx.activity.compose.setContent
import androidx.compose.runtime.CompositionLocalProvider
import com.bumble.appyx.core.integration.NodeHost
import com.bumble.appyx.core.integrationpoint.LocalIntegrationPoint
import com.bumble.appyx.core.integrationpoint.NodeActivity
import com.kurban.bankapp.presentation.navigation.ContainerNode

class HostActivity : NodeActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            BankAppTheme {
                CompositionLocalProvider(
                    LocalIntegrationPoint provides integrationPoint,
                ) {
                    NodeHost(integrationPoint = LocalIntegrationPoint.current) {
                        ContainerNode(buildContext = it)
                    }
                }
            }
        }
    }
}
