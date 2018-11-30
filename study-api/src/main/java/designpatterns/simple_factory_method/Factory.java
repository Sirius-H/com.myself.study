package designpatterns.simple_factory_method;

/**
 * 描述:静态工厂
 *
 * @author tangzhiming
 * @create 2018-11-29 14:31
 */
public class Factory {

    public static AbstractProduct getProduct(String type) {
        if ("A".equalsIgnoreCase(type)) {
            return new ConcretenessProductA();
        } else if ("B".equalsIgnoreCase(type)) {
            return new ConcretenessProductB();
        }
        throw new IllegalStateException("参数错误");
    }
}