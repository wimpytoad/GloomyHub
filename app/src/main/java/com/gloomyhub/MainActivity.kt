package com.gloomyhub

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import com.gloomyhub.ui.screens.CuratedSectionScreen
import com.gloomyhub.ui.theme.GloomyHubTheme
import com.gloomyhub.vms.CuratedSectionViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val viewModel: CuratedSectionViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val bookList = viewModel.suggestionsState.value

        setContent {
            GloomyHubTheme {
                Surface(modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background) {
                    CuratedSectionScreen(bookList)
                }
            }
        }
    }

    override fun onResume() {
        super.onResume()
        viewModel.getSuggestions()
    }
}

