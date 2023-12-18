/*
 * Copyright (c) 2022-2023 Universitat Politècnica de València
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
import androidx.appcompat.app.AppCompatActivity
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
        // Set the activity content to the root element of the generated view
        setContentView(binding.root)

        // Set the title of the Activity
        setTitle(R.string.buttons)

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