package com.reactnativecall
import com.facebook.react.bridge.*
import com.vdotok.streaming.CallClient
import com.vdotok.streaming.interfaces.CallSDKListener
import java.util.*

class CallModule(reactContext: ReactApplicationContext) : ReactContextBaseJavaModule(reactContext){

    override fun getName(): String {
        return "Call"
    }
  var callClient: CallClient? = null

    // Example method
    // See https://reactnative.dev/docs/native-modules-android
    @ReactMethod
    fun multiply(a: Int, b: Int, promise: Promise) {

          promise.resolve(a * b)
        }



         @ReactMethod
            fun add(a: Int, b: Int, promise: Promise) {
                  promise.resolve(a + b)
           CallClient.getInstance(currentActivity!!)?.let {
             callClient = it
           }
           callClient?.connect("https://q-signalling.vdotok.dev:8443", "call")

           Timer().schedule(
             object : TimerTask() {
               override fun run() {
//                 val params = Arguments.createMap().apply {
//                   putString("eventProperty", callClient?.isConnected()?.toString())
//                 }
//                 sendEvent(reactContext!!, "SomeEventName", params)
//                 callClient?.register(
//                   authToken ="8368ee5510834865faf20e4d805cb5e5" ,
//                   refId = "c7aae7c0f2fcb45ffba00c7b9ce017d6", project_id = "115G1WZI",
//                   0
//                 )

//                    println(callClient?.isConnected())
//                    successCallback.invoke(callClient?.isConnected())
               }
             }, 5000
           )
                }


  @ReactMethod
  fun sub(a: Int, b: Int, promise: Promise) {
    promise.resolve(a - b)
  }
    }
