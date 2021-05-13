package com.onix.internship.survay.arch.view.dialog


import android.graphics.Point
import android.os.Build
import android.view.Display
import androidx.fragment.app.DialogFragment

interface DialogResizable {

    fun getDialogWidth(): Float

    fun getDialogHeight(): Float

    fun DialogFragment.setDialogSize() {
        val display: Display? = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            requireContext().display
        } else {
            dialog?.window?.windowManager?.defaultDisplay
        }

        val point = Point()
        display?.getRealSize(point)
        dialog?.window?.setLayout(
            (point.x * getDialogWidth()).toInt(),
            (point.y * getDialogHeight()).toInt()
        )
    }
}