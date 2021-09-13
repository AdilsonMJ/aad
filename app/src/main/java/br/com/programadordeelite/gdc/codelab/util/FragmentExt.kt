package br.com.programadordeelite.gdc.codelab.util

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.annotation.IdRes
import androidx.annotation.StyleRes
import androidx.appcompat.app.AppCompatDelegate
import androidx.fragment.app.Fragment
import androidx.navigation.NavDirections
import androidx.navigation.fragment.findNavController
import br.com.programadordeelite.gdc.R
import com.google.android.material.snackbar.Snackbar

fun Fragment.navToExt(@IdRes dest: Int) = findNavController().navigate(dest)
fun Fragment.navToExt(directions: NavDirections) = findNavController().navigate(directions)
fun Fragment.navToExt(@IdRes dest: Int, args: Bundle) = findNavController().navigate(dest, args)
fun Fragment.toastExt(msg: String) = Toast.makeText(requireContext(), msg, Toast.LENGTH_SHORT).show()
fun Fragment.snakeExt(view: View, msg: String) = Snackbar.make(view, msg, Snackbar.LENGTH_SHORT).show()

fun Fragment.startActivity(clazz: Class<*>, name: String = "", args: Bundle = Bundle()){
    val intent = Intent(requireContext(), clazz).apply {
        if(!(name.isNullOrEmpty() && args.isEmpty)) {
            putExtra(name,args)
        }
    }
    requireActivity().startActivity(intent)
}

