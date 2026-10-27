package com.example.portfolio.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.unit.dp
import com.example.portfolio.data.model.Project

@Composable
fun ProjectCard(project: Project) {
    val uriHandler = LocalUriHandler.current

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 6.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Column(Modifier.padding(16.dp)) {
            Row(verticalAlignment = androidx.compose.ui.Alignment.CenterVertically) {
                Text(
                    project.index,
                    style = MaterialTheme.typography.labelMedium,
                    color = MaterialTheme.colorScheme.primary
                )
                if (project.isNew) {
                    Spacer(Modifier.width(8.dp))
                    SuggestionChip(onClick = {}, label = { Text("📱 New") })
                }
            }
            Spacer(Modifier.height(4.dp))
            Text(project.title, style = MaterialTheme.typography.titleLarge)
            Spacer(Modifier.height(6.dp))
            Text(project.description, style = MaterialTheme.typography.bodyMedium)
            Spacer(Modifier.height(10.dp))

            @OptIn(ExperimentalLayoutApi::class)
            FlowRow(
                horizontalArrangement = Arrangement.spacedBy(6.dp),
                verticalArrangement = Arrangement.spacedBy(6.dp)
            ) {
                project.tags.forEach { AssistChip(onClick = {}, label = { Text(it) }) }
            }

            Spacer(Modifier.height(10.dp))

            FlowRow(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                project.detailsUrl?.let {
                    FilledTonalButton(onClick = { uriHandler.openUri(it) }) {
                        Text("View Details")
                    }
                }
                project.sourceUrl?.let {
                    OutlinedButton(onClick = { uriHandler.openUri(it) }) { Text("Source") }
                }
                project.liveUrl?.let {
                    Button(onClick = { uriHandler.openUri(it) }) { Text("Live") }
                }
                project.apkUrl?.let {
                    OutlinedButton(onClick = { uriHandler.openUri(it) }) { Text("APK") }
                }
                project.telegramUrl?.let {
                    OutlinedButton(onClick = { uriHandler.openUri(it) }) { Text("Get App") }
                }
            }
        }
    }
}
