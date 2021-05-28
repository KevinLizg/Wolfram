package cc.wolfram;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
class QueryDaoJdbcImplement implements QueryDao{

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    @Override
    public int add(QA qa) {
        String sql = "insert into QA(question,answer) " +
                "values(:question,:answer)";
        Map<String, Object> param = new HashMap<>();
        param.put("question", qa.getQuestion());
        param.put("answer", qa.getAnswer());

        return (int) jdbcTemplate.update(sql, param);
    }

    @Override
    public String findAnswer(String questions){
        String sql = "select * from QA qa where qa.question in (:questions )";
        Map<String,Object> parameters = new HashMap<String,Object>();
        parameters.put("questions", questions);
        List<Map<String,Object>> list = jdbcTemplate.queryForList(sql, parameters);
        if(list.isEmpty()){
            return "blank";
        }
        return list.get(0).get("answer").toString();
    }
}

