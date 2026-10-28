package com.madhupatel.portfolio.ui.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.scaleIn
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDownward
import androidx.compose.material.icons.filled.Email
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.madhupatel.portfolio.data.model.PortfolioUiState
import kotlinx.coroutines.delay

@Composable
fun HeroSection(state: PortfolioUiState, scrollOffset: Int, onViewProjects: () -> Unit, onContact: () -> Unit) {
    var visible by remember { mutableStateOf(false) }
    val glow by animateFloatAsState(if (visible) 1f else .35f, tween(1400, easing = FastOutSlowInEasing), label = "hero-glow")
    LaunchedEffect(Unit) { delay(120); visible = true }

    Column(
        modifier = Modifier.fillMaxWidth().graphicsLayer { translationY = -scrollOffset * .12f }.background(
            Brush.linearGradient(listOf(Color(0xFF172D57), Color(0xFF0B1A2D), Color(0xFF0A2F39)))
        ).padding(horizontal = 24.dp, vertical = 42.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(14.dp)
    ) {
        AnimatedVisibility(visible, enter = fadeIn(tween(800)) + scaleIn(tween(900), initialScale = .65f)) {
            Box(Modifier.size(126.dp).alpha(glow).background(Brush.radialGradient(listOf(Color(0xFF8EA7FF).copy(alpha = .36f), Color.Transparent)), CircleShape), contentAlignment = Alignment.Center) {
                Box(Modifier.size(84.dp).background(Color.White.copy(alpha = .12f), CircleShape), contentAlignment = Alignment.Center) {
                    Text(state.name.firstOrNull()?.uppercase() ?: "M", style = MaterialTheme.typography.headlineLarge, color = Color.White)
                }
            }
        }
        Text(state.name, style = MaterialTheme.typography.headlineLarge, color = Color.White, textAlign = TextAlign.Center)
        Text(state.role, style = MaterialTheme.typography.titleMedium, color = MaterialTheme.colorScheme.secondary)
        Text(state.tagline, style = MaterialTheme.typography.bodyMedium, color = Color.White.copy(alpha = .78f), textAlign = TextAlign.Center)
        Row(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
            Button(onClick = onViewProjects) { Icon(Icons.Default.ArrowDownward, null); Spacer(Modifier.width(6.dp)); Text("Explore work") }
            OutlinedButton(onClick = onContact) { Icon(Icons.Default.Email, null); Spacer(Modifier.width(6.dp)); Text("Contact") }
        }
    }
}
