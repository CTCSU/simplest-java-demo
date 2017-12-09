import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Administrator on 2017/12/4.
 *  最简单的SpringIOC应用程序
 */
public class SpringMain {
    public static void main(String[] args){
        //根据路径加载文件,
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring.xml");
        //从上下文中获取对象
        SpringBean bean = (SpringBean)context.getBean("springBean");
        //获取对象的属性(从xml中注入的属性)
        System.out.println(bean.getWord());
    }
}
