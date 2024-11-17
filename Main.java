import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
public class Main {
    public static void main(String[] args) {
        String filePath = "C:\\Users\\Alina\\Desktop\\uni\\java\\files\\1.txt";
        File file = new File(filePath);
        Scanner scanner = null;
        try {
            scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


        // создаем объект Map для хранения слов и их количества
        Map<String, Integer> map = new HashMap<>();


        // читаем файл по словам и добавляем их в Map

        while (scanner.hasNext()) {
            String key = scanner.next();
            key = key.toLowerCase();
            if (map.containsKey(key)) {
                map.put(key, map.get(key) + 1);
            } else {
                map.put(key, 1);
            }
            //System.out.println(map);
        }


        // закрываем Scanner
        scanner.close();
        // создаем список из элементов Map
        List<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());

        // сортируем список по убыванию количества повторений
        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o2.getValue() - o1.getValue();  // Сортировка по убыванию
            }
        });

        for (int i = 0; i < Math.min(10, list.size()); i++) {
            Map.Entry<String, Integer> entry = list.get(i);
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
