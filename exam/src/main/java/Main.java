import java.util.*;

import controller.*;
import io.javalin.Javalin;
import model.Exams;
import model.UserAnswers;
import model.Users;

import static io.javalin.rendering.template.TemplateUtil.model;

public class Main {
    public static void main(String[] args) {

        UserController userController = new UserController(new ArrayList<>());
        ExamController examController = new ExamController(new ArrayList<>());
        QuestionsController questionsController = new QuestionsController(new ArrayList<>());
        AnswersController answersController = new AnswersController(new ArrayList<>());
        UserAnswerController userAnswerController = new UserAnswerController(new ArrayList<>());

        Javalin app = Javalin.create()
                .port(7777)
                .enableCorsForAllOrigins()
//         .enableStaticFiles("/public")
                .start();


        app.post("/deleteuser", ctx -> {
            if (ctx.formParam("email") != null) {
                userController.removeUser(ctx.formParam("email"));
                ctx.redirect("/");
            }
            ctx.redirect("/");
        });


        app.post("/adduser", ctx -> {
            Users user = new Users(ctx.formParam("email"), ctx.formParam("password"));
            userController.addUser(user);
            System.out.println();
            ctx.redirect("/");

        });

        app.post("/selectexam", ctx -> {
            int examId = Integer.parseInt(ctx.formParam("examId"));
            ctx.sessionAttribute("exam_id", examId);
            ctx.redirect("/questions");
        });

        app.post("/addexam", ctx -> {
            Exams exam = new Exams(ctx.formParam("name"));
            examController.addExam(exam);
            ctx.redirect("/");
        });

        app.post("/answer", ctx -> {
            int answerId = Integer.parseInt(String.valueOf(ctx.formParam("answerid")));
            int questionId = Integer.parseInt(String.valueOf(ctx.formParam("questionid")));
            int userId = Integer.parseInt(String.valueOf(ctx.sessionAttributeMap().get("userId")));
            UserAnswers userAnswers = new UserAnswers(answerId, questionId, ctx.sessionAttribute("examid"), userId);
            userAnswerController.addUserAnswer(userAnswers);
        });

        app.post("/login", ctx -> {
            if (userController.authorizeUser(ctx.formParam("username"), ctx.formParam("password"))) {
                int userId = userController.findUserByEmail(ctx.formParam("username")).getId();
                if (userController.findUserByEmail(ctx.formParam("username")).isAdmin_role()) {
                    ctx.sessionAttribute("admin", true);
                }
                ctx.sessionAttribute("userId", userId);
                ctx.redirect("/");
            } else {
                ctx.redirect("/login");
            }

        });

        app.get("/", ctx -> {
            String id = String.valueOf(ctx.sessionAttributeMap().get("userId"));
            String isAdmin = String.valueOf(ctx.sessionAttributeMap().get("admin"));
            if (id.equals("null")) {
                ctx.redirect("/login");
            } else if (isAdmin.equals("true")) {
                ctx.render("/templates/admin.vm",
                        model("users", userController.loadUsers(),
                                "sesusr", ctx.sessionAttributeMap().get("userId")));
            } else {
                ctx.redirect("/exams");
            }
        });

        app.get("/exams", ctx ->
                ctx.render("/templates/exams.vm",
                        model("exams", examController.loadExams(),
                        "users", userController.loadUsers())));

        app.get("/login", ctx ->
                ctx.render("/templates/login.vm",
                        model("exams", examController.loadExams(),
                                "users", userController.loadUsers())));

        app.get("/questions", ctx -> {
            int examId = Integer.parseInt(String.valueOf(ctx.sessionAttributeMap().get("exam_id")));
            ctx.sessionAttribute("examid", examId);
            ctx.render("/templates/questions.vm",
                    model("exams", examController.loadExams(),
                            "questions", questionsController.findQuestionsByExamId(examId),
                            "answers", answersController.findAnswersByExamId(examId)
                    ));
        });

        app.get("/logout", ctx -> {
            ctx.sessionAttribute("admin", false);
            ctx.sessionAttribute("userId", null);
            ctx.sessionAttribute("examid", null);
            ctx.redirect("/");
        });
    }
}