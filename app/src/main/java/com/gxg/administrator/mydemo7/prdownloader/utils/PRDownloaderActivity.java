package com.gxg.administrator.mydemo7.prdownloader.utils;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.downloader.Error;
import com.downloader.OnCancelListener;
import com.downloader.OnDownloadListener;
import com.downloader.OnPauseListener;
import com.downloader.OnProgressListener;
import com.downloader.OnStartOrResumeListener;
import com.downloader.PRDownloader;
import com.downloader.Progress;
import com.downloader.Status;
import com.gxg.administrator.mydemo7.R;

public class PRDownloaderActivity extends AppCompatActivity {
    private static String dirPath;

    final String URL1 = "http://p.gdown.baidu.com/539c7b6ba9efbfce01e64f0cb8ce585c9792ae12d80fb2e24ddc2065ac0a19bd0a1576c52b2bbe9f9f67e05f63c2c790231f5424d39d1bb43c5e1d275bbbef843b653af0d0aa34215511b4a5920dedc168d582bc1c293890141cf0cf4368df6167beba9c15fa8edf7c358660554a16cb3af4c37c9315eb84b5f633edf07d7d4574a73430f01a69ea790ae4e531234b56c29d0e9c8af6bb334519867521ccc46c96137a661c428fb7";
    final String URL2 = "http://p.gdown.baidu.com/f50a55ae49eb4c8f4077c056b47c4df30301cb466db4da6df16cd6b58ddd43d1a183d22386b438897e93955e88dd2ece03b5aa9f484f11e16b8f0f0aa4f99c94d38d5e038ecd2cbf1b69c276ca687860e97ccbc688a06bb41bb1168d2ca0570b380e60474a3b56471e29158c963c94f22b858353fd6bc798989658d2a73a5cc39c511fa277f85fde955a12236d03d36e0ff052365efddf9f1c79b00254c9c3a72093102d7e6c0d3e4f788bc9d2c576c62d06d4358b985be79e2a3d088e213dab9c84a260891c9bb3cb81ffdbcc21612885a050ac9bd30d4d79b2eefd5a89941160619439816fb11b624931ef85d2afac6d68d7f62c06f530";
    final String URL3 = "http://p.gdown.baidu.com/7f7062b519b0a19954b4f412dcc71003ef215e9676a0f5518bb79edc116b26d5388a52afdafa9239dfcf3856ad1897453af0eedfd425d37387037c5b4daf1db8eef3ddbe71daa2b5edaa6936efeeb62975f95e28384fc78fba08c806504641b92979be932b8cbed4c6536984acc57b73202c2c3393a9ef067656d463a797d88f974ce3b9b107594ce46c2417f7e4e773d06d1431799b6586a08467f1f3f80dab0ea2e48a612cf9c2fde758aa1719511d70ae76fc9b2c5d0038dd9668212db8905dcfb9915677c11e0306f83b46c610e354b0a5dea362876d1538926fee90cd00bf099d32752651f177cb26759a917f872714fd0817bf4b9fdb52a2535c01ce05f906a9aca4d080e97dd90efdb476364f71f004a2868e15774b4d8324fe524ec679fd80b61e275beeb78212d19e19da3f";
    final String URL4 = "http://www.appsapk.com/downloading/latest/Emoji%20Flashlight%20-%20Brightest%20Flashlight%202018-2.0.1.apk";
    final String URL5 = "http://www.appsapk.com/downloading/latest/Screen%20Recorder-7.7.apk";
    final String URL6 = "http://www.appsapk.com/downloading/latest/Call%20Recorder%20-%20Automatic%20Call%20Recorder-1.6.0.apk";
    final String URL7 = "http://www.appsapk.com/downloading/latest/Sound%20Profile%20(+%20volume%20scheduler)-5.25.apk";
    final String URL8 = "http://www.appsapk.com/downloading/latest/Evernote%20-%20stay%20organized.-7.9.7.apk";
    final String URL9 = "http://www.appsapk.com/downloading/latest/UC-Browser.apk";
    final String URL10 = "http://www.appsapk.com/downloading/latest/Barcode%20Scanner-1.2.apk";
    final String URL11 = "http://songs.djmazadownload.com/music/Zip/Hasee%20Toh%20Phasee%20[2014-MP3-VBR]%20-%20[DJMaza.Life].zip";
    final String URL12 = "http://www2.sdfi.edu.cn/netclass/jiaoan/englit/download/Harry%20Potter%20and%20the%20Sorcerer's%20Stone.pdf";
    final String URL13 = "https://media.giphy.com/media/Bk0CW5frw4qfS/giphy.gif";
    final String URL14 = "http://techslides.com/demos/sample-videos/small.mp4";
    final String URL15 = "http://www.sample-videos.com/video/mp4/720/big_buck_bunny_720p_10mb.mp4";

    Button buttonOne, buttonTwo, buttonThree, buttonFour,
            buttonFive, buttonSix, buttonSeven, buttonEight,
            buttonNine, buttonTen, buttonEleven, buttonTwelve,
            buttonThirteen, buttonFourteen, buttonFifteen,
            buttonCancelOne, buttonCancelTwo, buttonCancelThree,
            buttonCancelFour, buttonCancelFive, buttonCancelSix,
            buttonCancelSeven, buttonCancelEight, buttonCancelNine,
            buttonCancelTen, buttonCancelEleven, buttonCancelTwelve,
            buttonCancelThirteen, buttonCancelFourteen, buttonCancelFifteen;

    TextView textViewProgressOne, textViewProgressTwo, textViewProgressThree,
            textViewProgressFour, textViewProgressFive, textViewProgressSix,
            textViewProgressSeven, textViewProgressEight, textViewProgressNine,
            textViewProgressTen, textViewProgressEleven, textViewProgressTwelve,
            textViewProgressThirteen, textViewProgressFourteen, textViewProgressFifteen;

    ProgressBar progressBarOne, progressBarTwo, progressBarThree,
            progressBarFour, progressBarFive, progressBarSix,
            progressBarSeven, progressBarEight, progressBarNine,
            progressBarTen, progressBarEleven, progressBarTwelve,
            progressBarThirteen, progressBarFourteen, progressBarFifteen;

    int downloadIdOne, downloadIdTwo, downloadIdThree, downloadIdFour,
            downloadIdFive, downloadIdSix, downloadIdSeven,
            downloadIdEight, downloadIdNine, downloadIdTen,
            downloadIdEleven, downloadIdTwelve, downloadIdThirteen,
            downloadIdFourteen, downloadIdFifteen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prdownloader);
        dirPath = Utils.getRootDirPath(getApplicationContext());

        init();

        onClickListenerOne();
        onClickListenerTwo();
        onClickListenerThree();
        onClickListenerFour();
        onClickListenerFive();
        onClickListenerSix();
        onClickListenerSeven();
        onClickListenerEight();
        onClickListenerNine();
        onClickListenerTen();
        onClickListenerEleven();
        onClickListenerTwelve();
        onClickListenerThirteen();
        onClickListenerFourteen();
        onClickListenerFifteen();
    }

    private void init() {
        buttonOne = (Button) findViewById(R.id.buttonOne);
        buttonTwo = (Button) findViewById(R.id.buttonTwo);
        buttonThree = (Button) findViewById(R.id.buttonThree);
        buttonFour = (Button) findViewById(R.id.buttonFour);
        buttonFive = (Button) findViewById(R.id.buttonFive);
        buttonSix = (Button) findViewById(R.id.buttonSix);
        buttonSeven = (Button) findViewById(R.id.buttonSeven);
        buttonEight = (Button) findViewById(R.id.buttonEight);
        buttonNine = (Button) findViewById(R.id.buttonNine);
        buttonTen =(Button)  findViewById(R.id.buttonTen);
        buttonEleven = (Button) findViewById(R.id.buttonEleven);
        buttonTwelve = (Button) findViewById(R.id.buttonTwelve);
        buttonThirteen = (Button) findViewById(R.id.buttonThirteen);
        buttonFourteen = (Button) findViewById(R.id.buttonFourteen);
        buttonFifteen = (Button) findViewById(R.id.buttonFifteen);

        buttonCancelOne = (Button) findViewById(R.id.buttonCancelOne);
        buttonCancelTwo = (Button) findViewById(R.id.buttonCancelTwo);
        buttonCancelThree = (Button) findViewById(R.id.buttonCancelThree);
        buttonCancelFour = (Button) findViewById(R.id.buttonCancelFour);
        buttonCancelFive =(Button)  findViewById(R.id.buttonCancelFive);
        buttonCancelSix =(Button)  findViewById(R.id.buttonCancelSix);
        buttonCancelSeven = (Button) findViewById(R.id.buttonCancelSeven);
        buttonCancelEight = (Button) findViewById(R.id.buttonCancelEight);
        buttonCancelNine =(Button)  findViewById(R.id.buttonCancelNine);
        buttonCancelTen =(Button)  findViewById(R.id.buttonCancelTen);
        buttonCancelEleven =(Button)  findViewById(R.id.buttonCancelEleven);
        buttonCancelTwelve =(Button)  findViewById(R.id.buttonCancelTwelve);
        buttonCancelThirteen = (Button) findViewById(R.id.buttonCancelThirteen);
        buttonCancelFourteen =(Button)  findViewById(R.id.buttonCancelFourteen);
        buttonCancelFifteen = (Button) findViewById(R.id.buttonCancelFifteen);

        textViewProgressOne = (TextView) findViewById(R.id.textViewProgressOne);
        textViewProgressTwo =(TextView)  findViewById(R.id.textViewProgressTwo);
        textViewProgressThree = (TextView) findViewById(R.id.textViewProgressThree);
        textViewProgressFour = (TextView) findViewById(R.id.textViewProgressFour);
        textViewProgressFive = (TextView) findViewById(R.id.textViewProgressFive);
        textViewProgressSix = (TextView) findViewById(R.id.textViewProgressSix);
        textViewProgressSeven =(TextView)  findViewById(R.id.textViewProgressSeven);
        textViewProgressEight =(TextView)  findViewById(R.id.textViewProgressEight);
        textViewProgressNine = (TextView) findViewById(R.id.textViewProgressNine);
        textViewProgressTen = (TextView) findViewById(R.id.textViewProgressTen);
        textViewProgressEleven =(TextView)  findViewById(R.id.textViewProgressEleven);
        textViewProgressTwelve = (TextView) findViewById(R.id.textViewProgressTwelve);
        textViewProgressThirteen =(TextView)  findViewById(R.id.textViewProgressThirteen);
        textViewProgressFourteen = (TextView) findViewById(R.id.textViewProgressFourteen);
        textViewProgressFifteen = (TextView) findViewById(R.id.textViewProgressFifteen);

        progressBarOne = (ProgressBar) findViewById(R.id.progressBarOne);
        progressBarTwo =(ProgressBar)  findViewById(R.id.progressBarTwo);
        progressBarThree =(ProgressBar)  findViewById(R.id.progressBarThree);
        progressBarFour =(ProgressBar)  findViewById(R.id.progressBarFour);
        progressBarFive = (ProgressBar) findViewById(R.id.progressBarFive);
        progressBarSix = (ProgressBar) findViewById(R.id.progressBarSix);
        progressBarSeven =(ProgressBar)  findViewById(R.id.progressBarSeven);
        progressBarEight =(ProgressBar)  findViewById(R.id.progressBarEight);
        progressBarNine = (ProgressBar) findViewById(R.id.progressBarNine);
        progressBarTen = (ProgressBar) findViewById(R.id.progressBarTen);
        progressBarEleven = (ProgressBar) findViewById(R.id.progressBarEleven);
        progressBarTwelve = (ProgressBar) findViewById(R.id.progressBarTwelve);
        progressBarThirteen =(ProgressBar)  findViewById(R.id.progressBarThirteen);
        progressBarFourteen = (ProgressBar) findViewById(R.id.progressBarFourteen);
        progressBarFifteen = (ProgressBar) findViewById(R.id.progressBarFifteen);
    }

    public void onClickListenerOne() {
        buttonOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (Status.RUNNING == PRDownloader.getStatus(downloadIdOne)) {
                    PRDownloader.pause(downloadIdOne);
                    return;
                }

                buttonOne.setEnabled(false);
                progressBarOne.setIndeterminate(true);
                progressBarOne.getIndeterminateDrawable().setColorFilter(
                        Color.BLUE, android.graphics.PorterDuff.Mode.SRC_IN);

                if (Status.PAUSED == PRDownloader.getStatus(downloadIdOne)) {
                    PRDownloader.resume(downloadIdOne);
                    return;
                }

                downloadIdOne = PRDownloader.download(URL1, dirPath, "facebook.apk")
                        .build()
                        .setOnStartOrResumeListener(new OnStartOrResumeListener() {
                            @Override
                            public void onStartOrResume() {
                                progressBarOne.setIndeterminate(false);
                                buttonOne.setEnabled(true);
                                buttonOne.setText(R.string.pause);
                                buttonCancelOne.setEnabled(true);
                            }
                        })
                        .setOnPauseListener(new OnPauseListener() {
                            @Override
                            public void onPause() {
                                buttonOne.setText(R.string.resume);
                            }
                        })
                        .setOnCancelListener(new OnCancelListener() {
                            @Override
                            public void onCancel() {
                                buttonOne.setText(R.string.start);
                                buttonCancelOne.setEnabled(false);
                                progressBarOne.setProgress(0);
                                textViewProgressOne.setText("");
                                downloadIdOne = 0;
                                progressBarOne.setIndeterminate(false);
                            }
                        })
                        .setOnProgressListener(new OnProgressListener() {
                            @Override
                            public void onProgress(Progress progress) {
                                long progressPercent = progress.currentBytes * 100 / progress.totalBytes;
                                progressBarOne.setProgress((int) progressPercent);
                                textViewProgressOne.setText(Utils.getProgressDisplayLine(progress.currentBytes, progress.totalBytes));
                                progressBarOne.setIndeterminate(false);
                            }
                        })
                        .start(new OnDownloadListener() {
                            @Override
                            public void onDownloadComplete() {
                                buttonOne.setEnabled(false);
                                buttonCancelOne.setEnabled(false);
                                buttonOne.setText(R.string.completed);
                            }

                            @Override
                            public void onError(Error error) {
                                buttonOne.setText(R.string.start);
                                Toast.makeText(getApplicationContext(), getString(R.string.some_error_occurred) + " " + "1", Toast.LENGTH_SHORT).show();
                                textViewProgressOne.setText("");
                                progressBarOne.setProgress(0);
                                downloadIdOne = 0;
                                buttonCancelOne.setEnabled(false);
                                progressBarOne.setIndeterminate(false);
                                buttonOne.setEnabled(true);
                            }
                        });
            }
        });

        buttonCancelOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PRDownloader.cancel(downloadIdOne);
            }
        });
    }

    public void onClickListenerTwo() {
        buttonTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Status.RUNNING == PRDownloader.getStatus(downloadIdTwo)) {
                    PRDownloader.pause(downloadIdTwo);
                    return;
                }

                buttonTwo.setEnabled(false);
                progressBarTwo.setIndeterminate(true);
                progressBarTwo.getIndeterminateDrawable().setColorFilter(
                        Color.BLUE, android.graphics.PorterDuff.Mode.SRC_IN);

                if (Status.PAUSED == PRDownloader.getStatus(downloadIdTwo)) {
                    PRDownloader.resume(downloadIdTwo);
                    return;
                }
                downloadIdTwo = PRDownloader.download(URL2, dirPath, "wechat.apk")
                        .build()
                        .setOnStartOrResumeListener(new OnStartOrResumeListener() {
                            @Override
                            public void onStartOrResume() {
                                progressBarTwo.setIndeterminate(false);
                                buttonTwo.setEnabled(true);
                                buttonTwo.setText(R.string.pause);
                                buttonCancelTwo.setEnabled(true);
                                buttonCancelTwo.setText(R.string.cancel);
                            }
                        })
                        .setOnPauseListener(new OnPauseListener() {
                            @Override
                            public void onPause() {
                                buttonTwo.setText(R.string.resume);
                            }
                        })
                        .setOnCancelListener(new OnCancelListener() {
                            @Override
                            public void onCancel() {
                                downloadIdTwo = 0;
                                buttonTwo.setText(R.string.start);
                                buttonCancelTwo.setEnabled(false);
                                progressBarTwo.setProgress(0);
                                textViewProgressTwo.setText("");
                                progressBarTwo.setIndeterminate(false);
                            }
                        })
                        .setOnProgressListener(new OnProgressListener() {
                            @Override
                            public void onProgress(Progress progress) {
                                long progressPercent = progress.currentBytes * 100 / progress.totalBytes;
                                progressBarTwo.setProgress((int) progressPercent);
                                textViewProgressTwo.setText(Utils.getProgressDisplayLine(progress.currentBytes, progress.totalBytes));
                            }
                        })
                        .start(new OnDownloadListener() {
                            @Override
                            public void onDownloadComplete() {
                                buttonTwo.setEnabled(false);
                                buttonCancelTwo.setEnabled(false);
                                buttonTwo.setText(R.string.completed);
                            }

                            @Override
                            public void onError(Error error) {
                                buttonTwo.setText(R.string.start);
                                Toast.makeText(getApplicationContext(), getString(R.string.some_error_occurred) + " " + "2", Toast.LENGTH_SHORT).show();
                                textViewProgressTwo.setText("");
                                progressBarTwo.setProgress(0);
                                downloadIdTwo = 0;
                                buttonCancelTwo.setEnabled(false);
                                progressBarTwo.setIndeterminate(false);
                                buttonTwo.setEnabled(true);
                            }

                        });
            }
        });

        buttonCancelTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PRDownloader.cancel(downloadIdTwo);
            }
        });
    }

    public void onClickListenerThree() {
        buttonThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Status.RUNNING == PRDownloader.getStatus(downloadIdThree)) {
                    PRDownloader.pause(downloadIdThree);
                    return;
                }

                buttonThree.setEnabled(false);
                progressBarThree.setIndeterminate(true);
                progressBarThree.getIndeterminateDrawable().setColorFilter(
                        Color.BLUE, android.graphics.PorterDuff.Mode.SRC_IN);

                if (Status.PAUSED == PRDownloader.getStatus(downloadIdThree)) {
                    PRDownloader.resume(downloadIdThree);
                    return;
                }
                downloadIdThree = PRDownloader.download(URL3, dirPath, "instagram.apk")
                        .build()
                        .setOnStartOrResumeListener(new OnStartOrResumeListener() {
                            @Override
                            public void onStartOrResume() {
                                progressBarThree.setIndeterminate(false);
                                buttonThree.setEnabled(true);
                                buttonThree.setText(R.string.pause);
                                buttonCancelThree.setEnabled(true);
                                buttonCancelThree.setText(R.string.cancel);
                            }
                        })
                        .setOnPauseListener(new OnPauseListener() {
                            @Override
                            public void onPause() {
                                buttonThree.setText(R.string.resume);
                            }
                        })
                        .setOnCancelListener(new OnCancelListener() {
                            @Override
                            public void onCancel() {
                                downloadIdThree = 0;
                                buttonThree.setText(R.string.start);
                                buttonCancelThree.setEnabled(false);
                                progressBarThree.setProgress(0);
                                textViewProgressThree.setText("");
                                progressBarThree.setIndeterminate(false);
                            }
                        })
                        .setOnProgressListener(new OnProgressListener() {
                            @Override
                            public void onProgress(Progress progress) {
                                long progressPercent = progress.currentBytes * 100 / progress.totalBytes;
                                progressBarThree.setProgress((int) progressPercent);
                                textViewProgressThree.setText(Utils.getProgressDisplayLine(progress.currentBytes, progress.totalBytes));
                            }
                        })
                        .start(new OnDownloadListener() {
                            @Override
                            public void onDownloadComplete() {
                                buttonThree.setEnabled(false);
                                buttonCancelThree.setEnabled(false);
                                buttonThree.setText(R.string.completed);
                            }

                            @Override
                            public void onError(Error error) {
                                buttonThree.setText(R.string.start);
                                Toast.makeText(getApplicationContext(), getString(R.string.some_error_occurred) + " " + "3", Toast.LENGTH_SHORT).show();
                                textViewProgressThree.setText("");
                                progressBarThree.setProgress(0);
                                downloadIdThree = 0;
                                buttonCancelThree.setEnabled(false);
                                progressBarThree.setIndeterminate(false);
                                buttonThree.setEnabled(true);
                            }
                        });
            }
        });

        buttonCancelThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PRDownloader.cancel(downloadIdThree);
            }
        });
    }

    public void onClickListenerFour() {
        buttonFour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Status.RUNNING == PRDownloader.getStatus(downloadIdFour)) {
                    PRDownloader.pause(downloadIdFour);
                    return;
                }

                buttonFour.setEnabled(false);
                progressBarFour.setIndeterminate(true);
                progressBarFour.getIndeterminateDrawable().setColorFilter(
                        Color.BLUE, android.graphics.PorterDuff.Mode.SRC_IN);

                if (Status.PAUSED == PRDownloader.getStatus(downloadIdFour)) {
                    PRDownloader.resume(downloadIdFour);
                    return;
                }
                downloadIdFour = PRDownloader.download(URL4, dirPath, "flashlight.apk")
                        .build()
                        .setOnStartOrResumeListener(new OnStartOrResumeListener() {
                            @Override
                            public void onStartOrResume() {
                                progressBarFour.setIndeterminate(false);
                                buttonFour.setEnabled(true);
                                buttonFour.setText(R.string.pause);
                                buttonCancelFour.setEnabled(true);
                                buttonCancelFour.setText(R.string.cancel);
                            }
                        })
                        .setOnPauseListener(new OnPauseListener() {
                            @Override
                            public void onPause() {
                                buttonFour.setText(R.string.resume);
                            }
                        })
                        .setOnCancelListener(new OnCancelListener() {
                            @Override
                            public void onCancel() {
                                downloadIdFour = 0;
                                buttonFour.setText(R.string.start);
                                buttonCancelFour.setEnabled(false);
                                progressBarFour.setProgress(0);
                                textViewProgressFour.setText("");
                                progressBarFour.setIndeterminate(false);
                            }
                        })
                        .setOnProgressListener(new OnProgressListener() {
                            @Override
                            public void onProgress(Progress progress) {
                                long progressPercent = progress.currentBytes * 100 / progress.totalBytes;
                                progressBarFour.setProgress((int) progressPercent);
                                textViewProgressFour.setText(Utils.getProgressDisplayLine(progress.currentBytes, progress.totalBytes));
                            }
                        })
                        .start(new OnDownloadListener() {
                            @Override
                            public void onDownloadComplete() {
                                buttonFour.setEnabled(false);
                                buttonCancelFour.setEnabled(false);
                                buttonFour.setText(R.string.completed);
                            }

                            @Override
                            public void onError(Error error) {
                                buttonFour.setText(R.string.start);
                                Toast.makeText(getApplicationContext(), getString(R.string.some_error_occurred) + " " + "4", Toast.LENGTH_SHORT).show();
                                textViewProgressFour.setText("");
                                progressBarFour.setProgress(0);
                                downloadIdFour = 0;
                                buttonCancelFour.setEnabled(false);
                                progressBarFour.setIndeterminate(false);
                                buttonFour.setEnabled(true);
                            }
                        });
            }
        });

        buttonCancelFour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PRDownloader.cancel(downloadIdFour);
            }
        });
    }

    public void onClickListenerFive() {
        buttonFive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Status.RUNNING == PRDownloader.getStatus(downloadIdFive)) {
                    PRDownloader.pause(downloadIdFive);
                    return;
                }

                buttonFive.setEnabled(false);
                progressBarFive.setIndeterminate(true);
                progressBarFive.getIndeterminateDrawable().setColorFilter(
                        Color.BLUE, android.graphics.PorterDuff.Mode.SRC_IN);

                if (Status.PAUSED == PRDownloader.getStatus(downloadIdFive)) {
                    PRDownloader.resume(downloadIdFive);
                    return;
                }
                downloadIdFive = PRDownloader.download(URL5, dirPath, "screenrecorder.apk")
                        .build()
                        .setOnStartOrResumeListener(new OnStartOrResumeListener() {
                            @Override
                            public void onStartOrResume() {
                                progressBarFive.setIndeterminate(false);
                                buttonFive.setEnabled(true);
                                buttonFive.setText(R.string.pause);
                                buttonCancelFive.setEnabled(true);
                                buttonCancelFive.setText(R.string.cancel);
                            }
                        })
                        .setOnPauseListener(new OnPauseListener() {
                            @Override
                            public void onPause() {
                                buttonFive.setText(R.string.resume);
                            }
                        })
                        .setOnCancelListener(new OnCancelListener() {
                            @Override
                            public void onCancel() {
                                downloadIdFive = 0;
                                buttonFive.setText(R.string.start);
                                buttonCancelFive.setEnabled(false);
                                progressBarFive.setProgress(0);
                                textViewProgressFive.setText("");
                                progressBarFive.setIndeterminate(false);
                            }
                        })
                        .setOnProgressListener(new OnProgressListener() {
                            @Override
                            public void onProgress(Progress progress) {
                                long progressPercent = progress.currentBytes * 100 / progress.totalBytes;
                                progressBarFive.setProgress((int) progressPercent);
                                textViewProgressFive.setText(Utils.getProgressDisplayLine(progress.currentBytes, progress.totalBytes));
                            }
                        })
                        .start(new OnDownloadListener() {
                            @Override
                            public void onDownloadComplete() {
                                buttonFive.setEnabled(false);
                                buttonCancelFive.setEnabled(false);
                                buttonFive.setText(R.string.completed);
                            }

                            @Override
                            public void onError(Error error) {
                                buttonFive.setText(R.string.start);
                                Toast.makeText(getApplicationContext(), getString(R.string.some_error_occurred) + " " + "5", Toast.LENGTH_SHORT).show();
                                textViewProgressFive.setText("");
                                progressBarFive.setProgress(0);
                                downloadIdFive = 0;
                                buttonCancelFive.setEnabled(false);
                                progressBarFive.setIndeterminate(false);
                                buttonFive.setEnabled(true);
                            }
                        });
            }
        });

        buttonCancelFive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PRDownloader.cancel(downloadIdFive);
            }
        });

    }

    public void onClickListenerSix() {
        buttonSix.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Status.RUNNING == PRDownloader.getStatus(downloadIdSix)) {
                    PRDownloader.pause(downloadIdSix);
                    return;
                }

                buttonSix.setEnabled(false);
                progressBarSix.setIndeterminate(true);
                progressBarSix.getIndeterminateDrawable().setColorFilter(
                        Color.BLUE, android.graphics.PorterDuff.Mode.SRC_IN);

                if (Status.PAUSED == PRDownloader.getStatus(downloadIdSix)) {
                    PRDownloader.resume(downloadIdSix);
                    return;
                }
                downloadIdSix = PRDownloader.download(URL6, dirPath, "callrecorder.apk")
                        .build()
                        .setOnStartOrResumeListener(new OnStartOrResumeListener() {
                            @Override
                            public void onStartOrResume() {
                                progressBarSix.setIndeterminate(false);
                                buttonSix.setEnabled(true);
                                buttonSix.setText(R.string.pause);
                                buttonCancelSix.setEnabled(true);
                                buttonCancelSix.setText(R.string.cancel);
                            }
                        })
                        .setOnPauseListener(new OnPauseListener() {
                            @Override
                            public void onPause() {
                                buttonSix.setText(R.string.resume);
                            }
                        })
                        .setOnCancelListener(new OnCancelListener() {
                            @Override
                            public void onCancel() {
                                downloadIdSix = 0;
                                buttonSix.setText(R.string.start);
                                buttonCancelSix.setEnabled(false);
                                progressBarSix.setProgress(0);
                                textViewProgressSix.setText("");
                                progressBarSix.setIndeterminate(false);
                            }
                        })
                        .setOnProgressListener(new OnProgressListener() {
                            @Override
                            public void onProgress(Progress progress) {
                                long progressPercent = progress.currentBytes * 100 / progress.totalBytes;
                                progressBarSix.setProgress((int) progressPercent);
                                textViewProgressSix.setText(Utils.getProgressDisplayLine(progress.currentBytes, progress.totalBytes));
                            }
                        })
                        .start(new OnDownloadListener() {
                            @Override
                            public void onDownloadComplete() {
                                buttonSix.setEnabled(false);
                                buttonCancelSix.setEnabled(false);
                                buttonSix.setText(R.string.completed);
                            }

                            @Override
                            public void onError(Error error) {
                                buttonSix.setText(R.string.start);
                                Toast.makeText(getApplicationContext(), getString(R.string.some_error_occurred) + " " + "6", Toast.LENGTH_SHORT).show();
                                textViewProgressSix.setText("");
                                progressBarSix.setProgress(0);
                                downloadIdSix = 0;
                                buttonCancelSix.setEnabled(false);
                                progressBarSix.setIndeterminate(false);
                                buttonSix.setEnabled(true);
                            }
                        });
            }
        });

        buttonCancelSix.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PRDownloader.cancel(downloadIdSix);
            }
        });

    }

    public void onClickListenerSeven() {
        buttonSeven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Status.RUNNING == PRDownloader.getStatus(downloadIdSeven)) {
                    PRDownloader.pause(downloadIdSeven);
                    return;
                }

                buttonSeven.setEnabled(false);
                progressBarSeven.setIndeterminate(true);
                progressBarSeven.getIndeterminateDrawable().setColorFilter(
                        Color.BLUE, android.graphics.PorterDuff.Mode.SRC_IN);

                if (Status.PAUSED == PRDownloader.getStatus(downloadIdSeven)) {
                    PRDownloader.resume(downloadIdSeven);
                    return;
                }
                downloadIdSeven = PRDownloader.download(URL7, dirPath, "soundprofile.apk")
                        .build()
                        .setOnStartOrResumeListener(new OnStartOrResumeListener() {
                            @Override
                            public void onStartOrResume() {
                                progressBarSeven.setIndeterminate(false);
                                buttonSeven.setEnabled(true);
                                buttonSeven.setText(R.string.pause);
                                buttonCancelSeven.setEnabled(true);
                                buttonCancelSeven.setText(R.string.cancel);
                            }
                        })
                        .setOnPauseListener(new OnPauseListener() {
                            @Override
                            public void onPause() {
                                buttonSeven.setText(R.string.resume);
                            }
                        })
                        .setOnCancelListener(new OnCancelListener() {
                            @Override
                            public void onCancel() {
                                downloadIdSeven = 0;
                                buttonSeven.setText(R.string.start);
                                buttonCancelSeven.setEnabled(false);
                                progressBarSeven.setProgress(0);
                                textViewProgressSeven.setText("");
                                progressBarSeven.setIndeterminate(false);
                            }
                        })
                        .setOnProgressListener(new OnProgressListener() {
                            @Override
                            public void onProgress(Progress progress) {
                                long progressPercent = progress.currentBytes * 100 / progress.totalBytes;
                                progressBarSeven.setProgress((int) progressPercent);
                                textViewProgressSeven.setText(Utils.getProgressDisplayLine(progress.currentBytes, progress.totalBytes));
                            }
                        })
                        .start(new OnDownloadListener() {
                            @Override
                            public void onDownloadComplete() {
                                buttonSeven.setEnabled(false);
                                buttonCancelSeven.setEnabled(false);
                                buttonSeven.setText(R.string.completed);
                            }

                            @Override
                            public void onError(Error error) {
                                buttonSeven.setText(R.string.start);
                                Toast.makeText(getApplicationContext(), getString(R.string.some_error_occurred) + " " + "7", Toast.LENGTH_SHORT).show();
                                textViewProgressSeven.setText("");
                                progressBarSeven.setProgress(0);
                                downloadIdSeven = 0;
                                buttonCancelSeven.setEnabled(false);
                                progressBarSeven.setIndeterminate(false);
                                buttonSeven.setEnabled(true);
                            }
                        });
            }
        });

        buttonCancelSeven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PRDownloader.cancel(downloadIdSeven);
            }
        });

    }

    public void onClickListenerEight() {
        buttonEight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Status.RUNNING == PRDownloader.getStatus(downloadIdEight)) {
                    PRDownloader.pause(downloadIdEight);
                    return;
                }

                buttonEight.setEnabled(false);
                progressBarEight.setIndeterminate(true);
                progressBarEight.getIndeterminateDrawable().setColorFilter(
                        Color.BLUE, android.graphics.PorterDuff.Mode.SRC_IN);

                if (Status.PAUSED == PRDownloader.getStatus(downloadIdEight)) {
                    PRDownloader.resume(downloadIdEight);
                    return;
                }
                downloadIdEight = PRDownloader.download(URL8, dirPath, "evernote.apk")
                        .build()
                        .setOnStartOrResumeListener(new OnStartOrResumeListener() {
                            @Override
                            public void onStartOrResume() {
                                progressBarEight.setIndeterminate(false);
                                buttonEight.setEnabled(true);
                                buttonEight.setText(R.string.pause);
                                buttonCancelEight.setEnabled(true);
                                buttonCancelEight.setText(R.string.cancel);
                            }
                        })
                        .setOnPauseListener(new OnPauseListener() {
                            @Override
                            public void onPause() {
                                buttonEight.setText(R.string.resume);
                            }
                        })
                        .setOnCancelListener(new OnCancelListener() {
                            @Override
                            public void onCancel() {
                                downloadIdEight = 0;
                                buttonEight.setText(R.string.start);
                                buttonCancelEight.setEnabled(false);
                                progressBarEight.setProgress(0);
                                textViewProgressEight.setText("");
                                progressBarEight.setIndeterminate(false);
                            }
                        })
                        .setOnProgressListener(new OnProgressListener() {
                            @Override
                            public void onProgress(Progress progress) {
                                long progressPercent = progress.currentBytes * 100 / progress.totalBytes;
                                progressBarEight.setProgress((int) progressPercent);
                                textViewProgressEight.setText(Utils.getProgressDisplayLine(progress.currentBytes, progress.totalBytes));
                            }
                        })
                        .start(new OnDownloadListener() {
                            @Override
                            public void onDownloadComplete() {
                                buttonEight.setEnabled(false);
                                buttonCancelEight.setEnabled(false);
                                buttonEight.setText(R.string.completed);
                            }

                            @Override
                            public void onError(Error error) {
                                buttonEight.setText(R.string.start);
                                Toast.makeText(getApplicationContext(), getString(R.string.some_error_occurred) + " " + "8", Toast.LENGTH_SHORT).show();
                                textViewProgressEight.setText("");
                                progressBarEight.setProgress(0);
                                downloadIdEight = 0;
                                buttonCancelEight.setEnabled(false);
                                progressBarEight.setIndeterminate(false);
                                buttonEight.setEnabled(true);
                            }
                        });
            }
        });

        buttonCancelEight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PRDownloader.cancel(downloadIdEight);
            }
        });
    }

    public void onClickListenerNine() {
        buttonNine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Status.RUNNING == PRDownloader.getStatus(downloadIdNine)) {
                    PRDownloader.pause(downloadIdNine);
                    return;
                }

                buttonNine.setEnabled(false);
                progressBarNine.setIndeterminate(true);
                progressBarNine.getIndeterminateDrawable().setColorFilter(
                        Color.BLUE, android.graphics.PorterDuff.Mode.SRC_IN);

                if (Status.PAUSED == PRDownloader.getStatus(downloadIdNine)) {
                    PRDownloader.resume(downloadIdNine);
                    return;
                }
                downloadIdNine = PRDownloader.download(URL9, dirPath, "ucbrowser.apk")
                        .build()
                        .setOnStartOrResumeListener(new OnStartOrResumeListener() {
                            @Override
                            public void onStartOrResume() {
                                progressBarNine.setIndeterminate(false);
                                buttonNine.setEnabled(true);
                                buttonNine.setText(R.string.pause);
                                buttonCancelNine.setEnabled(true);
                                buttonCancelNine.setText(R.string.cancel);
                            }
                        })
                        .setOnPauseListener(new OnPauseListener() {
                            @Override
                            public void onPause() {
                                buttonNine.setText(R.string.resume);
                            }
                        })
                        .setOnCancelListener(new OnCancelListener() {
                            @Override
                            public void onCancel() {
                                downloadIdNine = 0;
                                buttonNine.setText(R.string.start);
                                buttonCancelNine.setEnabled(false);
                                progressBarNine.setProgress(0);
                                textViewProgressNine.setText("");
                                progressBarNine.setIndeterminate(false);
                            }
                        })
                        .setOnProgressListener(new OnProgressListener() {
                            @Override
                            public void onProgress(Progress progress) {
                                long progressPercent = progress.currentBytes * 100 / progress.totalBytes;
                                progressBarNine.setProgress((int) progressPercent);
                                textViewProgressNine.setText(Utils.getProgressDisplayLine(progress.currentBytes, progress.totalBytes));
                            }
                        })
                        .start(new OnDownloadListener() {
                            @Override
                            public void onDownloadComplete() {
                                buttonNine.setEnabled(false);
                                buttonCancelNine.setEnabled(false);
                                buttonNine.setText(R.string.completed);
                            }

                            @Override
                            public void onError(Error error) {
                                buttonNine.setText(R.string.start);
                                Toast.makeText(getApplicationContext(), getString(R.string.some_error_occurred) + " " + "9", Toast.LENGTH_SHORT).show();
                                textViewProgressNine.setText("");
                                progressBarNine.setProgress(0);
                                downloadIdNine = 0;
                                buttonCancelNine.setEnabled(false);
                                progressBarNine.setIndeterminate(false);
                                buttonNine.setEnabled(true);
                            }
                        });
            }
        });

        buttonCancelNine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PRDownloader.cancel(downloadIdNine);
            }
        });
    }

    public void onClickListenerTen() {
        buttonTen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Status.RUNNING == PRDownloader.getStatus(downloadIdTen)) {
                    PRDownloader.pause(downloadIdTen);
                    return;
                }

                buttonTen.setEnabled(false);
                progressBarTen.setIndeterminate(true);
                progressBarTen.getIndeterminateDrawable().setColorFilter(
                        Color.BLUE, android.graphics.PorterDuff.Mode.SRC_IN);

                if (Status.PAUSED == PRDownloader.getStatus(downloadIdTen)) {
                    PRDownloader.resume(downloadIdTen);
                    return;
                }
                downloadIdTen = PRDownloader.download(URL10, dirPath, "barcodescanner.apk")
                        .build()
                        .setOnStartOrResumeListener(new OnStartOrResumeListener() {
                            @Override
                            public void onStartOrResume() {
                                progressBarTen.setIndeterminate(false);
                                buttonTen.setEnabled(true);
                                buttonTen.setText(R.string.pause);
                                buttonCancelTen.setEnabled(true);
                                buttonCancelTen.setText(R.string.cancel);
                            }
                        })
                        .setOnPauseListener(new OnPauseListener() {
                            @Override
                            public void onPause() {
                                buttonTen.setText(R.string.resume);
                            }
                        })
                        .setOnCancelListener(new OnCancelListener() {
                            @Override
                            public void onCancel() {
                                downloadIdTen = 0;
                                buttonTen.setText(R.string.start);
                                buttonCancelTen.setEnabled(false);
                                progressBarTen.setProgress(0);
                                textViewProgressTen.setText("");
                                progressBarTen.setIndeterminate(false);
                            }
                        })
                        .setOnProgressListener(new OnProgressListener() {
                            @Override
                            public void onProgress(Progress progress) {
                                long progressPercent = progress.currentBytes * 100 / progress.totalBytes;
                                progressBarTen.setProgress((int) progressPercent);
                                textViewProgressTen.setText(Utils.getProgressDisplayLine(progress.currentBytes, progress.totalBytes));
                            }
                        })
                        .start(new OnDownloadListener() {
                            @Override
                            public void onDownloadComplete() {
                                buttonTen.setEnabled(false);
                                buttonCancelTen.setEnabled(false);
                                buttonTen.setText(R.string.completed);
                            }

                            @Override
                            public void onError(Error error) {
                                buttonTen.setText(R.string.start);
                                Toast.makeText(getApplicationContext(), getString(R.string.some_error_occurred) + " " + "10", Toast.LENGTH_SHORT).show();
                                textViewProgressTen.setText("");
                                progressBarTen.setProgress(0);
                                downloadIdTen = 0;
                                buttonCancelTen.setEnabled(false);
                                progressBarTen.setIndeterminate(false);
                                buttonTen.setEnabled(true);
                            }
                        });
            }
        });

        buttonCancelTen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PRDownloader.cancel(downloadIdTen);
            }
        });
    }

    public void onClickListenerEleven() {
        buttonEleven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Status.RUNNING == PRDownloader.getStatus(downloadIdEleven)) {
                    PRDownloader.pause(downloadIdEleven);
                    return;
                }

                buttonEleven.setEnabled(false);
                progressBarEleven.setIndeterminate(true);
                progressBarEleven.getIndeterminateDrawable().setColorFilter(
                        Color.BLUE, android.graphics.PorterDuff.Mode.SRC_IN);

                if (Status.PAUSED == PRDownloader.getStatus(downloadIdEleven)) {
                    PRDownloader.resume(downloadIdEleven);
                    return;
                }
                downloadIdEleven = PRDownloader.download(URL11, dirPath, "htp.zip")
                        .build()
                        .setOnStartOrResumeListener(new OnStartOrResumeListener() {
                            @Override
                            public void onStartOrResume() {
                                progressBarEleven.setIndeterminate(false);
                                buttonEleven.setEnabled(true);
                                buttonEleven.setText(R.string.pause);
                                buttonCancelEleven.setEnabled(true);
                                buttonCancelEleven.setText(R.string.cancel);
                            }
                        })
                        .setOnPauseListener(new OnPauseListener() {
                            @Override
                            public void onPause() {
                                buttonEleven.setText(R.string.resume);
                            }
                        })
                        .setOnCancelListener(new OnCancelListener() {
                            @Override
                            public void onCancel() {
                                downloadIdEleven = 0;
                                buttonEleven.setText(R.string.start);
                                buttonCancelEleven.setEnabled(false);
                                progressBarEleven.setProgress(0);
                                textViewProgressEleven.setText("");
                                progressBarEleven.setIndeterminate(false);
                            }
                        })
                        .setOnProgressListener(new OnProgressListener() {
                            @Override
                            public void onProgress(Progress progress) {
                                long progressPercent = progress.currentBytes * 100 / progress.totalBytes;
                                progressBarEleven.setProgress((int) progressPercent);
                                textViewProgressEleven.setText(Utils.getProgressDisplayLine(progress.currentBytes, progress.totalBytes));
                            }
                        })
                        .start(new OnDownloadListener() {
                            @Override
                            public void onDownloadComplete() {
                                buttonEleven.setEnabled(false);
                                buttonCancelEleven.setEnabled(false);
                                buttonEleven.setText(R.string.completed);
                            }

                            @Override
                            public void onError(Error error) {
                                buttonEleven.setText(R.string.start);
                                Toast.makeText(getApplicationContext(), getString(R.string.some_error_occurred) + " " + "11", Toast.LENGTH_SHORT).show();
                                textViewProgressEleven.setText("");
                                progressBarEleven.setProgress(0);
                                downloadIdEleven = 0;
                                buttonCancelEleven.setEnabled(false);
                                progressBarEleven.setIndeterminate(false);
                                buttonEleven.setEnabled(true);
                            }
                        });
            }
        });

        buttonCancelEleven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PRDownloader.cancel(downloadIdEleven);
            }
        });
    }

    public void onClickListenerTwelve() {
        buttonTwelve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Status.RUNNING == PRDownloader.getStatus(downloadIdTwelve)) {
                    PRDownloader.pause(downloadIdTwelve);
                    return;
                }

                buttonTwelve.setEnabled(false);
                progressBarTwelve.setIndeterminate(true);
                progressBarTwelve.getIndeterminateDrawable().setColorFilter(
                        Color.BLUE, android.graphics.PorterDuff.Mode.SRC_IN);

                if (Status.PAUSED == PRDownloader.getStatus(downloadIdTwelve)) {
                    PRDownloader.resume(downloadIdTwelve);
                    return;
                }
                downloadIdTwelve = PRDownloader.download(URL12, dirPath, "harry-porter.pdf")
                        .build()
                        .setOnStartOrResumeListener(new OnStartOrResumeListener() {
                            @Override
                            public void onStartOrResume() {
                                progressBarTwelve.setIndeterminate(false);
                                buttonTwelve.setEnabled(true);
                                buttonTwelve.setText(R.string.pause);
                                buttonCancelTwelve.setEnabled(true);
                                buttonCancelTwelve.setText(R.string.cancel);
                            }
                        })
                        .setOnPauseListener(new OnPauseListener() {
                            @Override
                            public void onPause() {
                                buttonTwelve.setText(R.string.resume);
                            }
                        })
                        .setOnCancelListener(new OnCancelListener() {
                            @Override
                            public void onCancel() {
                                downloadIdTwelve = 0;
                                buttonTwelve.setText(R.string.start);
                                buttonCancelTwelve.setEnabled(false);
                                progressBarTwelve.setProgress(0);
                                textViewProgressTwelve.setText("");
                                progressBarTwelve.setIndeterminate(false);
                            }
                        })
                        .setOnProgressListener(new OnProgressListener() {
                            @Override
                            public void onProgress(Progress progress) {
                                long progressPercent = progress.currentBytes * 100 / progress.totalBytes;
                                progressBarTwelve.setProgress((int) progressPercent);
                                textViewProgressTwelve.setText(Utils.getProgressDisplayLine(progress.currentBytes, progress.totalBytes));
                            }
                        })
                        .start(new OnDownloadListener() {
                            @Override
                            public void onDownloadComplete() {
                                buttonTwelve.setEnabled(false);
                                buttonCancelTwelve.setEnabled(false);
                                buttonTwelve.setText(R.string.completed);
                            }

                            @Override
                            public void onError(Error error) {
                                buttonTwelve.setText(R.string.start);
                                Toast.makeText(getApplicationContext(), getString(R.string.some_error_occurred) + " " + "12", Toast.LENGTH_SHORT).show();
                                textViewProgressTwelve.setText("");
                                progressBarTwelve.setProgress(0);
                                downloadIdTwelve = 0;
                                buttonCancelTwelve.setEnabled(false);
                                progressBarTwelve.setIndeterminate(false);
                                buttonTwelve.setEnabled(true);
                            }
                        });
            }
        });

        buttonCancelTwelve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PRDownloader.cancel(downloadIdTwelve);
            }
        });
    }

    public void onClickListenerThirteen() {
        buttonThirteen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Status.RUNNING == PRDownloader.getStatus(downloadIdThirteen)) {
                    PRDownloader.pause(downloadIdThirteen);
                    return;
                }

                buttonThirteen.setEnabled(false);
                progressBarThirteen.setIndeterminate(true);
                progressBarThirteen.getIndeterminateDrawable().setColorFilter(
                        Color.BLUE, android.graphics.PorterDuff.Mode.SRC_IN);

                if (Status.PAUSED == PRDownloader.getStatus(downloadIdThirteen)) {
                    PRDownloader.resume(downloadIdThirteen);
                    return;
                }
                downloadIdThirteen = PRDownloader.download(URL13, dirPath, "giphy.gif")
                        .build()
                        .setOnStartOrResumeListener(new OnStartOrResumeListener() {
                            @Override
                            public void onStartOrResume() {
                                progressBarThirteen.setIndeterminate(false);
                                buttonThirteen.setEnabled(true);
                                buttonThirteen.setText(R.string.pause);
                                buttonCancelThirteen.setEnabled(true);
                                buttonCancelThirteen.setText(R.string.cancel);
                            }
                        })
                        .setOnPauseListener(new OnPauseListener() {
                            @Override
                            public void onPause() {
                                buttonThirteen.setText(R.string.resume);
                            }
                        })
                        .setOnCancelListener(new OnCancelListener() {
                            @Override
                            public void onCancel() {
                                downloadIdThirteen = 0;
                                buttonThirteen.setText(R.string.start);
                                buttonCancelThirteen.setEnabled(false);
                                progressBarThirteen.setProgress(0);
                                textViewProgressThirteen.setText("");
                                progressBarThirteen.setIndeterminate(false);
                            }
                        })
                        .setOnProgressListener(new OnProgressListener() {
                            @Override
                            public void onProgress(Progress progress) {
                                long progressPercent = progress.currentBytes * 100 / progress.totalBytes;
                                progressBarThirteen.setProgress((int) progressPercent);
                                textViewProgressThirteen.setText(Utils.getProgressDisplayLine(progress.currentBytes, progress.totalBytes));
                            }
                        })
                        .start(new OnDownloadListener() {
                            @Override
                            public void onDownloadComplete() {
                                buttonThirteen.setEnabled(false);
                                buttonCancelThirteen.setEnabled(false);
                                buttonThirteen.setText(R.string.completed);
                            }

                            @Override
                            public void onError(Error error) {
                                buttonThirteen.setText(R.string.start);
                                Toast.makeText(getApplicationContext(), getString(R.string.some_error_occurred) + " " + "13", Toast.LENGTH_SHORT).show();
                                textViewProgressThirteen.setText("");
                                progressBarThirteen.setProgress(0);
                                downloadIdThirteen = 0;
                                buttonCancelThirteen.setEnabled(false);
                                progressBarThirteen.setIndeterminate(false);
                                buttonThirteen.setEnabled(true);
                            }
                        });
            }
        });

        buttonCancelThirteen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PRDownloader.cancel(downloadIdThirteen);
            }
        });

    }

    public void onClickListenerFourteen() {
        buttonFourteen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Status.RUNNING == PRDownloader.getStatus(downloadIdFourteen)) {
                    PRDownloader.pause(downloadIdFourteen);
                    return;
                }

                buttonFourteen.setEnabled(false);
                progressBarFourteen.setIndeterminate(true);
                progressBarFourteen.getIndeterminateDrawable().setColorFilter(
                        Color.BLUE, android.graphics.PorterDuff.Mode.SRC_IN);

                if (Status.PAUSED == PRDownloader.getStatus(downloadIdFourteen)) {
                    PRDownloader.resume(downloadIdFourteen);
                    return;
                }
                downloadIdFourteen = PRDownloader.download(URL14, dirPath, "small.mp4")
                        .build()
                        .setOnStartOrResumeListener(new OnStartOrResumeListener() {
                            @Override
                            public void onStartOrResume() {
                                progressBarFourteen.setIndeterminate(false);
                                buttonFourteen.setEnabled(true);
                                buttonFourteen.setText(R.string.pause);
                                buttonCancelFourteen.setEnabled(true);
                                buttonCancelFourteen.setText(R.string.cancel);
                            }
                        })
                        .setOnPauseListener(new OnPauseListener() {
                            @Override
                            public void onPause() {
                                buttonFourteen.setText(R.string.resume);
                            }
                        })
                        .setOnCancelListener(new OnCancelListener() {
                            @Override
                            public void onCancel() {
                                downloadIdFourteen = 0;
                                buttonFourteen.setText(R.string.start);
                                buttonCancelFourteen.setEnabled(false);
                                progressBarFourteen.setProgress(0);
                                textViewProgressFourteen.setText("");
                                progressBarFourteen.setIndeterminate(false);
                            }
                        })
                        .setOnProgressListener(new OnProgressListener() {
                            @Override
                            public void onProgress(Progress progress) {
                                long progressPercent = progress.currentBytes * 100 / progress.totalBytes;
                                progressBarFourteen.setProgress((int) progressPercent);
                                textViewProgressFourteen.setText(Utils.getProgressDisplayLine(progress.currentBytes, progress.totalBytes));
                            }
                        })
                        .start(new OnDownloadListener() {
                            @Override
                            public void onDownloadComplete() {
                                buttonFourteen.setEnabled(false);
                                buttonCancelFourteen.setEnabled(false);
                                buttonFourteen.setText(R.string.completed);
                            }

                            @Override
                            public void onError(Error error) {
                                buttonFourteen.setText(R.string.start);
                                Toast.makeText(getApplicationContext(), getString(R.string.some_error_occurred) + " " + "14", Toast.LENGTH_SHORT).show();
                                textViewProgressFourteen.setText("");
                                progressBarFourteen.setProgress(0);
                                downloadIdFourteen = 0;
                                buttonCancelFourteen.setEnabled(false);
                                progressBarFourteen.setIndeterminate(false);
                                buttonFourteen.setEnabled(true);
                            }
                        });
            }
        });

        buttonCancelFourteen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PRDownloader.cancel(downloadIdFourteen);
            }
        });

    }

    public void onClickListenerFifteen() {
        buttonFifteen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Status.RUNNING == PRDownloader.getStatus(downloadIdFifteen)) {
                    PRDownloader.pause(downloadIdFifteen);
                    return;
                }

                buttonFifteen.setEnabled(false);
                progressBarFifteen.setIndeterminate(true);
                progressBarFifteen.getIndeterminateDrawable().setColorFilter(
                        Color.BLUE, android.graphics.PorterDuff.Mode.SRC_IN);

                if (Status.PAUSED == PRDownloader.getStatus(downloadIdFifteen)) {
                    PRDownloader.resume(downloadIdFifteen);
                    return;
                }
                downloadIdFifteen = PRDownloader.download(URL15, dirPath, "big_buck_bunny_720p_10mb.mp4")
                        .build()
                        .setOnStartOrResumeListener(new OnStartOrResumeListener() {
                            @Override
                            public void onStartOrResume() {
                                progressBarFifteen.setIndeterminate(false);
                                buttonFifteen.setEnabled(true);
                                buttonFifteen.setText(R.string.pause);
                                buttonCancelFifteen.setEnabled(true);
                                buttonCancelFifteen.setText(R.string.cancel);
                            }
                        })
                        .setOnPauseListener(new OnPauseListener() {
                            @Override
                            public void onPause() {
                                buttonFifteen.setText(R.string.resume);
                            }
                        })
                        .setOnCancelListener(new OnCancelListener() {
                            @Override
                            public void onCancel() {
                                downloadIdFifteen = 0;
                                buttonFifteen.setText(R.string.start);
                                buttonCancelFifteen.setEnabled(false);
                                progressBarFifteen.setProgress(0);
                                textViewProgressFifteen.setText("");
                                progressBarFifteen.setIndeterminate(false);
                            }
                        })
                        .setOnProgressListener(new OnProgressListener() {
                            @Override
                            public void onProgress(Progress progress) {
                                long progressPercent = progress.currentBytes * 100 / progress.totalBytes;
                                progressBarFifteen.setProgress((int) progressPercent);
                                textViewProgressFifteen.setText(Utils.getProgressDisplayLine(progress.currentBytes, progress.totalBytes));
                            }
                        })
                        .start(new OnDownloadListener() {
                            @Override
                            public void onDownloadComplete() {
                                buttonFifteen.setEnabled(false);
                                buttonCancelFifteen.setEnabled(false);
                                buttonFifteen.setText(R.string.completed);
                            }

                            @Override
                            public void onError(Error error) {
                                buttonFifteen.setText(R.string.start);
                                Toast.makeText(getApplicationContext(), getString(R.string.some_error_occurred) + " " + "15", Toast.LENGTH_SHORT).show();
                                textViewProgressFifteen.setText("");
                                progressBarFifteen.setProgress(0);
                                downloadIdFifteen = 0;
                                buttonCancelFifteen.setEnabled(false);
                                progressBarFifteen.setIndeterminate(false);
                                buttonFifteen.setEnabled(true);
                            }
                        });
            }
        });

        buttonCancelFifteen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PRDownloader.cancel(downloadIdFifteen);
            }
        });
    }

}

