import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.Random;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();
    }


    public static void main(String[] args) {
        Random rndm = new Random();
        /*
        CustomArrayList<String> someStrings = new CustomArrayList<>();

        for(int i = 0; i < 10; i++) {
            int filled = 0;
            someStrings.add("str1------------");
            someStrings.add("str1------------");
            someStrings.add("str3------------");
            someStrings.add("str4------------");
            someStrings.add("str5------------");
            someStrings.add("str6------------");
            someStrings.add("str7------------");
            someStrings.add("str8------------");
            someStrings.add("str9------------");
            someStrings.add("str10-----------");
            someStrings.add("str11-----------");
            someStrings.add("str12-----------");
            someStrings.add("str13-----------");
            System.out.println("LF: " + someStrings.loadFactor());
            for(Node n : someStrings.getList()){
                if (n != null) filled++;
            }
            System.out.println("Filled:" + filled);
        }

        System.out.println("List length: " + someStrings.size());
        for(Node n : someStrings.getList()) System.out.println(n);
        */

        CustomArrayList<Integer> ints = new CustomArrayList<>();
        ints.add(123456789);
        for(int i = 0; i< 1000; i++){
            ints.add(rndm.nextInt());
        }

        System.out.println("Expanding list: ");
        for(Node n : ints.getList()) System.out.println(n);
        System.out.println("ArrayList size:" + ints.size());
        System.out.println("Inside list size: " + ints.getList().length);

        System.out.println("Getting: " + ints.get(123456789));

        CustomArrayList<Integer> intsBig = new CustomArrayList<>(ints.size());
        for(Integer i : ints){
            intsBig.add(i);
        }

        System.out.println("Big List: ");
        for(Node n : intsBig.getList()) System.out.println(n);


        launch(args);
    }

}
