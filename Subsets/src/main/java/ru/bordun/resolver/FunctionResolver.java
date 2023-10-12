package ru.bordun.resolver;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.bordun.dto.PointDto;
import ru.bordun.dto.SegmentDto;
import ru.bordun.mapper.SegmentMapper;
import ru.bordun.model.entity.Segment;
import ru.bordun.model.entity.Subset;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static ru.bordun.message.Message.NO_CROSS_SEGMENTS;


@Service
@RequiredArgsConstructor
public class FunctionResolver {

    private final SegmentMapper mapper;


    public PointDto findNearestPoint(List<Subset> subs, Double x) {


        Map<Double, Double> near = new TreeMap<>();


        if (subs.size() == 1) {
            return handleSingleSubset(subs, x);
        }


        List<Double> crossPoints = new ArrayList<>(getCrossPoints(subs));


        List<Segment> crossSegments = getSegments(subs, crossPoints);


        if (x.compareTo(Double.MAX_VALUE) == 0 && !crossPoints.contains(Double.MAX_VALUE)) {
            Double nearestToX = crossSegments.stream()
                    .flatMap(segment -> Stream.of(segment.getLeft(), segment.getRight()))
                    .max(Double::compareTo)
                    .orElseThrow();
            return PointDto.builder()
                    .point(nearestToX)
                    .build();
        }


        if (x.compareTo(-Double.MAX_VALUE) == 0 && !crossPoints.contains(-Double.MAX_VALUE)) {
            Double nearestToX = crossSegments.stream()
                    .flatMap(segment -> Stream.of(segment.getLeft(), segment.getRight()))
                    .min(Double::compareTo).orElseThrow();
            return PointDto.builder()
                    .point(nearestToX)
                    .build();
        }


        if (x.compareTo(0d) == 0 && crossPoints.contains(0d)) {
            return PointDto.builder()
                    .point(x)
                    .build();
        }


        for (Segment segment : crossSegments) {


            if (isExistInSegment(segment, x)) {
                return PointDto.builder()
                        .point(x)
                        .build();
            } else {


                if (segment.getLeft().compareTo(x) < 0) {
                    near.put(x - segment.getLeft(), segment.getLeft());
                } else {
                    near.put(segment.getLeft() - x, segment.getLeft());
                }


                if (segment.getRight().compareTo(x) < 0) {
                    near.put(x - segment.getRight(), segment.getRight());
                } else {
                    near.put(segment.getRight() - x, segment.getRight());
                }
            }
        }
        near.remove(Double.NEGATIVE_INFINITY);
        near.remove(Double.POSITIVE_INFINITY);
        return PointDto.builder()
                .point(near.values().stream().findFirst().orElseThrow())
                .build();
    }


    private PointDto handleSingleSubset(List<Subset> subs, Double x) {
        for (Segment segment : subs.get(0).getSegments()) {
            if (isExistInSegment(segment, x)) {
                return PointDto.builder()
                        .point(x)
                        .build();
            }
        }
        throw new RuntimeException(NO_CROSS_SEGMENTS.getMessage());
    }


    public List<SegmentDto> findAllCrossSegments(List<Subset> subs) {


        List<Double> crossPoints = new ArrayList<>(getCrossPoints(subs));

        List<Segment> crossSegments = getSegments(subs, crossPoints);

        return crossSegments.stream()
                .map(mapper::convertToSegmentDto)
                .collect(Collectors.toList());
    }


    private List<Segment> getSegments(List<Subset> subs, List<Double> crossPoints) {

        List<Segment> crossSegments = new ArrayList<>();

        for (int i = 0; i < crossPoints.size() - 1; i++) {


            double average = (crossPoints.get(i) + crossPoints.get(i + 1)) / 2;
            int counter = 0;


            for (Subset subset : subs) {


                for (Segment segment : subset.getSegments()) {
                    if (isExistInSegment(segment, average)) {
                        counter++;
                        break;
                    }
                }
            }


            if (counter == subs.size()) {
                crossSegments.add(new Segment(crossPoints.get(i), crossPoints.get(i + 1)));
            }
        }
        return crossSegments;
    }


    private TreeSet<Double> getCrossPoints(List<Subset> subs) {


        Set<Double> points = subs
                .stream()
                .flatMap(subset -> subset.getSegments().stream())
                .flatMap(segment -> Stream.of(segment.getLeft(), segment.getRight()))
                .collect(Collectors.toSet());


        TreeSet<Double> sortedPoints = new TreeSet<>();


        for (Subset subset : subs) {
            for (Segment segment : subset.getSegments()) {
                for (Double point : points) {
                    if (isExistInSegment(segment, point)) {
                        sortedPoints.add(point);
                    }
                }
            }
        }
        return sortedPoints;
    }


    private boolean isExistInSegment(Segment segment, double average) {
        return segment.getLeft().compareTo(average) <= 0 && segment.getRight().compareTo(average) >= 0;
    }

    private boolean isExistInAllSubset(List<Subset> subs, Double point) {
        int counter = 0;
        for (Subset subset : subs) {
            for (Segment segment : subset.getSegments()) {
                if (isExistInSegment(segment, point)) {
                    counter++;
                }
            }
        }
        return counter == subs.size();
    }
}