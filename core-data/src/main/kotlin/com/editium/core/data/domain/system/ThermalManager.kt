package com.editium.core.data.domain.system

import android.content.Context
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow

class ThermalManager(
    private val context: Context
) {
    val thermalState: Flow<Int> = callbackFlow {
        // Temporarily disable thermal management due to compilation issues
        trySend(0)
        awaitClose { }
    }
}
