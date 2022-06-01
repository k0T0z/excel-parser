import java.io.IOException;
import java.util.ArrayList;

public class ArrangeDataTest {
    public static void main(String[] str) throws IOException {
        ReadExcel readExcel = new ReadExcel("D:\\FOE - ASU\\CSE231s Advanced Computer Programming\\apigui\\Example.xlsx");
        ArrayList<Integer> a = readExcel.find();
        ArrayList<ArrayList<ArrayList<String>>> b = readExcel.read(a);

        ArrangeData arrangeData = new ArrangeData(b);

        ArrayList<ArrayList<ArrayList<String>>> e = arrangeData.getDirection(b);
        for (ArrayList<ArrayList<String>> x : e) {
            for (ArrayList<String> y : x) {
                System.out.println(y);
            }
            System.out.println();
        }

        ArrayList<ArrayList<ArrayList<String>>> c = arrangeData.getArrangedData(b);
        for (ArrayList<ArrayList<String>> x : c) {
            for (ArrayList<String> y : x) {
                System.out.println(y);
            }
            System.out.println();
        }
        ArrayList<ArrayList<ArrayList<String>>> d = arrangeData.getAllowedValues(b);
        for (ArrayList<ArrayList<String>> x : d) {
            for (ArrayList<String> y : x) {
                System.out.println(y);
            }
            System.out.println();
        }

        ArrayList<ArrayList<ArrayList<String>>> f = arrangeData.getState(b);
        for (ArrayList<ArrayList<String>> x : f) {
            for (ArrayList<String> y : x) {
                System.out.println(y);
            }
            System.out.println();
        }


    }
}
