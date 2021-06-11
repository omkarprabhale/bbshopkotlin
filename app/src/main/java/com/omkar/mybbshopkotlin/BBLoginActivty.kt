package com.omkar.mybbshopkotlin

import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.util.Patterns
import android.view.View

import androidx.appcompat.app.AlertDialog

import com.omkar.mybbshopkotlin.core.BBSuperActivity
import com.omkar.mybbshopkotlin.dataservices.BBRetrofitclient
import com.omkar.mybbshopkotlin.model.BBClientLogin
import com.omkar.mybbshopkotlin.model.BBLoginResp
import kotlinx.android.synthetic.main.activity_bblogin.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import kotlin.system.exitProcess
import kotlinx.android.synthetic.main.activity_main.*


class BBLoginActivty :BBSuperActivity(){


    override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_bblogin)
        noacctTv.setOnClickListener { openRegisteration() }
        loginTv.setOnClickListener { checkforLogin() }
        backTv.setOnClickListener { backToLogin() }
    }


    fun checkEmptyFields(): Boolean {
        return (usrusr?.text.toString().isNotEmpty() &&
            Patterns.EMAIL_ADDRESS.matcher(usrusr?.text.toString()).matches() &&
            pswrdd?.text.toString().isNotEmpty()&&
                    pswrdd.text.toString().length> 3)

    }

    fun openRegisteration() {
        llRegister!!.visibility = View.VISIBLE
        llLogin!!.visibility = View.GONE
        loginTv!!.visibility = View.GONE
        registerTv!!.visibility = View.VISIBLE
        noacctTv!!.visibility = View.GONE
        backTv!!.visibility = View.VISIBLE
    }


    fun backToLogin() {
        backTv!!.visibility = View.GONE
        noacctTv!!.visibility = View.VISIBLE
        llRegister!!.visibility = View.GONE
        llLogin!!.visibility = View.VISIBLE
        loginTv!!.visibility = View.VISIBLE
        registerTv!!.visibility = View.GONE
    }

    fun makeAllEmptyFields() {

        usrusr!!.setText("")
        pswrdd!!.setText("")

    }

    fun showErrorForEmpty() {
        val alertDialogBuilder = AlertDialog.Builder(this)
        alertDialogBuilder.setTitle("Invalid operation")
        alertDialogBuilder.setMessage("Please fill all fields and try again")
        alertDialogBuilder.setPositiveButton(
            "OK"
        ) { dialog, which -> dialog.cancel() }
        alertDialogBuilder.setCancelable(false)

        alertDialogBuilder.show()
    }

    fun checkforLogin() {
        try {

            if (checkEmptyFields()) {
                val resp = BBRetrofitclient.getInstance().myApi
                    .getLoginDetails(BBClientLogin(usrusr!!.text.toString(), pswrdd!!.text.toString()))
                resp.enqueue(object : Callback<BBLoginResp> {
                    override fun onResponse(call: Call<BBLoginResp>, response: Response<BBLoginResp>) {
                        if (response.isSuccessful && response.body() != null && response.body()!!.status == "success") {
                            makeAllEmptyFields()
                            startActivity(Intent(applicationContext, BBHomeActivity::class.java))

                        } else {
                            makeAllEmptyFields()
                            val alertDialogBuilder = AlertDialog.Builder(this@BBLoginActivty)
                            alertDialogBuilder.setTitle("Error")
                            alertDialogBuilder.setMessage("User not recognized")
                            alertDialogBuilder.setPositiveButton(
                                "Ok"
                            ) { dialog, which -> dialog.cancel() }
                            alertDialogBuilder.setCancelable(false)

                            alertDialogBuilder.show()

                        }
                    }

                    override fun onFailure(call: Call<BBLoginResp>, t: Throwable) {
                        makeAllEmptyFields()
                        val alertDialogBuilder = AlertDialog.Builder(this@BBLoginActivty)
                        alertDialogBuilder.setTitle("Network issue")
                        alertDialogBuilder.setMessage("some network issue try again")
                        alertDialogBuilder.setPositiveButton(
                            "Ok"
                        ) { dialog, which -> dialog.cancel() }
                        alertDialogBuilder.setCancelable(false)

                        alertDialogBuilder.show()
                    }
                })
            } else {
                showErrorForEmpty()

            }
        } catch (e: Exception) {
            Log.e(e.toString(), e.message)
        }

    }
    @Override
    override fun onBackPressed() {
                if (noacctTv?.visibility  == View.VISIBLE)
                {
                val alertDialogBuilder = AlertDialog.Builder(this)

                 // set the title of the Alert Dialog
                            alertDialogBuilder.setTitle("MyBBshop")

                 // set dialog message
                            alertDialogBuilder
                .setMessage("Are you sure to exit from application")
                .setCancelable(false)
                .setPositiveButton(("YES")
                ) { dialog, id ->
                    // what to do if YES is tapped
                    finishAffinity()
                    exitProcess(0)
                }.setNeutralButton(("CANCEL")
                                ) { dialog, id ->
                                    // code to do on CANCEL tapped
                                    dialog.cancel()
                                }

                                .setNegativeButton(("NO")
                                ) { dialog, id ->
                                    // code to do on NO tapped
                                    dialog.cancel()
                                }

                    val alertDialog = alertDialogBuilder.create()

                alertDialog.show()
                }
                else
                {
                    backTv!!.visibility = View.GONE
                    noacctTv!!.visibility = View.VISIBLE
                    llRegister!!.visibility = View.GONE
                    llLogin!!.visibility = View.VISIBLE
                    loginTv!!.text = getString(R.string.login)
                }
     }


}
