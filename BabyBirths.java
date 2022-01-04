import edu.duke.*;
import java.io.*;
import org.apache.commons.csv.*;

public class BabyBirths {
    int totalBirths, totalGirls, totalBoys, totalGirlNames, totalBoyNames;
    public void printNames() {
        
        FileResource fr = new FileResource();
        for(CSVRecord record : fr.getCSVParser(false)) {
            int numBorn = Integer.parseInt(record.get(2));
            if(numBorn <= 100) {
                System.out.println("Name: " + record.get(0) +
                                    " Gender: " + record.get(1) +
                                    " Num Born: " + record.get(2));
            }
        }
    }
    
    public void totalBirths (FileResource fr) {
        totalBirths = 0;
        totalGirls = 0;
        totalBoys = 0;
        totalGirlNames = 0;
        totalBoyNames = 0;
        for(CSVRecord record : fr.getCSVParser(false)) {
            int numBorn = Integer.parseInt(record.get(2));
            totalBirths += numBorn;
            if(record.get(1).equals("M")) {
                totalBoys += numBorn;
                totalBoyNames++;
            }
            else {
                totalGirls += numBorn;
                totalGirlNames++;
            }
        };
    }
    
    public void testTotalBirths () {
        FileResource fr = new FileResource();
        totalBirths(fr);
    }
    
    public int getRank (int year, String name, String gender) {
        FileResource fr = new FileResource("us_babynames_by_year/yob"+year+".csv");
        int rank = 0;
        int flag = 0;
        for(CSVRecord record : fr.getCSVParser(false)) {
            if(record.get(1).equals(gender)) {
                rank++;
                if(record.get(0).equals(name)) {
                    flag = 1;
                    break;
                }
            }
        }
        if (flag == 0)
            return -1;
        return rank;
    }
    
    public void testGetRank() {
        System.out.println(getRank(1960, "Emily", "F"));
    }
    
    public String getName (int year, int rank, String gender) {
        FileResource fr = new FileResource("us_babynames_by_year/yob"+year+".csv");
        int currentRank = 0;
        String reqdName = "NO NAME";
        for(CSVRecord record : fr.getCSVParser()) {
            if(record.get(1).equals(gender)) {
                currentRank++;
                if(currentRank == rank && gender == "M") {
                    reqdName = record.get(0);
                    break;
                }
                else if(currentRank == rank-1 && gender == "F") {
                    reqdName = record.get(0);
                    break;
                }
            }
        }
        //System.out.println(getRank(year, reqdName, gender));
        return reqdName;
    }
    
    public void testGetName () {
        System.out.println(getName(1980, 350, "F"));
    }
    
    public String whatIsNameInYear (String name, int year, int newYear, String gender) {
        int rank = getRank(year, name, gender);
        System.out.println(rank);
        String newName = getName(newYear, rank, gender);
        System.out.println(getRank(newYear, newName, gender));
        System.out.println(name + " born in " + year + " would be " + newName + " if she was born in " + newYear + ".");
        return newName;
    }
    
    public void testWhatIsNameInYear () {
        whatIsNameInYear("Susan", 1972, 2014, "F");
        whatIsNameInYear("Owen", 1974, 2014, "M");
    }
    
    public int yearOfHighestRank (String name, String gender) {
        DirectoryResource dr = new DirectoryResource();
        int rank = Integer.MAX_VALUE;
        int yearOfHighestRank = Integer.MIN_VALUE;
        for(File f : dr.selectedFiles()) {
            FileResource fr = new FileResource(f);
            int year = Integer.parseInt(f.getName().substring(3, 7));
            int currentRank = getRank(year, name, gender);
            if(currentRank < rank && currentRank != -1) {
                   yearOfHighestRank = year;
                   rank = currentRank;
            }
        }
        if(yearOfHighestRank == Integer.MIN_VALUE)
            yearOfHighestRank = -1;
        return yearOfHighestRank;
    }
    
    public void testYearOfHighestRank () {
        System.out.println(yearOfHighestRank("Genevieve", "F"));
        //System.out.println(yearOfHighestRank("Mich", "M"));
    }
    
    public double getAverageRank (String name, String gender) {
        DirectoryResource dr = new DirectoryResource();
        int sumRank = 0;
        int countFiles = 0;
        for(File f : dr.selectedFiles()) {
            FileResource fr = new FileResource(f);
            int year = Integer.parseInt(f.getName().substring(3, 7));
            int rank = getRank(year, name, gender);
            if(rank != -1) {
                sumRank += rank;
            }
            countFiles++;
        }
        if(sumRank == 0) {
            return -1;
        }
        return (double)sumRank/countFiles;
    }
    
    public void testGetAverageRank () {
        System.out.println(getAverageRank("Susan", "F"));
        System.out.println(getAverageRank("Robert", "M"));
    }
    //this function is a bit wrong
    //for girls ranked higher above Emily, it should give 323200, but it gives 27722 something
    public int getTotalBirthsRankedHigher (int year, String name, String gender) {
        FileResource fr = new FileResource("us_babynames_by_year/yob"+year+".csv");
        int totalBirths = 0;
        int rank = getRank(year, name, gender);
        for(CSVRecord record : fr.getCSVParser()) {
            int currentRank = getRank(year, record.get(0), gender);
            if(currentRank != -1 && currentRank < rank) {
                totalBirths += Integer.parseInt(record.get(2));
            }
        }
        return totalBirths;
    }
    
    public void testGetTotalBirthsRankedHigher () {
        System.out.println(getTotalBirthsRankedHigher (1990, "Emily", "F"));
    }
 }
