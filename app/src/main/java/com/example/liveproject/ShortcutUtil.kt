package com.example.liveproject

import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import androidx.core.content.pm.ShortcutInfoCompat
import androidx.core.content.pm.ShortcutManagerCompat
import androidx.core.graphics.drawable.IconCompat

object ShortcutUtil {

    /**
     * Create a [ShortcutInfoCompat] for a reservation.
     */
    private fun createShortcutInfoForReservation(
        context: Context,
        reservationId: String,
        shortLabel: String,
        longLabel: String,
    ): ShortcutInfoCompat {
        val shortcutId = "active_reservation_$reservationId"
        return ShortcutInfoCompat.Builder(context, shortcutId)
            .setShortLabel(shortLabel)
            .setLongLabel(longLabel)
            .setIcon(IconCompat.createWithResource(context, R.mipmap.ic_launcher_round))
            .setIntents(
                arrayOf(
                    Intent(context, MainActivity::class.java).apply {
                        action = Intent.ACTION_VIEW
                        flags = Intent.FLAG_ACTIVITY_CLEAR_TASK
                    },
//                    Intent(context, AppLauncher::class.java).apply {
//                        action = Intent.ACTION_VIEW
//                        val bundle = Bundle().apply {
//                            putString("reservation_id", reservationId)
//                        }
//                        putExtras(bundle)
//                    },
                )
            )
            .build()
    }

    /**
     * Request creating Pinned App Shortcut for a reservation.
     */
    @Throws(Exception::class)
    fun requestPinShortcutForReservation(
        context: Context,
        reservationId: String,
        shortLabel: String,
        longLabel: String,
        requestCode: Int = 1,
    ) {
        if (ShortcutManagerCompat.isRequestPinShortcutSupported(context)) {
            val shortcutInfo = createShortcutInfoForReservation(
                context,
                reservationId,
                shortLabel,
                longLabel,
            )

            val intent = ShortcutManagerCompat.createShortcutResultIntent(
                context,
                shortcutInfo,
            )

            val successCallback = PendingIntent.getBroadcast(
                context,
                requestCode,
                intent,
                PendingIntent.FLAG_UPDATE_CURRENT,
            )

            ShortcutManagerCompat.requestPinShortcut(
                context,
                shortcutInfo,
                successCallback.intentSender,
            )
        } else {
            throw Exception("Pinned App Shortcut not supported")
        }
    }
}