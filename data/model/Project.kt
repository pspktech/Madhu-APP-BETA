package com.example.portfolio.data.model

/**
 * Project model — mirrors the projects.html portfolio page.
 * Every optional link is nullable so cards can show only the buttons that exist.
 */
data class Project(
    val id: Int,
    val index: String,                    // "01 — BOT"
    val title: String,
    val description: String,
    val category: String,                 // "AI Automation", "E-Commerce", ...
    val tags: List<String>,               // chips shown on card
    val isFeatured: Boolean = false,      // "New" badge projects
    val isNew: Boolean = false,

    // Optional links — null = hide that button
    val detailsUrl: String? = null,       // projects/whatsapp-bot.html
    val sourceUrl: String? = null,        // GitHub repo
    val liveUrl: String? = null,          // deployed website
    val apkUrl: String? = null,           // APK release
    val telegramUrl: String? = null,      // Telegram channel

    val previewIcon: String,              // FontAwesome / emoji key
    val previewStyle: String              // "bot", "pickle", "insta", "vya"
)

object PortfolioProjects {

    val all: List<Project> = listOf(

        Project(
            id = 1,
            index = "01 — BOT",
            title = "WhatsApp AI Bot",
            description = "An AI-powered WhatsApp bot built on Node.js that automatically replies to incoming messages using an AI API. It handles common queries, responds in natural language, and can be extended for custom commands and automation flows.",
            category = "AI Automation",
            tags = listOf("Node.js", "Express.js", "AI API", "WhatsApp Web"),
            detailsUrl = "projects/whatsapp-bot.html",
            sourceUrl = "https://github.com/pspktech/whatsapp-ai-bot",
            previewIcon = "whatsapp",
            previewStyle = "bot"
        ),

        Project(
            id = 2,
            index = "02 — WEBSITE",
            title = "Nandhu Pickles",
            description = "A complete e-commerce website for a homemade pickles brand. It includes a product showcase, image gallery, pricing and a one-tap WhatsApp ordering flow — so customers can place orders without a complex checkout system.",
            category = "E-Commerce",
            tags = listOf("HTML", "CSS", "JavaScript", "Netlify"),
            detailsUrl = "projects/nandhu-pickles.html",
            liveUrl = "https://nandhupickles.netlify.app",
            previewIcon = "jar",
            previewStyle = "pickle"
        ),

        Project(
            id = 3,
            index = "03 — APP",
            title = "MyInstaPro",
            description = "An Android app to download Instagram videos, reels, photos and stories — fast, free and without a watermark. No login required, no ads, no tracking. Also includes blue tick verification requests and an updates channel.",
            category = "Android App",
            tags = listOf("Android", "Instagram", "Downloader", "No Watermark"),
            isFeatured = true,
            isNew = true,
            detailsUrl = "projects/myinstapro.html",
            telegramUrl = "https://t.me/madhupatelpspk",
            previewIcon = "instagram",
            previewStyle = "insta"
        ),

        Project(
            id = 4,
            index = "04 — WEBSITE",
            title = "Vigneshwara Youth Group",
            description = "A community website for a local youth group — showcasing events, member information, photo galleries and announcements. Designed with a fully responsive layout so members can access it on any device.",
            category = "Community",
            tags = listOf("HTML", "CSS", "JavaScript", "Netlify"),
            detailsUrl = "projects/vigneshwara.html",
            liveUrl = "https://teamvya.netlify.app",
            previewIcon = "people-group",
            previewStyle = "vya"
        ),

        Project(
            id = 5,
            index = "05 — WEBSITE",
            title = "Homecare",
            description = "A modern homecare services website designed to present at-home care and service information in a clear, approachable way. The interface follows a simple visitor journey: understand the offering, explore services, and take the next step through the live site.",
            category = "Home Services",
            tags = listOf("Web App", "Responsive UI", "Vercel"),
            detailsUrl = "projects/HomeCare.html",
            liveUrl = "https://homecare-mky9rkq0j-madhupatel.vercel.app/",
            previewIcon = "house-chimney",
            previewStyle = "pickle"
        ),

        Project(
            id = 6,
            index = "06 — APP",
            title = "InstaSaver",
            description = "An open-source Android app built with Kotlin to download Instagram Reels, posts and profile pictures — fast, clean and privacy-focused. Paste a link, tap download, and the media is saved to your device. No login, no ads, no tracking.",
            category = "Android App",
            tags = listOf("Kotlin", "MVVM", "Android Jetpack", "Material Design"),
            detailsUrl = "projects/InstaSaver.html",
            apkUrl = "https://github.com/pspktech/InstaSaver/releases/latest",
            sourceUrl = "https://github.com/pspktech/InstaSaver",
            previewIcon = "instagram",
            previewStyle = "insta"
        )
    )
}
