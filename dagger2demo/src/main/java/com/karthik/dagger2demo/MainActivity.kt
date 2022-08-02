package com.karthik.dagger2demo

import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.karthik.dagger2demo.di.ActivityComponent
import com.karthik.dagger2demo.di.DaggerActivityComponent
import com.karthik.dagger2demo.di.SharedPrefModule
import javax.inject.Inject


class MainActivity : AppCompatActivity(), View.OnClickListener {


    @Inject
    lateinit var sharedPreferences: SharedPreferences

    private lateinit var component: ActivityComponent

    private var usernameTxt: EditText? = null
    private var numberTxt: EditText? = null
    private var saveBtn: Button? = null
    private var getBtn: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_layout)
        initializeViews()
        initComponent()
    }

    private fun initComponent() {
        component = DaggerActivityComponent
            .builder()
            .sharedPrefModule(SharedPrefModule(this))
            .build()
        component.inject(this)

    }


    /**
     * Initialize Buttons and EditTexts
     */
    private fun initializeViews() {
        getBtn = findViewById(R.id.getBtn)
        saveBtn = findViewById(R.id.saveBtn)
        usernameTxt = findViewById(R.id.usernameTxt)
        numberTxt = findViewById(R.id.numberTxt)
        saveBtn?.setOnClickListener(this)
        getBtn?.setOnClickListener(this)
    }

    /**
     * Save to shared preference.
     * `SharedPreferences.Editor` is an interface used for modifying values in a
     * SharedPreferences object.
     * It's putString() will Set a String value in the preferences editor, to be
     * written back once commit() or apply() are called.
     */
    private fun saveToSharedPreference() {
        val editor: SharedPreferences.Editor = sharedPreferences.edit()
        editor.putString("username", usernameTxt!!.text.toString().trim { it <= ' ' })
        editor.putString("number", numberTxt!!.text.toString().trim { it <= ' ' })
        editor.apply()
    }

    /**
     * Retrieve From SharedPreferences and Bind to EditText
     */
    private fun retrieveFromSharedPreferences() {
        usernameTxt?.setText(sharedPreferences.getString("username", "Default"))
        numberTxt?.setText(sharedPreferences.getString("number", "12345"))
    }

    /**
     * When the buttons are clicked
     * @param view
     */
    override fun onClick(view: View) {
        when (view.getId()) {
            R.id.getBtn -> retrieveFromSharedPreferences()
            R.id.saveBtn -> saveToSharedPreference()
        }
    }

}