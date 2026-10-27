package com.example.portfolio.data.repository

import com.example.portfolio.data.model.*

class PortfolioRepository {

    fun getPortfolio(): PortfolioUiState = PortfolioUiState(
        name = "Madhu Patel",
        role = "Android Developer",
        tagline = "Kotlin • MVVM • Material 3",
        about = "Web apps, AI bots and Android tools — each one built end-to-end, from idea to deployment.",
        skills = listOf(
            Skill("Kotlin"),
            Skill("Jetpack Compose"),
            Skill("MVVM"),
            Skill("Node.js"),
            Skill("HTML/CSS/JS"),
            Skill("Express.js"),
            Skill("Android"),
            Skill("Git & GitHub")
        ),
        projects = PortfolioProjects.all,
        contacts = listOf(
            Contact("GitHub", "github.com/pspktech", "https://github.com/pspktech", "github"),
            Contact("Telegram", "t.me/madhupatelpspk", "https://t.me/madhupatelpspk", "telegram"),
            Contact("Website", "madhupatel.is-a.dev", "https://madhupatel.is-a.dev", "website")
        )
    )
}
