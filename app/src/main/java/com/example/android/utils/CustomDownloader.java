
package com.example.android.utils;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.util.Log;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.concurrent.ExecutionException;

/**
 * Class used to download files
 */
public class CustomDownloader {

    Activity activity;
    String title = "Downloading file..";
    File destination;
    final int buffer_size = 4096 * 2;
    final String tag = "Downloader";
    private ProgressDialog progressDialog;

    public CustomDownloader(Activity activity, File destination) {
        this.activity = activity;
        this.destination = destination;
        progressDialog = new ProgressDialog(activity);
        progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        progressDialog.setCancelable(false);
        progressDialog.setTitle(title);
    }

    public CustomDownloader(File destination) {
        this.destination = destination;
    }


    public File start(String url) {
        try {
            return new DetectTask().execute(url).get();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * AsyncTask
     */
    @SuppressLint("StaticFieldLeak")
    public class DetectTask extends AsyncTask<String, Integer, File> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            if (progressDialog != null)
                progressDialog.show();
        }

        @Override
        protected File doInBackground(String... urls) {

            try {
                URL url = new URL(urls[0]);
                URLConnection connection = url.openConnection();
                int fileLength = connection.getContentLength();
                BufferedInputStream reader = new BufferedInputStream(url.openStream(), buffer_size);
                FileOutputStream writer = new FileOutputStream(destination);

                byte data[] = new byte[buffer_size];
                int count = reader.read(data);
                int total = count;

                Log.d(tag, "download started for: " + url.getPath());

                while (count != -1) {
                    total += count;
                    publishProgress(total * 100 / fileLength);
                    writer.write(data, 0, count);
                    count = reader.read(data);
                }

                writer.flush();
                writer.close();
                reader.close();

                Log.d(tag, "File downloaded at " + destination.getAbsolutePath());

                //             Looper.prepare();
                System.out.println("File Download Complete");

            } catch (Exception e) {
                Log.w(tag, "Error occurred! --> $e");
                e.printStackTrace();

                //            Looper.prepare();
                System.out.println("Error");
            }

            return destination;
        }

        protected void onProgressUpdate(int[] values) {
            //  super.onProgressUpdate(Arrays.tovalues);
            if (progressDialog != null)
                progressDialog.setProgress(values[0]);
        }

        @Override
        protected void onPostExecute(File result) {
            if (progressDialog != null)
                progressDialog.dismiss();
        }


    }

}