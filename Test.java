import java.io.IOException;
import java.util.ArrayList;

public class Test {
    public static void main(String[] str) throws IOException {
        ReadExcel readExcel = new ReadExcel("C:\\Users\\saifs\\IdeaProjects\\demo\\Example.xlsx");
        ArrayList<Integer> a = readExcel.find();
        for (int s : a) {
            System.out.println(s);
        }
        ArrayList<ArrayList<ArrayList<String>>> b = readExcel.read(a);
        for (ArrayList<ArrayList<String>> x : b) {
            for (ArrayList<String> y : x) {
                System.out.println(y);
            }
            System.out.println();
        }

    }
}
