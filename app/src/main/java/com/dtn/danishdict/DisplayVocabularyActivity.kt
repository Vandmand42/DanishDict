package com.dtn.danishdict

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText

class DisplayVocabularyActivity : AppCompatActivity() {

    private lateinit var editDanishWordView: EditText
    private lateinit var editEnglishWordView: EditText

    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_word)
        editDanishWordView = findViewById(R.id.edit_danish)
        editEnglishWordView = findViewById(R.id.edit_english)

        val saveButton = findViewById<Button>(R.id.button_save)
        saveButton.setOnClickListener {
            val replyIntent = Intent()

            if (TextUtils.isEmpty(editDanishWordView.text) && TextUtils.isEmpty(editEnglishWordView.text)) {
                setResult(Activity.RESULT_CANCELED, replyIntent)
            } else {
                val danishWord = editDanishWordView.text.toString()
                val englishWord = editEnglishWordView.text.toString()

                replyIntent.putExtra(ENGLISH_REPLY, danishWord)
                replyIntent.putExtra(DANISH_REPLY, englishWord)
                setResult(Activity.RESULT_OK, replyIntent)
            }
            finish()
        }
    }

    companion object {
        const val ENGLISH_REPLY = "com.dtn.danishdict.ENGLISH"
        const val DANISH_REPLY = "com.dtn.danishdict.DANISH"
    }
}