package com.example.portfolio.ui.components

import androidx.compose.foundation.clickable // 👈 ఇదే మిస్ అయ్యింది
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Link
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.unit.dp
import com.example.portfolio.data.model.Contact

@Composable
fun ContactSection(contacts: List<Contact>) {
    val uriHandler = LocalUriHandler.current
    
    Column(modifier = Modifier.padding(horizontal = 16.dp)) {
        SectionTitle("Contact")
        Spacer(Modifier.height(8.dp))
        
        contacts.forEach { contact ->
            ListItem(
                headlineContent = { Text(contact.type) },
                supportingContent = { Text(contact.value) },
                leadingContent = {
                    Icon(
                        imageVector = when (contact.icon) {
                            "github" -> Icons.Filled.Link
                            "telegram" -> Icons.Filled.Email
                            else -> Icons.Filled.Person
                        },
                        contentDescription = null
                    )
                },
                // ఇక్కడ clickable వాడుతున్నాం, అందుకే పైన import చేశాం
                modifier = Modifier.clickable { uriHandler.openUri(contact.url) } 
            )
        }
    }
}
