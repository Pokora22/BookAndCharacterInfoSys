import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();
    }


    public static void main(String[] args) {
        CustomArrayList<String> someStrings = new CustomArrayList<>();
        someStrings.add("str1");
        someStrings.add("str2");
        someStrings.add("str3");
        someStrings.add("str4");
        someStrings.add("str5");
        someStrings.add("str6");
        someStrings.add("str7");
        someStrings.add("str8");
        someStrings.add("str9");
        someStrings.add("str10");
        someStrings.add("str11");
        someStrings.add("str12");
        someStrings.add("str13");

        System.out.println(someStrings.toString());

        launch(args);
    }
}
