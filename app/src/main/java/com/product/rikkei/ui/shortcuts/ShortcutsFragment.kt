package com.product.rikkei.ui.shortcuts

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.product.rikkei.MyApplication
import com.product.rikkei.adapters.ShortcutAdapter
import com.product.rikkei.databinding.FragmentShortcutsBinding

class ShortcutsFragment : Fragment() {
    private lateinit var binding: FragmentShortcutsBinding

    var category: String? = null
    val shortcutAdapter by lazy {
        ShortcutAdapter()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            category = it.getString("category")
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentShortcutsBinding.inflate(inflater)
        return binding.root
    }

    companion object {
        val TAG = ShortcutsFragment::class.simpleName

        @JvmStatic
        fun newInstance(category: String) =
            ShortcutsFragment().apply {
                arguments = Bundle().apply {
                    putString("category", category)
                }
            }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.rvShortcuts.adapter = shortcutAdapter

        category?.let {
            binding.appbar.text = it + " Keyboard Shortcuts"
            when (it) {
                "General" -> {
                    shortcutAdapter.shortcuts = (requireActivity().application as MyApplication).generalShortcuts
                }
                "GNOME" -> {
                    shortcutAdapter.shortcuts = (requireActivity().application as MyApplication).gnomeShortcuts
                }
                "KDE" -> {
                    shortcutAdapter.shortcuts = (requireActivity().application as MyApplication).kdeShortcuts
                }
                "Xfce" -> {
                    shortcutAdapter.shortcuts = (requireActivity().application as MyApplication).xfceShortcuts
                }
                "LXDE" -> {
                    shortcutAdapter.shortcuts = (requireActivity().application as MyApplication).lxdeShortcuts
                }
                "Cinnamon" -> {
                    shortcutAdapter.shortcuts = (requireActivity().application as MyApplication).cinnamonShortcuts
                }
                "Bash" -> {
                    shortcutAdapter.shortcuts = (requireActivity().application as MyApplication).bashShortcuts
                }
                "Ubuntu" -> {
                    shortcutAdapter.shortcuts = (requireActivity().application as MyApplication).ubuntuShortcuts
                }
                "Firefox" -> {
                    shortcutAdapter.shortcuts = (requireActivity().application as MyApplication).firefoxShortcuts
                }
                "ChromeOS" -> {
                    shortcutAdapter.shortcuts = (requireActivity().application as MyApplication).chromeOSShortcuts
                }
            }
        }
    }
}