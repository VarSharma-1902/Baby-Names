import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.geometry.Insets;
import javafx.scene.control.*;
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
        
        //read a name and display it's rank in a particular year
        Text name = new Text("Name");
        TextField nameField = new TextField();
        Text year = new Text("Year");
        ChoiceBox <Integer> yearChoice = new ChoiceBox();
        yearChoice.setValue(1880);
        yearChoice.getItems().addAll(1880 , 1881 , 1882 , 1883 , 1884 , 1885 , 1886 , 1887 ,1888 , 1889 , 1890 , 1891 , 1892 , 
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
        
        //get the rank of a particular name
        Text readRank = new Text("Rank");
        TextField rankField = new TextField();
        Text yearGetRank = new Text("Year");
        ChoiceBox <Integer> yearChoiceGetRank = new ChoiceBox();
        yearChoiceGetRank.setValue(1880);
        yearChoiceGetRank.getItems().addAll(1880 , 1881 , 1882 , 1883 , 1884 , 1885 , 1886 , 1887 ,1888 , 1889 , 1890 , 1891 , 1892 , 
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
        
        //check the name of the person in a specific year
        Text nameSpcYear = new Text("Name ");
        
        GridPane gridPane = new GridPane(); 
        gridPane.add(totalBirths, 0, 0);
        gridPane.add(name, 0, 1);
        gridPane.add(nameField, 1, 1);
        gridPane.add(year, 0, 2);
        gridPane.add(yearChoice, 1, 2);
        gridPane.add(genderText, 0,3);
        gridPane.add(genderChoice, 1,3);
        gridPane.add(getRank, 1, 4);
        gridPane.add(readRank, 0,5);
        gridPane.add(rankField, 1,5);
        gridPane.add(yearGetRank, 0, 6);
        gridPane.add(yearChoiceGetRank, 1, 7);
        gridPane.add(genderTextGetRank, 0,8);
        gridPane.add(genderChoiceGetRank, 1,9);
        gridPane.add(getName, 1,10);
        
        Scene scene = new Scene(gridPane);
        stage.setScene(scene);        
        stage.show();
    }
}
