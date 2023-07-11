package ru.Kopanov.api.Homework5;



public class Homework5 {
    public static void main(String[] args){
        String[] lst = {
                "Григорьев Анатолий 4152",
                "Фокин Глеб 1521",
                "Шестаков Клим 1432",
                "Хохлов Мартин 1252",
                "Хохлов Игорь 1253",
                "Шубин Лазарь 4552",
                "Гущина Арьяна 4353",
                "Брагина Виоланта 2652",
                "Афанасьева Екатерина 1122",
                "Рыбакова Снежана 4522",
                "Лазарева Алла 4329",
                "Бирюков Владлен 4534",
                "Копылов Панкратий 4448",
                "Горбунов Рубен 4536",
                "Лыткин Герман 1525",
                "Соколов Орест 1155"
        };
        Phonebook phonebook = new Phonebook();
        for (String item: lst) {
            String[] data = item.split(" ");
            Person newPerson = new Person(data[1], data[0], Integer.parseInt(data[2]));
            phonebook.add(newPerson);
        }

        Person newPerson = new Person("Игорь", "Шубин", 18654);
        phonebook.add(newPerson);

        System.out.println(phonebook.get("Шубин"));

        System.out.println();
        phonebook.showBook();
    }
}
