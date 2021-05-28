package cc.wolfram.controller;

import cc.wolfram.QA;
import cc.wolfram.QueryDao;
import cc.wolfram.WolframAlpha2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.servlet.http.HttpServletRequest;

@Controller
public class WolframController {
    @Autowired
    private QueryDao queryDao;

    @GetMapping(value = "/")
    public String index() {
        return "wolfram";
    }

    @GetMapping(value = "/input/query", produces = "text/html")
    @ResponseBody
    public String query(HttpServletRequest servletRequest, @RequestParam("data") String data) {
//        if(queryDao.findAnswer(data).equals("blank")){
            String answer = WolframAlpha2.query(data);
            return answer;
//            if(answer.equals("<noresults></noresults>")){
//                return "<font color=\"red\">Sorry! There is No Result for this!</font>";
//            }
//            else {
//                QA qa = new QA();
//                qa.setQuestion(data);
//                qa.setAnswer(answer);
//                queryDao.add(qa);
//                return "<font color=\"red\">The Answer is:</font>"+WolframAlpha2.query(data);
//            }
//        }
//        else{
//            return "<font color=\"red\"><b><i>You have searched this before, the answer is:</i></b></font>"+queryDao.findAnswer(data);
//        }
    }
}
