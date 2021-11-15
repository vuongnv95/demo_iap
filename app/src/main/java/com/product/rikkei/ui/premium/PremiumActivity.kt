package com.product.rikkei.ui.premium

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.android.billingclient.api.*
import com.product.rikkei.R
import com.product.rikkei.adapters.SkuDetailAdapter
import com.product.rikkei.databinding.ActivityPremiumBinding
import com.product.rikkei.utils.PremiumManager
import com.google.android.material.snackbar.Snackbar

class PremiumActivity : AppCompatActivity(), PurchasesUpdatedListener, BillingClientStateListener,
    SkuDetailAdapter.OnItemSkuDetailClickListener, SkuDetailsResponseListener {
    private lateinit var binding: ActivityPremiumBinding
    private lateinit var billingClient: BillingClient
    private val skuDetailAdapter by lazy {
        SkuDetailAdapter(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPremiumBinding.inflate(layoutInflater)
        setContentView(binding.root)

        billingClient = BillingClient.newBuilder(this)
            .setListener(this)
            .enablePendingPurchases()
            .build()

        billingClient.startConnection(this)

        binding.rvSkuDetail.adapter = skuDetailAdapter

        binding.pbLoading.visibility = View.VISIBLE
        binding.rvSkuDetail.visibility = View.INVISIBLE

        binding.ivBack.setOnClickListener {
            onBackPressed()
        }
    }

    override fun onItemSkuDetailClick(skuDetail: SkuDetails) {
        val flowParams = BillingFlowParams.newBuilder()
            .setSkuDetails(skuDetail)
            .build()
        billingClient.launchBillingFlow(this, flowParams)
    }

    override fun onPurchasesUpdated(p0: BillingResult, p1: MutableList<Purchase>?) {
        if (p0.responseCode == BillingClient.BillingResponseCode.OK && p1 != null) {
            for (purchase in p1) {
                if (purchase.purchaseState == Purchase.PurchaseState.PURCHASED && !purchase.isAcknowledged) {
                    val acknowledgePurchaseParams = AcknowledgePurchaseParams.newBuilder()
                        .setPurchaseToken(purchase.purchaseToken).build()
                    billingClient.acknowledgePurchase(acknowledgePurchaseParams) { }
                    PremiumManager.getInstance()?.isPremium = true
                    Snackbar.make(binding.root, "Success", 700).setBackgroundTint(ContextCompat.getColor(this, R.color.green)).show()
                    return
                }
            }
        } else {
            Snackbar.make(binding.root, "Error", 700).setBackgroundTint(ContextCompat.getColor(this, R.color.red)).show()
        }
    }

    override fun onBillingServiceDisconnected() {
        binding.pbLoading.visibility = View.VISIBLE
        binding.rvSkuDetail.visibility = View.INVISIBLE
    }

    override fun onBillingSetupFinished(p0: BillingResult) {
        if (p0.responseCode == BillingClient.BillingResponseCode.OK) {
            val skuDetailsParams = SkuDetailsParams.newBuilder()
                .setSkusList(PremiumManager.billingIds)
                .setType(BillingClient.SkuType.SUBS)
                .build()
            billingClient.querySkuDetailsAsync(skuDetailsParams, this)
        } else {
            binding.pbLoading.visibility = View.VISIBLE
            binding.rvSkuDetail.visibility = View.INVISIBLE
        }
    }

    override fun onSkuDetailsResponse(p0: BillingResult, p1: MutableList<SkuDetails>?) {
        if (p0.responseCode == BillingClient.BillingResponseCode.OK && p1 != null) {
            runOnUiThread {
                skuDetailAdapter.skuDetails = p1
                binding.pbLoading.visibility = View.INVISIBLE
                binding.rvSkuDetail.visibility = View.VISIBLE
            }
        } else {
            runOnUiThread {
                binding.pbLoading.visibility = View.VISIBLE
                binding.rvSkuDetail.visibility = View.INVISIBLE
            }
        }
    }
}