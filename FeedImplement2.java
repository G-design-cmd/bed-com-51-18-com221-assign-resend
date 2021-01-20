import javafx.application.Application;
import javafx.beans.binding.Bindings;
import java.lang.Number;
import javafx.beans.property.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
 import javafx.geometry.HPos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.shape.Line;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.geometry.Insets;
import javafx.stage.StageStyle;
import javafx.scene.paint.Color;
import java.util.HashMap;
import java.util.Map;
import javafx.scene.text.Text;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;

 public class FeedImplement2 extends Application {
    public static void main(String [] args){
        launch();
    }
   protected Text text = new Text(15, 15, "Enter ingredients amount in Kilograms(kg)");
   private TextField tfMaize = new TextField();
 private TextField tfSoya = new TextField();
 private TextField tfGnuts = new TextField();
 private TextField tfSalt = new TextField();
 private Button btCalculate = new Button("Calculate");
 
Text tc = new Text();
private DoubleProperty value = new SimpleDoubleProperty();
private DoubleProperty stackValue = new SimpleDoubleProperty();
double SoyaInput,MaizeInput,SaltInput,GnutInput;
private final Map<String, Button> accelerators = new HashMap<>();

 @Override // Override the start method in the Application class
 public void start(Stage primaryStage) throws Exception{
 // Create UI

 GridPane gridPane = new GridPane();
 LinePane lpane=new LinePane();//add line
gridPane.setHgap(5.5);
gridPane.setVgap(5.5);
 gridPane.add(text, 0, 0);
 gridPane.add(new Label("Enter value of maize "), 0, 1);
 gridPane.add(tfMaize, 1, 1);
gridPane.add(new Label("Enter value of soya"), 0, 2);
 gridPane.add(tfSoya, 1, 2);
 gridPane.add(new Label("Enter value of Groundnuts:"), 0, 3);
 gridPane.add(tfGnuts, 1, 3);
 gridPane.add(new Label("Enter value of salt:"), 0, 4);
 gridPane.add(tfSalt, 1, 4);
 
 gridPane.add(lpane,1,6);
 gridPane.add(btCalculate, 1, 5);
 gridPane.add(tc, 1, 8);

 // Set properties for UI
 gridPane.setAlignment(Pos.CENTER);
 tfSoya.setAlignment(Pos.BOTTOM_RIGHT);
 tfGnuts.setAlignment(Pos.BOTTOM_RIGHT);
 tfMaize.setAlignment(Pos.BOTTOM_RIGHT);
 tfSalt.setAlignment(Pos.BOTTOM_RIGHT);
 
 tfSalt.setEditable(true);
 GridPane.setHalignment(btCalculate, HPos.RIGHT);
btCalculate.setStyle("-fx-border-width: 2px; -fx-background-color: lime;-fx-border-color: green");
 // Process events
btCalculate.setOnAction(e -> Calculating());

  primaryStage.initStyle(StageStyle.UTILITY);
    primaryStage.setResizable(false);
Scene scene = new Scene(gridPane, 600, 400);

 primaryStage.setTitle("Animal feed Calculator"); // Set title
 primaryStage.setScene(scene); // Place the scene in the stage
 primaryStage.show(); // Display the stage
 }

class LinePane extends Pane {
 public LinePane() {
 Line line1 = new Line(10, 10, 10, 10);
 line1.startXProperty().bind(widthProperty().add(1));
 line1.setStrokeWidth(1);
 line1.setStroke(Color.BLACK);
 getChildren().add(line1);
}
}
private void handleAccelerators(GridPane layout) {
    layout.addEventFilter(KeyEvent.KEY_PRESSED, new EventHandler<KeyEvent>() {
      @Override
      public void handle(KeyEvent keyEvent) {
        Button activated = accelerators.get(keyEvent.getText());
        if (activated != null) {
          activated.fire();
        }
      }
    });
  }
  private GridPane  createLayout(TextField tc, Button btCalculate) {
    final GridPane layout = new GridPane();
    layout.setAlignment(Pos.CENTER);
    layout.setVgap(5);
    layout.setHgap(5);
    
    layout.getChildren().setAll(tc);
    handleAccelerators(layout);
    tc.prefWidthProperty().bind(btCalculate.widthProperty());
    return layout;
  }
 
public String getTextFeildInput() {
    btCalculate.setStyle("-fx-background-color: blue;");
 // Get values from text fields
 SoyaInput =Double.parseDouble(tfSoya.getText());
GnutInput = Double.parseDouble(tfGnuts.getText());
 SaltInput =Double.parseDouble(tfSalt.getText());
  MaizeInput =Double.parseDouble(tfMaize.getText());

 

 // Display output
  FeedImplement feed = new FeedImplement(SoyaInput, GnutInput, SaltInput,MaizeInput);

 feed.setSoyaRatio(SoyaInput);
   feed.setGnutRatio(GnutInput);
   feed.setSaltRatio(SaltInput);
   feed.setMaizeRatio(MaizeInput);


  String b=feed.doCalculations();
  return b;
  
 }
 public void Calculating(){

 
 
   
   tc.setText(getTextFeildInput().toString());

 }
 }