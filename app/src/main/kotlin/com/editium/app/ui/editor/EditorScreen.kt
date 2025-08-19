package com.editium.app.ui.editor

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp

@Composable
fun EditorScreen(onExport: () -> Unit = {}) {
    Column(Modifier.fillMaxSize().background(Color(0xFF1A1A1A))) {
        Box(Modifier.height(56.dp).padding(8.dp)) {
            Text("Editium", color = Color(0xFFE4E4E4), style = MaterialTheme.typography.titleMedium)
        }
        Box(Modifier.weight(1f).padding(8.dp).background(Color(0xFF2D2D2D))) {
            // Placeholder for PreviewSurface interop if needed
        }
        Box(Modifier.height(120.dp).background(Color(0xFF2D2D2D))) {
            // Placeholder for TimelineView interop
        }
        Button(onClick = onExport, modifier = Modifier.padding(8.dp)) { Text("Export") }
    }
}

