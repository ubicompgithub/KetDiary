package ubicomp.ketdiary.main;

import ubicomp.ketdiary.system.check.DefaultCheck;
import ubicomp.ketdiary.system.uploader.DataUploader;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;

/**
 * Service for uploading data onto the server
 * 
 * @author Stanley Wang
 */
public class UploadService extends Service {

	/**
	 * Start the uploading service
	 * 
	 * @param context
	 *            Application context
	 */
	public static void startUploadService(Context context) {
		Intent intent = new Intent(context, UploadService.class);
		context.startService(intent);
	}

	@Override
	public IBinder onBind(Intent arg0) {
		return null;
	}

	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		super.onStartCommand(intent, flags, startId);

		if (DefaultCheck.check())
			return Service.START_REDELIVER_INTENT;

		DataUploader.upload();

		return Service.START_REDELIVER_INTENT;
	}

}
