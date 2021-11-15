package com.product.rikkei.ui.splash

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.android.billingclient.api.*
import com.product.rikkei.R
import com.product.rikkei.ui.main.MainActivity
import com.product.rikkei.utils.PremiumManager

class SplashActivity : AppCompatActivity(), PurchasesUpdatedListener, BillingClientStateListener, PurchasesResponseListener {

    private lateinit var billingClient: BillingClient
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        billingClient = BillingClient.newBuilder(this)
            .setListener(this)
            .enablePendingPurchases()
            .build()

        billingClient.startConnection(this)
    }

    override fun onPurchasesUpdated(p0: BillingResult, p1: MutableList<Purchase>?) {

    }

    override fun onBillingServiceDisconnected() {
        PremiumManager.getInstance()?.isPremium = false
        startActivity(Intent(this, MainActivity::class.java))
        finish()
    }

    override fun onBillingSetupFinished(p0: BillingResult) {
        if (p0.responseCode == BillingClient.BillingResponseCode.OK) {
            billingClient.queryPurchasesAsync(BillingClient.SkuType.SUBS, this)
        } else {
            PremiumManager.getInstance()?.isPremium = false
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }
    }

    override fun onQueryPurchasesResponse(p0: BillingResult, p1: MutableList<Purchase>) {
        PremiumManager.getInstance()?.isPremium = p1.isNotEmpty()
        startActivity(Intent(this, MainActivity::class.java))
        finish()
    }
}