package com.example.portfolio.ui.screens

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.portfolio.data.model.Project
import com.example.portfolio.ui.theme.GradientEnd
import com.example.portfolio.ui.theme.GradientStart

@OptIn(ExperimentalMaterial3Api::class, ExperimentalLayoutApi::class)
@Composable
fun ProjectDetailScreen(project: Project, onBack: () -> Unit) {
    val uriHandler = LocalUriHandler.current
    
    // ఫోన్ బ్యాక్ బటన్ నొక్కినప్పుడు పనిచేయడానికి
    BackHandler { onBack() }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Project Details") },
                navigationIcon = {
                    IconButton(onClick = onBack) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back")
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    titleContentColor = MaterialTheme.colorScheme.onPrimary,
                    navigationIconContentColor = MaterialTheme.colorScheme.onPrimary
                )
            )
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .verticalScroll(rememberScrollState())
                .padding(16.dp)
        ) {
            // హెడర్ బ్యానర్ (గ్రేడియంట్ తో)
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(150.dp)
                    .background(
                        brush = Brush.linearGradient(listOf(GradientStart, GradientEnd)),
                        shape = RoundedCornerShape(16.dp)
                    ),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = project.index,
                    style = MaterialTheme.typography.headlineLarge,
                    color = Color.White,
                    fontWeight = FontWeight.Bold
                )
            }

            Spacer(Modifier.height(24.dp))

            // టైటిల్ మరియు కేటగిరీ
            Text(project.title, style = MaterialTheme.typography.headlineLarge)
            Text(
                text = project.category, 
                style = MaterialTheme.typography.titleMedium, 
                color = MaterialTheme.colorScheme.primary
            )

            Spacer(Modifier.height(16.dp))

            // డిస్క్రిప్షన్
            Text("About this project", style = MaterialTheme.typography.titleLarge)
            Spacer(Modifier.height(8.dp))
            Text(project.description, style = MaterialTheme.typography.bodyLarge)

            Spacer(Modifier.height(24.dp))

            // టెక్ స్టాక్
            Text("Tech Stack", style = MaterialTheme.typography.titleLarge)
            Spacer(Modifier.height(8.dp))
            FlowRow(
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                project.tags.forEach { tag ->
                    SuggestionChip(onClick = {}, label = { Text(tag) })
                }
            }

            Spacer(Modifier.height(32.dp))

            // లింక్స్ బటన్స్
            Text("Links", style = MaterialTheme.typography.titleLarge)
            Spacer(Modifier.height(8.dp))
            Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                project.sourceUrl?.let { 
                    Button(modifier = Modifier.fillMaxWidth(), onClick = { uriHandler.openUri(it) }) { Text("View Source Code") } 
                }
                project.liveUrl?.let { 
                    Button(modifier = Modifier.fillMaxWidth(), onClick = { uriHandler.openUri(it) }) { Text("Visit Live Website") } 
                }
                project.apkUrl?.let { 
                    Button(modifier = Modifier.fillMaxWidth(), onClick = { uriHandler.openUri(it) }) { Text("Download APK") } 
                }
                project.telegramUrl?.let { 
                    Button(modifier = Modifier.fillMaxWidth(), onClick = { uriHandler.openUri(it) }) { Text("Get App (Telegram)") } 
                }
            }
            
            Spacer(Modifier.height(32.dp))
        }
    }
}
