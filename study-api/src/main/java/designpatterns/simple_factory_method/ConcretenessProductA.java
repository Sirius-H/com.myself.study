package designpatterns.simple_factory_method;

/**
 * 描述:
 * concreteness product A
 *
 * @author tangzhiming
 * @create 2018-11-29 14:32
 */
public class ConcretenessProductA implements AbstractProduct{

    public String use() {
        return "我是A类";
    }
}