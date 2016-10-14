package com.hardskygames.kinopoiskcity.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.hardskygames.kinopoiskcity.KinoApp;

import java.util.List;

import dagger.ObjectGraph;

/**
 * @author Nikolay Mihailov <hardsky@yandex.ru>  on 11.05.16.
 */
public abstract class BaseActivity extends AppCompatActivity {
    private ObjectGraph activityGraph;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Create the activity graph by .plus-ing our modules onto the application graph.
        KinoApp application = (KinoApp) getApplication();
        activityGraph = application.getApplicationGraph().plus(getModules().toArray());

        // Inject ourselves so subclasses will have dependencies fulfilled when this method returns.
        activityGraph.inject(this);
    }


    @Override
    protected void onDestroy() {
        // Eagerly clear the reference to the activity graph to allow it to be garbage collected as
        // soon as possible.
        activityGraph = null;
        super.onDestroy();
    }

    /**
     * A list of modules to use for the individual activity graph. Subclasses can override this
     * method to provide additional modules provided they call and include the modules returned by
     * calling {@code super.getModules()}.
     */
    protected abstract List<Object> getModules();

    /**
     * Inject the supplied {@code object} using the activity-specific graph.
     */
    public void inject(Object object) {
        activityGraph.inject(object);
    }
}
