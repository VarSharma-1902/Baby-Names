import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.scene.text.Text;

public class appGUI extends Application
{
    @Override
    public void start(Stage stage) throws Exception
    {
        //object of the BabyBirths class
        BabyBirths baby = new BabyBirths();
        
        stage.setTitle("Baby Names");
        stage.setWidth(500);
        stage.setHeight(500);
        
        //button to calculate the total births
        Button totalBirths = new Button("Total Births");
        totalBirths.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent e){
                //create a new stage to display total births
                Stage births = new Stage();
                births.setTitle("Total Births");
                baby.testTotalBirths();
                Text total = new Text("Total Births: " + baby.totalBirths);
                Text boys = new Text("Total Boys: " + baby.totalBoys);
                GridPane grid = new GridPane();
                grid.add(total,0,0);
                Scene newScene = new Scene(grid);
                births.setScene(newScene);        
                births.show();
            }
        });
        
        GridPane gridPane = new GridPane(); 
        gridPane.setHgap(50);
        gridPane.setVgap(50);
        gridPane.add(totalBirths, 0, 0);
        
        
        Scene scene = new Scene(gridPane);
        stage.setScene(scene);        
        stage.show();
    }
}
