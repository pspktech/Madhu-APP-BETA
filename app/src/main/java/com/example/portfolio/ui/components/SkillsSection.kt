package com.example.portfolio.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.portfolio.data.model.Skill

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun SkillsSection(skills: List<Skill>) {
    Column(modifier = Modifier.padding(horizontal = 16.dp)) {
        SectionTitle("Skills")
        Spacer(Modifier.height(8.dp))
        FlowRow(
            horizontalArrangement = Arrangement.spacedBy(8.dp), 
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            skills.forEach { 
                SuggestionChip(onClick = {}, label = { Text(it.name) }) 
            }
        }
    }
}

@Composable
fun SectionTitle(title: String) {
    Text(
        text = title, 
        style = MaterialTheme.typography.titleLarge, 
        color = MaterialTheme.colorScheme.onSurface
    )
}
