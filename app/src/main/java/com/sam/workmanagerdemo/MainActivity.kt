package com.sam.workmanagerdemo

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.work.Constraints
import androidx.work.OneTimeWorkRequest
import androidx.work.WorkManager
private const val TAG = "MainActivity"
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(findViewById(R.id.toolbar))
      //  val constraints = Constraints.Builder().setRequiresCharging(true).build()
        val task = OneTimeWorkRequest.Builder(BackgroundPhotoUpload::class.java).build()
        val workManager = WorkManager.getInstance(applicationContext)
        workManager.enqueue(task)
        workManager.getWorkInfoByIdLiveData(task.id).observe(this, Observer {
            if (it!=null){
                println("Status Changed To: ${it.state.isFinished}")
                Log.e(TAG,"Status Changed To: ${it.state.isFinished}")
            }
        })
    }
}