package com.madhupatel.portfolio.ui.components

import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.AssistChip
import androidx.compose.material3.Button
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.platform.LocalHapticFeedback
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.unit.dp
import androidx.compose.ui.hapticfeedback.HapticFeedbackType
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import com.madhupatel.portfolio.data.model.Project

@OptIn(androidx.compose.foundation.layout.ExperimentalLayoutApi::class)
@Composable
fun ProjectCard(project: Project, position: Int, onViewDetails: (Project) -> Unit) {
    var appeared by remember { mutableStateOf(false) }
    val pressedSource = remember { MutableInteractionSource() }
    val pressed by pressedSource.collectIsPressedAsState()
    val entrance by animateFloatAsState(if (appeared) 1f else .94f, tween(500 + position * 80, easing = FastOutSlowInEasing), label = "card-entrance")
    val pressScale by animateFloatAsState(if (pressed) .985f else 1f, tween(120), label = "card-press")
    androidx.compose.runtime.LaunchedEffect(Unit) { appeared = true }
    val uriHandler = LocalUriHandler.current
    val haptic = LocalHapticFeedback.current
    val tap = { haptic.performHapticFeedback(HapticFeedbackType.LongPress) }

    GlassCard(Modifier.fillMaxWidth().padding(horizontal = 16.dp, vertical = 6.dp).graphicsLayer { scaleX = entrance * pressScale; scaleY = entrance * pressScale }) {
        Column(Modifier.padding(18.dp), verticalArrangement = Arrangement.spacedBy(10.dp)) {
            Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                Text(project.index, style = MaterialTheme.typography.labelMedium, color = MaterialTheme.colorScheme.secondary)
                if (project.isNew) AssistChip(onClick = {}, label = { Text("New") })
            }
            Text(project.title, style = MaterialTheme.typography.titleLarge, color = MaterialTheme.colorScheme.onSurface)
            Text(project.description, style = MaterialTheme.typography.bodyMedium, color = MaterialTheme.colorScheme.onSurfaceVariant)
            FlowRow(horizontalArrangement = Arrangement.spacedBy(6.dp), verticalArrangement = Arrangement.spacedBy(6.dp)) {
                project.tags.forEach { AssistChip(onClick = {}, label = { Text(it) }) }
            }
            FlowRow(horizontalArrangement = Arrangement.spacedBy(8.dp), verticalArrangement = Arrangement.spacedBy(8.dp)) {
                FilledTonalButton(onClick = { tap(); onViewDetails(project) }, interactionSource = pressedSource) { Text("View details") }
                project.sourceUrl?.let { OutlinedButton(onClick = { tap(); uriHandler.openUri(it) }) { Text("Source") } }
                project.liveUrl?.let { Button(onClick = { tap(); uriHandler.openUri(it) }) { Text("Live") } }
                project.apkUrl?.let { OutlinedButton(onClick = { tap(); uriHandler.openUri(it) }) { Text("APK") } }
                project.telegramUrl?.let { OutlinedButton(onClick = { tap(); uriHandler.openUri(it) }) { Text("Get app") } }
            }
        }
    }
}
