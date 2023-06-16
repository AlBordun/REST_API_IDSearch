package OOP.ParametrizedClasses;

import OOP.StudentDomen.User;

import java.util.*;

public class AverageAge<T extends User> {
    int count;
//    private List<Integer> AverageAge;
    double sum;

    public void ageSum(List<T> AnyList) {
        for (T average : AnyList) {
            sum += average.getAge();
            count++;
        }

    }

    public double getAverageAge() {
//        IntSummaryStatistics average = getAgeToList(AverageAge).stream().collect(Collectors.summarizingInt(Integer::intValue));
//        return average.getAverage();
//        double average = AverageAge.stream().mapToInt(value -> value).average();
//        if(average.isPresent()){
//            System.out.println(average.getAsDouble());
//        double average = AverageAge.stream().mapToInt(el -> el.getAge).average().getAsDouble();
//        return average;
        return sum/count;
    }
}

