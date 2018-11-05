package com.example.vicky.androidui

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*


var jsonResult = ""
var postResult = ""

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        login.setOnClickListener {
            if (username.text.toString().isNotEmpty() && password.text.toString().isNotEmpty())
                funcion(this@MainActivity, username.text.toString(), password.text.toString())
            else Toast.makeText(this@MainActivity, "Llene todos los campos", Toast.LENGTH_SHORT).show()

        }
    }


    fun funcion(activity: MainActivity, username: String, password: String){

//        val connection = URL("http://localhost/ApiApp/login/"+username+"/"+password).openConnection() as HttpURLConnection
//        val data = connection.inputStream.buffenetworkingReader().readText()
//        val result = URL("http://localhost/ApiApp/login/"+username+"/"+password).readText()

//        Toast.makeText(activity, 'data', Toast.LENGTH_SHORT).show();
    }



//    class makePostRequst(var activity: MainActivity, var username: String, var password: String) : AsyncTask<Void, Void, String>() {
//
//        override fun doInBackground(vararg params: Void?): String {
//            val client = OkHttpClient()
////            val requestBody = MultipartBody.Builder()
////                    .setType(MultipartBody.FORM)
////                    .addFormDataPart("username", username)
////                    .addFormDataPart("password", password)
////                    .build()
//            val request = Request.Builder()
//                    .url("http://localhost/ApiApp/login/"+username+"/"+password)
////                    .post(requestBody)
//                    .build()
//            val response = client.newCall(request).execute()
//            return response.body()!!.string()
//        }
//
//        override fun onPostExecute(result: String?) {
//            if (result != null) {
//                val obj = JSONObject(result)
//                postResult = obj.getString("message")
//                makeJSONRequst(activity, username, password).execute()
//            }
//            super.onPostExecute(result)
//        }
//
//    }
//
//    class makeJSONRequst(var activity: MainActivity, var username: String, var password: String) : AsyncTask<Void, Void, String>() {
//
//        override fun doInBackground(vararg params: Void?): String {
//            val JSON = MediaType.parse("application/json; charset=utf-8")
//            val client = OkHttpClient()
//            val requestObject = com.example.vicky.androidui.Model.Request()
//            requestObject.username = username
//            requestObject.password = password
//            val body = RequestBody.create(JSON, Gson().toJson(requestObject))
//            val request = Request.Builder()
//                    .url("http://192.168.43.212/login.php")
//                    .post(body)
//                    .build()
//            val response = client.newCall(request).execute()
//            return response.body()!!.string()
//        }
//
//        override fun onPostExecute(result: String?) {
//            if (result != null) {
//                val obj = JSONObject(result)
//                jsonResult = obj.getString("message")
//            }
//            val dialog = AlertDialog.Builder(activity)
//            val view = activity.layoutInflater.inflate(R.layout.dialog_result, null)
//            dialog.setView(view)
//            view.findViewById<TextView>(R.id.json_result).text = jsonResult
//            view.findViewById<TextView>(R.id.post_result).text = postResult
//            dialog.show()
//            super.onPostExecute(result)
//        }
//    }

}
