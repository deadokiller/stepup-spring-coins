package javapro.lesson4;

import javapro.lesson4.model.Employee;
import javapro.lesson4.model.Position;

import java.util.List;

import static javapro.lesson4.lesson4.getAverageAge;
import static javapro.lesson4.lesson4.getDistinct;
import static javapro.lesson4.lesson4.getBiggestThirdNumber;
import static javapro.lesson4.lesson4.getBiggestThirdNumberDistinct;
import static javapro.lesson4.lesson4.getLongestLongestWord;
import static javapro.lesson4.lesson4.getLongestWord;
import static javapro.lesson4.lesson4.getMap;
import static javapro.lesson4.lesson4.getOldestEngineerName;
import static javapro.lesson4.lesson4.getOrderStringList;

public class Main {
    public static void main(String[] args) {
        var list = List.of(5, 2, 10, 9, 4, 4, 10, 1, 13);
        // Реализуйте удаление из листа всех дубликатов
        System.out.println(getDistinct(list));
        //  Найдите в списке целых чисел 3-е наибольшее число (пример: 5 2 10 9 4 3 10 1 13 => 10)
        System.out.println(getBiggestThirdNumber(list));
        //Найдите в списке целых чисел 3-е наибольшее «уникальное» число (пример: 5 2 10 9 4 3 10 1 13 => 9, в отличие от прошлой задачи здесь разные 10 считает за одно число)
        System.out.println(getBiggestThirdNumberDistinct(list));
        var employeeList = List.of(new Employee("Mike", 12, Position.DIRECTOR),
                new Employee("Mike", 12, Position.MANAGER),
                new Employee("Nike", 22, Position.ENGINEER),
                new Employee("Pike", 52, Position.MANAGER),
                new Employee("Tike", 42, Position.ENGINEER),
                new Employee("MikeVin", 16, Position.MANAGER),
                new Employee("NikeVin", 25, Position.ENGINEER),
                new Employee("PikeVin", 57, Position.MANAGER),
                new Employee("TikeVin", 48, Position.ENGINEER));
        /*
            Имеется список объектов типа Сотрудник (имя, возраст, должность), необходимо получить список имен
            3 самых старших сотрудников с должностью «Инженер», в порядке убывания возраста
        */
        System.out.println(getOldestEngineerName(employeeList));
        /*
            Имеется список объектов типа Сотрудник (имя, возраст, должность),
            посчитайте средний возраст сотрудников с должностью «Инженер»
         */
        System.out.println(getAverageAge(employeeList));
        var wordList = List.of("набор", "слов", "для", "задания", "четвертого", "урока", "буква", "театр");
        //   Найдите в списке слов самое длинное
        System.out.println(getLongestWord(wordList));
        var string = "набор слов для задания четвертого урока для задания четвертого урока задания четвертого урока урока";
        /*
            Имеется строка с набором слов в нижнем регистре, разделенных пробелом. Постройте хеш-мапы,
            в которой будут хранится пары: слово - сколько раз оно встречается во входной строке
        */
        System.out.println(getMap(string));
        /*
            Отпечатайте в консоль строки из списка в порядке увеличения длины слова, если слова имеют одинаковую длины,
            то должен быть сохранен алфавитный порядок
        */
        System.out.println(getOrderStringList(wordList));
        var stringList = List.of("набор слов для задания",
                "четвертого урока для",
                "задания1 четвертого1 урока1 задания2",
                "четвертого22 урока2 урока3");
        System.out.println(getLongestLongestWord(stringList));
    }
}