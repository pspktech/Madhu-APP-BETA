package com.example.portfolio.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.portfolio.data.model.Skill

@Composable
fun SkillsSection(skills: List<Skill>) {
    Column(Modifier.padding(horizontal = 16.dp)) {
        Text("Skills", style = MaterialTheme.typography.headlineMedium)
        Spacer(Modifier.height(12.dp))
        LazyRow(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            items(skills) { skill ->
                AssistChip(
                    onClick = {},
                    label = { Text(skill.name) },
                    colors = AssistChipDefaults.assistChipColors(
                        containerColor = MaterialTheme.colorScheme.secondary.copy(alpha = 0.12f),
                        labelColor = MaterialTheme.colorScheme.secondary
                    )
                )
            }
        }
    }
}
