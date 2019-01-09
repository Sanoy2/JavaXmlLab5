import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

public class Main extends Application
{
    @Override public void start(Stage stage) throws Exception {



        Tester tester = new Tester();
        Results results = tester.RunTestes();

        stage.setTitle("Laboratory 5 - JAXP");
        //defining the axes
        final NumberAxis xAxis = new NumberAxis();
        final NumberAxis yAxis = new NumberAxis();
        xAxis.setLabel("Number of elements");
        yAxis.setLabel("Time in miliseconds");
        //creating the chart
        final LineChart<Number,Number> lineChart =
                new LineChart<Number,Number>(xAxis,yAxis);

        lineChart.setTitle("Task 4 results");
        //defining a series
        XYChart.Series DOM = new XYChart.Series();
        XYChart.Series SAX = new XYChart.Series();
        XYChart.Series STAX = new XYChart.Series();

        DOM.setName("DOM");
        SAX.setName("SAX");
        STAX.setName("StAX");

        for (int i = 0; i < results.getNumberOfElements().length; i++)
        {
            DOM.getData().add(new XYChart.Data(results.getNumberOfElements()[i], results.getTimeOfDOM()[i]));
            SAX.getData().add(new XYChart.Data(results.getNumberOfElements()[i], results.getTimeOfSAX()[i]));
            STAX.getData().add(new XYChart.Data(results.getNumberOfElements()[i], results.getTimeOfSTAX()[i]));
        }

        Scene scene  = new Scene(lineChart,800,600);
        lineChart.getData().add(DOM);
        lineChart.getData().add(SAX);
        lineChart.getData().add(STAX);

        stage.setScene(scene);
        stage.show();
    }


    public static void main(String[] args) throws Exception
    {
        System.out.println("Program started");
        launch();
        System.out.println("Program finished");
    }


}
