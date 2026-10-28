package com.madhupatel.portfolio.ui.screens

import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DarkMode
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SmallTopAppBar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.madhupatel.portfolio.data.model.Project
import com.madhupatel.portfolio.ui.components.ContactSection
import com.madhupatel.portfolio.ui.components.HeroSection
import com.madhupatel.portfolio.ui.components.ProjectCard
import com.madhupatel.portfolio.ui.components.SectionTitle
import com.madhupatel.portfolio.ui.components.SkillsSection
import com.madhupatel.portfolio.viewmodel.PortfolioViewModel
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PortfolioScreen(vm: PortfolioViewModel = viewModel()) {
    val state by vm.uiState.collectAsStateWithLifecycle()
    val listState = rememberLazyListState()
    val scope = rememberCoroutineScope()
    var selectedProject by remember { mutableStateOf<Project?>(null) }
    val blobs = rememberInfiniteTransition(label = "background-blobs")
    val drift by blobs.animateFloat(0f, 1f, infiniteRepeatable(tween(7000), RepeatMode.Reverse), label = "blob-drift")
    if (selectedProject != null) { ProjectDetailScreen(selectedProject!!, onBack = { selectedProject = null }); return }
    Scaffold(topBar = { SmallTopAppBar(title = { Text("M / MADHU PATEL") }, actions = { IconButton({}) { Icon(Icons.Default.DarkMode, "Portfolio theme") } }) }, containerColor = Color.Transparent) { padding ->
        Box(Modifier.fillMaxSize().background(Brush.verticalGradient(listOf(com.madhupatel.portfolio.ui.theme.DeepNight, com.madhupatel.portfolio.ui.theme.Glass)))) {
            Box(Modifier.offset(x = (drift * 44 - 22).dp, y = (drift * 80).dp).size(210.dp).alpha(.18f).background(Color(0xFF5876FF), androidx.compose.foundation.shape.CircleShape))
            Box(Modifier.offset(x = (220 - drift * 55).dp, y = (360 - drift * 70).dp).size(180.dp).alpha(.13f).background(Color(0xFF17C7B3), androidx.compose.foundation.shape.CircleShape))
            LazyColumn(state = listState, modifier = Modifier.fillMaxSize().padding(padding), verticalArrangement = Arrangement.spacedBy(18.dp)) {
                item { HeroSection(state, listState.firstVisibleItemScrollOffset, onViewProjects = { scope.launch { listState.animateScrollToItem(3) } }, onContact = { scope.launch { listState.animateScrollToItem(listState.layoutInfo.totalItemsCount - 1) } }) }
                item { Column(Modifier.padding(horizontal = 16.dp), verticalArrangement = Arrangement.spacedBy(8.dp)) { SectionTitle("About"); Text(state.about, color = androidx.compose.material3.MaterialTheme.colorScheme.onSurfaceVariant) } }
                item { SkillsSection(state.skills) }
                item { Text("Selected work", style = androidx.compose.material3.MaterialTheme.typography.titleLarge, modifier = Modifier.padding(horizontal = 16.dp)) }
                itemsIndexed(state.projects, key = { _, project -> project.id }) { index, project -> ProjectCard(project, index, onViewDetails = { selectedProject = it }) }
                item { ContactSection(state.contacts) }
                item { Spacer(Modifier.height(28.dp)) }
            }
        }
    }
}
