package com.portfolio.creepur.viewmodels.listeners

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.view.MenuItem
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.portfolio.creepur.R
import com.portfolio.creepur.models.UserAccountSignedIn
import com.portfolio.creepur.views.BookMarks
import com.portfolio.creepur.views.HomePage
import com.portfolio.creepur.views.Account

class NavigationItemSelected(var context: Context, var account: UserAccountSignedIn?) : BottomNavigationView.OnNavigationItemSelectedListener {

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        val act: Activity = context as Activity
        when (item.itemId) {
            R.id.navAccount -> {
                if(act.localClassName != "views.Account") {
                    val intent = Intent(context, Account::class.java)
                    intent.putExtra("ACCOUNT", account)
                    context.startActivity(intent)
                    act.overridePendingTransition(R.anim.trans_in_left, R.anim.trans_out_right)
                } else {
                    return false
                }
            }
            R.id.navHomePage -> {
                if(act.localClassName != "views.HomePage") {
                    val intent = Intent(context, HomePage::class.java)
                    intent.putExtra("ACCOUNT", account)
                    context.startActivity(intent)
                    if (act.localClassName == "views.Account"){
                        act.overridePendingTransition(R.anim.trans_in_right, R.anim.trans_out_left)
                    } else if (act.localClassName == "views.BookMarks"){
                        act.overridePendingTransition(R.anim.trans_in_left, R.anim.trans_out_right)
                    }
                } else{
                    return false
                }
            }
            R.id.navBookmarks -> {
                if (act.localClassName != "views.BookMarks") {
                    val intent = Intent(context, BookMarks::class.java)
                    intent.putExtra("ACCOUNT", account)
                    context.startActivity(intent)
                    act.overridePendingTransition(R.anim.trans_in_right, R.anim.trans_out_left)
                } else {
                    return false
                }
            }
        }
        return true
    }
}