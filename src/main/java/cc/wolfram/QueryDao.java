package cc.wolfram;

public interface QueryDao{
    int add(QA qa);

    String findAnswer(String question);
}
