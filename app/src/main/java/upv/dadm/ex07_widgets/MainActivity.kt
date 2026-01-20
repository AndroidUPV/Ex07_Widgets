/*
 * Copyright (c) 2022-2026 Universitat Politècnica de València
 * Authors: David de Andrés and Juan Carlos Ruiz
 *          Fault-Tolerant Systems
 *          Instituto ITACA
 *          Universitat Politècnica de València
 *
 * Distributed under MIT license
 * (See accompanying file LICENSE.txt)
 */

package upv.dadm.ex07_widgets

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import upv.dadm.ex07_widgets.databinding.ActivityMainBinding

/**
 * Some Buttons launch associated activities to display different kind of Views,
 * like TextView, Buttons, and various Widgets.
 */
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Get the automatically generated view binding for the layout resource
        val binding = ActivityMainBinding.inflate(layoutInflater)
        // Enable edge-to-edge display
        enableEdgeToEdge()
        // Set the activity content to the root element of the generated view
        setContentView(binding.root)
        // Get side margins in pixels
        val sideMarginPx = resources.getDimensionPixelSize(R.dimen.side_margins)
        // Prevent the layout from overlapping with system bars in edge-to-edge display
        ViewCompat.setOnApplyWindowInsetsListener(binding.root) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(sideMarginPx, systemBars.top, sideMarginPx, systemBars.bottom)
            insets
        }
        // Launch activity to display some TextFields
        binding.bTextFields.setOnClickListener { launchShowViewsActivity(TextFieldsActivity::class.java) }
        // Launch activity to display some Buttons
        binding.bButtons.setOnClickListener { launchShowViewsActivity(ButtonsActivity::class.java) }
        // Launch activity to display some Widgets
        binding.bWidgets.setOnClickListener { launchShowViewsActivity(WidgetsActivity::class.java) }
    }

    private fun launchShowViewsActivity(activity: Class<out AppCompatActivity>) {
        startActivity(Intent(this@MainActivity, activity))
    }
}