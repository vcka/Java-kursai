package ml.penkisimtai.web;

import ml.penkisimtai.exceptions.ModelVerificationException;
import ml.penkisimtai.model.Exam;
import ml.penkisimtai.service.ExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.Map;

@Controller
public class WebExamController {

	@Autowired
	ExamService examService;

//	@Autowired
//	QuestionService questionService;

//	@Autowired
//	AccessControlService<Exam> accessControlServiceQuiz;
//
//	@Autowired
//	AccessControlService<Question> accessControlServiceQuestion;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {
		return "home";
	}

	@RequestMapping(value = "/createQuiz", method = RequestMethod.GET)
//	@PreAuthorize("isAuthenticated()")
	public String newQuiz(Map<String, Object> model) {
		return "createQuiz";
	}

	@RequestMapping(value = "/createQuiz", method = RequestMethod.POST)
//	@PreAuthorize("isAuthenticated()")
	public String newQuiz(/*@AuthenticationPrincipal AuthenticatedUser user, */@Valid Exam exam, BindingResult result,
                          Map<String, Object> model) {
		Exam newQuiz;

		try {
//			RestVerifier.verifyModelResult(result);
			newQuiz = examService.save(exam);
		} catch (ModelVerificationException e) {
			return "createQuiz";
		}

		return "redirect:/editQuiz/" + newQuiz.getId();
	}
//
//	@RequestMapping(value = "/editQuiz/{quiz_id}", method = RequestMethod.GET)
//	@PreAuthorize("isAuthenticated()")
//	public ModelAndView editQuiz(@PathVariable long quiz_id) {
//		Quiz quiz = quizService.find(quiz_id);
//		accessControlServiceQuiz.canCurrentUserUpdateObject(quiz);
//
//		ModelAndView mav = new ModelAndView();
//		mav.addObject("quiz", quiz);
//		mav.setViewName("editQuiz");
//
//		return mav;
//	}
//
//	@RequestMapping(value = "/editAnswer/{question_id}", method = RequestMethod.GET)
//	@PreAuthorize("isAuthenticated()")
//	public ModelAndView editAnswer(@PathVariable long question_id) {
//		Question question = questionService.find(question_id);
//		accessControlServiceQuestion.canCurrentUserUpdateObject(question);
//
//		ModelAndView mav = new ModelAndView();
//		mav.addObject("question", question);
//		mav.setViewName("editAnswers");
//
//		return mav;
//	}
//
//	@RequestMapping(value = "/quiz/{quiz_id}", method = RequestMethod.GET)
//	@PreAuthorize("permitAll")
//	public ModelAndView getQuiz(@PathVariable long quiz_id) {
//		Quiz quiz = quizService.find(quiz_id);
//
//		ModelAndView mav = new ModelAndView();
//		mav.addObject("quiz", quiz);
//		mav.setViewName("quizView");
//
//		return mav;
//	}
//
//	@RequestMapping(value = "/quiz/{quiz_id}/play", method = RequestMethod.GET)
//	@PreAuthorize("permitAll")
//	public ModelAndView playQuiz(@PathVariable long quiz_id) {
//		Quiz quiz = quizService.find(quiz_id);
//
//		ModelAndView mav = new ModelAndView();
//		mav.addObject("quiz", quiz);
//		mav.setViewName("playQuiz");
//
//		return mav;
//	}
}
