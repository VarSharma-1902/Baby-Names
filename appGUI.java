import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.scene.text.Text;
import java.util.*;
import javafx.scene.shape.*;
import javafx.scene.paint.Color;
import javafx.scene.control.ScrollBar;
import javafx.geometry.Orientation;  
import javafx.scene.Group;

public class appGUI extends Application
{
    @Override
    public void start(Stage stage) throws Exception
    {
        //object of the BabyBirths class
        BabyBirths baby = new BabyBirths();
        
        ArrayList<Integer> years = new ArrayList<Integer> ();
        Collections.addAll(years, 1880 , 1881 , 1882 , 1883 , 1884 , 1885 , 1886 , 1887 ,1888 , 1889 , 1890 , 1891 , 1892 , 
                                        1893 , 1894 , 1895 , 1896 ,1897 , 1898 ,1899 , 1900 , 1901 , 1902 , 1903 , 1904 , 1905 , 
                                        1906 , 1907 , 1908 , 1909 , 1910 , 1911 , 1912 , 1913 , 1914 , 1915 , 1916 , 1917 , 1918 , 
                                        1919 , 1920 , 1921 , 1922 , 1923 , 1924 , 1925 , 1926 ,1927 , 1928 , 1929 , 1930 , 1931 , 
                                        1932 , 1933 , 1934 , 1935 , 1936 , 1937 , 1938 , 1939 ,1940 , 1941 , 1942 , 1943 , 1944 , 
                                        1945 , 1946 , 1947 , 1948 , 1949 , 1950 , 1951 , 1952 , 1953 , 1954 , 1955 , 1956 ,1957 , 
                                        1958 , 1959 ,1960 , 1961 , 1962 , 1963 , 1964 , 1965 , 1966 , 1967 , 1968 , 1969 , 1970 , 
                                        1971 , 1972 , 1973 , 1974 , 1975 , 1976 , 1977 , 1978 , 1979 , 1980 , 1981 , 1982 , 1983 , 
                                        1984 , 1985 , 1986 , 1987 , 1988 , 1989 , 1990 , 1991 , 1992 , 1993 , 1994 , 1995 ,1996 , 
                                        1997 , 1998 , 1999 ,2000 , 2001 , 2002 , 2003 , 2004 , 2005 , 2006 , 2007 , 2008 , 2009 , 
                                        2010 , 2011 , 2012 , 2013 , 2014);
        
        stage.setTitle("Baby Names");
        
        //total births
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
                Text girls = new Text("Total Girls: " + baby.totalGirls);
                Text boyNames = new Text("Total Boys' Names: " + baby.totalBoyNames);
                Text girlNames = new Text("Total Girls' Names: " + baby.totalGirlNames);
                GridPane grid = new GridPane();
                grid.add(total,0,0);
                grid.add(boys,0,1);
                grid.add(girls,0,2);
                grid.add(boyNames,0,3);
                grid.add(girlNames,0,4);
                Scene newScene = new Scene(grid);
                births.setScene(newScene);        
                births.show();
            }
        });
        
        //total birth styling
        Rectangle rectTotalBirths = new Rectangle(300,300);
        rectTotalBirths.setFill(Color.TRANSPARENT);
        rectTotalBirths.setStroke(Color.BLACK);
        GridPane rectGridTotalBirths = new GridPane();
        rectGridTotalBirths.add(totalBirths,1,1);
        rectGridTotalBirths.setPadding(new Insets(120,90,90,120));  //top, right, bottom, left
        
        //read a name and display it's rank in a particular year
        Text name = new Text("Name");
        TextField nameField = new TextField();
        Text year = new Text("Year");
        ChoiceBox <Integer> yearChoice = new ChoiceBox();
        yearChoice.setValue(1880);
        yearChoice.getItems().addAll(years);
        
        Text genderText = new Text("Gender");
        ToggleGroup gender = new ToggleGroup();
        RadioButton maleRadio = new RadioButton("Male");
        maleRadio.setToggleGroup(gender);
        RadioButton femaleRadio = new RadioButton("Female");
        femaleRadio.setToggleGroup(gender);
        GridPane genderChoice = new GridPane();
        genderChoice.add(maleRadio, 0,0);
        genderChoice.add(femaleRadio, 1,0);
        Button getRank = new Button("Get Rank");
        getRank.setOnAction(new EventHandler <ActionEvent>(){
            @Override
            public void handle(ActionEvent e){
                //Create new stage to display the rank
                Stage dispRank = new Stage();
                dispRank.setTitle("Rank");
                String sex = ""; 
                if(maleRadio.isSelected()){
                    sex = "M";
                }
                else if(femaleRadio.isSelected()){
                    sex = "F";
                }
                Integer rank = baby.getRank(yearChoice.getValue(), nameField.getText(), sex);
                Text nameText = new Text("Name: " + nameField.getText());
                Text yearText = new Text("Year: " + yearChoice.getValue());
                Text genderText = new Text("Gender: " + sex);
                Text rankText = new Text("Rank: " + rank.toString());
                GridPane rankGrid = new GridPane();
                rankGrid.add(nameText, 0, 0);
                rankGrid.add(yearText, 0, 1);
                rankGrid.add(genderText, 0, 2);
                rankGrid.add(rankText, 0, 3);
                Scene rankScene = new Scene(rankGrid);
                dispRank.setScene(rankScene);
                dispRank.show();
            }
        });
        
        Rectangle rectGetRank = new Rectangle(300,300);
        rectGetRank.setFill(Color.TRANSPARENT);
        rectGetRank.setStroke(Color.BLACK);
        GridPane rectGridGetRank = new GridPane();
        //styling
        rectGridGetRank.setHgap(5);
        rectGridGetRank.setVgap(5);
        rectGridGetRank.setPadding(new Insets(70,70,70,70));
        //adding elements
        rectGridGetRank.add(name, 0, 1);
        rectGridGetRank.add(nameField, 1, 1);
        rectGridGetRank.add(year, 0, 2);
        rectGridGetRank.add(yearChoice, 1, 2);
        rectGridGetRank.add(genderText, 0,3);
        rectGridGetRank.add(genderChoice, 1,3);
        rectGridGetRank.add(getRank, 1, 4);
        
        
        //get the rank of a particular name
        Text readRank = new Text("Rank");
        TextField rankField = new TextField();
        Text yearGetRank = new Text("Year");
        ChoiceBox <Integer> yearChoiceGetRank = new ChoiceBox();
        yearChoiceGetRank.setValue(1880);
        yearChoiceGetRank.getItems().addAll(years);
        Text genderTextGetRank = new Text("Gender");
        ToggleGroup genderGetRank = new ToggleGroup();
        RadioButton maleRadioGetRank = new RadioButton("Male");
        maleRadioGetRank.setToggleGroup(genderGetRank);
        RadioButton femaleRadioGetRank = new RadioButton("Female");
        femaleRadioGetRank.setToggleGroup(genderGetRank);
        GridPane genderChoiceGetRank = new GridPane();
        genderChoiceGetRank.add(maleRadioGetRank, 0,0);
        genderChoiceGetRank.add(femaleRadioGetRank, 1,0);
        Button getName = new Button("Get Name");
        getName.setOnAction(new EventHandler <ActionEvent>(){
            @Override
            public void handle(ActionEvent e){
                //Create new stage to display the name corresponding to the given rank
                Stage dispName = new Stage();
                dispName.setTitle("Name");
                String sex = ""; 
                if(maleRadioGetRank.isSelected()){
                    sex = "M";
                }
                else if(femaleRadioGetRank.isSelected()){
                    sex = "F";
                }
                Text rankText = new Text("Rank: " + rankField.getText());
                Text yearText = new Text("Year: " + yearChoiceGetRank.getValue());
                Text genderText = new Text("Gender: " + sex);
                Text nameText = new Text("Rank: " + baby.getName(yearChoiceGetRank.getValue(), Integer.parseInt(rankField.getText()), sex));
                GridPane nameGrid = new GridPane();
                nameGrid.add(rankText, 0, 0);
                nameGrid.add(yearText, 0, 1);
                nameGrid.add(genderText, 0, 2);
                nameGrid.add(nameText, 0, 3);
                Scene rankScene = new Scene(nameGrid);
                dispName.setScene(rankScene);
                dispName.show();
            }
        });
        
        Rectangle rectGetName = new Rectangle(300,300);
        rectGetName.setFill(Color.TRANSPARENT);
        rectGetName.setStroke(Color.BLACK);
        GridPane rectGridGetName = new GridPane();
        //styling
        rectGridGetName.setHgap(5);
        rectGridGetName.setVgap(5);
        rectGridGetName.setPadding(new Insets(70,50,70,70));
        //adding elements
        rectGridGetName.add(readRank, 0,0);
        rectGridGetName.add(rankField, 1,0);
        rectGridGetName.add(yearGetRank, 0, 1);
        rectGridGetName.add(yearChoiceGetRank, 1, 1);
        rectGridGetName.add(genderTextGetRank, 0,2);
        rectGridGetName.add(genderChoiceGetRank, 1,2);
        rectGridGetName.add(getName, 1,3);
        
        
        //check the name of the person in a specific year
        Text nameSpcYear = new Text("Name ");
        TextField nameFieldSpcYear = new TextField();
        Text birthYearText = new Text("Birth Year ");
        ChoiceBox <Integer> birthYear = new ChoiceBox();
        birthYear.setValue(1880);
        birthYear.getItems().addAll(years);
        Text yearText = new Text("Year ");
        ChoiceBox <Integer> yearSpcYear = new ChoiceBox();
        yearSpcYear.setValue(1880);
        yearSpcYear.getItems().addAll(years);
        Text genderSpcYear = new Text("Gender");
        ToggleGroup genderSpcYearToggle = new ToggleGroup();
        RadioButton maleRadioSpcYear = new RadioButton("Male");
        maleRadioGetRank.setToggleGroup(genderSpcYearToggle);
        RadioButton femaleRadioSpcYear = new RadioButton("Female");
        femaleRadioGetRank.setToggleGroup(genderSpcYearToggle);
        GridPane genderChoiceSpcYear = new GridPane();
        genderChoiceSpcYear.add(maleRadioSpcYear, 0,0);
        genderChoiceSpcYear.add(femaleRadioSpcYear, 1,0);
        Button getNameSpcYear = new Button("Get Name");
        getNameSpcYear.setOnAction(new EventHandler <ActionEvent>(){
            @Override
            public void handle(ActionEvent e){
                //Create new stage to display the name corresponding to the given rank
                Stage dispNameSpcYear = new Stage();
                dispNameSpcYear.setTitle("Name");
                String sex = ""; 
                if(maleRadioSpcYear.isSelected()){
                    sex = "M";
                }
                else if(femaleRadioSpcYear.isSelected()){
                    sex = "F";
                }
                Text nameText = new Text("Name: " + nameFieldSpcYear.getText());
                Text yearText = new Text("Birth Year: " + birthYear.getValue());
                Text genderText = new Text("Gender: " + sex);
                Text nameTextSpcYear = new Text("Your name in the year " + yearSpcYear.getValue() + " will be " +
                           baby.whatIsNameInYear(nameFieldSpcYear.getText(), birthYear.getValue(), yearSpcYear.getValue(),sex));
                GridPane nameGrid = new GridPane();
                nameGrid.add(nameText, 0, 0);
                nameGrid.add(yearText, 0, 1);
                nameGrid.add(genderText, 0, 2);
                nameGrid.add(nameTextSpcYear, 0, 3);
                Scene spcNameScene = new Scene(nameGrid);
                dispNameSpcYear.setScene(spcNameScene);
                dispNameSpcYear.show();
            }
        });
        
        Rectangle rectGetNameSpcYear = new Rectangle(300,300);
        rectGetNameSpcYear.setFill(Color.TRANSPARENT);
        rectGetNameSpcYear.setStroke(Color.BLACK);
        GridPane rectGridGetNameSpcYear = new GridPane();
        //styling
        rectGridGetNameSpcYear.setHgap(5);
        rectGridGetNameSpcYear.setVgap(5);
        rectGridGetNameSpcYear.setPadding(new Insets(30,50,30,50));
        //adding elements
        rectGridGetNameSpcYear.add(nameSpcYear, 0, 11);
        rectGridGetNameSpcYear.add(nameFieldSpcYear, 1, 11);
        rectGridGetNameSpcYear.add(birthYearText, 0, 12);
        rectGridGetNameSpcYear.add(birthYear, 1, 12);
        rectGridGetNameSpcYear.add(yearText, 0, 13);
        rectGridGetNameSpcYear.add(yearSpcYear, 1, 13);
        rectGridGetNameSpcYear.add(genderSpcYear, 0, 14);
        rectGridGetNameSpcYear.add(genderChoiceSpcYear, 1, 14);
        rectGridGetNameSpcYear.add(getNameSpcYear, 1, 15);
        
        //average rank of a name
        Text nameAvgRank = new Text("Name ");
        TextField nameFieldAvgRank = new TextField();
        Text genderAvgRank = new Text("Gender");
        ToggleGroup genderAvgRankToggle = new ToggleGroup();
        RadioButton maleRadioAvgRank = new RadioButton("Male");
        maleRadioAvgRank.setToggleGroup(genderAvgRankToggle);
        RadioButton femaleRadioAvgRank = new RadioButton("Female");
        femaleRadioAvgRank.setToggleGroup(genderAvgRankToggle);
        GridPane genderChoiceAvgRank = new GridPane();
        genderChoiceAvgRank.add(maleRadioAvgRank, 0,0);
        genderChoiceAvgRank.add(femaleRadioAvgRank, 1,0);
        Button getAvgRank = new Button("Get Average Rank");
        getAvgRank.setOnAction(new EventHandler <ActionEvent>(){
            @Override
            public void handle(ActionEvent e){
                //Create new stage to display the name corresponding to the given rank
                Stage dispAvgRank = new Stage();
                dispAvgRank.setTitle("Average Rank");
                String sex = ""; 
                if(maleRadioAvgRank.isSelected()){
                    sex = "M";
                }
                else if(femaleRadioAvgRank.isSelected()){
                    sex = "F";
                }
                Text nameText = new Text("Name: " + nameFieldAvgRank.getText());
                Text genderText = new Text("Gender: " + sex);
                Text avgRank = new Text("Average Rank: " + baby.getAverageRank(nameFieldAvgRank.getText(), sex));
                GridPane avgGrid = new GridPane();
                avgGrid.add(nameText, 0, 0);
                avgGrid.add(genderText, 0, 1);
                avgGrid.add(avgRank, 0, 2);
                Scene avgRankScene = new Scene(avgGrid);
                dispAvgRank.setScene(avgRankScene);
                dispAvgRank.show();
            }
        });
        
        Rectangle rectAvgRank = new Rectangle(300,300);
        rectAvgRank.setFill(Color.TRANSPARENT);
        rectAvgRank.setStroke(Color.BLACK);
        GridPane rectGridAvgRank = new GridPane();
        //styling
        rectGridAvgRank.setHgap(5);
        rectGridAvgRank.setVgap(5);
        rectGridAvgRank.setPadding(new Insets(30,50,30,50));
        //adding elements
        rectGridAvgRank.add(nameAvgRank, 0, 16);
        rectGridAvgRank.add(nameFieldAvgRank, 1, 16);
        rectGridAvgRank.add(genderAvgRank, 0, 17);
        rectGridAvgRank.add(genderChoiceAvgRank, 1, 17);
        rectGridAvgRank.add(getAvgRank, 1, 18);  
        
        //find the year of the highest rank of a name
        Text nameHighestRank = new Text("Name ");
        TextField nameFieldHighestRank = new TextField();
        Text genderHighestRank = new Text("Gender");
        ToggleGroup genderHighestRankToggle = new ToggleGroup();
        RadioButton maleRadioHighestRank = new RadioButton("Male");
        maleRadioHighestRank.setToggleGroup(genderHighestRankToggle);
        RadioButton femaleRadioHighestRank = new RadioButton("Female");
        femaleRadioHighestRank.setToggleGroup(genderHighestRankToggle);
        GridPane genderChoiceHighestRank = new GridPane();
        genderChoiceHighestRank.add(maleRadioHighestRank, 0,0);
        genderChoiceHighestRank.add(femaleRadioHighestRank, 1,0);
        Button getYear = new Button("Get Year");
        getYear.setOnAction(new EventHandler <ActionEvent>(){
            @Override
            public void handle(ActionEvent e){
                //Create new stage to display the name corresponding to the given rank
                Stage highestYearRank = new Stage();
                highestYearRank.setTitle("Highest Rank");
                String sex = ""; 
                if(maleRadioHighestRank.isSelected()){
                    sex = "M";
                }
                else if(femaleRadioHighestRank.isSelected()){
                    sex = "F";
                }
                Text nameText = new Text("Name: " + nameFieldHighestRank.getText());
                Text genderText = new Text("Gender: " + sex);
                Text highestYear = new Text("Year with the Highest Rank : " + baby.yearOfHighestRank(nameFieldHighestRank.getText(), sex));
                GridPane rankGrid = new GridPane();
                rankGrid.add(nameText, 0, 0);
                rankGrid.add(genderText, 0, 1);
                rankGrid.add(highestYear, 0, 2);
                Scene highestRankScene = new Scene(rankGrid);
                highestYearRank.setScene(highestRankScene);
                highestYearRank.show();
            }
        });
        
        Rectangle rectGetYear = new Rectangle(300,300);
        rectGetYear.setFill(Color.TRANSPARENT);
        rectGetYear.setStroke(Color.BLACK);
        GridPane rectGridGetYear = new GridPane();
        //styling
        rectGridGetYear.setHgap(5);
        rectGridGetYear.setVgap(5);
        rectGridGetYear.setPadding(new Insets(30,50,30,50));   
        //adding elements
        rectGridGetYear.add(nameHighestRank, 0, 19);
        rectGridGetYear.add(nameFieldHighestRank, 1, 19);
        rectGridGetYear.add(genderHighestRank, 0, 20);
        rectGridGetYear.add(genderChoiceHighestRank, 1, 20);
        rectGridGetYear.add(getYear, 1, 21); 
        
        GridPane gridPane = new GridPane(); 
        //gridPane styling
        gridPane.setMinSize(400,200);
        gridPane.setPadding(new Insets(10,10,10,10));
        gridPane.setVgap(5);
        //gridPane.setHgap(5);
        //gridPane adding elements
        gridPane.add(rectTotalBirths, 0, 0);
        gridPane.add(rectGridTotalBirths, 0, 0);
        
        gridPane.add(rectGetRank, 1, 0);
        gridPane.add(rectGridGetRank, 1, 0);
        
        gridPane.add(rectGetName, 2, 0);
        gridPane.add(rectGridGetName, 2, 0);
        
        gridPane.add(rectGetNameSpcYear, 0, 1);
        gridPane.add(rectGridGetNameSpcYear, 0, 1);
        
        gridPane.add(rectAvgRank, 1, 1);
        gridPane.add(rectGridAvgRank, 1, 1);
           
        gridPane.add(rectGetYear, 2, 1);
        gridPane.add(rectGridGetYear, 2, 1);
        
        
        Scene scene = new Scene(gridPane);
        stage.setScene(scene);        
        stage.show();
    }
}
