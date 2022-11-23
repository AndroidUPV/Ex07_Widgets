/*
 * Copyright (c) 2022
 * David de Andrés and Juan Carlos Ruiz
 * Development of apps for mobile devices
 * Universitat Politècnica de València
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
                getString(R.string.switch_message, if (isChecked) "" else "un"),
                Toast.LENGTH_SHORT
            ).show()
        }

        // Uncheck all RadioButtons within the RadioGroup
        binding.ibImage.setOnClickListener {
            binding.rgGroup.clearCheck()
        }
    }
}