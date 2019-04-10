package ml.penkisimtai.controller;

//import ml.penkisimtai.model.AuthenticatedUser;
import ml.penkisimtai.model.Exam;
import ml.penkisimtai.service.ExamService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
//import org.springframework.security.access.prepost.PreAuthorize;
//import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
@RequestMapping(ExamController.ROOT_MAPPING)
public class ExamController {

    public static final String ROOT_MAPPING = "/api/quizzes";

    private static final Logger logger = LoggerFactory.getLogger(ExamController.class);

    @Autowired
    private ExamService examService;

//    @Autowired
//    private QuestionService questionService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    @PreAuthorize("permitAll")
    @ResponseStatus(HttpStatus.OK)
    public Page<Exam> findAll(Pageable pageable,
                              @RequestParam(required = false, defaultValue = "false") Boolean published) {

        if (published) {
            return examService.findAllPublished(pageable);
        } else {
            return examService.findAll(pageable);
        }
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    @PreAuthorize("isAuthenticated()")
    @ResponseStatus(HttpStatus.CREATED)
    public Exam save( @Valid Exam exam, BindingResult result) { //@AuthenticationPrincipal AuthenticatedUser user,

        logger.debug("The Quiz " + exam.getName() + " is going to be created");

//        RestVerifier.verifyModelResult(result);

        return examService.save(exam);
    }
}
