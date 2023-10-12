package ru.bordun.validator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.bordun.model.entity.Subset;

import java.util.List;
import java.util.stream.Stream;

import static ru.bordun.message.Message.POINTS_OUT_OF_RANGE;
import static ru.bordun.message.Message.X_OUT_OF_RANGE;


@Service
@RequiredArgsConstructor
public class Validator {



    public void validate(List<Subset> subsets) {
        boolean isValidSubs = subsets.stream()
                .flatMap(subset -> subset.getSegments().stream())
                .flatMap(segment -> Stream.of(segment.getLeft(), segment.getRight()))
                .anyMatch(point -> !point.isNaN() || !point.isInfinite());
        if (!isValidSubs) {
            throw new RuntimeException(POINTS_OUT_OF_RANGE.getMessage());
        }
    }


    public void validate(Double x) {
        if (x.isNaN() || x.isInfinite()) {
            throw new RuntimeException(X_OUT_OF_RANGE.getMessage());
        }
    }
}