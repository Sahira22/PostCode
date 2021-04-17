package practicas.postcode;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class SpringApplicationContext implements ApplicationContextAware {
     
    private static ApplicationContext CONTEXT;



    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {

                CONTEXT= applicationContext;
        // TODO Auto-generated method stub
        
    }

    public static Object getBean(String beanName){
        return CONTEXT.getBean(beanName);



    }
    
}
