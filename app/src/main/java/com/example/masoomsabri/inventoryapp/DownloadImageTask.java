package com.example.masoomsabri.inventoryapp;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.UnknownHostException;

/**
 * Created by masoomsabri on 7/4/16.
 */
public class DownloadImageTask extends AsyncTask<String, Void, Bitmap> {
    private final static String TAG = DownloadImageTask.class.getSimpleName();

    ImageView thumbnail;

    public DownloadImageTask(ImageView imageView) {
        thumbnail = imageView;
    }

    @Override protected Bitmap doInBackground(String... params) {
        if (params == null) return null;
        Bitmap imageBitmap = downloadImageBitmap(params[0]);
        return imageBitmap;
    }

    @Override protected void onPostExecute(Bitmap bmp) {
        if (thumbnail != null) {
            if (bmp != null) {
                thumbnail.setImageBitmap(bmp);
            } else {
                thumbnail.setVisibility(View.GONE);
            }
        }
    }

    public Bitmap downloadImageBitmap(String imageUrl) {
        if (imageUrl == null || imageUrl.length() == 0) {
            Log.i(TAG,
                    "Null or empty Url string passed to image bitmap download. Not attempting download.");
            return null;
        }
        Bitmap bitmap = null;
        try {
            InputStream inputStream = new java.net.URL(imageUrl).openStream();
            bitmap = BitmapFactory.decodeStream(inputStream);
            if (inputStream != null) {
                inputStream.close();
            }
        } catch (OutOfMemoryError e) {
            Log.e(TAG,
                    String.format("Out of Memory Error in image bitmap download for Url: %s.", imageUrl), e);
        } catch (UnknownHostException e) {
            Log.e(TAG, String.format(
                    "Unknown Host Exception in image bitmap download for Url: %s. Device may be offline.",
                    imageUrl), e);
        } catch (MalformedURLException e) {
            Log.e(TAG, String.format(
                    "Malformed URL Exception in image bitmap download for Url: %s. Image Url may be corrupted.",
                    imageUrl), e);
        } catch (Exception e) {
            Log.e(TAG, String.format("Exception in image bitmap download for Url: %s", imageUrl), e);
        }
        return bitmap;
    }
}
