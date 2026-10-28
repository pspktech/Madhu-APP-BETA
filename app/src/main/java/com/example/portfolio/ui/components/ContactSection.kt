package com.madhupatel.portfolio.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Language
import androidx.compose.material.icons.filled.Link
import androidx.compose.material3.Icon
import androidx.compose.material3.ListItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.unit.dp
import com.madhupatel.portfolio.data.model.Contact

@Composable
fun ContactSection(contacts: List<Contact>) {
    val uriHandler = LocalUriHandler.current
    GlassCard(Modifier.padding(horizontal = 16.dp)) {
        Column(Modifier.padding(vertical = 10.dp)) {
            Text("Let's connect", style = MaterialTheme.typography.titleLarge, modifier = Modifier.padding(horizontal = 16.dp))
            Spacer(Modifier.height(4.dp))
            contacts.forEach { contact ->
                ListItem(
                    headlineContent = { Text(contact.type) },
                    supportingContent = { Text(contact.value, color = MaterialTheme.colorScheme.onSurfaceVariant) },
                    leadingContent = { Icon(when (contact.icon) { "telegram" -> Icons.Default.Email; "website" -> Icons.Default.Language; else -> Icons.Default.Link }, null) },
                    modifier = Modifier.clickable { uriHandler.openUri(contact.url) }
                )
            }
        }
    }
}
