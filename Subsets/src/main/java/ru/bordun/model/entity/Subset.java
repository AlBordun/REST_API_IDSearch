package ru.bordun.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.*;
@Component
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
public class Subset {

        private List<Segment> segments;

}
