package com.example.portfolio.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.portfolio.ui.components.*
import com.example.portfolio.viewmodel.PortfolioViewModel
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PortfolioScreen(vm: PortfolioViewModel = viewModel()) {
    val state by vm.uiState.collectAsStateWithLifecycle()
    val listState = rememberLazyListState()
    val scope = rememberCoroutineScope()

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Madhu Portfolio") },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    titleContentColor = MaterialTheme.colorScheme.onPrimary
                )
            )
        }
    ) { padding ->
        LazyColumn(
            state = listState,
            modifier = Modifier.fillMaxSize().padding(padding),
            verticalArrangement = Arrangement.spacedBy(20.dp)
        ) {
            item {
                HeroSection(
                    state = state,
                    onViewProjects = { scope.launch { listState.animateScrollToItem(3) } },
                    onContact = { scope.launch { listState.animateScrollToItem(listState.layoutInfo.totalItemsCount - 1) } }
                )
            }
            item {
                Column(Modifier.padding(horizontal = 16.dp)) {
                    SectionTitle("About")
                    Spacer(Modifier.height(8.dp))
                    Text(state.about, style = MaterialTheme.typography.bodyLarge)
                }
            }
            item { SkillsSection(state.skills) }
            item { Box(Modifier.padding(horizontal = 16.dp)) { SectionTitle("Projects") } }
            items(state.projects.size) { ProjectCard(state.projects[it]) }
            item { ContactSection(state.contacts) }
            item { Spacer(Modifier.height(24.dp)) }
        }
    }
}
