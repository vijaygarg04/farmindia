package farmindia.bmpl.com.farmindia;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

//import com.google.android.gms.fitness.data.DataPoint;

public class GraphActivity extends AppCompatActivity {
    private int nNumLabels;
    GraphView graph;
    GraphView graph1;
    GraphView graph2;
    private int mNumLabels;

    public GraphActivity(int numLabels) {
        mNumLabels = numLabels;
    }

    public GraphActivity() {
        mNumLabels = 3;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_graph);
        graph = (GraphView) findViewById(R.id.grah);
        LineGraphSeries<DataPoint> series = new LineGraphSeries<>(new DataPoint[]{

                new DataPoint(0, 8),
                new DataPoint(3, 10),
                new DataPoint(6, 12),
                new DataPoint(9, 15),
                new DataPoint(12, 10)
        });
        graph.addSeries(series);
        graph.getGridLabelRenderer().setHorizontalAxisTitle("Months");
        graph.getGridLabelRenderer().setVerticalAxisTitle("Price");


        // set manual X bounds
        graph.getViewport().setYAxisBoundsManual(true);
        graph.getViewport().setMinY(0);
        graph.getViewport().setMaxY(20);

        graph.getViewport().setXAxisBoundsManual(true);
        graph.getViewport().setMinX(0);
        graph.getViewport().setMaxX(12);

        // enable scaling and scrolling
        graph.getViewport().setScalable(true);
        graph.getViewport().setScalableY(true);
/////////////////////////////////////////////////////////////////////////////////////////////
        graph1 = (GraphView) findViewById(R.id.grah1);
        LineGraphSeries<DataPoint> series1 = new LineGraphSeries<>(new DataPoint[]{

                new DataPoint(0, 10),
                new DataPoint(1, 11),
                new DataPoint(2, 12),
                new DataPoint(3, 9),
                new DataPoint(4, 14),
                new DataPoint(5, 15),
                new DataPoint(6, 16),
                new DataPoint(7, 12),
                new DataPoint(8, 10),
                new DataPoint(9, 9),
                new DataPoint(10, 8),
                new DataPoint(11, 6),
                new DataPoint(12, 5)
        });
        graph1.addSeries(series1);
        graph1.getGridLabelRenderer().setHorizontalAxisTitle("Weeks");
        graph1.getGridLabelRenderer().setVerticalAxisTitle("Price");

        // set manual X bounds
        graph1.getViewport().setYAxisBoundsManual(true);
        graph1.getViewport().setMinY(0);
        graph1.getViewport().setMaxY(20);

        graph1.getViewport().setXAxisBoundsManual(true);
        graph1.getViewport().setMinX(0);
        graph1.getViewport().setMaxX(4);

        // enable scaling and scrolling
        graph1.getViewport().setScalable(true);
        graph1.getViewport().setScalableY(true);


        /////////////////////////////////////////////////////////////////////////////////////

        graph2 = (GraphView) findViewById(R.id.grah2);
        LineGraphSeries<DataPoint> series2 = new LineGraphSeries<>(new DataPoint[]{

                new DataPoint(0, 10),
                new DataPoint(1, 11),
                new DataPoint(2, 12),
                new DataPoint(3, 9),
                new DataPoint(4, 14),
                new DataPoint(5, 15),
                new DataPoint(6, 16),
                new DataPoint(7, 12),
                new DataPoint(8, 10),
                new DataPoint(9, 9),
                new DataPoint(10, 8),
                new DataPoint(11, 6),
                new DataPoint(12, 5)
        });
        graph2.addSeries(series2);
        graph2.getGridLabelRenderer().setHorizontalAxisTitle("Days");
        graph2.getGridLabelRenderer().setVerticalAxisTitle("Price");

        // set manual X bounds
        graph2.getViewport().setYAxisBoundsManual(true);
        graph2.getViewport().setMinY(0);
        graph2.getViewport().setMaxY(20);

        graph2.getViewport().setXAxisBoundsManual(true);
        graph2.getViewport().setMinX(0);
        graph2.getViewport().setMaxX(7);

        // enable scaling and scrolling
        graph2.getViewport().setScalable(true);
        graph2.getViewport().setScalableY(true);



    }

}
