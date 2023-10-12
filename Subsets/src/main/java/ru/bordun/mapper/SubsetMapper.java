package ru.bordun.mapper;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.bordun.dto.SubsetDto;
import ru.bordun.model.entity.Segment;
import ru.bordun.model.entity.Subset;

import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SubsetMapper {

    private final SegmentMapper mapper;

    public List<Subset> convertToSubsets(List<SubsetDto> subsets) {
        return subsets.stream()
                .map(subsetDto -> {
                    List<Segment> segments = subsetDto.getSegmentDtoList().stream()
                            .map(mapper::converToSegment)
                            .collect(Collectors.toList());
                    return Subset.builder().segments(segments).build();
                })
                .collect(Collectors.toList());
    }

}
