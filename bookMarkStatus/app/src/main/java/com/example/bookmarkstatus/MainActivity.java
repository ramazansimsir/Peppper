package com.example.bookmarkstatus;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;

import com.aldebaran.qi.sdk.QiContext;
import com.aldebaran.qi.sdk.QiSDK;
import com.aldebaran.qi.sdk.RobotLifecycleCallbacks;
import com.aldebaran.qi.sdk.builder.AnimateBuilder;
import com.aldebaran.qi.sdk.builder.AnimationBuilder;
import com.aldebaran.qi.sdk.builder.ChatBuilder;
import com.aldebaran.qi.sdk.builder.QiChatbotBuilder;
import com.aldebaran.qi.sdk.builder.TopicBuilder;
import com.aldebaran.qi.sdk.design.activity.RobotActivity;
import com.aldebaran.qi.sdk.object.actuation.Animate;
import com.aldebaran.qi.sdk.object.actuation.Animation;
import com.aldebaran.qi.sdk.object.conversation.AutonomousReactionImportance;
import com.aldebaran.qi.sdk.object.conversation.AutonomousReactionValidity;
import com.aldebaran.qi.sdk.object.conversation.BaseQiChatExecutor;
import com.aldebaran.qi.sdk.object.conversation.Bookmark;
import com.aldebaran.qi.sdk.object.conversation.BookmarkStatus;
import com.aldebaran.qi.sdk.object.conversation.Chat;
import com.aldebaran.qi.sdk.object.conversation.QiChatExecutor;
import com.aldebaran.qi.sdk.object.conversation.QiChatbot;
import com.aldebaran.qi.sdk.object.conversation.Topic;
import com.aldebaran.qi.sdk.object.locale.Language;
import com.aldebaran.qi.sdk.object.locale.Locale;
import com.aldebaran.qi.sdk.object.locale.Region;
import com.example.bookmarkstatus.databinding.ActivityMainBinding;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends RobotActivity implements RobotLifecycleCallbacks {


    ActivityMainBinding design;
    // Store the QiChatbot.
    private QiChatbot qiChatbot;
    // Store the Chat action.
    private Chat chat;
    // Store the proposal bookmark.

   private Bookmark bookmark;
    private BookmarkStatus firstStatus;
    private BookmarkStatus secondStatus;
    private BookmarkStatus thirdStatus;
    private BookmarkStatus fourthStatus;
    private BookmarkStatus fifthStatus;
    private BookmarkStatus sixthStatus;
    private BookmarkStatus seventhStatus;
    private BookmarkStatus eighthStatus;
    private BookmarkStatus ninethStatus;
    private BookmarkStatus tenthStatus;
    private BookmarkStatus eleventhStatus;
    private BookmarkStatus twelvethStatus;
    private BookmarkStatus thirteenthStatus;
    private BookmarkStatus fourteenStatus;

    Bookmark bookmark1;
    Bookmark bookmark2;


    MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        design=ActivityMainBinding.inflate(getLayoutInflater());

        setContentView(design.getRoot());
        // Register the RobotLifecycleCallbacks to this Activity.
        QiSDK.register(this, this);
        //mediaPlayer=MediaPlayer.create(MainActivity.this,R.raw.alicabbar);
    }

    @Override
    protected void onDestroy() {
        // Unregister the RobotLifecycleCallbacks for this Activity.
        QiSDK.unregister(this, this);
        super.onDestroy();
    }

    @Override
    public void onRobotFocusGained(QiContext qiContext) {
        // The robot focus is gained.
        // Get the bookmarks from the topic.
        Locale locale = new Locale(Language.TURKISH, Region.TURKEY);
        // Create a topic.
        Topic topic = TopicBuilder.with(qiContext)
                .withResource(R.raw.story)
                .build();

// Create a new QiChatbot.
        qiChatbot = QiChatbotBuilder.with(qiContext)
                .withTopic(topic)
                .withLocale(locale)
                .build();


        // Create the executor
        QiChatExecutor myExecutor = new MyQiChatExecutor(qiContext);

        // Set the executor to the qiChatbot
        Map<String, QiChatExecutor> executors = new HashMap<>();
        executors.put("myExecutor", myExecutor);
        qiChatbot.setExecutors(executors);

// Create a new Chat action.
        chat = ChatBuilder.with(qiContext)
                .withChatbot(qiChatbot)
                .withLocale(locale)
                .build();

        Map<String, Bookmark> bookmarks = topic.getBookmarks();
        bookmark=bookmarks.get("first");
        bookmark1=bookmarks.get("second");
        bookmark2=bookmarks.get("third");
        Bookmark bookmark3=bookmarks.get("fourth");
        Bookmark bookmark4=bookmarks.get("fifth");
        Bookmark bookmark5=bookmarks.get("sixth");
        Bookmark bookmark6=bookmarks.get("seventh");
        Bookmark bookmark7=bookmarks.get("eighth");
        Bookmark bookmark8=bookmarks.get("nineth");
        Bookmark bookmark9=bookmarks.get("tenth");
        Bookmark bookmark10=bookmarks.get("eleventh");
        Bookmark bookmark11=bookmarks.get("twelveth");
        Bookmark bookmark12=bookmarks.get("thirteenth");
        Bookmark bookmark13=bookmarks.get("fourteen");



        firstStatus=qiChatbot.bookmarkStatus(bookmark);
        secondStatus=qiChatbot.bookmarkStatus(bookmark1);
        thirdStatus=qiChatbot.bookmarkStatus(bookmark2);
        fourthStatus=qiChatbot.bookmarkStatus(bookmark3);
        fifthStatus=qiChatbot.bookmarkStatus(bookmark4);
        sixthStatus=qiChatbot.bookmarkStatus(bookmark5);
        seventhStatus=qiChatbot.bookmarkStatus(bookmark6);
        eighthStatus=qiChatbot.bookmarkStatus(bookmark7);
        ninethStatus=qiChatbot.bookmarkStatus(bookmark8);
        tenthStatus=qiChatbot.bookmarkStatus(bookmark9);
        eleventhStatus=qiChatbot.bookmarkStatus(bookmark10);
        twelvethStatus=qiChatbot.bookmarkStatus(bookmark11);
        thirteenthStatus=qiChatbot.bookmarkStatus(bookmark12);
        fourteenStatus=qiChatbot.bookmarkStatus(bookmark13);


        firstStatus.addOnReachedListener(()->{

            runOnUiThread(()->{
                design.imageView.setImageResource(R.drawable.resimiki);
            });
            // Animation containing labels.

        });
        secondStatus.addOnReachedListener(()->{
           runOnUiThread(()->{
               design.imageView.setImageResource(R.drawable.resimuc);
           });
        });
        thirdStatus.addOnReachedListener(()->{
            runOnUiThread(()->{
                design.imageView.setImageResource(R.drawable.resimdort);
            });
        });
        fourthStatus.addOnReachedListener(()->{
            runOnUiThread(()->{
                design.imageView.setImageResource(R.drawable.resimbes);
            });
        });
        fifthStatus.addOnReachedListener(()->{
            runOnUiThread(()->{
                design.imageView.setImageResource(R.drawable.resimalti);
            });
        });
        sixthStatus.addOnReachedListener(()->{
            runOnUiThread(()->{
                design.imageView.setImageResource(R.drawable.resimyedi);
            });
        });
        seventhStatus.addOnReachedListener(()->{
            runOnUiThread(()->{
                design.imageView.setImageResource(R.drawable.resimsekiz);
            });
        });
        eighthStatus.addOnReachedListener(()->{
            runOnUiThread(()->{
                design.imageView.setImageResource(R.drawable.resimdokuz);
            });
        });
        ninethStatus.addOnReachedListener(()->{
            runOnUiThread(()->{
                design.imageView.setImageResource(R.drawable.resimon);
            });
        });
        tenthStatus.addOnReachedListener(()->{
            runOnUiThread(()->{
                design.imageView.setImageResource(R.drawable.resimonbir);
            });
        });
        eleventhStatus.addOnReachedListener(()->{
            runOnUiThread(()->{
                design.imageView.setImageResource(R.drawable.resimoniki);
            });
        });
        twelvethStatus.addOnReachedListener(()->{
            runOnUiThread(()->{
                design.imageView.setImageResource(R.drawable.resimonuc);
            });
        });
        thirteenthStatus.addOnReachedListener(()->{
            runOnUiThread(()->{
                design.imageView.setImageResource(R.drawable.resimondort);
            });
        });
        fourteenStatus.addOnReachedListener(()->{
            runOnUiThread(()->{
                design.imageView.setImageResource(R.drawable.resimonbes);
            });
        });



        chat.async().run();

    }

    @Override
    public void onRobotFocusLost() {
        // The robot focus is lost.
        // Remove the listeners on each BookmarkStatus.
        if (firstStatus != null) {
            firstStatus.removeAllOnReachedListeners();
        }
        if (secondStatus != null) {
            secondStatus.removeAllOnReachedListeners();
        }
        if (thirdStatus != null) {
            thirdStatus.removeAllOnReachedListeners();
        }


    }

    @Override
    public void onRobotFocusRefused(String reason) {
        // The robot focus is refused.

    }

    private class MyQiChatExecutor extends BaseQiChatExecutor {
        private final QiContext qiContext;

        MyQiChatExecutor(QiContext context) {
            super(context);
            this.qiContext = context;
        }

        @Override
        public void runWith(List<String> params) {
            // Execute the command and wait for 2 seconds before the next execution.
            new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Do nothing, just wait for 2 seconds.
                }
            }, 2000);
        }

        @Override
        public void stop() {
            // This is called when chat is canceled or stopped.
            Log.i("MyQiChatExecutor", "QiChatExecutor stopped");
        }
    }

}
