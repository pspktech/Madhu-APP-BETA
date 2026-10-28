package com.madhupatel.portfolio.ui.components

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.FilterChip
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.unit.dp
import com.madhupatel.portfolio.data.model.Skill

@OptIn(androidx.compose.foundation.layout.ExperimentalLayoutApi::class)
@Composable
fun SkillsSection(skills: List<Skill>) {
    var visible by remember { mutableStateOf(false) }
    LaunchedEffect(Unit) { visible = true }
    Column(Modifier.padding(horizontal = 16.dp), verticalArrangement = Arrangement.spacedBy(10.dp)) {
        SectionTitle("Skills")
        FlowRow(horizontalArrangement = Arrangement.spacedBy(8.dp), verticalArrangement = Arrangement.spacedBy(8.dp)) {
            skills.forEachIndexed { index, skill ->
                val alpha by animateFloatAsState(if (visible) 1f else 0f, tween(450, delayMillis = index * 65), label = "skill-alpha-$index")
                val scale by animateFloatAsState(if (visible) 1f else .75f, tween(450, delayMillis = index * 65), label = "skill-scale-$index")
                FilterChip(selected = false, onClick = {}, label = { Text(skill.name) }, modifier = Modifier.graphicsLayer { this.alpha = alpha; scaleX = scale; scaleY = scale })
            }
        }
    }
}

@Composable
fun SectionTitle(title: String) { Text(title, style = MaterialTheme.typography.titleLarge, color = MaterialTheme.colorScheme.onSurface) }
