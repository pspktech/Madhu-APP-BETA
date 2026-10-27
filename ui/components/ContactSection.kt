package com.example.portfolio.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Link
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.portfolio.viewmodel.PortfolioUiState

@Composable
fun ContactSection(state: PortfolioUiState, onLinkClick: (String) -> Unit) {
    Column(Modifier.padding(16.dp)) {
        Text("Contact", style = MaterialTheme.typography.headlineMedium)
        Spacer(Modifier.height(12.dp))
        ContactRow(Icons.Default.Email, state.email) { onLinkClick("mailto:${state.email}") }
        Spacer(Modifier.height(8.dp))
        ContactRow(Icons.Default.Link, "GitHub") { onLinkClick(state.github) }
        Spacer(Modifier.height(8.dp))
        ContactRow(Icons.Default.Link, "LinkedIn") { onLinkClick(state.linkedin) }
    }
}

@Composable
private fun ContactRow(icon: androidx.compose.ui.graphics.vector.ImageVector, label: String, onClick: () -> Unit) {
    FilledTonalButton(
        onClick = onClick,
        modifier = Modifier.fillMaxWidth()
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(icon, contentDescription = null)
            Spacer(Modifier.width(12.dp))
            Text(label)
        }
    }
}
