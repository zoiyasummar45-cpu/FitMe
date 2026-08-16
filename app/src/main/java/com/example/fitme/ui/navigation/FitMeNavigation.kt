package com.example.fitme.ui.navigation

sealed class Screen(val route: String) {
    object Splash : Screen("splash")
    object Login : Screen("login")
    object SignUp : Screen("sign_up")
    object Welcome : Screen("welcome")
    object Gender : Screen("gender")
    object FitnessGoal : Screen("fitness_goal")
    object FitnessLevel : Screen("fitness_level")
    object BodyMetrics : Screen("body_metrics")
    object WomensWellness : Screen("womens_wellness")
    object PlanReady : Screen("plan_ready")
    object GetStarted : Screen("get_started")
    object Home : Screen("home")
}
