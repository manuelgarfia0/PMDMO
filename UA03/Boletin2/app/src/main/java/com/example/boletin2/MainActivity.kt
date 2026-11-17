package com.example.boletin2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.*
import com.example.boletin2.ui.exercises.*
import com.example.boletin2.ui.menu.MenuScreen
import com.example.boletin2.ui.theme.Boletin2Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Boletin2Theme {
                var selectedExercise by remember { mutableStateOf<Int?>(null) }
                val listState = rememberLazyListState()

                if (selectedExercise == null) {
                    MenuScreen(
                        listState = listState,
                        onSelectExercise = { id -> selectedExercise = id }
                    )
                } else {
                    when (selectedExercise) {
                        // Boletín 1
                        1 -> Exercise1_1Screen(onBack = { selectedExercise = null })
                        2 -> Exercise1_2Screen(onBack = { selectedExercise = null })
                        3 -> Exercise1_3Screen(onBack = { selectedExercise = null })
                        4 -> Exercise1_4Screen(onBack = { selectedExercise = null })
                        5 -> Exercise1_5Screen(onBack = { selectedExercise = null })
                        6 -> Exercise1_6Screen(onBack = { selectedExercise = null })
                        7 -> Exercise1_7Screen(onBack = { selectedExercise = null })
                        8 -> Exercise1_8Screen(onBack = { selectedExercise = null })
                        9 -> Exercise1_9Screen(onBack = { selectedExercise = null })
                        10 -> Exercise1_10Screen(onBack = { selectedExercise = null })

                        // Boletín 2
                        21 -> Exercise2_1Screen(onBack = { selectedExercise = null })
                        22 -> Exercise2_2Screen(onBack = { selectedExercise = null })
                        23 -> Exercise2_3Screen(onBack = { selectedExercise = null })
                        24 -> Exercise2_4Screen(onBack = { selectedExercise = null })
                        25 -> Exercise2_5Screen(onBack = { selectedExercise = null })
                        26 -> Exercise2_6Screen(onBack = { selectedExercise = null })
                        27 -> Exercise2_7Screen(onBack = { selectedExercise = null })
                        28 -> Exercise2_8Screen(onBack = { selectedExercise = null })
                        29 -> Exercise2_9Screen(onBack = { selectedExercise = null })
                        30 -> Exercise2_10Screen(onBack = { selectedExercise = null })
                        31 -> Exercise2_11Screen(onBack = { selectedExercise = null })
                        32 -> Exercise2_12Screen(onBack = { selectedExercise = null })

                        // Boletín 3
                        41 -> Exercise3_1Screen(onBack = { selectedExercise = null })
                        42 -> Exercise3_2Screen(onBack = { selectedExercise = null })
                        43 -> Exercise3_3Screen(onBack = { selectedExercise = null })
                        44 -> Exercise3_4Screen(onBack = { selectedExercise = null })
                        45 -> Exercise3_5Screen(onBack = { selectedExercise = null })
                        46 -> Exercise3_6Screen(onBack = { selectedExercise = null })
                        47 -> Exercise3_7Screen(onBack = { selectedExercise = null })
                        48 -> Exercise3_8Screen(onBack = { selectedExercise = null })
                        49 -> Exercise3_9Screen(onBack = { selectedExercise = null })
                        50 -> Exercise3_10Screen(onBack = { selectedExercise = null })

                        // Boletín 4
                        61 -> Exercise4_1Screen(onBack = { selectedExercise = null })
                        62 -> Exercise4_2Screen(onBack = { selectedExercise = null })
                        63 -> Exercise4_3Screen(onBack = { selectedExercise = null })
                        64 -> Exercise4_4Screen(onBack = { selectedExercise = null })
                        65 -> Exercise4_5Screen(onBack = { selectedExercise = null })
                        66 -> Exercise4_6Screen(onBack = { selectedExercise = null })
                        67 -> Exercise4_7Screen(onBack = { selectedExercise = null })
                        68 -> Exercise4_8Screen(onBack = { selectedExercise = null })
                        69 -> Exercise4_9Screen(onBack = { selectedExercise = null })
                        70 -> Exercise4_10Screen(onBack = { selectedExercise = null })

                        else -> MenuScreen(listState = listState, onSelectExercise = { id -> selectedExercise = id })
                    }
                }
            }
        }
    }
}
