package com.sam.workmanagerdemo
import android.content.Context
import android.util.Log
import androidx.work.Worker
import androidx.work.WorkerParameters

private const val TAG = "BackgroundPhotoUpload"
class BackgroundPhotoUpload(appContext: Context, workerParams: WorkerParameters): Worker(appContext,workerParams) {
    override fun doWork(): Result {
        // upload photos to server here...
        println(" pretend uploading photos to google cloud platform...")
        Log.e(TAG,"uploading photos to google cloud platform...")
        return Result.success()
    }
}