package com.editium.app.ui.editor

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.editium.app.ui.views.PreviewSurface
import com.editium.app.ui.views.TimelineView
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class VideoEditorFragment : Fragment() {
    private val viewModel: VideoEditorViewModel by viewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        // Thin bridge fragment; actual UI in Compose or custom views can be inflated from XML if needed
        return View(requireContext())
    }
}

