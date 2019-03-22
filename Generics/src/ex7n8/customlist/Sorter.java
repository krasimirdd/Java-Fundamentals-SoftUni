package ex7n8.customlist;

public class Sorter {

    public static <T extends Comparable<T>> void sort(SmartList<T> smartList) {

        for (int i = 0; i < smartList.size(); i++) {
            for (int j = i + 1; j < smartList.size(); j++) {

                if (smartList.get(i).compareTo(smartList.get(j)) > 0) {
                    smartList.swap(i, j);
                }
            }

        }
    }
}
