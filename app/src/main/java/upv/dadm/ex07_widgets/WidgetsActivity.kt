/*
 * Copyright (c) 2022-2024 Universitat Politècnica de València
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
import android.view.View
import android.widget.SeekBar
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import upv.dadm.ex07_widgets.databinding.ActivityWidgetsBinding

/**
 * Displays some widgets.
 * A Switch controls the visibility of a ProgressBar.
 * Messages are display whenever the progress/rating of ProgressBar/RatingBar changes.
 */
class WidgetsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Get the automatically generated view binding for the layout resource
        val binding = ActivityWidgetsBinding.inflate(layoutInflater)
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

        // This callback will be activated whenever the checked state of the Switch changes
        binding.sSwitchProgress.setOnCheckedChangeListener { _, isChecked ->
            // The visibility of the ProgressBar is controlled by the checked state of the Switch
            if (isChecked) {
                binding.pbIndefiniteProgress.visibility = View.VISIBLE
            } else {
                binding.pbIndefiniteProgress.visibility = View.INVISIBLE
            }
        }

        // This callback will be activated whenever the progress of a SeekBar changes
        val listener = object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                // Do nothing
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
                // Do nothing
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
                // Display the current progress
                Toast.makeText(
                    this@WidgetsActivity,
                    getString(R.string.message_progress, seekBar?.progress ?: 0, seekBar?.max ?: 0),
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
        // Associate the listener to each SeekBar
        binding.sbContinuous.setOnSeekBarChangeListener(listener)
        binding.sbDiscrete.setOnSeekBarChangeListener(listener)

        // This callback will be activated whenever the rating of the RatingBar changes
        binding.rbRating.setOnRatingBarChangeListener { _, rating, _ ->
            // Display the current rating
            Toast.makeText(
                this@WidgetsActivity,
                getString(R.string.message_rating, rating),
                Toast.LENGTH_SHORT
            ).show()
        }
    }
}