package com.example.studentportal

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import kotlinx.android.synthetic.main.activity_create_link.*

class CreateLink : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_link)
        initViews()
    }

    private fun initViews() {
      supportActionBar?.setDisplayHomeAsUpEnabled(true)
      supportActionBar?.title = "Create a Portal"
      btConfirm.setOnClickListener { onConfirmClick() }

    }

    private fun onConfirmClick() {
      // mis even level 1 checken

//      val profileActivityIntent = Intent(this, ProfileActivity::class.java)
//      profileActivityIntent.putExtra(ProfileActivity.PROFILE_EXTRA, profile)
//      startActivity(profileActivityIntent)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
      return when (item?.itemId) {
        android.R.id.home -> {
          finish()
          true
        }
        else -> return super.onOptionsItemSelected(item)
      }
    }

}
