package gooner.worker

import android.content.Context
import android.util.Log
import androidx.concurrent.futures.CallbackToFutureAdapter
import androidx.work.ListenableWorker
import androidx.work.WorkerParameters
import com.google.common.util.concurrent.ListenableFuture

class RemindWorker(var appContext: Context, var workerParams: WorkerParameters) :
    ListenableWorker(appContext, workerParams) {

    override fun startWork(): ListenableFuture<Result> {
        val tag = inputData.getString("shiftId")

        Log.d(
            "Remind",
            "Success: " + inputData.getString("shiftId") + " " + workerParams.tags.first()
        )

        if (tag.equals("My-tag")) {
            Log.d("Remind", "OK")
        } else Log.d("Remind", "False")

        return CallbackToFutureAdapter.getFuture({
            it.set(Result.success())
        })
    }
}