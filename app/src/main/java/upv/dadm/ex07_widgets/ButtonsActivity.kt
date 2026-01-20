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

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import upv.dadm.ex07_widgets.databinding.ActivityButtonsBinding

/**
 * Displays some Buttons.
 * A message is displayed when the state of the Switch changes.
 */
class ButtonsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Get the automatically generated view binding for the layout resource
        val binding = ActivityButtonsBinding.inflate(layoutInflater)
        // Enable edge-to-edge display
        enableEdgeToEdge()
        // Set the activity content to the root element of the generated view
        setContentView(binding.root)
        // Prevent the layout from overlapping with system bars in edge-to-edge display
        ViewCompat.setOnApplyWindowInsetsListener(binding.root) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // This callback will be activated whenever the check state of the Switch changes
        binding.sSwitch.setOnCheckedChangeListener { _, isChecked ->
            // Display a Toast informing about its check state
            Toast.makeText(
                this@ButtonsActivity,
                getString(if (isChecked) R.string.switch_checked else R.string.switch_unchecked),
                Toast.LENGTH_SHORT
            ).show()
        }

        // Uncheck all RadioButtons within the RadioGroup
        binding.ibImage.setOnClickListener {
            binding.rgGroup.clearCheck()
        }

    }
}