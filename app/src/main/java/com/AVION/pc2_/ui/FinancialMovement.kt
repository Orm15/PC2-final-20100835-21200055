package com.AVION.pc2_.ui

import com.google.type.Date

data class FinancialMovement(
    val description: String? = null,
    val amount: Double? = null,
    val date: Date? = null // Or use a Timestamp if preferred
)