package com.example.portfolio.data.repository

import com.example.portfolio.data.model.*

class PortfolioRepository {
    fun getPortfolio(): PortfolioUiState = PortfolioUiState(
        skills = listOf(
            Skill("Kotlin"), Skill("Jetpack Compose"), Skill("MVVM"),
            Skill("Node.js"), Skill("HTML/CSS/JS"), Skill("Express.js"),
            Skill("Android"), Skill("Git & GitHub")
        ),
        projects = PortfolioProjects.all,
        contacts = listOf(
            Contact("GitHub", "pspktech", "https://github.com/pspktech", "github"),
            Contact("Telegram", "madhupatelpspk", "https://t.me/madhupatelpspk", "telegram"),
            Contact("Website", "madhupatel.is-a.dev", "https://madhupatel.is-a.dev", "website")
        )
    )
}
