import java.util.ArrayList;

public class ArrangeData {
    static ArrayList<Integer> numberOfObjectsEachAPI = new ArrayList<>();

    ArrangeData(ArrayList<ArrayList<ArrayList<String>>> fullData) {
        for (int i = 0 ; i < ReadExcel.apis ; i++) {
            numberOfObjectsEachAPI.add(0); // add location in array for the current api
            for (int j = 1 ; j < fullData.get(i).size() ; j++) { // j = 1 to ignore first row
                String tempString1 = fullData.get(i).get(j).get(1);
                while (tempString1.length() != 0) {
                    String tempString2;
                    int index = 0, objectNumber;
                    for (int k = tempString1.length() - 1 ; k >= 0 ; k--) {
                        if(tempString1.charAt(k) == '/') {
                            index = k+1;
                            break;
                        }
                    }
                    tempString2 = tempString1.substring(index);
                    tempString1 = tempString1.substring(0, index - 1);
                    if(tempString2.charAt(0) != 'o') {
                        continue;
                    }
                    tempString2 = tempString2.substring(6);
                    objectNumber = Integer.parseInt(tempString2);
                    if(numberOfObjectsEachAPI.get(i) < objectNumber) {
                        numberOfObjectsEachAPI.set(i, objectNumber);
                    }
                }
            }
        }
    }

    ArrayList<ArrayList<ArrayList<String>>> getDirection(ArrayList<ArrayList<ArrayList<String>>> fullData) {
        ArrayList<ArrayList<ArrayList<String>>> arrangedData = new ArrayList<>();

        for (int i = 0 ; i < ReadExcel.apis ; i++) {
            ArrayList<ArrayList<String>> tempArray1 = new ArrayList<>();
            for (int e = 0 ; e < numberOfObjectsEachAPI.get(i) ; e++) {
                ArrayList<String> tempArray2 = new ArrayList<>();
                for (int j = 1 ; j < fullData.get(i).size() ; j++) { // j = 1 to ignore first row
                    String tempString1 = fullData.get(i).get(j).get(0);
                    tempArray2.add(tempString1);
                }
                tempArray1.add(tempArray2);
            }
            arrangedData.add(tempArray1);
        }
        return arrangedData;
    }

    ArrayList<ArrayList<ArrayList<String>>> getArrangedData(ArrayList<ArrayList<ArrayList<String>>> fullData) {
        ArrayList<ArrayList<ArrayList<String>>> arrangedData = new ArrayList<>();

        for (int i = 0 ; i < ReadExcel.apis ; i++) {
            ArrayList<ArrayList<String>> tempArray1 = new ArrayList<>();
            for (int e = 0 ; e < numberOfObjectsEachAPI.get(i) ; e++) {
                ArrayList<String> tempArray2 = new ArrayList<>();
                String tempString2 = "object" + (e + 1);
                for (int j = 1 ; j < fullData.get(i).size() ; j++) { // j = 1 to ignore first row
                    String tempString1 = fullData.get(i).get(j).get(1);
                    int tempIndex1 = tempString1.indexOf(tempString2);
                    if (tempIndex1 == -1) {
                        continue;
                    }
                    tempIndex1 += tempString2.length() + 1;
                    String tempString4;
                    int tempIndex2 = 0;
                    for (int k = tempIndex1; k < tempString1.length() ; k++) {
                        if(tempString1.charAt(k) == '/') {
                            tempIndex2 = k - 1;
                            break;
                        } else if (k == (tempString1.length() - 1)) {
                            tempIndex2 = k;
                        }
                    }
                    if (tempIndex1 < tempString1.length() && tempIndex2 < tempString1.length()) {
                        tempString4 = tempString1.substring(tempIndex1, tempIndex2 + 1);
                        boolean tempBoolean1 = true;
                        for (String s : tempArray2) {
                            if(s.equals(tempString4)) {
                                tempBoolean1 = false;
                                break;
                            }
                        }
                        if(tempBoolean1) {
                            tempArray2.add(tempString4);
                        }
                    }
                }
                tempArray1.add(tempArray2);
            }
            arrangedData.add(tempArray1);
        }
        return arrangedData;
    }


    ArrayList<ArrayList<ArrayList<String>>> getAllowedValues(ArrayList<ArrayList<ArrayList<String>>> fullData) {
        ArrayList<ArrayList<ArrayList<String>>> arrangedData = new ArrayList<>();

        for (int i = 0 ; i < ReadExcel.apis ; i++) {
            ArrayList<ArrayList<String>> tempArray1 = new ArrayList<>();
            for (int e = 0 ; e < numberOfObjectsEachAPI.get(i) ; e++) {
                ArrayList<String> tempArray2 = new ArrayList<>();
                for (int j = 1 ; j < fullData.get(i).size() ; j++) { // j = 1 to ignore first row
                    String tempString1 = fullData.get(i).get(j).get(3);
                    if(tempString1.equals("")) {
                        tempArray2.add("All Values are Allowed");
                    }
                    else {
                        tempArray2.add(tempString1);
                    }
                }
                tempArray1.add(tempArray2);
            }
            arrangedData.add(tempArray1);
        }
        return arrangedData;
    }

    ArrayList<ArrayList<ArrayList<String>>> getState(ArrayList<ArrayList<ArrayList<String>>> fullData) {
        ArrayList<ArrayList<ArrayList<String>>> arrangedData = new ArrayList<>();

        for (int i = 0 ; i < ReadExcel.apis ; i++) {
            ArrayList<ArrayList<String>> tempArray1 = new ArrayList<>();
            for (int e = 0 ; e < numberOfObjectsEachAPI.get(i) ; e++) {
                ArrayList<String> tempArray2 = new ArrayList<>();
                for (int j = 1 ; j < fullData.get(i).size() ; j++) { // j = 1 to ignore first row
                    String tempString1 = fullData.get(i).get(j).get(4);

                    tempArray2.add(tempString1);

                }
                tempArray1.add(tempArray2);
            }
            arrangedData.add(tempArray1);
        }
        return arrangedData;
    }




}
