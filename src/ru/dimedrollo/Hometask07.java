import java.util.*;


public class Hometask7 {

    /**
     * Функция читает ввод с консоли и считает повторения элементов
     *
     * @return хэш-карту пар, где ключ - уникальное число, значение - количество его повторений
     */
    public static Map<Integer, Integer> readAndCount() {
        // объявляем объекты для чтения с консоли и хранения данных
        Scanner scanner = new Scanner(System.in);
        HashMap<Integer, Integer> map = new HashMap<>();

        //читаем с консоли пока идет ввод
        while (scanner.hasNext()) {
            int i = scanner.nextInt();
            //при вводе -1 выходим из цикла
            if (i == -1) {
                break;
            }
            //проверям принадлежность к требуемому диапазону
            if (-100 < i && i < 100) {
                //если ключ повторяется, то инкрементируем его значение. Если ключ новый, даем значение 1.
                if (map.containsKey(i)) {
                    int a = map.get(i);
                    map.replace(i, a + 1);

                } else {
                    map.put(i, 1);
                }
            }
        }
        return map;
    }

    /**
     * Функция сортирует хэш-карту по значениям в порядке возрастания
     *
     * @return Множество пар ключ-значение, отсортированное по значениям в порядке возрастания
     */
    public static Set<Map.Entry<Integer, Integer>> sort() {
        Map<Integer, Integer> unsortedMap = readAndCount();
        ArrayList<Integer> list = new ArrayList<>();
        LinkedHashMap sortedMap = new LinkedHashMap<>();
        //Получаем список значений
        for (Map.Entry<Integer, Integer> entry : unsortedMap.entrySet()) {
            list.add(entry.getValue());
        }
        //Сортируем список значений
        Collections.sort(list);
        //создадим хэш-карту на основе отсортированного списка
        for (Integer num : list) {
            for (Map.Entry entry : unsortedMap.entrySet()) {
                if (entry.getValue().equals(num)) {
                    sortedMap.put(entry.getKey(), num);
                }
            }
        }
        //Возвращаем множество пар
        return sortedMap.entrySet();
    }


    public static void main(String[] args) {
        //Объявляем список редких значений для хранения элементов, встречающихся минимальное количество раз
        ArrayList<Integer> rareNums = new ArrayList<>();

        Set<Map.Entry<Integer, Integer>> entrySet = sort();
        //Преобразуем множество в массив, для перебора элементов
        Map.Entry<Integer, Integer>[] entryArr = new Map.Entry[entrySet.size()];
        entryArr = entrySet.toArray(entryArr);
        //проходим по элементам массива, добавляем ключи в список редких значений
        for (int i = 0; i < entrySet.size(); i++) {
            rareNums.add(entryArr[i].getKey());
            //Если значение в следующей паре отлично от текущего, выходим из цикла
            if (entryArr[i].getValue() != entryArr[i + 1].getValue()) {
                break;
            }
        }
        System.out.println(rareNums);

    }
}

