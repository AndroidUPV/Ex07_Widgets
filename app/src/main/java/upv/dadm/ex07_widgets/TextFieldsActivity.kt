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
import android.text.Editable
import android.text.TextWatcher
import androidx.appcompat.app.AppCompatActivity
import upv.dadm.ex07_widgets.databinding.ActivityTextFieldsBinding

/**
 * Displays some TextFields.
 * A TextWatcher is used to display an error message when
 * the text does not match the expected password.
 */
class TextFieldsActivity : AppCompatActivity() {

    // This is the right password!
    private val password = "DADM"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Get the automatically generated view binding for the layout resource
        val binding = ActivityTextFieldsBinding.inflate(layoutInflater)
        // Set the activity content to the root element of the generated view
        setContentView(binding.root)

        // Set the title of the Activity
        setTitle(R.string.text_string)

        // Add a TextWatcher to react to any change in this TextView's text
        binding.etPassword.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                // Do nothing
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                // Do nothing
            }

            // Check the password is correct after the TextView's text changes
            override fun afterTextChanged(s: Editable?) {
                if (binding.etPassword.text.toString() != password) {
                    binding.etPassword.error = getString(R.string.failed)
                }
            }

        })

    }
}