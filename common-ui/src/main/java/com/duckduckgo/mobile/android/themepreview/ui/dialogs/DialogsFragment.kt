/*
 * Copyright (c) 2022 DuckDuckGo
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.duckduckgo.mobile.android.themepreview.ui.dialogs

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import com.duckduckgo.mobile.android.R
import com.duckduckgo.mobile.android.ui.view.TypewriterDaxDialog
import com.duckduckgo.mobile.android.ui.view.dialog.RadioListAlertDialog
import com.duckduckgo.mobile.android.ui.view.dialog.TextAlertDialog
import com.duckduckgo.mobile.android.ui.view.dialog.TextAlertDialog.EventListener
import com.duckduckgo.mobile.android.ui.view.dialog.StackedAlertDialog
import com.google.android.material.snackbar.Snackbar

/** Fragment to display a list of dialogs. */
@SuppressLint("NoFragment") // we don't use DI here
class DialogsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_components_dialogs, container, false)
    }

    override fun onViewCreated(
        view: View,
        savedInstanceState: Bundle?
    ) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<Button>(R.id.textAlertDialogWithImageButton)?.let {
            it.setOnClickListener {
                activity?.supportFragmentManager?.let { fragmentManager ->
                    TextAlertDialog.Builder(requireContext())
                        .setHeaderImageResource(R.drawable.ic_dax_icon)
                        .setTitle(R.string.text_dialog_title)
                        .setMessage(R.string.text_dialog_message)
                        .setPositiveButton(R.string.text_dialog_positive)
                        .setNegativeButton(R.string.text_dialog_negative)
                        .addEventListener(object : EventListener() {
                            override fun onPositiveButtonClicked() {
                                Snackbar.make(it, "Negative Button Clicked", Snackbar.LENGTH_SHORT).show()
                            }

                            override fun onNegativeButtonClicked() {
                                Snackbar.make(it, "Negative Button Clicked", Snackbar.LENGTH_SHORT).show()
                            }
                        })
                        .build()
                        .show(fragmentManager, TextAlertDialog.TAG_TEXT_ALERT_DIALOG)
                }
            }
        }

        view.findViewById<Button>(R.id.radioButtonAlertDialog)?.let {
            it.setOnClickListener {
                activity?.supportFragmentManager?.let { fragmentManager ->
                    RadioListAlertDialog.Builder(requireContext())
                        .setTitle(R.string.text_dialog_title)
                        .setMessage(R.string.text_dialog_message)
                        .setPositiveButton(R.string.text_dialog_positive)
                        .setNegativeButton(R.string.text_dialog_negative)
                        .setOptions(listOf(R.string.text_dialog_option, R.string.text_dialog_option, R.string.text_dialog_option))
                        .addEventListener(object : RadioListAlertDialog.EventListener() {
                            override fun onRadioItemSelected(selectedItem: Int) {
                                Snackbar.make(it, "Radio Button $selectedItem selected", Snackbar.LENGTH_SHORT).show()
                            }
                        })
                        .build()
                        .show(fragmentManager, RadioListAlertDialog.TAG_RADIO_LIST_ALERT_DIALOG)
                }
            }
        }

        view.findViewById<Button>(R.id.textAlertDialogButton)?.let {
            it.setOnClickListener {
                activity?.supportFragmentManager?.let { fragmentManager ->
                    TextAlertDialog.Builder(requireContext())
                        .setTitle(R.string.text_dialog_title)
                        .setMessage(R.string.text_dialog_message)
                        .setPositiveButton(R.string.text_dialog_positive)
                        .setNegativeButton(R.string.text_dialog_negative)
                        .addEventListener(object : EventListener() {
                            override fun onPositiveButtonClicked() {
                                Snackbar.make(it, "Positive Button Clicked", Snackbar.LENGTH_SHORT).show()
                            }

                            override fun onNegativeButtonClicked() {
                                Snackbar.make(it, "Negative Button Clicked", Snackbar.LENGTH_SHORT).show()
                            }
                        })
                        .build()
                        .show(fragmentManager, TextAlertDialog.TAG_TEXT_ALERT_DIALOG)
                }
            }
        }
        view.findViewById<Button>(R.id.stackedAlertDialogWithImageButton)?.let {
            it.setOnClickListener {
                activity?.supportFragmentManager?.let { fragmentManager ->
                    StackedAlertDialog.Builder(requireContext())
                        .setHeaderImageResource(R.drawable.ic_dax_icon)
                        .setTitle(R.string.text_dialog_title)
                        .setMessage(R.string.text_dialog_message)
                        .setStackedButtons(
                            listOf(
                                R.string.text_dialog_positive,
                                R.string.text_dialog_positive,
                                R.string.text_dialog_positive
                            )
                        )
                        .addEventListener(object : StackedAlertDialog.EventListener() {
                            override fun onButtonClicked(position: Int) {
                                Snackbar.make(it, "Button $position Clicked", Snackbar.LENGTH_SHORT).show()
                            }
                        })
                        .build()
                        .show(fragmentManager, StackedAlertDialog.TAG_STACKED_ALERT_DIALOG)
                }
            }

            view.findViewById<Button>(R.id.stackedAlertDialogWithButtons)?.let {
                it.setOnClickListener {
                    activity?.supportFragmentManager?.let { fragmentManager ->
                        StackedAlertDialog.Builder(requireContext())
                            .setTitle(R.string.text_dialog_title)
                            .setMessage(R.string.text_dialog_message)
                            .setStackedButtons(
                                listOf(
                                    R.string.text_dialog_positive,
                                    R.string.text_dialog_positive,
                                    R.string.text_dialog_positive,
                                    R.string.text_dialog_positive
                                )
                            )
                            .addEventListener(object : StackedAlertDialog.EventListener() {
                                override fun onButtonClicked(position: Int) {
                                    Snackbar.make(it, "Button $position Clicked", Snackbar.LENGTH_SHORT).show()
                                }
                            })
                            .build()
                            .show(fragmentManager, StackedAlertDialog.TAG_STACKED_ALERT_DIALOG)
                    }
                }

                view.findViewById<Button>(R.id.animated_button)?.let {
                    it.setOnClickListener {
                        activity?.supportFragmentManager?.let { fragmentManager ->
                            TypewriterDaxDialog.newInstance(
                                daxText = "This is an example of a Dax dialog with an animated text",
                                primaryButtonText = "Primary CTA",
                                secondaryButtonText = "Secondary CTA",
                                hideButtonText = "Hide",
                                toolbarDimmed = true
                            ).show(fragmentManager, "dialog")
                        }
                    }
                }

                view.findViewById<Button>(R.id.not_dimmed_button)?.let {
                    it.setOnClickListener {
                        activity?.supportFragmentManager?.let { fragmentManager ->
                            TypewriterDaxDialog.newInstance(
                                daxText = "This is an example of a Dax dialog with toolbar location not dimmed",
                                primaryButtonText = "Primary CTA",
                                secondaryButtonText = "Secondary CTA",
                                hideButtonText = "Hide",
                                toolbarDimmed = false,
                            ).show(fragmentManager, "dialog")
                        }
                    }
                }

                view.findViewById<Button>(R.id.dismissible_button)?.let {
                    it.setOnClickListener {
                        activity?.supportFragmentManager?.let { fragmentManager ->
                            TypewriterDaxDialog.newInstance(
                                daxText = "This is an example of a Dax dialog that can be dimissed by clicking anywhere in the screen.",
                                primaryButtonText = "Primary CTA",
                                secondaryButtonText = "Secondary CTA",
                                hideButtonText = "Hide",
                                toolbarDimmed = true,
                                dismissible = true
                            ).show(fragmentManager, "dialog")
                        }
                    }
                }

                view.findViewById<Button>(R.id.no_hide_button)?.let {
                    it.setOnClickListener {
                        activity?.supportFragmentManager?.let { fragmentManager ->
                            TypewriterDaxDialog.newInstance(
                                daxText = "This is an example of a Dax dialog without hide button.",
                                primaryButtonText = "Primary CTA",
                                secondaryButtonText = "Secondary CTA",
                                hideButtonText = "Hide",
                                toolbarDimmed = true,
                                showHideButton = false,
                            ).show(fragmentManager, "dialog")
                        }
                    }
                }

                view.findViewById<Button>(R.id.custom_typing_button)?.let {
                    it.setOnClickListener {
                        activity?.supportFragmentManager?.let { fragmentManager ->
                            TypewriterDaxDialog.newInstance(
                                daxText = "This is an example of a Dax dialog with a custom typing delay of 200ms.",
                                primaryButtonText = "Primary CTA",
                                secondaryButtonText = "Secondary CTA",
                                hideButtonText = "Hide",
                                toolbarDimmed = true,
                                typingDelayInMs = 200L
                            ).show(fragmentManager, "dialog")
                        }
                    }
                }
            }
        }
    }
}
