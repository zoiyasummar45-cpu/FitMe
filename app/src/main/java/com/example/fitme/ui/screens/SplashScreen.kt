package com.example.fitme.ui.screens

import androidx.compose.animation.core.*
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.fitme.ui.components.FitMeLogoHeader
import com.example.fitme.ui.theme.FitMeColors
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(
    onTimeout: () -> Unit
) {
    var startAnimation by remember { mutableStateOf(false) }

    val logoScale by animateFloatAsState(
        targetValue = if (startAnimation) 1f else 0.6f,
        animationSpec = spring(
            dampingRatio = Spring.DampingRatioMediumBouncy,
            stiffness = Spring.StiffnessLow
        ),
        label = "scale"
    )

    val alphaFade by animateFloatAsState(
        targetValue = if (startAnimation) 1f else 0f,
        animationSpec = tween(durationMillis = 1000),
        label = "alpha"
    )

    LaunchedEffect(Unit) {
        startAnimation = true
        delay(2600)
        onTimeout()
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(FitMeColors.BackgroundLight),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Spacer(modifier = Modifier.height(20.dp))

            // Main Logo Header with animation
            Box(
                modifier = Modifier
                    .scale(logoScale)
                    .alpha(alphaFade)
            ) {
                FitMeLogoHeader(
                    logoSize = 220.dp,
                    showSubtitle = true,
                    showBadges = true
                )
            }

            // 4 Feature Pillars from image
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .alpha(alphaFade),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    FeaturePillarItem(icon = "💪", title = "PERSONALIZED\nWORKOUTS")
                    FeaturePillarItem(icon = "🎯", title = "GOAL BASED\nPLANS")
                    FeaturePillarItem(icon = "📊", title = "TRACK YOUR\nPROGRESS")
                    FeaturePillarItem(icon = "📅", title = "STAY CONSISTENT\nSTAY ACTIVE")
                }

                Spacer(modifier = Modifier.height(24.dp))
            }
        }
    }
}

@Composable
fun FeaturePillarItem(
    icon: String,
    title: String
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.width(76.dp)
    ) {
        Box(
            modifier = Modifier
                .size(46.dp)
                .clip(CircleShape)
                .background(FitMeColors.BlueBackground),
            contentAlignment = Alignment.Center
        ) {
            Text(text = icon, fontSize = 22.sp)
        }
        Spacer(modifier = Modifier.height(6.dp))
        Text(
            text = title,
            fontSize = 9.sp,
            fontWeight = FontWeight.Bold,
            color = FitMeColors.TextSecondary,
            textAlign = TextAlign.Center,
            lineHeight = 11.sp
        )
    }
}
