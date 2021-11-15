package com.product.rikkei.ui.home

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.product.rikkei.MyApplication
import com.product.rikkei.R
import com.product.rikkei.adapters.CategoryAdapter
import com.product.rikkei.databinding.FragmentHomeBinding
import com.product.rikkei.ui.premium.PremiumActivity
import com.product.rikkei.ui.shortcuts.ShortcutsFragment
import com.product.rikkei.utils.PremiumManager
import com.google.android.material.snackbar.Snackbar


class HomeFragment : Fragment(), CategoryAdapter.OnItemCategoryClickListener {
    private lateinit var binding: FragmentHomeBinding
    private val categoryAdapter by lazy {
        CategoryAdapter(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater)
        return binding.root
    }

    companion object {
        val TAG = HomeFragment::class.simpleName

        @JvmStatic
        fun newInstance() = HomeFragment().apply {
            arguments = Bundle().apply {
            }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.rvCategory.adapter = categoryAdapter
        categoryAdapter.categories = (requireActivity().application as MyApplication).categories

        binding.btPremium.setOnClickListener {
            requireActivity().startActivity(Intent(requireActivity(), PremiumActivity::class.java))
        }

    }

    override fun onItemCategoryClick(index: Int, category: String) {
        if (index < 6) {
            requireActivity().supportFragmentManager.beginTransaction()
                .add(R.id.fragmentContainer, ShortcutsFragment.newInstance(category), ShortcutsFragment.TAG)
                .addToBackStack(ShortcutsFragment.TAG)
                .commit()
        } else {
            if (PremiumManager.getInstance()?.isPremium == true) {
                requireActivity().supportFragmentManager.beginTransaction()
                    .add(R.id.fragmentContainer, ShortcutsFragment.newInstance(category), ShortcutsFragment.TAG)
                    .addToBackStack(ShortcutsFragment.TAG)
                    .commit()
            } else {
                Snackbar.make(binding.root, "Please get premium to unlock", 1500)
                    .setBackgroundTint(ContextCompat.getColor(requireActivity(), R.color.accent)).show()
            }
        }

    }
}