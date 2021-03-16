package com.softsuit.aad.codelab.userinterface.menu

import android.os.Bundle
import android.view.ContextMenu
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import com.softsuit.aad.R
import com.softsuit.aad.codelab.util.toast
import com.softsuit.aad.databinding.FragmentOrderBinding

class OrderFragment : Fragment(R.layout.fragment_order) {
    private lateinit var binding: FragmentOrderBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentOrderBinding.bind(view)
        setHasOptionsMenu(true)
        registerForContextMenu(binding.title)

        binding.alertButton.setOnClickListener {
            AlertDialog
                .Builder(requireContext())
                .setTitle("Alerta")
                .setMessage("Olá!")
                .setPositiveButton("OK") { _, _ -> toast("Pressed OK") }
                .setNegativeButton("Cancel") { _, _ -> toast("Pressed Cancel") }
                .show()
        }
        binding.datePickerButton.setOnClickListener {
            DatePickerFragment { result -> binding.selectedDateText.text = result }
                .show(childFragmentManager,"datePicker")
        }
    }

    override fun onCreateContextMenu(
        menu: ContextMenu,
        v: View,
        menuInfo: ContextMenu.ContextMenuInfo?
    ) {
        super.onCreateContextMenu(menu, v, menuInfo)
        requireActivity().menuInflater.inflate(R.menu.menu_main, menu)
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_status -> {
                toast(getString(R.string.action_status_message))
                return true
            }
            R.id.action_favorites -> {
                toast(getString(R.string.action_favorites_message))
                return true
            }
            R.id.action_contact -> {
                toast(getString(R.string.action_contact_message))
                return true
            }
            else -> Unit
        }
        return super.onContextItemSelected(item)
    }
}