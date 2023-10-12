package ru.bordun.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.bordun.mapper.SubsetMapper;
import ru.bordun.resolver.FunctionResolver;
import ru.bordun.validator.Validator;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/function")
public class FunctionController {

    private final FunctionResolver resolver;
    private final Validator validator;
    private final SubsetMapper subsetMapper;

}
