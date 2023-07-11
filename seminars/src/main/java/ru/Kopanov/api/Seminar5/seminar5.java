package ru.Kopanov.api.Seminar5;

import java.util.*;

public class seminar5 {
    public static void main(String[] args) {

        String[] data = {
                "123456 Иванов",
                "321456 Васильев",
                "234561 Петрова",
                "234432 Иванов",
                "654321 Иванов",
                "654321 Петрова",

        };
        task1(data);

        String[] students = {
                "Григорьев Анатолий 4 5 2",
                "Фокин Глеб 1 5 2",
                "Шестаков Клим 4 3 2",
                "Хохлов Мартин 2 5 2",
                "Шубин Лазарь 4 5 2",
                "Гущина Арьяна 4 3 3",
                "Брагина Виоланта 2 5 2",
                "Афанасьева Екатерина 1 1 2",
                "Рыбакова Снежана 4 2 2",
                "Лазарева Алла 4 3 2",
                "Бирюков Владлен 4 5 2",
                "Копылов Панкратий 4 4 4",
                "Горбунов Рубен 4 5 3",
                "Лыткин Герман 1 5 2",
                "Соколов Орест 1 1 5"

                //...
        };
        task2(students);
    }
    public static void task1(String[] data){
        HashMap<Integer, String> hashMap1 = new HashMap<>();
        HashMap<String, List<Integer>> hashMap2 = new HashMap<>();

        //Способ 1
        for (String person: data) {
            String[] parts = person.split(" ");
            hashMap1.put(Integer.parseInt(parts[0]), parts[1]);
        }
        for (Map.Entry<Integer, String> element : hashMap1.entrySet()){
            if(element.getValue().equals("Иванов")){
                System.out.println(element.getKey());
            }
        }

        //Способ 2
        for (String person: data) {
            String[] parts = person.split(" ");
            if (hashMap2.containsKey(parts[1])){
                hashMap2.get(parts[1]).add(Integer.parseInt(parts[0]));
            }
            else {
                ArrayList<Integer> lst = new ArrayList<>();
                lst.add(Integer.parseInt(parts[0]));
                hashMap2.put(parts[1], lst);
            }
        }
        List<Integer> lst = hashMap2.get("Иванов");
        if (lst != null){
            System.out.println(lst);
        }
    }

    public static void task2(String[] students){
        HashMap<Double, List<Student>> statistic = new HashMap<>();
        for (String student: students){
            String[] studentParts = student.split(" ");
            int a = Integer.parseInt(studentParts[2]);
            int b = Integer.parseInt(studentParts[3]);
            int c = Integer.parseInt(studentParts[4]);
            double r = (double) (a + b + c)/3;
            Student st = new Student(studentParts[1], studentParts[0], r);
            if (statistic.containsKey(r)){
                statistic.get(r).add(st);
            }
            else {
                ArrayList<Student> lst = new ArrayList<>();
                lst.add(st);
                statistic.put(r, lst);
            }
        }
        TreeMap<Double, List<Student>> sortedStatistic = new TreeMap<>(new RatingCompare());
        sortedStatistic.putAll(statistic);

        System.out.println("TOP 3 Losers:");
        int counter = 1;
        for (Map.Entry<Double, List<Student>> item: sortedStatistic.entrySet()){
            System.out.printf("%d место - средний балл %.3f\n", counter++, item.getKey());
            for (Student student: item.getValue()){
                System.out.println("\t" + student);
            }
            if (counter > 3) break;
        }

    }
}
