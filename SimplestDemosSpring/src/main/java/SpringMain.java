import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Administrator on 2017/12/4.
 *  最简单的SpringIOC应用程序
 */
public class SpringMain {
    public static void main(String[] args){
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring.xml");
        SpringBean bean = (SpringBean)context.getBean("springBean");
        System.out.println(bean.getWord());
    }
}
