package com.developer.pcsapi

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.developer.pcsapi.api.BaseRetrofit
import com.developer.pcsapi.response.admin.AdminResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class RegisterActivity : AppCompatActivity() {

    companion object{
        private  lateinit var context: Context
    }
    private val api by lazy { BaseRetrofit().endPoint }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        val btnSimpanAdmin = findViewById<Button>(R.id.btnSimpanAdmin)
        val txtNamaAdmin = findViewById<TextView>(R.id.txtNamaAdmin)
        val txtPasswordAdmin = findViewById<TextView>(R.id.txtPasswordAdmin)
        val txtEmailAdmin = findViewById<TextView>(R.id.txtEmailAdmin)

        btnSimpanAdmin.setOnClickListener {
//            Toast.makeText(this,"Simpan Admin", Toast.LENGTH_LONG).show()
            api.postAdmin(txtEmailAdmin.text.toString(), txtPasswordAdmin.text.toString(), txtNamaAdmin.text.toString()).enqueue(object : Callback<AdminResponse>{
                override fun onResponse(call: Call<AdminResponse>, response: Response<AdminResponse>) {
                    val moveIntent = Intent(this@RegisterActivity, LoginActivity::class.java)
                    startActivity(moveIntent)
                    finish()
                }

                override fun onFailure(call: Call<AdminResponse>, t: Throwable) {
                    Log.e("AdminError", t.toString())
                }

            })
        }
    }
}