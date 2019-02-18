package club.pinea.pms.util;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * aaa
 *
 * @author pineapple
 * @create 2019/2/15
 */
@Service
public class Test {

    private Integer i = 0;

    public void init(){
        i = 10;
    }

    public void print(String args){
        //TODO
        System.out.println("This is : " + args);
        System.out.println(i++);
    }
}
