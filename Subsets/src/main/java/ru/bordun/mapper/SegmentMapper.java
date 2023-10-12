package ru.bordun.mapper;

import org.springframework.stereotype.Service;
import ru.bordun.dto.SegmentDto;
import ru.bordun.model.entity.Segment;

@Service
public class SegmentMapper {

    public SegmentDto convertToSegmentDto(Segment segment) {
        return SegmentDto.builder()
                .leftPoint(segment.getLeft())
                .rightPoint(segment.getRight())
                .build();
    }

    public Segment converToSegment(SegmentDto segmentDto) {
        if (segmentDto.getLeftPoint().compareTo(segmentDto.getRightPoint()) > 0) {
            return Segment.builder()
                    .right(segmentDto.getLeftPoint())
                    .left(segmentDto.getRightPoint())
                    .build();
        }
    return Segment.builder()
            .left(segmentDto.getLeftPoint())
            .right(segmentDto.getRightPoint())
            .build();
    }
}
