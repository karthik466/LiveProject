package com.example.liveproject

import android.os.Bundle
import android.speech.tts.TextToSpeech
import android.speech.tts.UtteranceProgressListener
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.util.Locale


class TextToSpeechActivity : AppCompatActivity(),TextToSpeech.OnInitListener {

    lateinit var mInput : EditText
    lateinit var btnSummit : Button
    lateinit var mTextToSpeech: TextToSpeech
    var isSpeechEnabled = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_text_to_speech)
        mInput = findViewById(R.id.text)
        btnSummit =  findViewById<Button>(R.id.submit)
        initSpeechControl()
        btnSummit.setOnClickListener {
            convertTextToSpeech()
        }
    }

    private fun initSpeechControl() {
        mTextToSpeech = TextToSpeech(this,this)


    }

    private fun convertTextToSpeech() {
        val text = mInput.text.toString()

        if(text.isNotEmpty() && isSpeechEnabled){
            mTextToSpeech.speak(text, TextToSpeech.QUEUE_FLUSH, null,"DONE")
        }



    }

    override fun onInit(status: Int) {
        if (status == TextToSpeech.SUCCESS) {
            val result: Int = mTextToSpeech.setLanguage(Locale.US)
            if (result == TextToSpeech.LANG_MISSING_DATA
                || result == TextToSpeech.LANG_NOT_SUPPORTED
            ) {
                Log.e("TTS", "This Language is not supported")
                isSpeechEnabled = false
            } else {
                btnSummit.isEnabled = true
                isSpeechEnabled = true
                mTextToSpeech.setOnUtteranceProgressListener(object : UtteranceProgressListener(){
                    override fun onStart(p0: String?) {

                    }

                    override fun onDone(p0: String?) {
                        runOnUiThread {
                            Toast.makeText(this@TextToSpeechActivity, "Play completed $p0"
                                ,Toast.LENGTH_LONG).show()
                        }

                    }

                    override fun onError(p0: String?) {

                    }
                })
            }
        } else {
            Log.e("TTS", "Initilization Failed!")
            isSpeechEnabled = false
        }
    }




}