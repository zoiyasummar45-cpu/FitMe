package com.example.fitme.ui.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.*
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.fitme.ui.theme.FitMeColors

@Composable
fun FitMeLogoHeader(
    modifier: Modifier = Modifier,
    logoSize: Dp = 180.dp,
    showSubtitle: Boolean = true,
    showBadges: Boolean = true
) {
    Column(
        modifier = modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        FitMeLogoCanvas(
            size = logoSize,
            showBadges = showBadges
        )

        Spacer(modifier = Modifier.height(12.dp))

        // FitMe Title
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Fit",
                fontSize = (logoSize.value * 0.22f).sp,
                fontWeight = FontWeight.Black,
                color = FitMeColors.BlueDark
            )
            Text(
                text = "Me",
                fontSize = (logoSize.value * 0.22f).sp,
                fontWeight = FontWeight.Black,
                color = FitMeColors.MagentaPrimary
            )
        }

        if (showSubtitle) {
            Spacer(modifier = Modifier.height(4.dp))
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier.padding(horizontal = 16.dp)
            ) {
                // Left accent line
                Canvas(modifier = Modifier.width(20.dp).height(2.dp)) {
                    drawLine(
                        color = FitMeColors.BluePrimary,
                        start = Offset(0f, size.height / 2),
                        end = Offset(size.width, size.height / 2),
                        strokeWidth = 4f
                    )
                }

                Spacer(modifier = Modifier.width(8.dp))

                Text(
                    text = "STRONG TODAY  •  HEALTHY THROUGH EVERY STAGE",
                    fontSize = 9.sp,
                    fontWeight = FontWeight.Bold,
                    color = FitMeColors.BluePrimary,
                    textAlign = TextAlign.Center
                )

                Spacer(modifier = Modifier.width(8.dp))

                // Right accent line
                Canvas(modifier = Modifier.width(20.dp).height(2.dp)) {
                    drawLine(
                        color = FitMeColors.MagentaPrimary,
                        start = Offset(0f, size.height / 2),
                        end = Offset(size.width, size.height / 2),
                        strokeWidth = 4f
                    )
                }
            }
        }
    }
}

@Composable
fun FitMeLogoCanvas(
    size: Dp = 160.dp,
    showBadges: Boolean = true
) {
    Canvas(
        modifier = Modifier.size(size)
    ) {
        val w = this.size.width
        val h = this.size.height

        val blueBrush = Brush.linearGradient(
            colors = listOf(FitMeColors.BlueDark, FitMeColors.BluePrimary, FitMeColors.BlueLight)
        )
        val pinkBrush = Brush.linearGradient(
            colors = listOf(FitMeColors.MagentaDark, FitMeColors.MagentaPrimary, FitMeColors.MagentaLight)
        )

        // 1. Outer framing arc
        val strokeWidth = w * 0.04f
        drawArc(
            brush = Brush.sweepGradient(
                0f to FitMeColors.BluePrimary,
                0.5f to FitMeColors.MagentaPrimary,
                1f to FitMeColors.BluePrimary
            ),
            startAngle = 140f,
            sweepAngle = 260f,
            useCenter = false,
            style = Stroke(width = strokeWidth, cap = StrokeCap.Round),
            size = Size(w * 0.85f, h * 0.85f),
            topLeft = Offset(w * 0.075f, h * 0.05f)
        )

        // 2. Male Silhouette (Left - Blue)
        val malePath = Path().apply {
            moveTo(w * 0.46f, h * 0.60f)
            // Torso & Back
            cubicTo(w * 0.44f, h * 0.45f, w * 0.42f, h * 0.35f, w * 0.35f, h * 0.22f)
            // Neck & Head
            cubicTo(w * 0.34f, h * 0.18f, w * 0.32f, h * 0.14f, w * 0.34f, h * 0.10f)
            cubicTo(w * 0.38f, h * 0.10f, w * 0.40f, h * 0.14f, w * 0.41f, h * 0.17f)
            // Chest & Bicep flexing
            cubicTo(w * 0.43f, h * 0.22f, w * 0.46f, h * 0.26f, w * 0.48f, h * 0.30f)
            // Arm holding dumbbell
            cubicTo(w * 0.38f, h * 0.32f, w * 0.25f, h * 0.33f, w * 0.22f, h * 0.38f)
            cubicTo(w * 0.20f, h * 0.43f, w * 0.26f, h * 0.48f, w * 0.32f, h * 0.44f)
            cubicTo(w * 0.38f, h * 0.48f, w * 0.44f, h * 0.54f, w * 0.46f, h * 0.60f)
            close()
        }
        drawPath(path = malePath, brush = blueBrush)

        // Male Dumbbell
        drawCircle(
            color = FitMeColors.BlueDark,
            radius = w * 0.05f,
            center = Offset(w * 0.24f, h * 0.38f)
        )
        drawCircle(
            color = FitMeColors.CardBackground,
            radius = w * 0.02f,
            center = Offset(w * 0.24f, h * 0.38f)
        )

        // Heart Pulse Icon above Male Arm
        val heartPath = Path().apply {
            val cx = w * 0.27f
            val cy = h * 0.23f
            val s = w * 0.07f
            moveTo(cx, cy + s * 0.6f)
            cubicTo(cx - s * 0.8f, cy, cx - s * 0.8f, cy - s * 0.7f, cx, cy - s * 0.4f)
            cubicTo(cx + s * 0.8f, cy - s * 0.7f, cx + s * 0.8f, cy, cx, cy + s * 0.6f)
            close()
        }
        drawPath(path = heartPath, brush = blueBrush)

        // Pulse wave line inside heart
        val pulsePath = Path().apply {
            moveTo(w * 0.23f, h * 0.23f)
            lineTo(w * 0.25f, h * 0.23f)
            lineTo(w * 0.26f, h * 0.20f)
            lineTo(w * 0.28f, h * 0.26f)
            lineTo(w * 0.29f, h * 0.23f)
            lineTo(w * 0.31f, h * 0.23f)
        }
        drawPath(
            path = pulsePath,
            color = Color.White,
            style = Stroke(width = 3f, cap = StrokeCap.Round)
        )

        // 3. Female Silhouette (Right - Magenta)
        val femalePath = Path().apply {
            moveTo(w * 0.47f, h * 0.60f)
            // Back & Waist
            cubicTo(w * 0.50f, h * 0.50f, w * 0.52f, h * 0.40f, w * 0.49f, h * 0.30f)
            // Ponytail Hair & Head
            cubicTo(w * 0.51f, h * 0.20f, w * 0.56f, h * 0.14f, w * 0.60f, h * 0.15f)
            cubicTo(w * 0.64f, h * 0.18f, w * 0.61f, h * 0.25f, w * 0.58f, h * 0.28f)
            // Neck & Shoulder
            cubicTo(w * 0.62f, h * 0.32f, w * 0.65f, h * 0.37f, w * 0.63f, h * 0.45f)
            // Arm holding pink dumbbell
            cubicTo(w * 0.66f, h * 0.40f, w * 0.70f, h * 0.38f, w * 0.73f, h * 0.40f)
            cubicTo(w * 0.74f, h * 0.44f, w * 0.69f, h * 0.48f, w * 0.62f, h * 0.52f)
            cubicTo(w * 0.58f, h * 0.56f, w * 0.52f, h * 0.60f, w * 0.47f, h * 0.60f)
            close()
        }
        drawPath(path = femalePath, brush = pinkBrush)

        // Female Dumbbell
        drawCircle(
            color = FitMeColors.MagentaPrimary,
            radius = w * 0.04f,
            center = Offset(w * 0.72f, h * 0.40f)
        )

        // 4. Grounded Leaf Base (Blue left leaf, Pink right leaf)
        val leftLeaf = Path().apply {
            moveTo(w * 0.47f, h * 0.75f)
            cubicTo(w * 0.30f, h * 0.75f, w * 0.12f, h * 0.65f, w * 0.14f, h * 0.48f)
            cubicTo(w * 0.28f, h * 0.48f, w * 0.42f, h * 0.60f, w * 0.47f, h * 0.75f)
            close()
        }
        drawPath(path = leftLeaf, brush = blueBrush)

        val rightLeaf = Path().apply {
            moveTo(w * 0.47f, h * 0.75f)
            cubicTo(w * 0.64f, h * 0.75f, w * 0.82f, h * 0.65f, w * 0.80f, h * 0.48f)
            cubicTo(w * 0.66f, h * 0.48f, w * 0.52f, h * 0.60f, w * 0.47f, h * 0.75f)
            close()
        }
        drawPath(path = rightLeaf, brush = pinkBrush)

        // 5. Connected 5 Life-Stage Badges on Right Arc
        if (showBadges) {
            val badgeCenters = listOf(
                Offset(w * 0.78f, h * 0.15f), // 1. Menstruation
                Offset(w * 0.84f, h * 0.28f), // 2. Pregnancy
                Offset(w * 0.85f, h * 0.42f), // 3. Postpartum
                Offset(w * 0.82f, h * 0.56f), // 4. PCOS/PCOD
                Offset(w * 0.76f, h * 0.68f)  // 5. Menopause
            )

            badgeCenters.forEachIndexed { _, pos ->
                drawCircle(
                    brush = pinkBrush,
                    radius = w * 0.055f,
                    center = pos
                )
                drawCircle(
                    color = Color.White,
                    radius = w * 0.045f,
                    center = pos
                )
                drawCircle(
                    brush = pinkBrush,
                    radius = w * 0.038f,
                    center = pos
                )
            }
        }
    }
}
