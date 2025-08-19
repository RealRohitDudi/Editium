package com.editium.app.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.core.view.WindowCompat
import com.editium.app.ui.editor.EditorScreen
import com.editium.app.ui.export.ExportScreen
import com.editium.app.ui.projects.ProjectsScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)
        setContent { EditiumApp() }
    }
}

@Composable
fun EditiumApp() {
    val navController = rememberNavController()
    Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
        NavHost(navController = navController, startDestination = "editor") {
            composable("projects") { ProjectsScreen(onOpenProject = { navController.navigate("editor") }) }
            composable("editor") { EditorScreen(onExport = { navController.navigate("export") }) }
            composable("export") { ExportScreen(onDone = { navController.popBackStack("editor", inclusive = false) }) }
        }
    }
}
