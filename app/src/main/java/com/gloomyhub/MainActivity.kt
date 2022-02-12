package com.gloomyhub

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import com.gloomyhub.ui.screens.CuratedSectionScreen
import com.gloomyhub.ui.theme.GloomyHubTheme
import com.gloomyhub.vms.CuratedSectionViewModel
import org.koin.core.component.KoinComponent
import org.koin.androidx.viewmodel.ext.android.viewModel


class MainActivity : ComponentActivity(), KoinComponent {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            GloomyHubTheme {
                Surface(modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background) {
                    CuratedSectionScreen()
                }
            }
        }
    }

    override fun onResume() {
        super.onResume()
    }
}

