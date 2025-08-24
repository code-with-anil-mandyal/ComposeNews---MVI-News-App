package com.mviktorcomposeexample.common.utils

import kotlinx.datetime.TimeZone
import kotlinx.datetime.daysUntil
import kotlinx.datetime.toLocalDateTime
import kotlinx.datetime.todayIn
import kotlin.math.abs
import kotlin.time.Clock
import kotlin.time.ExperimentalTime
import kotlin.time.Instant

object DateUtils {

    @OptIn(ExperimentalTime::class)
     fun getDaysAgoString(date : String) : String{
        val today = Clock.System.todayIn(TimeZone.Companion.currentSystemDefault())
        val days = today.daysUntil(
            Instant.Companion.parse(date).toLocalDateTime(TimeZone.Companion.currentSystemDefault()).date
        )

        val result = when{
            abs(days) > 1 -> "${abs(days)} days ago"
            abs(days) ==  1 -> "Yesterday"
            else -> "Today"
        }

        return result
    }
}