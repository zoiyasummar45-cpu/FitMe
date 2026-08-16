package com.example.fitme.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.fitme.ui.components.FitMeGradientButton
import com.example.fitme.ui.components.FitMeLogoHeader
import com.example.fitme.ui.components.FitMeTextField
import com.example.fitme.ui.components.SocialAuthButton
import com.example.fitme.ui.theme.FitMeColors

@Composable
fun LoginScreen(
    onLoginSuccess: () -> Unit,
    onNavigateToSignUp: () -> Unit
) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var rememberMe by remember { mutableStateOf(true) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(FitMeColors.BackgroundLight)
            .verticalScroll(rememberScrollState())
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(16.dp))

        // Top FitMe Logo Header
        FitMeLogoHeader(
            logoSize = 150.dp,
            showSubtitle = true
        )

        Spacer(modifier = Modifier.height(28.dp))

        Text(
            text = "Welcome Back!",
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold,
            color = FitMeColors.TextPrimary
        )

        Text(
            text = "Login to continue your fitness journey",
            fontSize = 14.sp,
            color = FitMeColors.TextSecondary,
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(24.dp))

        // Email / Phone Field
        FitMeTextField(
            value = email,
            onValueChange = { email = it },
            placeholder = "Email or Phone Number",
            leadingIcon = Icons.Filled.Email
        )

        Spacer(modifier = Modifier.height(12.dp))

        // Password Field
        FitMeTextField(
            value = password,
            onValueChange = { password = it },
            placeholder = "Password",
            leadingIcon = Icons.Filled.Lock,
            isPassword = true
        )

        Spacer(modifier = Modifier.height(8.dp))

        // Remember Me & Forgot Password
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Checkbox(
                    checked = rememberMe,
                    onCheckedChange = { rememberMe = it },
                    colors = CheckboxDefaults.colors(
                        checkedColor = FitMeColors.MagentaPrimary
                    )
                )
                Text(
                    text = "Remember me",
                    fontSize = 13.sp,
                    color = FitMeColors.TextSecondary
                )
            }

            Text(
                text = "Forgot Password?",
                fontSize = 13.sp,
                fontWeight = FontWeight.SemiBold,
                color = FitMeColors.MagentaPrimary,
                modifier = Modifier.clickable { }
            )
        }

        Spacer(modifier = Modifier.height(24.dp))

        // Login Gradient CTA Button
        FitMeGradientButton(
            text = "Login",
            onClick = onLoginSuccess
        )

        Spacer(modifier = Modifier.height(20.dp))

        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(horizontal = 16.dp)
        ) {
            Box(
                modifier = Modifier
                    .weight(1f)
                    .height(1.dp)
                    .background(FitMeColors.BorderLight)
            )
            Text(
                text = "  or continue with  ",
                fontSize = 12.sp,
                color = FitMeColors.TextMuted
            )
            Box(
                modifier = Modifier
                    .weight(1f)
                    .height(1.dp)
                    .background(FitMeColors.BorderLight)
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Social Buttons
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            SocialAuthButton(
                iconText = "🌐",
                label = "Google",
                onClick = onLoginSuccess,
                modifier = Modifier.weight(1f)
            )
            SocialAuthButton(
                iconText = "🍏",
                label = "Apple",
                onClick = onLoginSuccess,
                modifier = Modifier.weight(1f)
            )
        }

        Spacer(modifier = Modifier.height(28.dp))

        // Sign Up Link
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Don't have an account? ",
                fontSize = 14.sp,
                color = FitMeColors.TextSecondary
            )
            Text(
                text = "Sign Up",
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold,
                color = FitMeColors.MagentaPrimary,
                modifier = Modifier.clickable(onClick = onNavigateToSignUp)
            )
        }

        Spacer(modifier = Modifier.height(24.dp))
    }
}
