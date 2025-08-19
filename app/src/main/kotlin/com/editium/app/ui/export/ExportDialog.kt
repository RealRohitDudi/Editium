package com.editium.app.ui.export

import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.DialogFragment

class ExportDialog : DialogFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return Dialog(requireContext())
    }
}

