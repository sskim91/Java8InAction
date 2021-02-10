package lambdasinaction.chap10;

import java.util.Optional;
import java.util.Properties;

/**
 * @author sskim
 */
public class Quiz10 {

    //10-1 QUIZ
    //Optional 언랩하지 않고 두 Optional 합치기
//    public Optional<Insurance> nullSafeFindCheapsetInsurance(Optional<Person> person, Optional<Car> car) {
//
//    }

    //10-2 QUIZ
    //Optional 필터링
    public String getCarInsuranceName(Optional<Person> person, int minAge) {
        return person.filter(i -> i.getAge() >= minAge)
                .flatMap(Person::getCar)
                .flatMap(Car::getInsurance)
                .map(Insurance::getName)
                .orElse("Unknown");
    }

    //10-3 QUIZ
    //Optional로 프로퍼티에서 지속시간 읽기
    public int readDuration(Properties props, String name) {
        return Optional.ofNullable(props.getProperty(name))
                .flatMap(OperationsWithOptional::stringToInt)
                .filter(i -> i > 0)
                .orElse(0);
    }
}
