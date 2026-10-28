package com.madhupatel.portfolio.ui.screens

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.SuggestionChip
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.unit.dp
import com.madhupatel.portfolio.data.model.Project
import com.madhupatel.portfolio.ui.components.GlassCard
import com.madhupatel.portfolio.ui.theme.GradientEnd
import com.madhupatel.portfolio.ui.theme.GradientStart

@OptIn(ExperimentalMaterial3Api::class, androidx.compose.foundation.layout.ExperimentalLayoutApi::class)
@Composable
fun ProjectDetailScreen(project: Project, onBack: () -> Unit) {
    BackHandler(onBack = onBack)
    val uriHandler = LocalUriHandler.current
    Scaffold(topBar = { TopAppBar(title = { Text(project.title) }, navigationIcon = { IconButton(onClick = onBack) { Icon(Icons.AutoMirrored.Filled.ArrowBack, "Back") } }) }) { padding ->
        Column(Modifier.fillMaxSize().padding(padding).verticalScroll(rememberScrollState()).padding(16.dp), verticalArrangement = Arrangement.spacedBy(18.dp)) {
            GlassCard(Modifier.fillMaxWidth().background(Brush.linearGradient(listOf(GradientStart, GradientEnd)), RoundedCornerShape(24.dp))) {
                Column(Modifier.fillMaxWidth().padding(24.dp)) { Text(project.index, color = Color.White); Spacer(Modifier.height(8.dp)); Text(project.category, color = Color.White) }
            }
            Text(project.description, style = androidx.compose.material3.MaterialTheme.typography.bodyLarge)
            Text("Tech stack", style = androidx.compose.material3.MaterialTheme.typography.titleLarge)
            FlowRow(horizontalArrangement = Arrangement.spacedBy(8.dp), verticalArrangement = Arrangement.spacedBy(8.dp)) { project.tags.forEach { SuggestionChip(onClick = {}, label = { Text(it) }) } }
            project.sourceUrl?.let { Button(onClick = { uriHandler.openUri(it) }, modifier = Modifier.fillMaxWidth()) { Text("View source code") } }
            project.liveUrl?.let { Button(onClick = { uriHandler.openUri(it) }, modifier = Modifier.fillMaxWidth()) { Text("Visit live website") } }
            project.apkUrl?.let { Button(onClick = { uriHandler.openUri(it) }, modifier = Modifier.fillMaxWidth()) { Text("Download APK") } }
            project.telegramUrl?.let { Button(onClick = { uriHandler.openUri(it) }, modifier = Modifier.fillMaxWidth()) { Text("Get app on Telegram") } }
        }
    }
}
