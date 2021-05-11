package com.example.fcmexample

import android.annotation.SuppressLint
import android.content.ClipboardManager
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import com.example.fcmexample.databinding.ActivitySendBinding
import com.example.fcmsender.FCMSender
import com.example.fcmsender.MessageType
import com.google.android.material.snackbar.Snackbar
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class SendActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySendBinding
    private val clipboardManager by lazy { getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager }


    @SuppressLint("LogNotTimber")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_send)

        supportActionBar!!.setDisplayHomeAsUpEnabled(true)



        binding.apply {

            sendModel = SendMessageModel()

            setOnMessageTypeChanged { _, isChecked ->
                sendModel!!.sendAsNotificationMessage = isChecked
            }


            onSendClick = View.OnClickListener {
                if(clipboardManager.hasPrimaryClip()){
                    val token = clipboardManager.primaryClip!!.getItemAt(0)



                    CoroutineScope(Dispatchers.IO).launch {
                       val fcmResponse = FCMSender.FCMMessageBuilder().setTitle(sendModel?.title ?: "")
                            .setTopic(sendModel?.topic ?: "")
                            .setBody(sendModel?.message ?: "")
                            .setMessageType(if(sendModel!!.sendAsNotificationMessage) MessageType.NOTIFICATION else MessageType.DATA)
                            .build()
                            .sendTo(token.text.toString())

                    }

                } else {
                    Snackbar.make(binding.root, "Copy token from previous screen", Snackbar.LENGTH_SHORT).show()

                }

            }

        }
    }
}